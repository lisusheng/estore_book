package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.Book;
import com.briup.mapper.BookMapper;
import com.briup.mapper.Impl.BookMapperImpl;
import com.briup.service.IBookService;

public class IBookServiceImpl implements IBookService{
	private static BookMapper dao = new BookMapperImpl();
	
	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return dao.findAllBooks();
	}

	@Override
	public Book findBookById(Integer id) {
		return dao.findBookById(id);
	}

	@Override
	public Book findBookByCategoryId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findBookByCategoryId(id);
	}

}
