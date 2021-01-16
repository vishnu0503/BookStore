package com.capgemini.book_store.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Bookreview")
public class Review {
	@Id
	@GeneratedValue(generator = "review", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "review", sequenceName = "bookreview123", initialValue = 100, allocationSize = 1)
	private int bookreviewId;

	// private String bookName;
	public Date getReviewDate() {
		return ReviewDate;
	}

	private int ratings;
	private String headLine;
	private String comments;
	private Date ReviewDate;
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookId")
	private Book book;

	public void setReviewDate(Date reviewDate) {
		ReviewDate = reviewDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getratings() {
		return ratings;
	}

	public void setratings(int ratings) {
		this.ratings = ratings;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getcomments() {
		return comments;
	}

	public void setcomments(String comments) {
		this.comments = comments;
	}

	public Customer getCustomerName() {
		return customer;
	}

	public void setCustomerName(Customer customer) {
		this.customer = customer;
	}

	public int getBookreviewId() {
		return bookreviewId;
	}

	public void setBookreviewId(int bookreviewId) {
		this.bookreviewId = bookreviewId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Review [bookreviewId=" + bookreviewId + ", ratings=" + ratings + ", headLine=" + headLine
				+ ", comments=" + comments + ", ReviewDate=" + ReviewDate + ", customer=" + customer + ", book=" + book
				+ "]";
	}

}
