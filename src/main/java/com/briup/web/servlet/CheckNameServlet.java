package com.briup.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.service.ICustomerService;
import com.briup.service.Impl.ICustomerServiceImpl;

@WebServlet("/CheckNameServlet")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ICustomerService service = new ICustomerServiceImpl();
		
		PrintWriter out = response.getWriter();
		
		if (service.findCustomerByName(request.getParameter("name")) != null) {
			out.println("用户名已经存在！");
		} else {
			out.println("√");
		}
	}

}