package com.capgemini.book_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.book_store.bean.Customer;
import com.capgemini.book_store.dao.ICustomerDAO;

@Service("customerService")

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	ICustomerDAO repo;

	@Override
	public boolean createCustomer(Customer customer) {
		
		if(repo.findByEmailId(customer.getEmailId()) == null) {
			repo.save(customer);
			return true;
		}
		return false;

	}

	@Override
	public boolean validate(String email, String password) {
		
		Customer c = repo.findByEmailId(email);
		if (c != null && c.getEmailId().equals(email) && c.getPassword().equals(password))
				return true;
		return false;
	}

	@Override
	public Customer update(Customer customer) {
		Customer c = repo.findByEmailId(customer.getEmailId());
		c.setCustomerName(customer.getCustomerName());
		c.setPassword(customer.getPassword());
		c.setConfirmPassword(customer.getConfirmPassword());
		c.setMobileNumber(customer.getMobileNumber());
		c.setAddress(customer.getAddress());
		c.setCity(customer.getCity());
		c.setZipcode(customer.getZipcode());
		c.setCountry(customer.getCountry());
		repo.save(c);
		return c;
	}

}
