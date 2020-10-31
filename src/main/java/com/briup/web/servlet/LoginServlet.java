package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.briup.bean.Book;
import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.service.ICustomerService;
import com.briup.service.Impl.IBookServiceImpl;
import com.briup.service.Impl.ICustomerServiceImpl;
import com.briup.service.Impl.IOrderFormServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取验证码 用户填写的验证码
		String verifycode = request.getParameter("verifycode");
		// 2.校验验证码
		HttpSession session = request.getSession();
		String checkCode_ssesion = (String) session.getAttribute("checkCode_ssesion");
		// 3.确保验证码一次性
		session.removeAttribute("checkCode_ssesion");

		if (!checkCode_ssesion.equalsIgnoreCase(verifycode)) {
			// 验证码不正确
			// 提示信息
			request.setAttribute("login_msg", "验证码错误！");
			// 跳转登陆页面
			request.getRequestDispatcher("login.jsp").forward(request, response);

			return;
		}

		ICustomerService service = new ICustomerServiceImpl();
		Customer customer = service.login(request.getParameter("name"), request.getParameter("password"));
		if (customer != null) {
			// 消费者一登陆 把customer放入session
			session.setAttribute("customer", customer);
			// 同时把该消费者的订单也放入session
			// 从session中获取Customer
			IOrderFormServiceImpl orderFormService = new IOrderFormServiceImpl();
			// 调用通过消费者id来查绚订单
			List<OrderForm> orderFormList = orderFormService.findOrderFormByCustomerId(customer.getId());
			System.out.println(orderFormList);
			// 把该消费者的订单放入session中
			session.setAttribute("orderFormList", orderFormList);

			response.sendRedirect("index.jsp");
		} else {
			// 提示信息
			request.setAttribute("login_msg", "密码或验证码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}