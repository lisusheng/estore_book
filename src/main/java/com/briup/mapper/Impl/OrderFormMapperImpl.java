package com.briup.mapper.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.OrderForm;
import com.briup.mapper.OrderFormMapper;
import com.briup.util.MybatisSqlSessionFactoryUtil;

public class OrderFormMapperImpl implements OrderFormMapper {

	@Override
	public void saveOrderForm(OrderForm of) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession(true);

			OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);

			mapper.saveOrderForm(of);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderForm findOrderFormByOrderid(Long orderid) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();

			OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);

			return mapper.findOrderFormByOrderid(orderid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderForm> findOrderFormByCustomerId(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();

			OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);

			return mapper.findOrderFormByCustomerId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteOrderFormById(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession(true);

			OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);

			mapper.deleteOrderFormById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
