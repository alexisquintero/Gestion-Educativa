<%-- 
    Document   : InscripcionMateria
    Created on : Jul 15, 2018, 3:32:48 PM
    Author     : Supervisor
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Materia"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/abListado.css" type="text/css" rel="stylesheet">
        <title>Inscripción a materia</title>
    </head>
    <body>
        <%  List<Materia> materiasInsc = 
        (List<Materia>)session.getAttribute("materiasInsc"); %>
        <div>
            <div>Materias</div>
            <table>    
                <tr>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Año</th>
                    <th>Electiva</th>
                    <th style="text-align: left">Hs Semana</th>
                    <th>Inscribir</th>
                </tr>
                <c:forEach var="materia" items="${materiasInsc}">  
                    <tr>
                        <td>
                            <c:out value="${materia.nombre}" />
                        </td>       
                        <td>
                            <c:out value="${materia.descripcion}" />
                        </td>
                        <td>
                            <c:out value="${materia.anio}" /> 
                        </td>
                        <td>
                            <c:out value="${materia.electiva}" /> 
                        </td>
                        <td style="text-align: left">
                            <c:out value="${materia.horasSemana}" /> 
                        </td>
                        <td>
                            <a href="MateriaInsc?redirect=Inscribir&id=${materia.idMateria}">
                            Inscribir</a></td>
                        </td>
                    </tr>
                </c:forEach>          
            </table>
        </div>
        <footer>
            <a href="LoginAlumno">Menu</a>
        </footer>
    </body>
</html>
