package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.OrderLine;
import com.briup.service.Impl.IOrderFormServiceImpl;
import com.briup.service.Impl.IOrderLineServiceImpl;

@WebServlet("/LookOrderDetailServlet")
public class LookOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String orderId = request.getParameter("id");
		//通过订单id来查询订单明细
		IOrderLineServiceImpl orderLineServiceImpl = new IOrderLineServiceImpl();
		List<OrderLine> orderLineList = orderLineServiceImpl.findOrderLineByOrderId(Integer.parseInt(orderId));
		// 把该消费者要下订单的订单明细表放入session
		request.getSession().setAttribute("OrderLineList", orderLineList);
		
		//把每个订单的总价格放入session
		String totalPrice = request.getParameter("cost");
		request.getSession().setAttribute("totalPrice", totalPrice);
		
		response.sendRedirect("orderdetail.jsp");

	}

}