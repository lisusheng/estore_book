package com.briup.mapper;

import java.util.List;

import com.briup.bean.ShopCar;

public interface ShopCarMapper {
	void saveShopCar(ShopCar sc);
	void updateShopCar(ShopCar sc);
	ShopCar findShopCarByBookId(Integer id);
	List<ShopCar> findShopCarsByCustomer(Integer id);
	
}
