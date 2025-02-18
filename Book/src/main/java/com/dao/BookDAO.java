package com.dao;

import java.util.List;

import com.entity.Book;

public interface BookDAO {

	int addBook(Book book);

	int deleteBook(int bookId);

	int updateBook(Book book);

	Book getBookById(int bookid);

	

	List<Book> getAllBooks();

}
