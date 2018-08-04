<%-- 
    Document   : NotaPromedioFinal
    Created on : Jul 29, 2018, 6:41:33 PM
    Author     : Supervisor
--%>

<%@page import="java.util.Map"%>
<%@page import="Entidades.Final"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/abListado.css" type="text/css" rel="stylesheet">
        <title>Nota promedio de finales</title>
    </head>
    <body>
        <%  Map<Final, Integer> promedioFinales = 
        (Map<Final, Integer>)session.getAttribute("promedioFinales"); %>
        <div>
            <div>Finales</div>
            <table>
                <tr>
                    <th>Fecha</th>
                    <th style="text-align: left">Aula</th>
                    <th>Nota</th>
                </tr>
                <c:forEach var="promedioFinal" items="${promedioFinales}">
                    <tr>
                        <td><c:out value="${promedioFinal.key.fecha}" /></td>
                        <td style="text-align: left"><c:out value="${promedioFinal.key.aula}" /></td>
                        <td><c:out value="${promedioFinal.value}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
