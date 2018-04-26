<%-- 
    Document   : AlumnoCarrera
    Created on : Apr 25, 2018, 7:13:58 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.entidad"%>
<%@page import="java.util.List"%>
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
        <%  List<Carrera> carreras = 
        (List<Carrera>)session.getAttribute("carreras"); %>
        <form action="AlumnoCarrera" method="post">
            <table>    
                <tr>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Seleccionar</th>
                </tr>
                <c:forEach var="carrera" items="${carreras}">  
                    <tr>
                        <td>
                            <c:out value="${carrera.nombre}" />
                        </td>       
                        <td>
                            <c:out value="${carrera.descripcion}" />
                        </td>
                        <td>
                            <input type="radio" name="idCarrera" value="${carrera.idCarrera}"> Seleccionar<br>
                        </td>
                    </tr>
                </c:forEach>          
            </table>
            <input type="submit" value="Seleccionar"> 
        </form>
    </body>
</html>
