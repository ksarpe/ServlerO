package product;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DeleteProduct extends HttpServlet {
    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        HttpSession session = request.getSession();
        List<String> shoppingList = (List<String>) session.getAttribute("shoppingList");
        if (shoppingList != null && index >= 0 && index < shoppingList.size()) {
            shoppingList.remove(index);
        }
        
        response.sendRedirect("index.jsp");
    }
}
