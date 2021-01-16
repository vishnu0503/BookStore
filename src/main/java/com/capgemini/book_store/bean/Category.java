package com.capgemini.book_store.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue(generator="category",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="category",sequenceName="category123",initialValue=100,allocationSize=1)
	private int categoryId;
	
	private String categoryName;
	

	public enum categoryName{
		BUSINESS, HEALTH, MARKETINMG, PROGRAMING, TECHNOLOGY, LIFESTYLE, HISTORY
	}

	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	};
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
