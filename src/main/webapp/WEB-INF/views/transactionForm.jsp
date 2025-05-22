<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Nouvelle transaction</title></head>
<body>
    <h2>Effectuer une transaction</h2>

    <c:if test="${not empty erreurs}">
        <ul style="color:red;">
            <c:forEach var="err" items="${erreurs}">
                <li>${err}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form method="post" action="transactions">
        Compte source : <input type="text" name="sourceAccountId" value="${sourceAccountId}"/><br/>
        Compte cible : <input type="text" name="targetAccountId" value="${targetAccountId}"/><br/>
        Montant : <input type="text" name="montant" value="${montant}"/><br/>
        Type :
        <select name="type">
            <option value="DEPOSIT" ${type == 'DEPOSIT' ? 'selected' : ''}>Dépôt</option>
            <option value="WITHDRAWAL" ${type == 'WITHDRAWAL' ? 'selected' : ''}>Retrait</option>
            <option value="TRANSFER" ${type == 'TRANSFER' ? 'selected' : ''}>Virement</option>
        </select><br/>
        <input type="submit" value="Valider"/>
    </form>
</body>
</html>
