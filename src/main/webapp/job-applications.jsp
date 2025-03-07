<%--
  Created by IntelliJ IDEA.
  User: youne
  Date: 3/5/2025
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Job Applications</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Job Applications</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Application ID</th>
            <th>Job Offer</th>
            <th>Candidate</th>
            <th>Application Date</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="application" items="${applications}">
            <tr>
                <td>${application.id}</td>
                <td>${application.offreEmploiId}</td>
                <td>${application.candidatId}</td>
                <td>${application.dateCandidature}</td>
                <td>${application.statut}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>