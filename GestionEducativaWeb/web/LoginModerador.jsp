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
        <title>Login Moderador</title>           
    </head>   
    <body>
        <header>
            <h3>Universidad Tecnológica Nacional</h3>
            <h3>Facultad Regional Rosario</h3>
            <h1>Módulo de autogestión moderador</h1>
        </header>
        <form action="LoginModerador" method="post">
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
