<%-- 
    Document   : FinalesInsc
    Created on : Jul 21, 2018, 5:01:34 PM
    Author     : Supervisor
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Final"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscripcion final</title>
    </head>
    <body>
        <%  List<Final> finales = 
        (List<Final>)session.getAttribute("finales"); %>
        <table>    
            <tr>
                <th>Fecha</th>
                <th>Horario Inicio</th>
                <th>Horario Fin</th>
                <th>Aula</th>
                <th>Inscribir</th>
            </tr>
            <c:forEach var="final" items="${finales}">  
                <tr>
                    <td>
                        <c:out value="${final.fecha}" />
                    </td>       
                    <td>
                        <c:out value="${final.horarioInicio}" />
                    </td>
                    <td>
                        <c:out value="${final.horarioFin}" /> 
                    </td>
                    <td>
                        <c:out value="${final.aula}" /> 
                    </td>
                    <td>
                        <a href="FinalInsc?redirect=Inscribir&id=${final.idFinal}">
                        Inscribir</a></td>
                    </td>                
                </tr>
            </c:forEach>          
        </table>
        <footer>
            <a href="LoginAlumno">Menu</a>
        </footer>
    </body>
</html>
