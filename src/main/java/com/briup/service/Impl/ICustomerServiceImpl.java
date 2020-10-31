package com.briup.service.Impl;

import com.briup.bean.Customer;
import com.briup.mapper.CustomerMapper;
import com.briup.mapper.Impl.CustomerMapperImpl;
import com.briup.service.ICustomerService;

public class ICustomerServiceImpl implements ICustomerService{
	private static CustomerMapper dao = new CustomerMapperImpl();
	
	@Override
	public void register(Customer customer) {
		dao.register(customer);
	}

	@Override
	public Customer findCustomerByName(String name) {
		
		return dao.findCustomerByName(name);
	}

	@Override
	public Customer login(String name, String password) {
		return dao.login(name, password);
	}

}
