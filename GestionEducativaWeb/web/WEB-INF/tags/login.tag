<%-- 
    Document   : login
    Created on : Jul 18, 2017, 5:43:28 PM
    Author     : Supervisor
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="titulo" required="true" %>
<%@attribute name="tipo" required="true" %>

<%-- any content can be specified here e.g.: --%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${titulo}</title>           
    </head>   
    <body>
        <header>
            <h3>Universidad Tecnológica Nacional</h3>
            <h3>Facultad Regional Rosario</h3>
            <h1></h1>
            <h1>Sistema Académico SYSACAD</h1>
            <h1>Módulo de autogestión alumnos</h1>
        </header>
        <form method="post" action="Login">
            <table>
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" name="usuario"> </td>
                </tr>
                <tr>
                    <td>Contraseña</td>    
                    <td><input type="password" name="password"> </td>
                </tr>
                <tr>
                    <td></td>    
                    <td><input type="submit" value="login"> </td>
                </tr>
            </table>
            <input type="hidden" name="clase" value="${tipo}">
        </form>
        <footer>
            <h2>IMPORTANTE: AL GENERAR EL CERTIFICADO DE CURSADO NO SE PODRÁN ELIMINAR LAS INSCRIPCIONES</h2>
        </footer>
    </body>
    
</html>