package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.OrderForm;
import com.briup.mapper.OrderFormMapper;
import com.briup.mapper.Impl.OrderFormMapperImpl;
import com.briup.service.IOrderFormService;

public class IOrderFormServiceImpl implements IOrderFormService{
	private static OrderFormMapper dao = new OrderFormMapperImpl();
	
	@Override
	public void saveOrderForm(OrderForm of) {
		dao.saveOrderForm(of);
	}

	@Override
	public OrderForm findOrderFormByOrderid(Long orderid) {
		return dao.findOrderFormByOrderid(orderid);
	}

	@Override
	public List<OrderForm> findOrderFormByCustomerId(Integer id) {
		return dao.findOrderFormByCustomerId(id);
	}

	@Override
	public void deleteOrderFormById(Integer id) {
		dao.deleteOrderFormById(id);
	}

}
