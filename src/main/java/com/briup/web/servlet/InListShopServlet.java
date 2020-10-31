package com.briup.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.bean.Customer;
import com.briup.bean.ShopAddress;
import com.briup.bean.ShopCar;
import com.briup.service.Impl.IBookServiceImpl;
import com.briup.service.Impl.IShopAddressServiceImpl;

@WebServlet("/InListShopServlet")
public class InListShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("bookId");
//		System.out.println(id);
		IBookServiceImpl bookService = new IBookServiceImpl();
		Book book = bookService.findBookById(Integer.parseInt(id));
//		System.out.println("book前:" + book);
		String num = request.getParameter("num");
//		System.out.println(num);

		HttpSession session = request.getSession();
		Map<Integer, ShopCar> map = (Map<Integer, ShopCar>) session.getAttribute("shopCar");
//		System.out.println("map:" + map);
		// 拿到session里面的customer把id设置进去
		Customer c = (Customer) session.getAttribute("customer");
		if (map == null) {
			map = new HashMap<>();
			ShopCar shopCar = new ShopCar();
			System.out.println(num);
			// 设置数值框里的数量
			shopCar.setNum(Integer.parseInt(num));
			Customer customer = new Customer();
			// 设置customer_id
			customer.setId(c.getId());
			shopCar.setCustomer(customer);
			// 设置book
			shopCar.setBook(book);
			map.put(book.getId(), shopCar);
			session.setAttribute("shopCar", map);
		} else {
			if (map.containsKey(book.getId())) {
				ShopCar shopCar = map.get(book.getId());
				shopCar.setNum(shopCar.getNum() + Integer.parseInt(num));

				map.put(book.getId(), shopCar);
			} else {
				ShopCar shopCar = new ShopCar();
				shopCar.setNum(Integer.parseInt(num));
				shopCar.setBook(book);
				Customer customer = new Customer();
				customer.setId(c.getId());
				shopCar.setCustomer(customer);
				map.put(book.getId(), shopCar);
			}
		}

		Set<Entry<Integer, ShopCar>> entrySet = map.entrySet();
		int totalNum = 0;
		double totalPrice = 0;
		for (Entry<Integer, ShopCar> entry : entrySet) {
			ShopCar value = entry.getValue();
			totalNum += value.getNum();
			totalPrice += value.getBook().getPrice() * value.getNum();
		}
		session.setAttribute("totalNum", totalNum);
		session.setAttribute("totalPrice", totalPrice);

		IShopAddressServiceImpl shopAddressService = new IShopAddressServiceImpl();

		List<ShopAddress> list = shopAddressService.findAddressByCustomerId(c.getId());
		System.out.println("ShopAddresslist:" + list);
		session.setAttribute("ShopAddresslist", list);

		response.sendRedirect("list.jsp");
	}

}