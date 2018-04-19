<%-- 
    Document   : CarreraMateria
    Created on : Apr 15, 2018, 7:39:14 PM
    Author     : Supervisor
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CarreraMaterias</title>
    </head>
    <body>
        <%  ArrayList<Entidades.Materia> materiasDisponible = 
        (ArrayList<Entidades.Materia>)session.getAttribute("materiasDisponible"); %> 
        <form action="CarreraMateriaPost" method="post">
            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Año</th>
                    <th>Electiva</th>
                    <th>Horas Semana</th>
                    <th>Agregar</th>
                </tr>
                <c:forEach var="materia" items="${materiasDisponible}">   
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
                            <input type="checkbox" name="id" value="${materia.idMateria}"></input>                          
                        </td>  
                    </tr>
                </c:forEach>  
            </table>
            <input type="submit" value="Agregar"> 
        </form>
    </body>
</html>
