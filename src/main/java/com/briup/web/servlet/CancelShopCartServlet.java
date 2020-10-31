package com.briup.web.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.ShopCar;

@WebServlet("/CancelShopCartServlet")
public class CancelShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bookId = request.getParameter("bid");
		System.out.println(bookId);
		
		HttpSession session = request.getSession();
		Map<Integer, ShopCar> map = (Map<Integer, ShopCar>) session.getAttribute("shopCar");
		System.out.println("remove前：" + map);
		//通过map中的key值(即书的id)来取消购物车里面对应的项
		map.remove(Integer.parseInt(bookId));
		System.out.println("remove后：" + map);
		//再把map放入session
		session.setAttribute("shopCar", map);
		
		int totalNum = 0;
		double totalPrice = 0;
		//如果取消购物车里面对应的项之后 购物车中什么都没有 则把总价和总数设为0放入session
		if (map == null) {
			session.setAttribute("totalNum", totalNum);
			session.setAttribute("totalPrice", totalPrice);
		} else {
			//若取消购物车里面对应的项之后 购物车中还有商品 则遍历每个商品 获取数量和单价 
			//通过一下两行获取总价和总数  最后将它们放入session
			//totalNum += value.getNum();
			//totalPrice += value.getBook().getPrice() * value.getNum();
			Set<Entry<Integer,ShopCar>> entrySet = map.entrySet();
			for (Entry<Integer, ShopCar> entry : entrySet) {
				ShopCar value = entry.getValue();
				totalNum += value.getNum();
				totalPrice += value.getBook().getPrice() * value.getNum();
			}
			session.setAttribute("totalNum", totalNum);
			session.setAttribute("totalPrice", totalPrice);
		}
		response.sendRedirect("shopCart.jsp");
	}

}