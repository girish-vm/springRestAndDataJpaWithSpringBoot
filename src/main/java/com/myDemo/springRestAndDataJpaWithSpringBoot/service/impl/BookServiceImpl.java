/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Book;
import com.myDemo.springRestAndDataJpaWithSpringBoot.repository.BookRepository;
import com.myDemo.springRestAndDataJpaWithSpringBoot.service.BookService;

/**
 * @author gimanjun
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> retrieveBooks() {
		// TODO Auto-generated method stub
		List<Book> books = bookRepository.findAll();
		  return books;
	}

	@Override
	public Book getBook(Long bookId) {
		// TODO Auto-generated method stub
		Optional<Book> optBook = bookRepository.findById(bookId);
		  return optBook.get();
	}

	@Override
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long bookId) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(bookId);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	
	
	
}


