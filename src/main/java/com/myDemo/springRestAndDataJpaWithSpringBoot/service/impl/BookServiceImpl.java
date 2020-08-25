/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
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
	@Transactional
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
	@Transactional
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	
	
	
}


