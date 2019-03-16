<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
div.container {
	border: 3px solid Blue;
	color: Black;
	border-style: dotted;
	padding-top: 20px;
	padding-right: 20px;
	padding-bottom: 20px;
	padding-left: 20px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

a:link, a:visited {
	background-color: #4CAF50;
	color: white;
	padding: 8px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

a:hover, a:active {
	background-color: #45a049;
}

table, th, td {
	border: 1px solid black;
	padding-top: 18px;
	padding-right: 18px;
	padding-bottom: 10px;
	padding-left: 10px;
	float: center;
}

input[type=text] {
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: center;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>

<br>

<div>${msg}</div>

<div class="container">
	<c:choose>
		<c:when test="${empty products}">
        	No Products found!<br>
        	<br> <a href="/product">Add New Product</a> <br>
    	</c:when>
	<c:otherwise>
	<br> <a href="/product">Add New Product</a> <br>
	<br> <a href="/item/all">View all Item</a> <br>
	<table style="width: 90%">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Price</td>
			<td>Quantity</td>
			<td>ItemId</td>
			<br>
		</tr>
		<c:forEach begin="0" end="${fn:length(products) - 1}" var="index">
			<tr>
				<td><c:out value="${products[index].id}" /></td>
				<td><c:out value="${products[index].name}" /></td>
				<td><c:out value="${products[index].price}" /></td>
				<td><c:out value="${products[index].quantity}" /></td>
				<td><c:out value="${products[index].itemid}" /></td>
				<td><a href="/products/<c:out value="${products[index].id}" />">edit</a></td>
				<td>
					<form action="/products/<c:out value="${products[index].id}"/>/delete"
						method="post">
						<input type="submit" value="Delete">
					</form>
				</td>
				<td><a href="/products/<c:out value="${products[index].id}" />/view/">View</a></td>
			</tr>
		</c:forEach>
	</table>
	</c:otherwise>
</c:choose>
</div>