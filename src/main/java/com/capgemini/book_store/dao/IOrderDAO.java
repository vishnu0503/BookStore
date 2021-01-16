package com.capgemini.book_store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.Customer;
import com.capgemini.book_store.bean.Order;

public interface IOrderDAO extends  JpaRepository<Order,Integer>
{
	public List<Order> findByReceipientName(String name);
	Order findByCustomer(Customer customer);
	List<Order> findByCustomer(int customerId);
}
