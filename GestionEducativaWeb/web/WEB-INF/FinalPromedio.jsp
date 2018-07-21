<%-- 
    Document   : FinalPromedio
    Created on : Jul 21, 2018, 8:23:36 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.Final"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nota final promedio</title>
    </head>
    <body>
        <%  float nota = (float)session.getAttribute("nota"); 
            Final final1 = (Final)session.getAttribute("final1");%>
        <table>    
            <tr>
                <th>Fecha</th>
                <th>Horario Inicio</th>
                <th>Horario Fin</th>
                <th>Aula</th>
                <th>Nota promedio</th>
            </tr>
            <tr>
                <td>
                    ${final.fecha}
                </td>       
                <td>
                    ${final.horarioInicio}
                </td>
                <td>
                    ${final.horarioFin}
                </td>
                <td>
                    ${final.aula} 
                </td>
                <td>
                    ${nota}
                </td>                
            </tr>
        </table>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
