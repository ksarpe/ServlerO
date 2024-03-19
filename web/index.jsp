<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<h2>Add Product to Shopping List</h2>

<form action="shoppingList" method="post">
    <label for="productName">Product Name:</label>
    <input type="text" id="productName" name="productName" required>
    
    <label for="productQuantity">Quantity:</label>
    <input type="number" id="productQuantity" name="productQuantity" required min="1" value="1">
    
    <button type="submit">Add to list</button>
</form>

</body>
</html>
