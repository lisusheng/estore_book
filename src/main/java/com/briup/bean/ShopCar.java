package com.briup.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 购物车类
 */
public class ShopCar implements Serializable {

	private Integer id;
	private Integer num;
	private Customer customer;
	private Book book;

	public ShopCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "ShopCar [id=" + id + ", num=" + num + ", customer=" + customer + ", book=" + book + "]";
	}

}
