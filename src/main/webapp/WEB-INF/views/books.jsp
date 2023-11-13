<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Student-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/template/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<h2>Books</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>Book Name</th>
				<th>Book Author</th>
				<th>Publisher</th>
				<th>CreateDate</th>
			</tr>

			<c:forEach items="${bookList}" var="book" varStatus="status">

				<!-- create an "update" link with Book id -->

				<c:url var="updateLink" value="/book/update">
					<c:param name="id" value="${book.id}" />
				</c:url>

				<!-- create an "delete" link with Book id -->
				<c:url var="deleteLink" value="/book/delete">
					<c:param name="id" value="${book.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'lightgray':'#9484d5'}">
					<td>${book.id}</td>
					<td>${book.bookName}</td>
					<td>${book.Bookauthor}</td>
					<td>${book.publisher}</td>
					<td>${book.createDate}</td>
					<td>
						<!-- show the links --> 
						 
						<a class="update" href="${updateLink}">Update</a> 
						<a class="delete" href="${pageContext.request.contextPath}/book/delete/${book.id}">Delete</a>
						<!--   <a class="delete" href="${deleteLink}"> Delete</a>-->
					</td>

				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/book/new">Add Book</a>
	</div>
</body>
</html>