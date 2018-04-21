<%-- 
    Document   : ModeradorAM
    Created on : Apr 21, 2018, 10:26:15 AM
    Author     : Supervisor
--%>

<%@page import="Entidades.Moderador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear y modificar moderador</title>
    </head>
    <body>
        <%  Moderador moderador = 
        (Moderador)session.getAttribute("moderador"); %>   
        <form action="ModeradorAM" method="post">
            <table>
                <tr>
                    <th>Propiedad</th>
                    <th>Valor</th>
                </tr>
                <tr>
                    <td>ID</td>
                    <td><input type=text" name="id" value="${moderador.idModerador}" readonly="readonly"> </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${moderador.nombre}"> </td>
                </tr>
                <tr>
                    <td>Apellido</td>    
                    <td><input type="text" name="apellido" value="${moderador.apellido}"> </td>
                </tr>
                <tr>
                    <td>Telefono</td>    
                    <td><input type="text" name="telefono" value="${moderador.telefono}"> </td>
                </tr>
                <tr>
                    <td>Email</td>    
                    <td><input type="text" name="email" value="${moderador.email}"> </td>
                </tr>
                <tr>
                    <td>Direccion</td>    
                    <td><input type="text" name="direccion" value="${moderador.direccion}"> </td>
                </tr>
                <tr>
                    <td>Legajo</td>    
                    <td><input type="text" name="legajo" value="${moderador.legajo}"> </td>
                </tr>
            </table>           
            <input type="submit" value="Guardar"> 
        </form> 
    </body>
</html>
