<%-- 
    Document   : index.jsp
    Created on : 17-oct-2022, 17:08:47
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <%-- NO DISPONES DE TODAS LAS ETIQUETAS META Y QUE ADEMÁS SE HACE MEDIANTE UN INCLUDE --%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Identificacion</title>
    <link rel="stylesheet" href="./CSS/styleIdentificacion.css">
</head>

<body>
    <form action="ControladorDatos" method="post">
        <fieldset>
            <h3>Proceso de Identificacion</h3>
            
            <%
                if(request.getAttribute("error")!= null){
                    %>
                    <p><%=request.getAttribute("error")%></p>
                    <%
                }
            
            %>
            <label for="usuario">Usuario: </label>
            <%-- LOS CAMPOS NO TIENEN PORQUE SER REQUERIDOS EN EL CLIENTE --%>
            <%
                if(request.getAttribute("nombreUsuario")!=null){
                    %>
                    <%-- SEGÚN INDICAS EN EL CONTROLADOR ControladorIndex CARGAS EL NOMBRE O NADA CON LO QUE ESTA PREGUNTA SOBRA --%>
                    <input type="text" name="usuario" id="usuario" required="required" value="<%=request.getAttribute("nombreUsuario")%>">
                    <%
                }else{
                    %>
                    <input type="text" name="usuario" id="usuario" required="required">
                    <%
                }
            %>
                   
               
            <br><br>

            <label for="password">Contraseña: </label>
            <input type="password" name="password" id="password" required="required">
            <br><br>
            
            <input type="checkbox" name="recordar" id="recordar">
            <label for="recordar">Recordar usuario</label>
            
            <br><br>
            <input type="submit" value="Enviar" name="enviar">
            
        </fieldset>
    </form>
</body>
</html>