package com.capgemini.book_store.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(generator = "book", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "book", sequenceName = "book123", initialValue = 100, allocationSize = 1)
	private int bookId;

	private int quantity;

	private static int qtySold;

	private double price;

	@OneToOne
	private Category category;

	@Size(max = 128)
	private String title;

	@Size(max = 64)
	private String author;

	@Size(max = 2000)
	private String description;

	@Size(max = 15)
	private String isbnNmber;

	private String imageLink;

	private Date publishDate;

	private Date lastUpdate;

	@Max(5)
	private float overallRating;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQtySold() {
		return qtySold;
	}

	public void setQtySold(int qtySold) {
		this.qtySold = qtySold;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbnNmber() {
		return isbnNmber;
	}

	public void setIsbnNmber(String isbnNmber) {
		this.isbnNmber = isbnNmber;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public float getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(float overallRating) {
		this.overallRating = overallRating;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", quantity=" + quantity + ", price=" + price + ", category=" + category
				+ ", title=" + title + ", author=" + author + ", description=" + description + ", isbnNmber="
				+ isbnNmber + ", imageLink=" + imageLink + ", publishDate=" + publishDate + ", lastUpdate=" + lastUpdate
				+ ", overallRating=" + overallRating + "]";
	}

}
