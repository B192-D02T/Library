<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Add Book</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<div align="center">
			<h2>Add / Update Book</h2>
			<table>
				<form:form modelAttribute="book" action="saveBook" method="post">
					<form:hidden path="id" />
					<tr>
						<td class="studentprop"><b>BookName:</b></td>
						<td><form:input path="bookName" size="40" /></td>
						<td><form:errors path="bookName" class="error" /></td>
					</tr>

					<tr>
						<td class="studentprop"><b>Book Author:</b></td>
						<td><form:input path="Bookauthor" size="40" /></td>
						<td><form:errors path="Bookauthor" class="error" /></td>
					</tr>

					<tr>
						<td class="studentprop"><b>Publisher:</b></td>
						<td><form:input path="publisher" size="40" /></td>
						<td><form:errors path="publisher" class="error" /></td>
					</tr>

					<tr>
						<td></td>
						<td align="center"><form:button>Submit</form:button></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>