<%-- 
    Document   : MateriaAM
    Created on : Apr 21, 2018, 5:51:27 PM
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
        <link href="css/formAB.css" type="text/css" rel="stylesheet">
        <title>Crear y modificar materias</title>
    </head>
    <body>
        <%  Materia materia = 
        (Materia)session.getAttribute("materia");%>       
        <form action="MateriaAM" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type=text" name="id" value="${materia.idMateria}" readonly="readonly"> </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${materia.nombre}"> </td>
                </tr>
                <tr>
                    <td>Descripción</td>    
                    <td><input type="text" name="descripcion" value="${materia.descripcion}"> </td>
                </tr>
                <tr>
                    <td>Año</td>    
                    <td>
                        <select name="anio">
                            <option
                                <c:if test='${materia.anio == "Primero"}'>selected="selected"</c:if>
                                value="Primero">Primero</option>
                            <option
                                <c:if test='${materia.anio == "Segundo"}'>selected="selected"</c:if>
                                value="Segundo">Segundo</option>
                            <option
                                <c:if test='${materia.anio == "Tercero"}'>selected="selected"</c:if>
                                value="Tercero">Tercero</option>
                            <option
                                <c:if test='${materia.anio == "Cuarto"}'>selected="selected"</c:if>
                                value="Cuarto">Cuarto</option>
                            <option
                                <c:if test='${materia.anio == "Quinto"}'>selected="selected"</c:if>
                                value="Quinto">Quinto</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Electiva</td>    
                    <td><input type="text" name="electiva" value="${materia.electiva}"> </td>
                </tr>
                <tr>
                    <td>Hs Semana</td>    
                    <td><input type="text" name="horasSemana" value="${materia.horasSemana}"> </td>
                </tr>
            </table>
            <input type="submit" value="Guardar" class="button"> 
        </form>
        <div>
            <div>Correlativas Regulares</div>
            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Año</th>
                    <th>Electiva</th>
                    <th>Hs Semana</th>
                    <th>Acción</th>
                </tr>
                <c:forEach var="reg" items="${materia.correlativasRegulares}">   
                    <tr>
                        <td>
                            <c:out value="${reg.nombre}" /> 
                        </td>
                        <td>
                            <c:out value="${reg.descripcion}" /> 
                        </td>
                        <td>
                            <c:out value="${reg.anio}" /> 
                        </td>
                        <td>
                             <c:out value="${reg.electiva}" /> 
                        </td>
                        <td>
                            <c:out value="${reg.horasSemana}" /> 
                        </td>
                        <td>
                            <a href="MateriaRegular?redirect=Eliminar&id=${reg.idMateria}">
                            Eliminar</a></td>
                        </td>  
                    </tr>
                </c:forEach>  
                <tr>
                    <td colspan="6">
                        <a href="MateriaRegular?redirect=Agregar">Agregar</a></td>
                    </td> 
                </tr>
            </table>
        </div>
        <div>
            <div>Correlativas Aprobadas</div>
            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Año</th>
                    <th>Electiva</th>
                    <th>Hs Semana</th>
                    <th>Acción</th>
                </tr>
                <c:forEach var="ap" items="${materia.correlativasAprobadas}">   
                    <tr>
                        <td>
                            <c:out value="${ap.nombre}" /> 
                        </td>
                        <td>
                            <c:out value="${ap.descripcion}" /> 
                        </td>
                        <td>
                            <c:out value="${ap.anio}" /> 
                        </td>
                        <td>
                             <c:out value="${ap.electiva}" /> 
                        </td>
                        <td>
                            <c:out value="${ap.horasSemana}" /> 
                        </td>
                        <td>
                            <a href="MateriaAprobada?redirect=Eliminar&id=${ap.idMateria}">
                            Eliminar</a>
                        </td>  
                    </tr>
                </c:forEach>  
                <tr>
                    <td colspan="6">
                        <a href="MateriaAprobada?redirect=Agregar">Agregar</a>
                    </td>
                </tr>
            </table>
        </div>
        <footer>
            <a href="LoginAdministrador">Menu</a>
        </footer>
    </body>
</html>
