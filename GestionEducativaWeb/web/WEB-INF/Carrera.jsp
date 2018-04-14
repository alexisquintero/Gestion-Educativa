<%-- 
    Document   : Carrera
    Created on : Apr 13, 2018, 8:52:05 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.entidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Carrera"%>
<%@page import="Negocio.ControladorGestion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carreras</title>
    </head>
    <body>     
        <%  ArrayList<Carrera> carreras = 
        (ArrayList<Carrera>)session.getAttribute("carreras"); %>
        <ul>           
            <c:forEach var="carrera" items="${carreras}">               
                <c:out value="${carrera.nombre}" />
            </c:forEach>
        </ul>
        <table> 
            <tr>
                <td><a href="?redirect=Crear">
                        Crear nueva carrera</a></td>
            </tr>
            <tr>
                <td><a href="?redirect=Editar">
                        Editar carrera existente</a></td>
            </tr>
            <tr>
                <td><a href="?redirect=Eliminar">
                        Eliminar carrera</a></td>
            </tr>
        </table> 
    </body>
</html>
