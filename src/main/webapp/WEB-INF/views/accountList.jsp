<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Liste des comptes</title></head>
<body>
    <h2>Comptes enregistrés</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Client</th><th>Type</th><th>Solde</th><th>Ouverture</th><th>Statut</th>
        </tr>
        <c:forEach var="acc" items="${accounts}">
            <tr>
                <td>${acc.accountId}</td>
                <td>${acc.clientId}</td>
                <td>${acc.type}</td>
                <td>${acc.solde}</td>
                <td>${acc.dateOuverture}</td>
                <td>${acc.statut}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
