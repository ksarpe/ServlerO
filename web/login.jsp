<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    <style>
      .error-message {
        color: red;
      }
    </style>
  </head>
  <body>
    <form action="login" method="post">
      <input type="text" name="username" required placeholder="Username" />
      <input type="password" name="password" required placeholder="Password" />
      <button type="submit">Login</button>
      <% if (request.getParameter("error") != null) { %>
      <p class="error-message">Błędne dane logowania.</p>
      <% } %>
    </form>
  </body>
</html>
