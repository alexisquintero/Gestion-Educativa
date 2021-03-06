<%-- 
    Document   : FinalesInsc
    Created on : Jul 21, 2018, 5:01:34 PM
    Author     : Supervisor
--%>

<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@page import="Entidades.Final"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/abListado.css" type="text/css" rel="stylesheet">
        <title>Inscripcion final</title>
    </head>
    <body>
        <%  List<Final> finales = 
        (List<Final>)session.getAttribute("finales"); %>
        <div>
            <div>Finales</div>
            <table>    
                <tr>
                    <th>Fecha</th>
                    <th>Horario Inicio</th>
                    <th>Horario Fin</th>
                    <th style="text-align: left">Aula</th>
                    <th>Inscribir</th>
                </tr>
                <c:forEach var="final1" items="${finales}">  
                    <tr>
                        <td>
                            <c:out value="${final1.fecha}" />
                        </td>       
                        <td>
                            <c:out value="${final1.horarioInicio}" />
                        </td>
                        <td>
                            <c:out value="${final1.horarioFin}" /> 
                        </td>
                        <td style="text-align: left">
                            <c:out value="${final1.aula}" /> 
                        </td>
                        <td>
                            <a href="FinalInsc?redirect=Inscribir&id=${final1.idFinal}">
                            Inscribir</a></td>
                        </td>                
                    </tr>
                </c:forEach>          
            </table>
        </div>
        <footer>
            <a href="LoginAlumno">Menu</a>
        </footer>
    </body>
</html>
