package com.capgemini.book_store.service;

import java.util.List;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Customer;
import com.capgemini.book_store.bean.Review;

public interface ReviewService
{
public Book search(String bookName);
public Customer validate(String cname);
public float average(String bookName,int rating);
public List<Book> findByRating();
public List<Book> findByOrder();
Review createReview(Review review);

}
