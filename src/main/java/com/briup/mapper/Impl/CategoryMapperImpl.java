package com.briup.mapper.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Category;
import com.briup.mapper.CategoryMapper;
import com.briup.util.MybatisSqlSessionFactoryUtil;

public class CategoryMapperImpl implements CategoryMapper{

	@Override
	public List<Category> findAllCategorys() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();
			
			CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
			
			return mapper.findAllCategorys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> findCategorysByParentId(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();
			
			CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
			
			return mapper.findCategorysByParentId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
