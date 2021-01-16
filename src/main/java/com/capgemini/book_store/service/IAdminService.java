package com.capgemini.book_store.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.capgemini.book_store.bean.Admin;
import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Category;
import com.capgemini.book_store.bean.Customer;
import com.capgemini.book_store.bean.Order;
import com.capgemini.book_store.bean.Review;

@Service
public interface IAdminService {

	public Admin addAdmin(Admin admin);

	public boolean deleteAdmin(int adminId);

	public Admin updateAdmin(Admin admin);

	public List<Admin> showAllAdmins();

	public Book addBook(Book book);

	public boolean deleteBook(int bookId);

	public Book updateBook(Book book);

	public List<Book> showAllBooks();

	List<Customer> showAllCustomer();

	
	boolean deleteCustomer(int customerId);

	
	Customer createCustomer(Customer customer);

	
	boolean updateCustomer(Customer customer);


	List<Category> showAllCategory();

	
	boolean deleteCategory(int categoryId);

	
	Category createCategory(Category category);

	
	boolean updateCategory(String categoryName, String upcategoryName);


	List<Book> searchByCategory(String categoryName);
	
	List<Order> getAllOrder();

	boolean updateStatus(Order order);

	Map<Book, Integer> getAllBook(int orderId);

	boolean getAllReview(int bookId);

	boolean updateReview(Review review);

	boolean deleteReview(int reviewId);

}