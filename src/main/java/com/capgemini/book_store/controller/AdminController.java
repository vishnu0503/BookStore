package com.capgemini.book_store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.book_store.bean.Admin;
import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Category;
import com.capgemini.book_store.bean.Customer;
import com.capgemini.book_store.bean.Order;
import com.capgemini.book_store.bean.Review;
import com.capgemini.book_store.service.IAdminService;

@RestController
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@RequestMapping(value = "/")
	public String printHello() {
		
		return "Hello";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addBook")
	public Book addBook(@RequestBody Book book) {
		
		return adminService.addBook(book);
//		return "Book Added Successfully";
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteBook/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		
		boolean result = adminService.deleteBook(bookId);
		if(result)
			return "Book Deleted Successfully";
		else
			return "Book Cannot be Deleted";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateBook")
	public Book updateBook(@RequestBody Book book) {
		
		Book book1 = adminService.updateBook(book);
		return book1;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/showAllBooks")	
	public List<Book> showAllBooks(){
		
		return adminService.showAllBooks();
				
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		
		return adminService.addAdmin(admin);
//		return "Admin Added Successfully";
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAdmin/{adminId}")
	public String deleteAdmin(@PathVariable int adminId) {
		
		adminService.deleteAdmin(adminId);
		return "Admin deleted successfully";
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		
		return adminService.updateAdmin(admin);
		
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/showAllAdmins")
	public List<Admin> showAllAdmins(){
		
		System.out.println(adminService.showAllAdmins());
		return adminService.showAllAdmins();
		
	}
	
	@RequestMapping(value = "/showAllCustomers", method=RequestMethod.GET)
	public List<Customer> showAllCustomer()
	{
		return adminService.showAllCustomer();
		
	}
	
	@RequestMapping(value="/deleteCustomer/{customerId}", method=RequestMethod.DELETE)
	public boolean deleteCustomer(@PathVariable int customerId) {
		
		
		return adminService.deleteCustomer(customerId);
	}
	
	@RequestMapping(value="/createCustomer", method=RequestMethod.PUT)
	public Customer createCustomer(@RequestBody Customer customer ) 
	{
	return adminService.createCustomer(customer);
	}
	
	@RequestMapping(value="/updateCustomer",method=RequestMethod.PUT)
	public boolean updateCustomer(@RequestBody Customer customer)
	{
		return adminService.updateCustomer(customer);
	}
	
	

	@RequestMapping(value = "/showAllCategory", method=RequestMethod.GET)
	public List<Category> showAllCategory()
	{
		return adminService.showAllCategory();
		
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}", method=RequestMethod.DELETE)
	public boolean deleteCategory(@PathVariable int categoryId) {
		
		
		return adminService.deleteCategory(categoryId);
	}
	
	@RequestMapping(value="/createCategory", method=RequestMethod.POST)
	public Category createCategory(@RequestBody Category category ) 
	{
	return adminService.createCategory(category);
	}
	
	@RequestMapping(value="/updateCategory/{categoryName}/{upCategoryName}",method=RequestMethod.PUT)
	public boolean updateCategory(@PathVariable String categoryName, @PathVariable String upCategoryName)
	{
		return adminService.updateCategory(categoryName,upCategoryName);
	}
	
	@RequestMapping(value="/searchByCategory/{categoryName}", method=RequestMethod.GET)
	public List<Book> searchByCategory(@PathVariable String categoryName){
		System.out.println(categoryName);
		return adminService.searchByCategory(categoryName);	
	}
	
	@RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
	public boolean getAllOrders()
	{
		System.out.println(adminService.getAllOrder());
		return true; 
	}
	
	@RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
	public boolean updateOrderStatus(@RequestBody Order order)
	{
		return adminService.updateStatus(order);
	}
	
	@RequestMapping(value = "/getAllBooks/{orderId}", method = RequestMethod.GET)
	public Map<Book, Integer> getAllBooks(@PathVariable int orderId)
	{
		return adminService.getAllBook(orderId);
	}
	
	@RequestMapping(value = "/getAllReview/{bookId}", method = RequestMethod.GET)
	public boolean getAllReview(@PathVariable int bookId)
	{
		return adminService.getAllReview(bookId);
	}
	
	@RequestMapping(value = "/updateReview", method = RequestMethod.PUT)
	public boolean updateReview(@RequestBody Review review)
	{
		return adminService.updateReview(review);
	}
	
	@RequestMapping(value = "/deleteReview/{reviewId}", method = RequestMethod.DELETE)
	public boolean deleteReview(@PathVariable int reviewId)
	{
		return adminService.deleteReview(reviewId);
	}
	
}
