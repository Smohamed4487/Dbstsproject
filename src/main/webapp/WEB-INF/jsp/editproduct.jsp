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
	<form action="/product/${products.id}/" method="post">
		
		Name:<br> <input type="text" name="name" value="${products.name}"><br>
		Price:<br> <input type="number" name="price" value="${products.price}"> <br>
		Quantity:<br> <input type="number" name="quantity" value="${products.quantity}"><br>
		ItemID:<br> <input type="number" name="itemid" value="${products.itemid}"><br>
		<input type="submit" value="Save">
	</form>

</div>