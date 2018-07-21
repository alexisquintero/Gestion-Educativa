<%-- 
    Document   : NotaPromedio
    Created on : Jul 21, 2018, 6:07:34 PM
    Author     : Supervisor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nota promedio</title>
    </head>
    <body>
        <%  float nota = 
        (float)session.getAttribute("nota"); %>
        <h1>Nota promedio: ${nota}</h1>
        <footer>
            <a href="LoginAlumno">Menu</a>
        </footer>
    </body>
</html>
