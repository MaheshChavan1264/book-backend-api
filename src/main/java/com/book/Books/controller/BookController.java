package com.book.Books.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.Books.model.Books;
import com.book.Books.service.BookService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BookController {
	@Autowired
	private BookService bookService;
	
//	@RequestMapping(path = "/addbooks", method=RequestMethod.POST)
	@PostMapping("/addbooks")
	public Books saveBook(@RequestBody Books books) {
		return bookService.saveBook(books);
	}
	
	//@RequestMapping(path = "/getbooklist", method=RequestMethod.GET)
	@GetMapping("/getbooklist")
	public List<Books> fetchBookList(){
		
		List<Books> bookList = new ArrayList<Books>();
		bookList = bookService.fetchBookList();
		return bookList;
		
	}
	
	@GetMapping("/getbookbyid/{id}")
	public Optional<Books> fetchBookById(@PathVariable int id) {
		return bookService.fetchBookById(id);
	}
	
	@GetMapping("/deletebookbyid/{id}")
	public String deleteBookById(@PathVariable int id) {
		return bookService.deleteBookById(id);
	}
}
