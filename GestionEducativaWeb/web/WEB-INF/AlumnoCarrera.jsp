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
        <link href="css/abListado.css" type="text/css" rel="stylesheet">
        <title>Carreras</title>
    </head>
    <body>     
        <%  List<Carrera> carreras = 
        (List<Carrera>)session.getAttribute("carreras"); %>
        <form action="AlumnoCarrera" method="post">
            <div>
                <div>Carreras</div>
                <table>    
                    <tr>
                        <th>Nombre</th>
                        <th style="text-align: left">Descripción</th>
                        <th>Seleccionar</th>
                    </tr>
                    <c:forEach var="carrera" items="${carreras}">  
                        <tr>
                            <td>
                                <c:out value="${carrera.nombre}" />
                            </td>       
                            <td style="text-align: left">
                                <c:out value="${carrera.descripcion}" />
                            </td>
                            <td>
                                <input type="radio" name="idCarrera" value="${carrera.idCarrera}"><br>
                            </td>
                        </tr>
                    </c:forEach>          
                </table>
            </div>
            <input type="submit" value="Seleccionar" class="button"> 
        </form>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
