<%@page import="java.util.List"%>
<%@page import="com.entity.Book"%>
<%@page import="com.service.BookServiceImpl"%>
<%@page import="com.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
	<h4>
		<a href="book.html">Add New Book</a>
	</h4>
	<%
        BookService service = new BookServiceImpl();
        List<Book> bList = service.getAllBook();
    %>

	<table id="Book" border="1">
		<tr>
			<th>BOOK ID</th>
			<th>BOOK NAME</th>
			<th>BOOK PRICE</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>

		<%
            if (bList != null) {
                for (Book book : bList) {
        %>
		<tr>
			<td><%= book.getId() %></td>
			<td><%= book.getName() %></td>
			<td><%= book.getPrice() %></td>
			<td><a href="DeleteBookServlet?id=<%= book.getId() %>">DELETE</a></td>
			<td><a href="updateBook.jsp?id=<%= book.getId() %>">UPDATE</a></td>
		</tr>
		<%
                }
            } else {
        %>
		<tr>
			<td colspan="5">No books available</td>
		</tr>
		<%
            }
        %>
	</table>

</body>
</html>
