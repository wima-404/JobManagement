<%--
  Created by IntelliJ IDEA.
  User: youne
  Date: 3/5/2025
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Apply for Job</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Apply for Job: ${jobOffer.titre}</h2>
    <form action="JobApplicationController" method="post">
        <input type="hidden" name="action" value="submit">
        <input type="hidden" name="jobOfferId" value="${jobOffer.id}">

        <div class="form-group">
            <label for="candidateId">Select Candidate</label>
            <select class="form-control" id="candidateId" name="candidateId" required>
                <!-- Populate with candidates from database -->
                <option value="">Select Candidate</option>
            </select>
        </div>

        <div class="form-group">
            <label for="lettreMutation">Motivation Letter</label>
            <textarea class="form-control" id="lettreMutation" name="lettreMutation" rows="5" required></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Submit Application</button>
    </form>
</div>
</body>
</html>