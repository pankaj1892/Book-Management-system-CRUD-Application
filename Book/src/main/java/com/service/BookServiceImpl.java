package com.service;

import java.util.List;

import com.dao.BookDAO;
import com.dao.BookDAOImpl;
import com.entity.Book;

public class BookServiceImpl implements BookService {

	BookDAO dao = new BookDAOImpl();

	@Override
	public int insertBook(Book book) {

		return dao.addBook(book);
	}

	@Override
	public int removeBook(int id) {
		
		return dao.deleteBook(id);
	}

	@Override
	public int updateBook(Book book) {
		
		return dao.updateBook(book);
	}

	@Override
	public Book getBook(int id) {
	
		return dao.getBookById(id);
	}

	@Override
	public List<Book> getAllBook() {

		return dao.getAllBooks();
	}

}
