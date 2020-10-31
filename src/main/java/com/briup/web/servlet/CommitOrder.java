package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.bean.OrderLine;
import com.briup.bean.ShopAddress;
import com.briup.bean.ShopCar;
import com.briup.mapper.Impl.ShopAddressMapperImpl;
import com.briup.service.Impl.IOrderFormServiceImpl;
import com.briup.service.Impl.IOrderLineServiceImpl;
import com.briup.service.Impl.IShopAddressServiceImpl;

@WebServlet("/CommitOrder")
public class CommitOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Double totalPrice = (Double) session.getAttribute("totalPrice");

		String shipAddId = request.getParameter("shipAddId");

		IOrderFormServiceImpl orderFormService = new IOrderFormServiceImpl();

		OrderForm of = new OrderForm();

		ShopAddress shopAddress = new ShopAddress();
		// set customer_id
		Customer c = (Customer) session.getAttribute("customer");
		System.out.println("in commit:" + c);
		Customer customer = new Customer();
		customer.setId(c.getId());
		of.setCustomer(customer);
		// 如果没有选择已有的收货地址 则新建收货地址
		ShopAddress sd = new ShopAddress();
		if (shipAddId == null) {
			sd.setCustomer(c);
			sd.setReceiveName(request.getParameter("receiveName"));
			sd.setAddress(request.getParameter("address"));
			sd.setPhone(request.getParameter("phone"));
			
			IShopAddressServiceImpl shopAddressService = new IShopAddressServiceImpl();
			shopAddressService.saveAddress(sd);
			
			// set shopAddress 把收货地址的id放入orderForm数据库内
			of.setShopAddress(sd);
		} else {
			//选择存在地址  直接获取shipAddId set进去
			sd.setId(Integer.parseInt(shipAddId));
			of.setShopAddress(sd);
		}
		// set oderDate
		of.setOrderdate(new Date());
		// set cost
		of.setCost(totalPrice);
		// set orderid 每个orderid都不一样 通过long orderid = new Date().getTime()来设置
		long orderId = new Date().getTime();
		System.out.println(orderId);
		of.setOrderid(orderId);
		// 把订单存入orderform数据库
		orderFormService.saveOrderForm(of);

		// 再把订单存入orderline数据库
		IOrderLineServiceImpl orderLineService = new IOrderLineServiceImpl();
		Map<Integer, ShopCar> map = (Map<Integer, ShopCar>) session.getAttribute("shopCar");
		for (ShopCar shopCar : map.values()) {// 对ShopCar遍历
			OrderLine ol = new OrderLine();
			// 设置书的数量
			ol.setNum(new Long(shopCar.getNum()));
			// 设置书的单价
			ol.setCost(shopCar.getBook().getPrice());
			// 获取书的id向数据库插入
			Book book = new Book();
			book.setId(shopCar.getBook().getId());
			ol.setBook(book);
			// 设置orderForm_id
			OrderForm orderForm = orderFormService.findOrderFormByOrderid(orderId);
			ol.setOrderForm(orderForm);
			// 订单存入orderline数据库
			orderLineService.saveOrderLine(ol);

		}
		OrderForm orderForm = orderFormService.findOrderFormByOrderid(orderId);
		List<OrderLine> orderLineList = orderLineService.findOrderLineByOrderId(orderForm.getId());
		// 把该消费者要下订单的订单明细表放入session
		session.setAttribute("OrderLineList", orderLineList);
		
		response.sendRedirect("orderdetail.jsp");

	}

}