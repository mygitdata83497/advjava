<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Product Form</title>
</head>
<body>
	<form action="add.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter Product Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter Product Price</td>
				<td><input type="number" name="price" /></td>
			</tr>
			<tr>
				<td>Enter Product Quantity</td>
				<td><input type="number" name="quantity" /></td>
			</tr>
			<tr>
				<td>Enter Category ID</td>
				<td><input type="number" name="categoryId" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add A Product" /></td>
				</tr>
		</table>
	</form>

</body>
</html>