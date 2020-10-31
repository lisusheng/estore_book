package com.briup.bean;

import org.apache.ibatis.type.Alias;

/**
 * 收获地址类
 */
@Alias("addr")
public class ShopAddress {
	private Integer id;
	private String receiveName;
	private String address;
	private String phone;
	private Customer customer;

	public ShopAddress() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ShopAddress [id=" + id + ", receiveName=" + receiveName + ", address=" + address + ", phone=" + phone
				+ ", customer=" + customer + "]";
	}

}
