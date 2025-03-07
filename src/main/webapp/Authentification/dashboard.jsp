<%--
  Created by IntelliJ IDEA.
  User: Faouz
  Date: 04/03/2025
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession sessionUser = request.getSession(false);
    if (sessionUser == null || sessionUser.getAttribute("username") == null) {
        response.sendRedirect("login.jsp?error=Veuillez vous connecter !");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Tableau de bord</title>
</head>
<body>
<h2>Bienvenue, <%= sessionUser.getAttribute("username") %>!</h2>
<form action="auth" method="post">
    <input type="hidden" name="action" value="logout">
    <button type="submit">Déconnexion</button>
</form>
</body>
</html>


