<%-- 
    Document   : MenuAdministrador
    Created on : Apr 9, 2018, 9:00:30 PM
    Author     : Supervisor
--%>
<%@page import="Entidades.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  Administrador administrador = (Administrador)session.getAttribute("usuario"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Administrador</title>
    </head>
    <body> 
        <header>
            <h1><%= administrador.apellido + ", " + administrador.nombre %></h1>
        </header>
        <table> 
            <tr>
                <td><a href="">Editar Carrera</a></td>
            </tr>
            <tr>
                <td><a href="">Editar Moderador</a></td>
            </tr>
            <tr>
                <td><a href="">Editar Docente</a></td>
            </tr>
            <tr>
                <td><a href="">Editar Materia</a></td>
            </tr>
        </table>      
    </body>
</html>
