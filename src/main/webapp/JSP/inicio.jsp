<%-- 
    Document   : inicio
    Created on : 17-oct-2022, 17:26:55
    Author     : Sergio
--%>

<%
    String usuario = request.getParameter("usuario");
    if(usuario==null){
        usuario="no identificado";
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Identificacion</title>
    <link rel="stylesheet" href="./../CSS/styleIdentificacion.css">
</head>

<body>
    <form>
        <fieldset>
            <h2>Menu admin de <%=usuario%> </h2>
            
            
            <a href="ControladorIndex">Cerrar Sesion</a>
        </fieldset>
    </form>
</body>
</html>