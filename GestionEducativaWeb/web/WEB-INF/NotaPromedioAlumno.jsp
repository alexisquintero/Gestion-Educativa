<%-- 
    Document   : NotaPromedioAlumno
    Created on : Jul 29, 2018, 6:45:32 PM
    Author     : Supervisor
--%>

<%@page import="java.util.Map"%>
<%@page import="Entidades.Alumno"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/abListado.css" type="text/css" rel="stylesheet">
        <title>Nota promedio de alumnos</title>
    </head>
    <body>
        <%  Map<Alumno, Integer> promedioAlumnos = 
        (Map<Alumno, Integer>)session.getAttribute("promedioAlumnos"); %>
        <div>
            <div>Alumnos</div>
            <table>
                <tr>
                    <th>Nombre</th>
                    <th style="text-align: left">Apellido</th>
                    <th>Nota</th>
                </tr>
                <c:forEach var="promedioAlumno" items="${promedioAlumnos}">
                    <tr>
                        <td><c:out value="${promedioAlumno.key.nombre}" /></td>
                        <td style="text-align: left"><c:out value="${promedioAlumno.key.apellido}" /></td>
                        <td><c:out value="${promedioAlumno.value}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
