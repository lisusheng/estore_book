package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.service.Impl.IOrderFormServiceImpl;
import com.briup.service.Impl.IOrderLineServiceImpl;

@WebServlet("/DelOrderListServlet")
public class DelOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String orderId = request.getParameter("id");
		System.out.println(orderId);
		
		//删除订单项
		IOrderLineServiceImpl orderLineServiceImpl = new IOrderLineServiceImpl();
		orderLineServiceImpl.deleteOrderLineByOrderFormId(Integer.parseInt(orderId));
		//删除订单
		IOrderFormServiceImpl orderFormServiceImpl = new IOrderFormServiceImpl();
		orderFormServiceImpl.deleteOrderFormById(Integer.parseInt(orderId));
		
		//再把更新后的订单列表放入session
		HttpSession session = request.getSession();
		// 从session中获取Customer
		Customer customer = (Customer) session.getAttribute("customer");
		IOrderFormServiceImpl orderFormService = new IOrderFormServiceImpl();
		// 调用通过消费者id来查询订单
		List<OrderForm> orderFormList = orderFormService.findOrderFormByCustomerId(customer.getId());
		System.out.println(orderFormList);
		// 把该消费者的订单放入session中
		session.setAttribute("OrderFormList", orderFormList);
		
		response.sendRedirect("orderlist.jsp");
	}

}