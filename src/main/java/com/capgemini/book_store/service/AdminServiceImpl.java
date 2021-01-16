package com.capgemini.book_store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.book_store.bean.Admin;
import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.BookDetail;
import com.capgemini.book_store.bean.Category;
import com.capgemini.book_store.bean.Customer;
import com.capgemini.book_store.bean.Order;
import com.capgemini.book_store.bean.Review;
import com.capgemini.book_store.dao.IAdminDAO;
import com.capgemini.book_store.dao.IBookDAO;
import com.capgemini.book_store.dao.IBookDetailDAO;
import com.capgemini.book_store.dao.ICategoryDAO;
import com.capgemini.book_store.dao.ICustomerDAO;
import com.capgemini.book_store.dao.IOrderDAO;
import com.capgemini.book_store.dao.IReviewDAO;



@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IBookDAO bookDAO;

	@Autowired
	private IAdminDAO adminDAO;

	@Autowired
	private IReviewDAO reviewDAO;
	
	@Autowired
	private IBookDetailDAO bookDetailDAO;
	
	@Autowired
	private ICategoryDAO categoryDAO;
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	private IOrderDAO orderDAO;
	

	/* (non-Javadoc)
	 * @see com.capgemini.book_store.service.IAdminService#addAdmin(com.capgemini.book_store.bean.Admin)
	 */
	@Override
	public Admin addAdmin(Admin admin) {

		adminDAO.save(admin);
		return admin;

	}

	/* (non-Javadoc)
	 * @see com.capgemini.book_store.service.IAdminService#deleteAdmin(int)
	 */
	@Override
	public boolean deleteAdmin(int adminId) {

		adminDAO.deleteById(adminId);
		return true;

	}

	/* (non-Javadoc)
	 * @see com.capgemini.book_store.service.IAdminService#updateAdmin(com.capgemini.book_store.bean.Admin, int)
	 */
	@Override
	public Admin updateAdmin(Admin admin) {

//		Admin admin1 = adminDAO.findOne(adminId1);
//		if (admin.getPassword() == null) {
//			admin.setPassword(admin1.getPassword());
//		}
//		admin.setAdminId(admin.getAdminId());
		adminDAO.save(admin);
		return admin;

	}

	/* (non-Javadoc)
	 * @see com.capgemini.book_store.service.IAdminService#showAllAdmins(int)
	 */
	@Override
	public List<Admin> showAllAdmins() {

//		Admin admin = adminDAO.findOne(adminId);

//		List<Admin> l1 = adminDAO.findAll();
//		List<Admin> l2 = null;
//
//		for (int i = 0; i < l1.size(); i++) {
//			if (l1.get(i) != admin)
//				l2.add(l1.get(i));
//		}
//		return l2;
		System.out.println(adminDAO.findAll());
		return adminDAO.findAll();

	}

	/* (non-Javadoc)
	 * @see com.capgemini.book_store.service.IAdminService#addBook(com.capgemini.book_store.bean.Book)
	 */
	@Override
	public Book addBook(Book book) {

		bookDAO.save(book);
		return book;

	}

	/* (non-Javadoc)
	 * @see com.capgemini.book_store.service.IAdminService#deleteBook(int)
	 */
	@Override
	public boolean deleteBook(int bookId) {

		Optional<Book> oprBook = bookDAO.findById(bookId);
		Book book = oprBook.get();
		List<Review> li = reviewDAO.findByBook(book);
		if (li.isEmpty()) {
			bookDAO.deleteById(bookId);
			return true;
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see com.capgemini.book_store.service.IAdminService#updateBook(com.capgemini.book_store.bean.Book, int)
	 */
	@Override
	public Book updateBook(Book book) {

		// Book book1 = repo.findOne(book.getBookId());
		//book.setBookId(bookId);
		bookDAO.save(book);
		return book;

	}

	/* (non-Javadoc)
	 * @see com.capgemini.book_store.service.IAdminService#showAllBoks()
	 */
	@Override
	public List<Book> showAllBooks() {

		return bookDAO.findAll();
	}
	
	@Override
	public List<Customer> showAllCustomer()
	{
		
		return customerDAO.findAll();
	}
	
	
	@Override
	public boolean deleteCustomer(int customerId) {
		
		if(reviewDAO.findByCustomer(customerDAO.findById(customerId).get()) != null  || orderDAO.findByCustomer(customerDAO.findById(customerId).get())!=null) 
		{  return false;  }
		customerDAO.deleteById(customerId);
		return true;
	}
	
	
	@Override
	public Customer createCustomer(Customer customer) {
		if(customerDAO.findByEmailId(customer.getEmailId()) != null) {
			return null;
		}
		return customerDAO.save(customer);
	}
	
	
	@Override
	public boolean updateCustomer(Customer customer) {
		
		Customer cust=customerDAO.findById(customer.getCustomerId()).get();
		cust.setCustomerName(customer.getCustomerName());
		cust.setCity(customer.getCity());
		cust.setCountry(customer.getCountry());
		cust.setMobileNumber(customer.getMobileNumber());
		cust.setZipcode(customer.getZipcode());
		cust.setAddress(customer.getAddress());
		if(customerDAO.findByEmailId(customer.getEmailId()) == null) {
			cust.setEmailId(cust.getEmailId());
		}
		cust.setEmailId(customer.getEmailId());
		cust.setPassword(customer.getPassword());
		customerDAO.save(cust);
		return true;
		
	}
	
	
	@Override
	public List<Category> showAllCategory()
	{
		List<Category> li= categoryDAO.findAll();
		return li;
	}
	
	
	@Override
	public boolean deleteCategory(int categoryId) {
		
		/*if(bookRepo.findByCategory(categoryRepo.findById(categoryId).get()) != null) {
			return false;
		}*/
		categoryDAO.deleteById(categoryId);
		return true;
	}
	
	@Override
	public Category createCategory(Category category) {
		
		return categoryDAO.saveAndFlush(category);
	}
	
	
	@Override
	public boolean updateCategory(String categoryName, String upcategoryName) {
		
		List<Category> li = categoryDAO.findAll();
		for(Category c : li)
		{
			if(c.getCategoryName().equals(categoryName))
			{
				c.setCategoryName(upcategoryName);
				categoryDAO.save(c);
			}
		}
		return true;
		
		
	}
	@Override
	public List<Book> searchByCategory(String categoryName){
			
		System.out.println(categoryDAO.findByCategoryName(categoryName));
		return bookDAO.findByCategory(categoryDAO.findByCategoryName(categoryName));
		
		
	}
	
	/* Manage Orders */
	
	@Override
	public List<Order> getAllOrder() {
		return orderDAO.findAll();
	}

	@Override
	public boolean updateStatus(Order order) {
		Order ord = orderDAO.getOne(order.getOrderId());
		ord.setOrderStatus(order.getOrderStatus());
		orderDAO.saveAndFlush(ord);
		return true;
	}

	@Override
	public Map<Book, Integer> getAllBook(int orderId) {
		Map<Book, Integer> mBook = new HashMap<>();
		List<BookDetail> li = bookDetailDAO.findByOrder(orderDAO.findById(orderId).get());
		
		for(BookDetail b : li )
		{
			mBook.put(b.getBook(), b.getQuantity());
		}
	   System.out.println(mBook);
		return mBook;
	}

	/* Manage Review */

	@Override
	public boolean getAllReview(int bookId) {
		System.out.println("------"+bookDAO.getOne(bookId));
		System.out.println("-----"+reviewDAO.findByBook(bookDAO.getOne(bookId)));
		return true;
	}

	@Override
	public boolean updateReview(Review review) {
		Review rev = reviewDAO.findById(review.getBookreviewId()).get();
		rev.setHeadLine(review.getHeadLine());
		rev.setComments(review.getComments());
		reviewDAO.save(rev);
		return true;
	}

	@Override
	public boolean deleteReview(int reviewId) {
		reviewDAO.deleteById(reviewId);
		return true;
	}

}
