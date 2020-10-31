package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.service.ICustomerService;
import com.briup.service.Impl.ICustomerServiceImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ICustomerService service = new ICustomerServiceImpl();
		
		if (service.findCustomerByName(request.getParameter("name")) != null) {
			response.sendRedirect("register.jsp");
		} else {
			Customer c = new Customer();
			c.setName(request.getParameter("name"));
			c.setPassword(request.getParameter("password"));
			c.setZipCode(request.getParameter("zipCode"));
			c.setAddress(request.getParameter("address"));
			c.setTelephone(request.getParameter("telephone"));
			c.setEmail(request.getParameter("email"));
			
			service.register(c);
			response.sendRedirect("index.jsp");
		}
	}

}