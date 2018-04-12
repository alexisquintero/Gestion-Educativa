<%-- 
    Document   : LoginAlumno
    Created on : Jul 19, 2017, 6:06:43 PM
    Author     : Supervisor
//TODO: Cambiar a login alumno
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
            <h1></h1>
            <h1>Sistema Académico SYSACAD</h1>
            <h1>Módulo de autogestión alumno</h1>
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
        <footer>
           <h2>IMPORTANTE: AL GENERAR EL CERTIFICADO DE CURSADO NO SE PODRÁN ELIMINAR LAS INSCRIPCIONES</h2>
        </footer>
    </body>
    
</html>