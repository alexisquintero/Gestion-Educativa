<%-- 
    Document   : Moderador
    Created on : Apr 13, 2018, 8:52:39 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.entidad"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Moderador"%>
<%@page import="Negocio.ControladorGestion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Moderadores</title>
    </head>
    <body>
        <%  List<Moderador> moderadores = 
        (List<Moderador>)session.getAttribute("moderadores"); %>
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
            <c:forEach var="moderador" items="${moderadores}">  
                <tr>
                    <td>
                        <c:out value="${moderador.nombre}" />
                    </td>       
                    <td>
                        <c:out value="${moderador.apellido}" />
                    </td>
                    <td>
                        <c:out value="${moderador.telefono}" />
                    </td>
                    <td>
                        <c:out value="${moderador.email}" />
                    </td>
                    <td>
                        <c:out value="${moderador.direccion}" />
                    </td>
                    <td>
                        <c:out value="${moderador.legajo}" />
                    </td>
                    <td>
                        <a href="Moderador?redirect=Editar&id=${moderador.idModerador}">
                        Editar</a></td>
                    </td>
                                        <td>
                        <a href="Moderador?redirect=Eliminar&id=${moderador.idModerador}">
                        Eliminar</a></td>
                    </td>
                </tr>
            </c:forEach>          
        </table>
        <table> 
            <tr>
                <td><a href="Moderador?redirect=Crear">
                        Crear nuevo moderador</a></td>
            </tr>
        </table> 
    </body>
</html>
