<%-- 
    Document   : CarreraMateria
    Created on : Apr 15, 2018, 7:39:14 PM
    Author     : Supervisor
--%>

<%@page import="java.util.stream.Stream"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CarreraMaterias</title>
    </head>
    <body>
        <%  Stream<Entidades.Materia> materiasDisponible = 
        (Stream<Entidades.Materia>)session.getAttribute("materiasDisponible"); %> 
        <form>
            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Año</th>
                    <th>Electiva</th>
                    <th>Horas Semana</th>
                    <th>Accion</th>
                </tr>
                <c:forEach var="materia" items="${materiasDisponibles}">   
                        <input type="hidden" name="id" value="${carrera.idCarrera}">
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
                                <input type="submit" value="Agregar"> 
                            </td>  
                        </tr>
                    </c:forEach>  
            </table>
        </form>
    </body>
</html>
