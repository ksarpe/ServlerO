<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Shopping List</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<h2>My Shopping List</h2>

<table>
    <tr>
        <th>Product Name</th>
        <th>Quantity</th>
    </tr>
    <% 
        List<String> shoppingList = (List<String>) request.getSession().getAttribute("shoppingList");
        if (shoppingList != null) {
            for(String item : shoppingList) {
                String[] parts = item.split(" - Quantity: ");
                out.println("<tr><td>" + parts[0] + "</td><td>" + parts[1] + "</td></tr>");
            }
        }
    %>
</table>

</body>
</html>
