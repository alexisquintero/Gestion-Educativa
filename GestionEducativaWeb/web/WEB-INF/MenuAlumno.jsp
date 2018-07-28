<%-- 
    Document   : MenuAlumno
    Created on : Jul 21, 2018, 6:14:40 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  Alumno alumno = 
        (Alumno)session.getAttribute("usuario"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Alumno</title>
    </head>
    <body>
        <header>
            <h1><%= alumno.getApellido() + ", " + alumno.getNombre() %></h1>
        </header>
        <table> 
            <tr>
                <td><a href="MenuAlumno?redirect=InscripcionMateria">
                        Inscribir a cursado</a></td>
            </tr>
                        <tr>
                <td><a href="MenuAlumno?redirect=InscripcionFinal">
                        Inscribir a examen final</a></td>
            </tr>
        </table>  
    </body>
</html>
