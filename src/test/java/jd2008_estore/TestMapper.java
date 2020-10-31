package jd2008_estore;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.bean.OrderLine;
import com.briup.bean.ShopAddress;
import com.briup.mapper.Impl.CategoryMapperImpl;
import com.briup.mapper.Impl.OrderFormMapperImpl;
import com.briup.mapper.Impl.OrderLineMapperImpl;
import com.briup.mapper.Impl.ShopAddressMapperImpl;
import com.briup.service.Impl.IBookServiceImpl;
import com.briup.service.Impl.ICategoryServiceImpl;
import com.briup.service.Impl.IOrderLineServiceImpl;

public class TestMapper {
	@Test
	public void testBook() {
		IBookServiceImpl s = new IBookServiceImpl();
		
		List<Book> list = s.findAllBooks();
		
		list.forEach(System.out::println);
	}
	@Test
	public void testCategory() {
		CategoryMapperImpl dao = new CategoryMapperImpl();
		
		List<Category> list = dao.findAllCategorys();
		list.forEach(System.out::println);
	}
	@Test
	public void testAddress() {
		ShopAddressMapperImpl dao = new ShopAddressMapperImpl();
		
//		ShopAddress s = new ShopAddress();
//		s.setReceiveName("廖小小");
//		s.setAddress("上海");
//		s.setPhone("666");
//		Customer customer = new Customer();
//		customer.setId(25);
//		
//		s.setCustomer(customer);
//		
//		dao.saveAddress(s);
		
		List<ShopAddress> list = dao.findAddressByCustomerId(25);
		list.forEach(System.out::println);
		
	}
	
	@Test
	public void testOrderLineSave() {
		
		OrderLineMapperImpl dao = new OrderLineMapperImpl();
		OrderLine ol = new OrderLine();
		ol.setNum(1L);
		ol.setCost(20.0);
		
		Book book = new Book();
		book.setId(1);
		ol.setBook(book);
		
		OrderForm of = new OrderForm();
		of.setId(2);
		ol.setOrderForm(of);
		
		dao.saveOrderLine(ol);
	}
	
	@Test
	public void testOrderLineFindAll() {
		OrderLineMapperImpl dao = new OrderLineMapperImpl();
		List<OrderLine> list = dao.findOrderLineByOrderId(3);
		list.forEach(System.out::println);
	}
	
	@Test
	public void testOrderFormFindByOrderId() {
		OrderFormMapperImpl dao = new OrderFormMapperImpl();
		OrderForm o = dao.findOrderFormByOrderid(2L);
		System.out.println(o);
	}
	@Test
	public void testOrderFormFindByCustomerId() {
		OrderFormMapperImpl dao = new OrderFormMapperImpl();
		List<OrderForm> list = dao.findOrderFormByCustomerId(25);
		System.out.println(list);
	}
	@Test
	public void testSaveOrderFormFind() {
		OrderFormMapperImpl dao = new OrderFormMapperImpl();
		
		OrderForm of = new OrderForm();
		of.setCost(40.0);
		of.setOrderdate(new Date());
		Customer customer = new Customer();
		customer.setId(25);
		of.setCustomer(customer);
		ShopAddress add = new ShopAddress();
		add.setId(24);
		of.setShopAddress(add);
		
		dao.saveOrderForm(of);
	}
	@Test
	public void testDeleteId() {
		OrderFormMapperImpl dao = new OrderFormMapperImpl();
		dao.deleteOrderFormById(4);
	}
	
	@Test
	public void testfindCategorysByParentId() {
		ICategoryServiceImpl categoryService = new ICategoryServiceImpl();
    	
    	List<Category> parentCategories = categoryService.findCategorysByParentId(1);
    	
    	System.out.println(parentCategories);
	}
	
	@Test
	public void test1() {
		IOrderLineServiceImpl orderLineServiceImpl = new IOrderLineServiceImpl();
		orderLineServiceImpl.deleteOrderLineByOrderFormId(44);
		
	}
}
