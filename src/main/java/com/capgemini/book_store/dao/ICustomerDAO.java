package com.capgemini.book_store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.Customer;

public interface ICustomerDAO extends JpaRepository<Customer, Integer> {

	public Customer findByEmailId(String email);

}
