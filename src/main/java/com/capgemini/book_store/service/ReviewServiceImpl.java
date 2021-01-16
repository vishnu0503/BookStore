package com.capgemini.book_store.service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Customer;
import com.capgemini.book_store.bean.Review;
import com.capgemini.book_store.dao.IBookDAO;
import com.capgemini.book_store.dao.IReviewDAO;


@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

	
	@Autowired
	IBookDAO bookDAO;
	
	@Autowired
	IReviewDAO reviewDAO;
	
	@Override
	public Book search(String bookName) 
	{
		Book b=bookDAO.findBytitle(bookName);
		return b;
	}

	@Override
	public Customer validate(String cname)
	{
		Customer c=reviewDAO.findBycustomerName(cname);
		if(c!=null)
			return c;
		else
		    return null;
	}
	
	@Override
	public Review createReview(Review review)
	{
		return reviewDAO.save(review);
	}

	@Override
	public float average(String bookName, int rating)
	{
		List<Review> rlist=reviewDAO.findByBook(bookDAO.findBytitle(bookName));
		float total=0;
		for(Review r:rlist)
		{
			total+=r.getRatings();
			//System.out.println(total);
		}
		total=total+rating;
		float avg=total/(rlist.size()+1);
		Book book=bookDAO.findBytitle(bookName);
		book.setOverallRating(avg);
		bookDAO.save(book);
		return avg;
	}
	
	@Override
	public List<Book> findByRating()
	{
	    List<Book> blist=bookDAO.findAll();
	    Comparator<Book> comparator = (book1, book2) -> {
            return new Float(book1.getOverallRating()).compareTo(new Float(book2.getOverallRating()));
	    };
	    Collections.sort(blist,comparator.reversed());
		return blist;
	    
		
	}

	@Override
	public List<Book> findByOrder() 
	{
		List<Book> blist=bookDAO.findAll();
		Comparator<Book> comparator = (book1, book2) -> {
            return new Float(book1.getQtySold()).compareTo(new Float(book2.getQtySold()));
	    };
	    Collections.sort(blist,comparator.reversed());
		return blist;
	}

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
