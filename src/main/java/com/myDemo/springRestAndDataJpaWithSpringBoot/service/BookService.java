/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.service;

import java.util.List;

import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Book;

/**
 * @author gimanjun
 *
 */
public interface BookService {
	public List<Book> retrieveBooks();
	 
	 public Book getBook(Long bookId);
	 
	 public void saveBook(Book book);
	 
	 public void deleteBook(Long bookId);
	 
	 public void updateBook(Book book);
}
