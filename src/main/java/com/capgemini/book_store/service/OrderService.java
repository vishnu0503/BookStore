package com.capgemini.book_store.service;

import java.util.List;
import java.util.Map;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Order;

public interface OrderService {
	
	public Book findByBookName(String bookname);

	public boolean update(int customerId, int bookId, int quantity);

	public Order createOrder(Order order);
	public List<Order> vieworders(int customerId);

	public Map<Book, Integer> findByBookId(int bookId, int qty);

}
