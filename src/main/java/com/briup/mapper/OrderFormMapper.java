package com.briup.mapper;

import java.util.List;

import com.briup.bean.OrderForm;

public interface OrderFormMapper {
	void saveOrderForm(OrderForm of);
	OrderForm findOrderFormByOrderid(Long orderid);
	List<OrderForm> findOrderFormByCustomerId(Integer id);
	void deleteOrderFormById(Integer id);
}
