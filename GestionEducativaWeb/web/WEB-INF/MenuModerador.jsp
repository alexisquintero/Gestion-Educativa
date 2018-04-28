<%-- 
    Document   : MenuModerador
    Created on : Apr 23, 2018, 7:28:18 PM
    Author     : Supervisor
--%>
<%@page import="Entidades.Moderador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  Moderador moderador = 
        (Moderador)session.getAttribute("usuario"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Moderador</title>
    </head>
    <body> 
        <header>
            <h1><%= moderador.getApellido() + ", " + moderador.getNombre() %></h1>
        </header>
        <table> 
            <tr>
                <td><a href="MenuModerador?redirect=Alumno">
                        Editar Alumno</a></td>
            </tr>
                        <tr>
                <td><a href="MenuModerador?redirect=Docente">
                        Editar Docente</a></td>
            </tr>
            <tr>
                <td><a href="MenuModerador?redirect=Comision">
                        Editar Comisión</a></td>
            </tr>
            <tr>
                <td><a href="MenuModerador?redirect=Final">
                        Editar Final</a></td>
            </tr>
        </table>      
    </body>
</html>
