<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="a" tagdir="/WEB-INF/tags"%>
<a:enTete titre="Membre supprimé"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suppression d'un membre</title>
    </head>
    <body>
        <h1>Membre supprimé avec succès</h1>
        <hr>
        <c:forEach items="membres" var="membre">
            <a href="membresCanal?idCanal=1">Les membres du canal</a>
        </c:forEach>
        </body>
</html>