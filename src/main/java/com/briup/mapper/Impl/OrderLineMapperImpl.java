package com.briup.mapper.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.OrderLine;
import com.briup.mapper.CustomerMapper;
import com.briup.mapper.OrderLineMapper;
import com.briup.util.MybatisSqlSessionFactoryUtil;

public class OrderLineMapperImpl implements OrderLineMapper {

	@Override
	public void saveOrderLine(OrderLine ol) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession(true);
			
			OrderLineMapper mapper = sqlSession.getMapper(OrderLineMapper.class);
			
			mapper.saveOrderLine(ol);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderLine> findOrderLineByOrderId(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession();
			
			OrderLineMapper mapper = sqlSession.getMapper(OrderLineMapper.class);
			
			return mapper.findOrderLineByOrderId(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteOrderLineByOrderFormId(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisSqlSessionFactoryUtil.openSession(true);
			
			OrderLineMapper mapper = sqlSession.getMapper(OrderLineMapper.class);
			
			mapper.deleteOrderLineByOrderFormId(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
