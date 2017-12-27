package Controlers;

import Models.Libro;
import Models.LibrosDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listadoLibros", urlPatterns = {"/listadoLibros"})
public class listadoLibros extends HttpServlet {
    
    private LibrosDB librosdb;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        librosdb = new LibrosDB();
        
        List<Libro> lista = librosdb.obtenerTodos();
        
        request.setAttribute("libros", lista);
        request.setAttribute("titulo", "Listado de libros:");
        
        getServletContext().getRequestDispatcher("/listado.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
