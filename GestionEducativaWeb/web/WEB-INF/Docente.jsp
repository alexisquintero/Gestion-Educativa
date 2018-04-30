<%-- 
    Document   : Docente
    Created on : Apr 13, 2018, 8:53:09 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.entidad"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Docente"%>
<%@page import="Negocio.ControladorGestion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Docentes</title>
    </head>
    <body>
        <%  List<Docente> docentes = 
        (List<Docente>)session.getAttribute("docentes"); %>
        <table>    
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
                <th>Email</th>
                <th>Dirección</th>
                <th>Legajo</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach var="docente" items="${docentes}">  
                <tr>
                    <td>
                        <c:out value="${docente.nombre}" />
                    </td>       
                    <td>
                        <c:out value="${docente.apellido}" />
                    </td>
                    <td>
                        <c:out value="${docente.telefono}" />
                    </td>
                    <td>
                        <c:out value="${docente.email}" />
                    </td>
                    <td>
                        <c:out value="${docente.direccion}" />
                    </td>
                    <td>
                        <c:out value="${docente.legajo}" />
                    </td>                    
                    <td>
                        <a href="Docente?redirect=Editar&id=${docente.idDocente}">
                        Editar</a></td>
                    </td>
                                        <td>
                        <a href="Docente?redirect=Eliminar&id=${docente.idDocente}">
                        Eliminar</a></td>
                    </td>
                </tr>
            </c:forEach>          
        </table>
        <table> 
            <tr>
                <td><a href="Docente?redirect=Crear">
                        Crear nuevo docente</a></td>
            </tr>
        </table>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
