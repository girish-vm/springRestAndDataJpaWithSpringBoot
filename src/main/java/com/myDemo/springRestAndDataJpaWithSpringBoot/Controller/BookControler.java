/**
 * 
 */
package com.myDemo.springRestAndDataJpaWithSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myDemo.springRestAndDataJpaWithSpringBoot.entity.Book;
import com.myDemo.springRestAndDataJpaWithSpringBoot.service.BookService;

/**
 * @author gimanjun
 *
 */
@RestController
public class BookControler {

	@Autowired
	 private BookService bookService;
	 
	 public void setEmployeeService(BookService bookService) {
	  this.bookService = bookService;
	 }

	 @GetMapping("/api/books")
	 public List<Book> getBooks() {
	  List<Book> books = bookService.retrieveBooks();
	  return books;
	 }
	 
	 @GetMapping("/api/books/{bookId}")
	 public Book getBook(@PathVariable(name="bookId")Long bookId) {
	  return bookService.getBook(bookId);
	 }
	 
	 @PostMapping("/api/books")
	 public void saveBook(@RequestBody Book book){
		 bookService.saveBook(book);
	  System.out.println("book Saved Successfully");
	 }
	 
	 @DeleteMapping("/api/books/{bookId}")
	 public void deleteEmployee(@PathVariable(name="bookId")Long bookId){
		 bookService.deleteBook(bookId);
	  System.out.println("book Deleted Successfully");
	 }
	 
	 @PutMapping("/api/books/{bookId}")
	 public void updateBook(@RequestBody Book book,
	   @PathVariable(name="bookId")Long bookId){
	  Book updateBook = bookService.getBook(bookId);
	  if(updateBook != null){
		  bookService.updateBook(updateBook);
	  }
	  
	 }
	}
	

