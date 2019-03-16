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
	padding-top: 10px;
	padding-right: 10px;
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
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>

<br>
<br>

<div>${msg}</div>
	<br> <a href="/item">Add New Item</a> <br>

<div class="container">
	<c:choose>
		<c:when test="${empty i}">
        	No Items found!
    	</c:when>
	<c:otherwise>
	<table style="width: 70%">
		<tr>
			<td>Item ID</td>
			<td>Brand</td>
			<td>Description</td>
			<td>No of Products</td>
			<br>
		</tr>
		<c:forEach begin="0" end="${fn:length(i) - 1}" var="index">
			<tr>
				<td><c:out value="${i[index].itemid}" /></td>
				<td><c:out value="${i[index].brand}" /></td>
				<td><c:out value="${i[index].description}" /></td>
				<td><c:out value="${i[index].noofproducts}" /></td>
				<td><a href="/items/<c:out value="${i[index].itemid}" />">edit</a></td>
				<td>
					<form action="/items/<c:out value="${i[index].itemid}"/>/delete"
						method="post">
						<input type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:otherwise>
</c:choose>
</div>