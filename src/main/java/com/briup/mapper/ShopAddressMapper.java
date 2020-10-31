package com.briup.mapper;

import java.util.List;

import com.briup.bean.ShopAddress;

public interface ShopAddressMapper {
	void saveAddress(ShopAddress sd);
	
	List<ShopAddress> findAddressByCustomerId(Integer id);
	
}
