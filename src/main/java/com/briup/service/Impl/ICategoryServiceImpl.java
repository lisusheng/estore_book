package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.Category;
import com.briup.mapper.CategoryMapper;
import com.briup.mapper.Impl.CategoryMapperImpl;
import com.briup.service.ICategoryService;

public class ICategoryServiceImpl implements ICategoryService {
	private static CategoryMapper dao = new CategoryMapperImpl();

	@Override
	public List<Category> findAllCategorys() {
		// TODO Auto-generated method stub
		return dao.findAllCategorys();
	}

	@Override
	public List<Category> findCategorysByParentId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findCategorysByParentId(id);
	}

}
