package com.capgemini.book_store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Customer;
import com.capgemini.book_store.bean.Order;
import com.capgemini.book_store.bean.Review;
import com.capgemini.book_store.exception.EmailIdAlreadyExists;
import com.capgemini.book_store.service.CustomerService;
import com.capgemini.book_store.service.OrderService;
import com.capgemini.book_store.service.ReviewService;

@RestController

public class CustomerController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	CustomerService service;
	@Autowired
	OrderService orderService;
	


	@RequestMapping(value = "/register", method = RequestMethod.PUT)
	public String createCustomer(@RequestBody Customer customer) {

		boolean result = service.createCustomer(customer);
		if (result)
			return "Customer created successfully";
		else
			throw new EmailIdAlreadyExists("Email already exists");

	}

	@RequestMapping(value = "/validate/{emailId}/{password}", method = RequestMethod.POST)
	public String validate(@PathVariable("emailId") String emailId, @PathVariable("password") String password) {
		boolean result = service.validate(emailId, password);
		if (result) {
			return "successfull Login....";
		}

		return "Invalid Credentials......";

	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.PUT)
	public String update(@RequestBody Customer customer) {
		Customer c1 = service.update(customer);
		if (c1 != null)
			return "Succesfully Updated...";
		else
			return "Failed....";

	}

	@RequestMapping(value = "/viewOrder/{customerId}", method = RequestMethod.GET)
	public List<Order> viewOrder(@PathVariable("customerId") int customerId) {

		return orderService.vieworders(customerId);

	}

	@RequestMapping(value = "/search/{bookName}", method = RequestMethod.GET)
	public String search(@PathVariable("bookName") String bookName) {

		Book b = reviewService.search(bookName);
		if (b != null) {
			String s = "Book details are " + b;
			return s;
		} else
			return "Book not found!!!";
	}

	@RequestMapping(value = "/createReview", method = RequestMethod.PUT)
	public String create(@RequestBody Review review) {

		reviewService.createReview(review);
		reviewService.average(review.getBook().getTitle(), review.getRatings());
		return "Thank you for giving the review";
	}

	@RequestMapping(value = "/favbook", method = RequestMethod.GET)
	public List<Book> favBook() {

		return reviewService.findByRating();
	}

	@RequestMapping(value = "/bestbook", method = RequestMethod.GET)
	public List<Book> bestBook() {
		
		return reviewService.findByOrder();
		
	}

	@RequestMapping("/update/{customerId}/{bookId}/{qty}")
	public String update(@PathVariable int customerId, @PathVariable int bookId, @PathVariable int qty) {
	 
		 orderService.update(customerId, bookId, qty);
		return "Updated Successfully";

	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.PUT)
	public String placeOrder(@RequestBody Order order) {

		orderService.createOrder(order);
		return "Your order has been placed successfuly";

	}
	

	@RequestMapping("/AddToCart/{qty}/{bookId}")
	public Map<Book,Integer> addToCart(@PathVariable("qty") int qty,@PathVariable("bookId") int bookId ) {
		Map<Book, Integer> b = orderService.findByBookId(bookId,qty);
		
		return b;

	}

	/*@RequestMapping("/delete/{bookname}")
	public String delete(@PathVariable("bookname") String bookname) {
		Book b = orderService.findByBookName(bookname);
		// int id=b.getBookId();
		blist.remove(b);
		return "Successfully deleted";
	}*/

}
