package com.briup.bean;

import java.util.Date;

/**
 * 订单类
 */
public class OrderForm {
	private Integer id;
	private Double cost;
	private Date orderdate;
	private Customer customer;
	private ShopAddress shopAddress;
	private Long orderid;

	public OrderForm() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShopAddress getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}
	

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", cost=" + cost + ", orderdate=" + orderdate + ", customer=" + customer
				+ ", shopAddress=" + shopAddress + "]";
	}

}
