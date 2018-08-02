<%-- 
    Document   : Alumno
    Created on : Apr 23, 2018, 7:53:40 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.entidad"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Alumno"%>
<%@page import="Negocio.ControladorGestion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/abListado.css" type="text/css" rel="stylesheet">
        <title>Alumnos</title>
    </head>
    <body>
        <%  List<Alumno> alumnos = 
        (List<Alumno>)session.getAttribute("alumnos"); %>
        <div>
            <div>Alumnos</div>
            <table>    
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Carrera</th>
                    <th>Telefono</th>
                    <th>Email</th>
                    <th>Dirección</th>
                    <th>Legajo</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
                <c:forEach var="alumno" items="${alumnos}">  
                    <tr>
                        <td>
                            <c:out value="${alumno.nombre}" />
                        </td>       
                        <td>
                            <c:out value="${alumno.apellido}" />
                        </td>
                        <td>
                            <c:out value="${alumno.carrera.descripcion}" />
                        </td>
                        <td>
                            <c:out value="${alumno.telefono}" />
                        </td>
                        <td>
                            <c:out value="${alumno.email}" />
                        </td>
                        <td>
                            <c:out value="${alumno.direccion}" />
                        </td>
                        <td>
                            <c:out value="${alumno.legajo}" />
                        </td>                    
                        <td>
                            <a href="Alumno?redirect=Editar&id=${alumno.idAlumno}">
                            Editar</a>
                        </td>
                        <td>
                            <a href="Alumno?redirect=Eliminar&id=${alumno.idAlumno}">
                            Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>          
            </table>
                
            <table> 
                <tr>
                    <td><a href="Alumno?redirect=Crear">
                            Crear nuevo alumno</a></td>
                </tr>
            </table>
        </div>
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
