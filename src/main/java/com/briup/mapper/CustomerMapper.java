package com.briup.mapper;



import com.briup.bean.Customer;

public interface CustomerMapper {
	
	void register(Customer customer);
	
	Customer findCustomerByName(String name);
	
	Customer login(String name,String password);	
}
