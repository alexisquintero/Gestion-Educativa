<%-- 
    Document   : Bedel
    Created on : Apr 29, 2018, 3:10:52 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.Bedel"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bedeles</title>
    </head>
    <body>
        <%  List<Bedel> bedeles = 
        (List<Bedel>)session.getAttribute("bedeles"); %>
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
            <c:forEach var="bedel" items="${bedeles}">  
                <tr>
                    <td>
                        <c:out value="${bedel.nombre}" />
                    </td>       
                    <td>
                        <c:out value="${bedel.apellido}" />
                    </td>
                    <td>
                        <c:out value="${bedel.telefono}" />
                    </td>
                    <td>
                        <c:out value="${bedel.email}" />
                    </td>
                    <td>
                        <c:out value="${bedel.direccion}" />
                    </td>
                    <td>
                        <c:out value="${bedel.legajo}" />
                    </td>                    
                    <td>
                        <a href="Bedel?redirect=Editar&id=${bedel.idBedel}">
                        Editar</a>
                    </td>
                    <td>
                        <a href="Bedel?redirect=Eliminar&id=${bedel.idBedel}">
                        Eliminar</a>
                    </td>
                </tr>
            </c:forEach>          
        </table>
        <table> 
            <tr>
                <td><a href="Bedel?redirect=Crear">
                        Crear nuevo bedel</a></td>
            </tr>
        </table>
    </body>
</html>
