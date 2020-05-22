<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Agriotes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">   
    </head>
    <body>
        <div class="sidenav">
            <a href="deconnexion">Déconnexion</a>
        </div> 
        <h1>Les membres du canal ${idCanal}</h1>
        <hr>
        <form action="membresCanal" method="post">
            <table width = "300px" border="1">
                <tr>
                    <th>Id canal</th>
                    <th>Id personne</th>
                    <th>Supprimer</th>
                </tr>
                <c:forEach items="${membres}" var="membre">
                    <tr>  
                        <td>${membre.idCanal}</td>
                        <td>${membre.idPersonne}</td>
                        <td>
                            <input type="hidden" name="idCanal" value="${membre.idCanal}"/>
                            <input type="hidden" name="idPersonne" value="${membre.idPersonne}"/>
                            <button type="submit">Supprimer</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <a href="ajouterMembresCanal?idCanal=1">Ajouter</a><hr>                      
    </body>
</html>