<%-- 
    Document   : MateriaAprobada
    Created on : Apr 22, 2018, 7:20:49 PM
    Author     : Supervisor
--%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/abListado.css" type="text/css" rel="stylesheet">
        <title>Materias aprobadas</title>
    </head>
    <body>
        <%  List<Entidades.Materia> materiasDisponible = 
        (List<Entidades.Materia>)session.getAttribute("materiasDisponible"); %> 
        <form action="MateriaAprobada" method="post">
            <div>
            <div>Materias</div>
                <table>
                    <tr>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Año</th>
                        <th>Electiva</th>
                        <th style="text-align:left">Horas Semana</th>
                        <th>Agregar</th>
                    </tr>
                    <c:forEach var="materia" items="${materiasDisponible}">   
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
                            <td style="text-align:left">
                                <c:out value="${materia.horasSemana}" /> 
                            </td>
                            <td>
                                <input type="checkbox" name="id" value="${materia.idMateria}"></input>                          
                            </td>  
                        </tr>
                    </c:forEach>  
                </table>
            </div>
            <input type="submit" value="Agregar" class="button"> 
        </form>
        <footer>
            <a href="LoginAdministrador">Menu</a>
        </footer>
    </body>
</html>
