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

@WebServlet("/OrderFormListServlet")
public class OrderFormListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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