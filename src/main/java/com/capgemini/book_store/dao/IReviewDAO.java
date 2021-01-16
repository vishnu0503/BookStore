package com.capgemini.book_store.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Customer;
import com.capgemini.book_store.bean.Review;

public interface IReviewDAO extends JpaRepository<Review, Integer>
{
//public List<Review> findBybookName(String bookName);
public Customer findBycustomerName(String cname);
Customer findByCustomer(Customer customer);

List<Review> findByBook(Book book);
}
