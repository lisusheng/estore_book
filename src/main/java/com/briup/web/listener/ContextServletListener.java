package com.briup.web.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.service.Impl.IBookServiceImpl;
import com.briup.service.Impl.ICategoryServiceImpl;
@WebListener
public class ContextServletListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application = sce.getServletContext();
    	
    	IBookServiceImpl bookService = new IBookServiceImpl();
    	List<Book> list = bookService.findAllBooks();
    	
    	application.setAttribute("list", list);
    	
    	ICategoryServiceImpl categoryService = new ICategoryServiceImpl();
    	
    	List<Category> parentCategories = categoryService.findCategorysByParentId(0);
    	
    	HashMap<String, List<Category>> map = new HashMap<>();
    	for (Category category : parentCategories) {
			List<Category> chirlCategories = categoryService.findCategorysByParentId(category.getId());
			
			map.put(category.getName(), chirlCategories);
		}
    	System.out.println(map);
    	
//    	for (List<Category> l : map.values()) {
//    		l.forEach(System.out::println);
//		}
    	
    	application.setAttribute("map", map);
    	
    	
    	
    }
	
}
