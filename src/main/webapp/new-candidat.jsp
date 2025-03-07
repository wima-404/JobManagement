<%--
  Created by IntelliJ IDEA.
  User: Faouz
  Date: 04/03/2025
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Tableau de Bord - SmartRecruit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">SmartRecruit</a>
        <div class="navbar-nav">
            <a class="nav-link" href="offres.jsp">Offres d'Emploi</a>
            <a class="nav-link" href="candidatures.jsp">Mes Candidatures</a>
            <a class="nav-link" href="logout">Déconnexion</a>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h1>Bienvenue, [Nom Utilisateur]</h1>

    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Offres Récentes</div>
                <div class="card-body">
                    <!-- Liste des offres récentes -->
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Mes Candidatures</div>
                <div class="card-body">
                    <!-- Liste des candidatures -->
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
```