<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>

div.container{
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

input[type=number] {
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

<div class="container">
	<form action="/product" method="post">
		Name:<br> <input type="text" name="name" ><br>
		Price:<br> <input type="number" name="price" > <br>
		Quantity:<br> <input type="number" name="quantity"><br>
		<select name="itemid">
			<c:forEach begin="0" end="${fn:length(items) - 1}" var="index">
				<option value="	<c:out value="${items[index].itemid}" />">
								<c:out value="${items[index].brand}" />
				</option>
			</c:forEach>
		</select>		
		<input type="submit" value="Save">
	</form>
</div>





