package com.capgemini.book_store.service;

import com.capgemini.book_store.bean.Customer;

public interface CustomerService 
{
public boolean createCustomer(Customer customer);
public boolean validate(String email,String password);
public Customer update(Customer customer);




























}
