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
        <title>Crear y modificar materias</title>
    </head>
    <body>
        <%  Materia materia = 
        (Materia)session.getAttribute("materia");%>       
        <form action="MateriaAM" method="post">
            <table>
                <tr>
                    <th>Propiedad</th>
                    <th>Valor</th>
                </tr>
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
                    <td><input type="text" name="anio" value="${materia.anio}"> </td>
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
            <h3>Correlativas Regulares</h3>   
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
                    <td>
                        <input type=text" name="rNombre" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="rDescripcion" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="rAnio" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="rElectiva" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="eHorasSemana" readonly="readonly">
                    </td>
                    <td>
                        <a href="MateriaRegular?redirect=Agregar">
                            Agregar</a></td>
                    </td> 
                </tr>
            </table>
            <h3>Correlativas Aprobadas</h3>
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
                            Eliminar</a></td>
                        </td>  
                    </tr>
                </c:forEach>  
                <tr>
                    <td>
                        <input type=text" name="aNombre" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="aDescripcion" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="aAnio" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="aElectiva" readonly="readonly">
                    </td>
                    <td>
                        <input type=text" name="aHorasSemana" readonly="readonly">
                    </td>
                    <td>
                        <a href="MateriaAprobada?redirect=Agregar">
                            Agregar</a></td>
                    </td> 
                </tr>
            </table>
            <input type="submit" value="Guardar"> 
        </form>
    </body>
</html>
