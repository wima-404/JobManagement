<%--
  Created by IntelliJ IDEA.
  User: Faouz
  Date: 04/03/2025
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-top: 10px;
        }
        input, select {
            margin-bottom: 15px;
            padding: 10px;
        }
        button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .error {
            color: red;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<h2>Connexion</h2>

<%
    // Gestion des messages d'erreur
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<div class="error"><%= errorMessage %></div>
<% } %>

<form action="LoginServlet" method="post">
    <label for="email">Email :</label>
    <input type="email" id="email" name="email" required
           placeholder="Entrez votre email">

    <label for="password">Mot de passe :</label>
    <input type="password" id="password" name="password" required
           placeholder="Entrez votre mot de passe">

    <label for="role">Rôle :</label>
    <select id="role" name="role" required>
        <option value="">Selectionnez un role</option>
        <option value="CANDIDATURE">Candidature</option>
        <option value="RECRUTEMENT">Recreteur</option>
    </select>

    <button type="submit">Se connecter</button>
</form>
</body>
</html>