package com.briup.mapper.Impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.mapper.CustomerMapper;
import com.briup.util.MybatisSqlSessionFactoryUtil;

public class CustomerMapperImpl implements CustomerMapper{

	@Override
	public void register(Customer customer) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession(true);
			
			CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
			
			mapper.register(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer findCustomerByName(String name) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();
			
			CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
			
			return mapper.findCustomerByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer login(String name, String password) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();
			
			CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
			
			return mapper.login(name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
