package com.briup.service;

import java.util.List;

import com.briup.bean.OrderLine;

public interface IOrderLineService {
	//保存订单项
	void saveOrderLine(OrderLine ol);
	//根据订单项ID查找订单项
	List<OrderLine> findOrderLineByOrderId(Integer id);
	//根据订单号删除订单项
	void deleteOrderLineByOrderFormId(Integer id);
}
