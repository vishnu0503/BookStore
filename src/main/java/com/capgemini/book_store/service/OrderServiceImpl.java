package com.capgemini.book_store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.BookDetail;
import com.capgemini.book_store.bean.Order;
import com.capgemini.book_store.dao.IBookDAO;
import com.capgemini.book_store.dao.ICustomerDAO;
import com.capgemini.book_store.dao.IOrderDAO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	IOrderDAO iOrderDAO;
	@Autowired
	IBookDAO iBookDAO;

	@Autowired
	ICustomerDAO iCustomerDAO;
	
	Map<Book,Integer> cart = new HashMap<>();

	@Override
	public Book findByBookName(String bookname) {
		// TODO Auto-generated method stub
		Book b = iBookDAO.findBytitle(bookname);
		System.out.println(b);
		return b;
	}
  
	@Override
	public boolean update(int customerId, int bookId, int quantity) {
		
		Order order = iOrderDAO.findByCustomer(iCustomerDAO.findById(customerId).get());
		List<BookDetail> li = order.getDetails();
		for(BookDetail b: li)
		{
			if(b.getBook().getBookId()==bookId)
			{
				b.setQuantity(quantity);
				iOrderDAO.save(order);
				return true;
			}
		}
		return false;
	}

	@Override
	public Order createOrder(Order order) {
		
		return iOrderDAO.save(order);
		// TODO Auto-generated method stub
	}

	@Override
	public List<Order> vieworders(int customerId) {
		return iOrderDAO.findByCustomer(customerId);
	}

	@Override
	public Map<Book, Integer> findByBookId(int bookId, int qty) {
		// TODO Auto-generated method stub
		Book b = iBookDAO.findById(bookId).get();
		cart.put(b, qty);
		return cart;
	}

}
