<%-- 
    Document   : Finales
    Created on : Jul 21, 2018, 6:38:30 PM
    Author     : Supervisor
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Final"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finales</title>
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
                        <a href="Finales?redirect=NotaPromedio&id=${final.idFinal}">
                        Nota promedio</a></td>
                    </td>                
                </tr>
            </c:forEach>          
        </table>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>