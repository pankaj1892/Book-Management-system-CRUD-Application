package com.service;

import java.util.List;

import com.entity.Book;

public interface BookService {
	int insertBook(Book book);

	int removeBook(int id);

	int updateBook(Book book);

	Book getBook(int id);

	List<Book> getAllBook();

}
