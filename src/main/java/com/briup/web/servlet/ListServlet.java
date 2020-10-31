package com.briup.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.service.Impl.IBookServiceImpl;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parentCatName = request.getParameter("parentCatName");
		HttpSession session = request.getSession();
		session.setAttribute("parentCategoryName", parentCatName);
//		System.out.println(parentCatName);
		HashMap<String, List<Category>> map = (HashMap<String, List<Category>>) request.getServletContext().getAttribute("map");
		System.out.println(map);
		List<Category> 	categoriesList = map.get(parentCatName);
		
		IBookServiceImpl bookServiceImpl = new IBookServiceImpl();
		ArrayList<Book> bList = new ArrayList<>();
		for (Category category : categoriesList) {
			Book book = bookServiceImpl.findBookByCategoryId(category.getId());
			bList.add(book);
		}
		bList.forEach(System.out::println);
		request.getSession().setAttribute("bList", bList);
		
		
		response.sendRedirect("list.jsp");
	}

}