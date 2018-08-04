<%-- 
    Document   : LoginModerador
    Created on : Apr 23, 2018, 7:09:53 PM
    Author     : Supervisor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" type="text/css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Adamina|Raleway:500" rel="stylesheet">
        <title class="title">Login Moderador</title>           
    </head>   
    <body>
        <img src="images/utn.gif" alt="">
        <header class="header">
            <h3 class="universidad">Universidad Tecnológica Nacional</h3>
            <h3 class="universidad">Facultad Regional Rosario</h3>
            <h1 class="modulo">Módulo de autogestión moderador</h1>
        </header>
        <form action="LoginModerador" method="post">
            <table class="table">
                <tr>
                    <td><input type="text" name="usuario" placeholder="Usuario" required> </td>
                </tr>
                <tr>
                    <td><input type="password" name="password" placeholder="Contraseña" required> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="login" class="button"> </td>
                </tr>
            </table>
        </form>
    </body>
</html>
