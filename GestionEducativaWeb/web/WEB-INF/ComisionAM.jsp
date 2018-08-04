<%-- 
    Document   : ComisionAM
    Created on : Apr 28, 2018, 2:37:55 PM
    Author     : Supervisor
--%>

<%@page import="Entidades.Comision"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/formAB.css" type="text/css" rel="stylesheet">
        <title>Crear y modificar comisión</title>
    </head>
    <body>
        <%  Comision comision = 
        (Comision)session.getAttribute("comision");%>       
        <form action="ComisionAM" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type=text" name="id" value="${comision.idComision}" readonly="readonly"> </td>
                </tr>
                <tr>
                    <td>Aula</td>
                    <td><input type="text" name="aula" value="${comision.aula}"> </td>
                </tr>
                <tr>
                    <td>Cupo</td>    
                    <td><input type="text" name="cupo" value="${comision.cupo}"> </td>
                </tr>
            </table> 
            <input type="submit" value="Guardar" class="button"> 
        </form>
        <div>
            <div>Horarios</div>
            <table>
                <tr>
                    <th>Dia</th>
                    <th>Horario Inicio</th>
                    <th>Horario Fin</th>
                    <th style="text-align: left">Materia</th>
                    <th>Eliminar</th>
                </tr>
                <c:forEach var="horario" items="${comision.horarios}">   
                    <tr>
                        <td>
                            <c:out value="${horario.dia}" /> 
                        </td>
                        <td>
                            <c:out value="${horario.horarioInicio}" /> 
                        </td>
                        <td>
                            <c:out value="${horario.horarioFin}" /> 
                        </td>
                        <td style="text-align: left">
                            <c:out value="${horario.materia.nombre}" /> 
                        </td>
                        <td>
                            <a href="Horario?redirect=Eliminar&id=${horario.idHorario}">
                            Eliminar</a>
                        </td>  
                    </tr>
                </c:forEach>  
                    <tr style="display: none"></tr>
            </table>
        </div>
        </form>      
        <footer>
            <a href="LoginModerador">Menu</a>
        </footer>
    </body>
</html>
