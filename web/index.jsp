<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" DO NAPRAWY %>--%> 
<%@ page import="java.util.List" %>
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
                <c:choose>
                    <c:when test="${not empty sessionScope.currentUser}">
                        <p>Welcome, ${sessionScope.currentUser.username}!</p>
                        <form action="${pageContext.request.contextPath}/logout" method="get">
                            <button type="submit">Logout</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </header>
    

<div class="container">
    <h2>Dodaj nowy produkt</h2>
    <form action="shoppingList" method="post">
        <label for="productName">Nazwa produktu:</label>
        <input type="text" id="productName" name="productName" required>
        
        <label for="productQuantity">Ilość:</label>
        <input type="number" id="productQuantity" name="productQuantity" required min="1" value="1">
        
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
            List<String> shoppingList = (List<String>) request.getSession().getAttribute("shoppingList");
            if (shoppingList != null) {
                for(int i = 0; i < shoppingList.size(); i++) {
                    String item = shoppingList.get(i);
                    String[] parts = item.split(" - Quantity: ");
                    out.println("<tr><td>" + parts[0] + "</td><td>" + parts[1]
                    + "</td><td>"
                    + "<button onclick='markItem(this);' class='mark-btn'>✓</button>"
                    + "<form action='delete' method='get' style='display:inline;'><input type='hidden' name='index' value='" + i + "'/><button type='submit' class='delete-btn'>X</button></form>"
                    + "</td></tr>");
                }
            }
        %>
</table>

</div>

</body>

<script>
function markItem(btn, index) {
    // Przekreślenie wiersza
    var row = btn.parentNode.parentNode;
    row.classList.add("marked");
    
    // Przenoszenie wiersza na koniec tabeli
    var table = document.getElementById("shoppingListTable");
    table.tBodies[0].appendChild(row);
    
    // Opcjonalnie: Wywołaj serwlet w tle, aby zapisać stan "odhaczenia" produktu
    // fetch('mark?index=' + index).then(response => console.log('Item marked'));
}
</script>

</html>
