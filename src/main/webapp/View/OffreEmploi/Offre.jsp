<%--
  Created by IntelliJ IDEA.
  User: Faouz
  Date: 04/03/2025
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Offres d'Emploi - SmartRecruit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Offres d'Emploi</h1>

    <div class="row mb-3">
        <div class="col-md-6">
            <input type="text" class="form-control" placeholder="Rechercher une offre">
        </div>
        <div class="col-md-4">
            <select class="form-select">
                <option>Tous les domaines</option>
                <option>Informatique</option>
                <option>Marketing</option>
                <option>Finance</option>
            </select>
        </div>
        <div class="col-md-2">
            <button class="btn btn-primary">Rechercher</button>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">Développeur Java</h5>
                    <p class="card-text">Entreprise: Tech Solutions</p>
                    <p class="card-text">Description courte de l'offre...</p>
                    <a href="#" class="btn btn-success">Postuler</a>
                </div>
            </div>
            <!-- Autres offres similaires -->
        </div>
    </div>
</div>
</body>
</html>
```
