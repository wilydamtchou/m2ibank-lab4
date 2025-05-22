<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Créer un compte</title></head>
<body>
    <h2>Créer un nouveau compte</h2>

    <c:if test="${not empty erreurs}">
        <ul style="color:red;">
            <c:forEach var="err" items="${erreurs}">
                <li>${err}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form method="post" action="accounts">
        ID Client : <input type="text" name="clientId" value="${clientId}"/><br/>
        Type de compte :
        <select name="type">
            <option value="CHECKING" ${type == 'CHECKING' ? 'selected' : ''}>Courant</option>
            <option value="SAVINGS" ${type == 'SAVINGS' ? 'selected' : ''}>Épargne</option>
        </select><br/>
        <input type="submit" value="Créer"/>
    </form>
</body>
</html>
