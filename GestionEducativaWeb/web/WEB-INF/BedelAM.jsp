<%-- 
    Document   : BedelAM
    Created on : Apr 29, 2018, 3:26:34 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.Bedel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/formAB.css" type="text/css" rel="stylesheet">
        <title>Crear y modificar bedel</title>
    </head>
    <body>
        <%  Bedel bedel = 
        (Bedel)session.getAttribute("bedel");%>       
        <form action="BedelAM" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type=text" name="id" value="${bedel.idBedel}" readonly="readonly"> </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${bedel.nombre}"> </td>
                </tr>
                <tr>
                    <td>Apellido</td>    
                    <td><input type="text" name="apellido" value="${bedel.apellido}"> </td>
                </tr>
                <tr>
                    <td>Telefono</td>    
                    <td><input type="text" name="telefono" value="${bedel.telefono}"> </td>
                </tr>
                <tr>
                    <td>Email</td>    
                    <td><input type="text" name="email" value="${bedel.email}"> </td>
                </tr>
                <tr>
                    <td>Direccion</td>    
                    <td><input type="text" name="direccion" value="${bedel.direccion}"> </td>
                </tr>
                <tr>
                    <td>Legajo</td>    
                    <td><input type="text" name="legajo" value="${bedel.legajo}"> </td>
                </tr>
            </table>           
            <input type="submit" value="Guardar" class="button"> 
        </form>  
        <footer>
            <a href="LoginAdministrador">Menu</a>
        </footer>
    </body>
</html>
