<%-- 
    Document   : HorariosInsc
    Created on : Jul 19, 2018, 8:36:43 PM
    Author     : Supervisor
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Horario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscripcion a horarios</title>
    </head>
    <body>
        <%  List<Horario> horarios = 
        (List<Horario>)session.getAttribute("horarios"); %>
        <table>    
            <tr>
                <th>Día</th>
                <th>Horario inicio</th>
                <th>Horario fin</th>
                <th>Inscribir</th>
            </tr>
            <c:forEach var="horario" items="${horarios}">  
                <tr>
                    <td>
                        <c:out value="${horario.dia}" />
                    </td>       
                    <td>
                        <c:out value="${horario.horarioInicio}" />
                    </td>
                    <td>
                        <c:out value="${horario.horarioFin}" /> 
                    </td>
                    <td>
                        <a href="HorarioInsc?redirect=Inscribir&id=${horario.idHorario}">
                        Inscribir</a>
                    </td>                   
                </tr>
            </c:forEach>          
        </table>
        <footer>
            <a href="LoginAlumno">Menu</a>
        </footer>
    </body>
</html>
