package com.capgemini.book_store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.Category;

public interface ICategoryDAO extends JpaRepository<Category, Integer> {
	
	Category findByCategoryName(String catName);

}
