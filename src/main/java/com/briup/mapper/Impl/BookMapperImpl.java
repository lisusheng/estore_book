package com.briup.mapper.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.mapper.BookMapper;
import com.briup.util.MybatisSqlSessionFactoryUtil;

public class BookMapperImpl implements BookMapper{

	@Override
	public List<Book> findAllBooks() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();
			
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			
			return mapper.findAllBooks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book findBookById(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();
			
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			
			return mapper.findBookById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book findBookByCategoryId(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();
			
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			
			return mapper.findBookByCategoryId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
