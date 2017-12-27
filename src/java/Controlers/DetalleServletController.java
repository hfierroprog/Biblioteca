package Controlers;

import Models.Libro;
import Models.LibrosDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "DetalleServletController", urlPatterns = {"/detalle"})
public class DetalleServletController extends HttpServlet {

    LibrosDB libros = new LibrosDB();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int id = Integer.valueOf(request.getParameter("id"));
        
        Libro libro = libros.buscarPorId(id);
        
        request.setAttribute("libro", libro);
        request.setAttribute("titulo", libro.getTitulo()+":");
        
        getServletContext().getRequestDispatcher("/detalle.jsp").forward(request, response);
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
