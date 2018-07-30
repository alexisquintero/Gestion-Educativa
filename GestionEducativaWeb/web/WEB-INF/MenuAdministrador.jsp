<%-- 
    Document   : MenuAdministrador
    Created on : Apr 9, 2018, 9:00:30 PM
    Author     : Supervisor
--%>
<%@page import="Entidades.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  Administrador administrador = 
        (Administrador)session.getAttribute("usuario"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menu.css" type="text/css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Karma:300|Roboto+Mono:300" rel="stylesheet">
        <title>Menu Administrador</title>
    </head>
    <body> 
        <header>
            <h1><%= administrador.getApellido() + ", " + administrador.getNombre() %></h1>
        </header>
        <table> 
            <tr>
                <td><a href="MenuAdministrador?redirect=Carrera">
                        Editar Carrera</a></td>
            </tr>
            <tr>
                <td><a href="MenuAdministrador?redirect=Moderador">
                        Editar Moderador</a></td>
            </tr>
            <tr>
                <td><a href="MenuAdministrador?redirect=Materia">
                        Editar Materia</a></td>
            </tr>
            <tr>
                <td><a href="MenuAdministrador?redirect=Bedel">
                        Editar Bedel</a></td>
            </tr>
        </table>      
    </body>
</html>
