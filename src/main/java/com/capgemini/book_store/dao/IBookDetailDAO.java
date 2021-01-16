package com.capgemini.book_store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.BookDetail;
import com.capgemini.book_store.bean.Order;

public interface IBookDetailDAO extends JpaRepository<BookDetail, Integer> {

	List<BookDetail> findByOrder(Order order);
}
