package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.ShopAddress;
import com.briup.mapper.ShopAddressMapper;
import com.briup.mapper.Impl.ShopAddressMapperImpl;
import com.briup.service.IShopAddressService;

public class IShopAddressServiceImpl implements IShopAddressService{
	private static ShopAddressMapper dao = new ShopAddressMapperImpl();
	
	@Override
	public List<ShopAddress> findAddressByCustomerId(Integer id) {
		return dao.findAddressByCustomerId(id);
	}

	@Override
	public void saveAddress(ShopAddress sd) {
		dao.saveAddress(sd);
	}

}
