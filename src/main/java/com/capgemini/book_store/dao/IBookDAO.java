package com.capgemini.book_store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Category;

public interface IBookDAO extends JpaRepository<Book, Integer>{
	
	public Book findBytitle(String bookName);
	List<Book> findByCategory(Category category);
	public Book findBybookId(int bookId,int quantity);
	
}
