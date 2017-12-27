<%@page import="Models.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Libro libro = (Libro) request.getAttribute("libro");
    String titulo = (String) request.getAttribute("titulo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=titulo%></title>
    </head>
    <body>
        <% if(libro != null) {%>
            <h2><%=titulo%></h2>
            <br>
            <h4><b>Id:</b><%= libro.getId() %></h4>
            <h4><b>Titulo:</b><%= libro.getTitulo() %></h4>
            <h4><b>Autor:</b><%= libro.getAutor() %></h4>
        <% } else{ %>
            <h2>Error: libro no encontrado!</h2>          
        <% }%>
    </body>
</html>
