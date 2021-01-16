package com.capgemini.book_store.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class BookDetail {

	@Id
	@GeneratedValue(generator="bookDetail",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="bookDetail",sequenceName="seven",initialValue=100,allocationSize=1)
	private int bookDetailId;
	
	@ManyToOne
	private Order order;
	
	@OneToOne
	private Book book;
	
	private int quantity;

	public int getBookDetailId() {
		return bookDetailId;
	}

	public void setBookDetailId(int bookDetailId) {
		this.bookDetailId = bookDetailId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BookDetail [bookDetailId=" + bookDetailId + ", order=" + order + ", book=" + book + ", quantity="
				+ quantity + "]";
	}
	
	
	
	
	
}
