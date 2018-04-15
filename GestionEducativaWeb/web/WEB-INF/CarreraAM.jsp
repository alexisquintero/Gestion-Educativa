<%-- 
    Document   : CarreraAM
    Created on : Apr 14, 2018, 4:25:09 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.Carrera"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Materia"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form action="CarreraAM" method="post">
            <table>
                <tr>
                    <th>Propiedad</th>
                    <th>Valor</th>
                </tr>
                <tr>
                    <td>ID</td>
                    <td><input type=text" name="id" value="${carrera.idCarrera}" readonly="readonly"> </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${carrera.nombre}"> </td>
                </tr>
                <tr>
                    <td>Descripción</td>    
                    <td><input type="text" name="descripcion" value="${carrera.descripcion}"> </td>
                </tr>
            </table>
            <tr>
                <input type="submit" value="Guardar"> 
            </tr>
        </form>
        <form action="" method="post">
            <h1>Materias</h1>   
            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Año</th>
                    <th>Acción</th>
                </tr>
                <c:forEach var="materia" items="${carrera.materias}">   
                    <tr>
                        <td>
                            <c:out value="${materia.nombre}" /> 
                        </td>
                        <td>
                            <c:out value="${materia.descripcion}" /> 
                        </td>
                        <td>
                            <c:out value="${materia.año}" /> 
                        </td>
                        <td>
                            <input type="submit" value="Eliminar"> 
                        </td>  
                    </tr>
                </c:forEach>  
                <tr>
                    <td>
                        <input type=text" name="nNombre" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="nDescripcion" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="nAnio" readonly="readonly">
                    </td>
                    <td>
                        <input type="submit" value="Agregar"> 
                    </td> 
                </tr>
            </table>
        </form>              
    </body>
</html>
