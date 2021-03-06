<%@page import="java.util.List"%>
<%@page import="Models.entity.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
    List<Libro> libros = (List<Libro>) request.getAttribute("libros");
    String titulo = (String) request.getAttribute("titulo");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=titulo%></title>
    </head>
    <body>
        <h2><%=titulo%></h2>
        <div style="margin:30px">
            <form action="<%= request.getContextPath()+"/buscar" %>" method="post">
                <input type="text" name="texto">
                <input type="submit" value="Buscar">
            </form>
        </div>

        <table border="1" cellspacing="1" cellpadding="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Titulo</th>
                    <th>Autor</th>
                    <th>Detalle</th>
                </tr>
            </thead>
            <tbody>
                <% for(Libro libro: libros) { %>
                <tr>
                    <td><%=libro.getId()%></td>
                    <td><%= libro.getTitulo() %></td>
                    <td><%= libro.getAutor() %></td>
                    <td><a href="detalle?id=<%= libro.getId()%>" >ver</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
