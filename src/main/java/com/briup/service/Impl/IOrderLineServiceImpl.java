package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.OrderLine;
import com.briup.mapper.OrderLineMapper;
import com.briup.mapper.Impl.OrderLineMapperImpl;
import com.briup.service.IOrderLineService;

public class IOrderLineServiceImpl implements IOrderLineService{
	private static OrderLineMapper dao = new OrderLineMapperImpl();
	
	@Override
	public void saveOrderLine(OrderLine ol) {
		dao .saveOrderLine(ol);
	}

	@Override
	public List<OrderLine> findOrderLineByOrderId(Integer id) {
		return dao.findOrderLineByOrderId(id);
	}

	@Override
	public void deleteOrderLineByOrderFormId(Integer id) {
		dao.deleteOrderLineByOrderFormId(id);
	}

}
