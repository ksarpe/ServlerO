package product;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends HttpServlet {
    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        List<String> shoppingList = (List<String>) session.getAttribute("shoppingList");
        if (shoppingList == null) {
            shoppingList = new ArrayList<>();
        }
        
        String product = request.getParameter("productName") + " - Quantity: " + request.getParameter("productQuantity");
        shoppingList.add(product);
        
        session.setAttribute("shoppingList", shoppingList);
        
        response.sendRedirect("index.jsp");
    }
}
