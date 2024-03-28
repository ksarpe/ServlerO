<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="database.Product" %>
<%@ page import="database.User" %>
<html>
<head>
    <title>Pomocnik Zakupowy by O.</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <header>
    <div class="container header-content">
        <h1>Pomocnik Zakupowy</h1>
        <div class="user-controls">
            <% 
                User currentUser = (User) session.getAttribute("currentUser");
                if (currentUser != null) {
            %>
                    <span class="welcome">Hej <%= currentUser.getUsername() %>!</span>
                    <form action="<%= request.getContextPath() %>/logout" method="get">
                        <button type="submit">Wyloguj</button>
                    </form>
            <% 
                } else { 
            %>
                    <a href="<%= request.getContextPath() %>/login.jsp">Login</a>
            <% 
                } 
            %>
        </div>
    </div>
</header>

    

<div class="container">
    <h2>Dodaj nowy produkt</h2>
    <form action="shoppingList" method="post">
    <label for="productName">Nazwa produktu:</label>
    <input type="text" id="productName" name="productName" required 
           pattern="[A-Za-z0-9 ]+" title="Tylko litery i cyfry są dozwolone.">
    
    <label for="productQuantity">Ilość:</label>
    <input type="text" id="productQuantity" name="productQuantity" required 
           pattern="\d+[A-Za-z]*" title="Wpisz liczbę i opcjonalnie jednostkę (np. 500ml).">
    
    
    <button type="submit">Dodaj</button>
</form>

    
    <h2>Lista zakupów:</h2>
    <table id="shoppingListTable">
    <tr>
        <th>Nazwa</th>
        <th>Ilość</th>
        <th>Akcje</th>
    </tr>
    <% 
        if (currentUser != null && currentUser.getShoppingList() != null) {
            List<Product> shoppingList = currentUser.getShoppingList();
            for (int i = 0; i < shoppingList.size(); i++) {
                Product product = shoppingList.get(i);
                out.println(""
                + "<tr>"
                + "<td>" + product.getName() + "</td><td>" + product.getQuantity()
                + "</td>"
                + "<td>"
                + "<button onclick='markItem(" + i + ");' class='mark-btn'>✓</button>"
                + "</td>"
                + "</tr>");
            }
        }
    %>
</table>

</div>

</body>

<script>
function markItem(index) {
    fetch('MarkProductServlet?index=' + index, {
        method: 'POST'
    }).then(response => {
        if(response.ok) {
            console.log('Item marked as bought');
            //refresh the page
            location.reload();
        } else {
            console.error('Failed to mark the item');
        }
    });
}
</script>

</html>
