<%-- 
    Document   : DocenteAM
    Created on : Apr 21, 2018, 2:35:41 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.Docente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear y modificar docente</title>
    </head>
    <body>
        <%  Docente docente = 
        (Docente)session.getAttribute("docente"); %>   
        <form action="DocenteAM" method="post">
            <table>
                <tr>
                    <th>Propiedad</th>
                    <th>Valor</th>
                </tr>
                <tr>
                    <td>ID</td>
                    <td><input type=text" name="id" value="${docente.idDocente}" readonly="readonly"> </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${docente.nombre}"> </td>
                </tr>
                <tr>
                    <td>Apellido</td>    
                    <td><input type="text" name="apellido" value="${docente.apellido}"> </td>
                </tr>
                <tr>
                    <td>Telefono</td>    
                    <td><input type="text" name="telefono" value="${docente.telefono}"> </td>
                </tr>
                <tr>
                    <td>Email</td>    
                    <td><input type="text" name="email" value="${docente.email}"> </td>
                </tr>
                <tr>
                    <td>Direccion</td>    
                    <td><input type="text" name="direccion" value="${docente.direccion}"> </td>
                </tr>
                <tr>
                    <td>Legajo</td>    
                    <td><input type="text" name="legajo" value="${docente.legajo}"> </td>
                </tr>
            </table>           
            <input type="submit" value="Guardar"> 
        </form>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
