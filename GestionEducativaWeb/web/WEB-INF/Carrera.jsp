<%-- 
    Document   : Carrera
    Created on : Apr 13, 2018, 8:52:05 PM
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
        <div>
            <div>Carreras</div>
            <table>    
                <tr>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
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
                            <a href="Carrera?redirect=Editar&id=${carrera.idCarrera}">
                            Editar</a>
                        </td>
                        <td>
                            <a href="Carrera?redirect=Eliminar&id=${carrera.idCarrera}">
                            Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>          
            </table>

            <table> 
                <tr>
                    <td>
                        <a href="Carrera?redirect=Crear">Crear nueva carrera</a>
                    </td>
                </tr>
            </table> 
        </div>
        <footer>
            <a href="LoginAdministrador">Menu</a>
        </footer>
    </body>
</html>
