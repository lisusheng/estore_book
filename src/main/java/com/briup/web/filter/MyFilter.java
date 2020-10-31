package com.briup.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.briup.bean.Customer;

@WebFilter("/*")
public class MyFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(request, response);
		
		//以下操作是来判断用户是否登录  若没有登陆  不让访问其他页面
//		// 0.强制转换
//		HttpServletRequest req = (HttpServletRequest) request;
//		// 1.获取请求资源请求路径
//		String uri = req.getRequestURI();
////		System.out.println(uri);
//		// 2.判断是否包含相关资源路径
//		if (uri.contains("/login.jsp") || uri.contains("/LoginServlet") || uri.contains("/checkCodeServlet")|| uri.contains("/bookcover/")|| uri.contains("/css/")|| uri.contains("/images/")|| uri.contains("/js/")) {
//			// 包含 用户就是想去登录 放行
//			chain.doFilter(request, response);
//		} else {
//			// 不包含 需要验证用户是否登录
//			// 3.从获取session中获取customer
//			Customer customer = (Customer)req.getSession().getAttribute("customer");
//			if (customer != null) {
//				// 登陆了
//				chain.doFilter(request, response);
//			} else {
//				// 没有登陆 跳转登录页面
//				req.setAttribute("login_msg", "您尚未登陆，请登录");
//				req.getRequestDispatcher("/login.jsp").forward(req, response);
//			}
//		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
