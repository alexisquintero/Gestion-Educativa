<%-- 
    Document   : LoginAdministrador
    Created on : Jul 18, 2017, 5:23:17 PM
    Author     : Supervisor
--%>
<%@ page import="Login.LoginAdministrador" %>
<%@ page language="java"  contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Administrador</title>           
    </head>   
    <body>
        <header>
            <h3>Universidad Tecnológica Nacional</h3>
            <h3>Facultad Regional Rosario</h3>
            <h1>Módulo de autogestión administrador</h1>
        </header>
        <form action="LoginAdministrador" method="post">
            <table>
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" name="usuario"> </td>
                </tr>
                <tr>
                    <td>Contraseña</td>    
                    <td><input type="password" name="password"> </td>
                </tr>
                <tr>
                    <td></td>    
                    <td><input type="submit" value="login"> </td>
                </tr>
            </table>
        </form>
    </body>
</html>