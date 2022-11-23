package com.book.Books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.Books.dao.CrudBookDao;
import com.book.Books.model.Books;

@Service
public class BookService {

	@Autowired
	private CrudBookDao bookdao;
	
	public Books saveBook(Books books) {
		return bookdao.save(books);
	}

	public List<Books> fetchBookList() {
		
		return bookdao.findAll();
	}

	public Optional<Books> fetchBookById(int id) {
		// TODO Auto-generated method stub
		return bookdao.findById(id);
	}

	public String deleteBookById(int id) {
		String result;
		try {
			bookdao.deleteById(id);
			result = "Successfully deleted";
		}
		catch(Exception e) {
			result = "Select book id was not deleted";
		}
		
		return result;
	}
}
