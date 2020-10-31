package com.briup.service.Impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.briup.bean.ShopCar;
import com.briup.service.IShopCarService;

public class IShopCarServiceImpl implements IShopCarService{
	private HashMap<Integer, ShopCar> map = new HashMap<>();
	@Override
	public void saveShopCar(ShopCar sc) {
		Set<Integer> keySet = map.keySet();
		if (keySet.contains(sc.getBook().getId())) {
			ShopCar shopCar = map.get(sc.getBook().getId());
			shopCar.setNum(shopCar.getNum() + 1);
		} else {
			map.put(sc.getBook().getId(), sc);
		}
		
	}

	@Override
	public void updateShopCar(ShopCar sc) {
	}

	@Override
	public ShopCar findShopCarByBookId(Integer id) {
		return null;
	}

	@Override
	public List<ShopCar> findShopCarsByCustomer(Integer id) {
		return null;
	}

}
