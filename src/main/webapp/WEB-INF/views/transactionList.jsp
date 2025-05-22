<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Liste des transactions</title></head>
<body>
    <h2>Transactions enregistrées</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Source</th><th>Cible</th><th>Montant</th><th>Date</th><th>Type</th><th>Statut</th>
        </tr>
        <c:forEach var="tx" items="${transactions}">
            <tr>
                <td>${tx.transactionId}</td>
                <td>${tx.sourceAccountId}</td>
                <td>${tx.targetAccountId}</td>
                <td>${tx.montant}</td>
                <td>${tx.dateHeure}</td>
                <td>${tx.type}</td>
                <td>${tx.statut}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="transactionForm.jsp">Effectuer une transaction</a>
</body>
</html>
