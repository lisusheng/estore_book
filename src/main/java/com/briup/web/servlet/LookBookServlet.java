package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.service.Impl.IBookServiceImpl;

@WebServlet("/LookBookServlet")
public class LookBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IBookServiceImpl service = new IBookServiceImpl();
		
		String id = request.getParameter("id");
		Book book = service.findBookById(Integer.parseInt(id));
//		System.out.println(book);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("book", book);
		response.sendRedirect("viewBook.jsp");
		
	}

}