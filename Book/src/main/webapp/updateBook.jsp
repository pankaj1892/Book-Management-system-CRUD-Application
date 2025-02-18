<%@page import="com.entity.Book"%>
<%@page import="com.service.BookServiceImpl"%>
<%@page import="com.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	BookService service = new BookServiceImpl();

	Book book = service.getBook(id);
	RequestDispatcher rd = request.getRequestDispatcher("readBooks.jsp");

	if (book != null) {
	%>
	<form action="UpdateBookServlet" Method="get">

		ID<input type="text" name="id" value="<%=book.getId()%>" readonly><br>
		NAME<input type="text" name="name" value="<%=book.getName()%>"><br>
		PRICE<input type="text" name="price" value="<%=book.getPrice()%>"><br>
		<input type="submit" value="UPDATE"><br>
	</form>

	<%
	rd.include(request, response);

	} else {
	%>
	<h2>Record Not Found.......</h2>

	<%
	}
	%>
</body>
</html>