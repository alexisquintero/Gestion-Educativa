<%-- 
    Document   : CarreraAM
    Created on : Apr 14, 2018, 4:25:09 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.Carrera"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Materia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear y modificar carrera</title>
    </head>
    <body>
        <%  Carrera carrera = 
        (Carrera)session.getAttribute("carrera"); %>
        <form action="" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type=text" name="id" value="${carrera.idCarrera}" readonly="readonly"</td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"> </td>
                </tr>
                <tr>
                    <td>Descripción</td>    
                    <td><input type="text" name="descripcion"> </td>
                </tr>
                <tr>
                    <td>Materias</td>   
                    <c:forEach var="materia" items="${carrera.materias}">                          
                        <c:out value="${materia.nombre}" /> 
                    </c:forEach>                    
                    <td><input type="submit" value="agregar"> </td>
                </tr>
            </table>
        </form>
    </body>
</html>
