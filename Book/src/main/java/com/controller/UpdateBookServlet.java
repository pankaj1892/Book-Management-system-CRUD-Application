package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;
import com.service.BookService;
import com.service.BookServiceImpl;

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService service;

	@Override
	public void init() throws ServletException {

		service = new BookServiceImpl();
	}

	public UpdateBookServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));

		Book book = new Book(id, name, price);

		int res = service.updateBook(book);
		RequestDispatcher rd = request.getRequestDispatcher("readBooks.jsp");
		if (res > 0) {

			out.print("<h2>data update..</h2>");
			rd.include(request, response);
			
		}
		else {
			out.print("<h2>data not update.......................</h2>");
		}
	}

}
