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
        <link href="css/abListado.css" type="text/css" rel="stylesheet">
        <title>Finales</title>
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
                    <th>Aula</th>
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
                        <td>
                            <c:out value="${final1.aula}" /> 
                        </td>
                        <td>
                            <a href="Finales?redirect=NotaPromedio&id=${final.idFinal}">
                            Nota promedio</a></td>
                        </td>                
                    </tr>
                </c:forEach>          
            </table>
        </div>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
