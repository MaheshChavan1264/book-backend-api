package com.book.Books.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.Books.model.Books;

public interface CrudBookDao extends JpaRepository<Books, Integer> {

}
