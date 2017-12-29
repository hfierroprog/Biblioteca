package Controlers;

import Models.dao.LibroDaoJDBC;
import Models.entity.Libro;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listadoLibros", urlPatterns = {"/listadoLibros"})
public class listadoLibros extends HttpServlet {
    
    LibroDaoJDBC modelo = new LibroDaoJDBC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Libro> lista = modelo.listar();
        
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
