<%-- 
    Document   : Materia
    Created on : Apr 13, 2018, 8:53:36 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.entidad"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Materia"%>
<%@page import="Negocio.ControladorGestion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materias</title>
    </head>
    <body>
        <%  List<Materia> materias = 
        (List<Materia>)session.getAttribute("materias"); %>
        <table>    
            <tr>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Año</th>
                <th>Electiva</th>
                <th>Hs Semana</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach var="materia" items="${materias}">  
                <tr>
                    <td>
                        <c:out value="${materia.nombre}" />
                    </td>       
                    <td>
                        <c:out value="${materia.descripcion}" />
                    </td>
                    <td>
                        <c:out value="${materia.año}" /> 
                    </td>
                    <td>
                        <c:out value="${materia.electiva}" /> 
                    </td>
                    <td>
                        <c:out value="${materia.horasSemana}" /> 
                    </td>
                    <td>
                        <a href="Materia?redirect=Editar&id=${materia.idMateria}">
                        Editar</a></td>
                    </td>
                    <td>
                        <a href="Materia?redirect=Eliminar&id=${materia.idMateria}">
                        Eliminar</a>
                    </td>                   
                </tr>
            </c:forEach>          
        </table>
        <table> 
            <tr>
                <td><a href="Materia?redirect=Crear">
                        Crear nueva materia</a></td>
            </tr>
        </table>
    </body>
</html>
