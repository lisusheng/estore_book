package com.briup.mapper.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.ShopAddress;
import com.briup.mapper.CategoryMapper;
import com.briup.mapper.ShopAddressMapper;
import com.briup.util.MybatisSqlSessionFactoryUtil;

public class ShopAddressMapperImpl implements ShopAddressMapper{

	@Override
	public List<ShopAddress> findAddressByCustomerId(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();
			
			ShopAddressMapper mapper = sqlSession.getMapper(ShopAddressMapper.class);
			
			return mapper.findAddressByCustomerId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveAddress(ShopAddress sd) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession(true);
			
			ShopAddressMapper mapper = sqlSession.getMapper(ShopAddressMapper.class);
			
			mapper.saveAddress(sd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
