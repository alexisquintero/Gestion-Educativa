<%-- 
    Document   : Error
    Created on : Apr 11, 2018, 8:18:42 PM
    Author     : Supervisor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1><%= session.getAttribute("error") %></h1>
    </body>
</html>
