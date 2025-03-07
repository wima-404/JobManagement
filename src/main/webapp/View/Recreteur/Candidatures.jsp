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
    <title>Mes Candidatures - SmartRecruit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Mes Candidatures</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Offre</th>
            <th>Entreprise</th>
            <th>Date Candidature</th>
            <th>Statut</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Développeur Java</td>
            <td>Tech Solutions</td>
            <td>15/03/2024</td>
            <td><span class="badge bg-warning">En cours</span></td>
            <td>
                <button class="btn btn-sm btn-info">Détails</button>
                <button class="btn btn-sm btn-danger">Retirer</button>
            </td>
        </tr>

        </tbody>
    </table>
</div>
</body>
</html>
