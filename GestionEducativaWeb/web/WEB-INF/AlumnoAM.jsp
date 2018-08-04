<%-- 
    Document   : AlumnoAM
    Created on : Apr 23, 2018, 9:28:59 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.Alumno"%>
<%@page import="Entidades.Carrera"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/formAB.css" type="text/css" rel="stylesheet">
        <title>Crear y modificar alumno</title>
    </head>
    <body>
        <%  Alumno alumno = 
        (Alumno)session.getAttribute("alumno");%>       
        <form action="AlumnoAM" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type=text" name="id" value="${alumno.idAlumno}" readonly="readonly"> </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${alumno.nombre}"> </td>
                </tr>
                <tr>
                    <td>Apellido</td>    
                    <td><input type="text" name="apellido" value="${alumno.apellido}"> </td>
                </tr>
                <tr>
                    <td>Carrera</td>    
                    <td><input type="text" name="carrera" value="${alumno.carrera.descripcion}" disabled> </td>
                    <td><a href="AlumnoCarrera?id=${alumno.carrera.idCarrera}">Cambiar</a></td>
                </tr>
                <tr>
                    <td>Telefono</td>    
                    <td><input type="text" name="telefono" value="${alumno.telefono}"> </td>
                </tr>
                <tr>
                    <td>Email</td>    
                    <td><input type="text" name="email" value="${alumno.email}"> </td>
                </tr>
                <tr>
                    <td>Direccion</td>    
                    <td><input type="text" name="direccion" value="${alumno.direccion}"> </td>
                </tr>
                <tr>
                    <td>Legajo</td>    
                    <td><input type="text" name="legajo" value="${alumno.legajo}"> </td>
                </tr>
            </table>           
            <input type="submit" value="Guardar" class="button"> 
        </form>        
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
