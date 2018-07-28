<%-- 
    Document   : CantidadAlumnosMateria
    Created on : Jul 27, 2018, 11:31:38 PM
    Author     : Supervisor
--%>

<%@page import="java.util.Map"%>
<%@page import="Entidades.Materia"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cantidad de alumnos por materia</title>
    </head>
    <body>
        <%  Map<Materia, Integer> materiasAlumnos = 
        (Map<Materia, Integer>)session.getAttribute("materiasAlumnos"); %>
        <table>
            <tr>
                <th>Materia</th>
                <th>Alumnos</th>
            </tr>
            <c:forEach var="materiaAlumno" items="${materiasAlumnos}">
                <tr>
                    <td><c:out value="${materiaAlumno.key.nombre}" /></td>
                    <td><c:out value="${materiaAlumno.value}" /></td>
                </tr>
            </c:forEach>
        </table>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
