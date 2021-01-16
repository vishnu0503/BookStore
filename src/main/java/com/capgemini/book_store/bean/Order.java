package com.capgemini.book_store.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(generator = "order", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "order", sequenceName = "five", initialValue = 100, allocationSize = 1)
	private int orderId;

	@OneToOne
	private Customer customer;

	private int totalQuant;

	private double price;

	private String paymentMethod;

	private Date orderDate;

	private String receipientName;

	private String orderStatus;

	@OneToMany(targetEntity = BookDetail.class)
	private List<BookDetail> details;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getTotalQuant() {
		return totalQuant;
	}

	public void setTotalQuant(int totalQuant) {
		this.totalQuant = totalQuant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getReceipientName() {
		return receipientName;
	}

	public void setReceipientName(String receipientName) {
		this.receipientName = receipientName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<BookDetail> getDetails() {
		return details;
	}

	public void setDetails(List<BookDetail> details) {
		this.details = details;
	}

}
