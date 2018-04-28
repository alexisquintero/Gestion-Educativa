<%-- 
    Document   : Comision
    Created on : Apr 27, 2018, 8:47:33 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.entidad"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Comision"%>
<%@page import="Negocio.ControladorGestion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comision</title>
    </head>
    <body>
        <%  List<Comision> comisiones = 
        (List<Comision>)session.getAttribute("comisiones"); %>
        <table>    
            <tr>
                <th>Aula</th>
                <th>Cupo</th>
            </tr>
            <c:forEach var="comision" items="${comisiones}">  
                <tr>
                    <td>
                        <c:out value="${comision.aula}" />
                    </td>       
                    <td>
                        <c:out value="${comision.cupo}" />
                    </td>                                        
                    <td>
                        <a href="Comision?redirect=Editar&id=${comision.idComision}">
                        Editar</a>
                    </td>
                    <td>
                        <a href="Comision?redirect=Eliminar&id=${comision.idComision}">
                        Eliminar</a>
                    </td>
                </tr>
            </c:forEach>          
        </table>
        <table> 
            <tr>
                <td><a href="Comision?redirect=Crear">
                        Crear nueva comision</a></td>
            </tr>
        </table>
    </body>
</html>
