package Controlers;

import Models.dao.LibroDaoJDBC;
import Models.entity.Libro;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuscarServletController", urlPatterns = {"/buscar"})
public class BuscarServletController extends HttpServlet {

    LibroDaoJDBC modelo = new LibroDaoJDBC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String texto = request.getParameter("texto");
        
        texto = texto.toUpperCase();
        
        Libro libro = modelo.buscarPorTexto(texto);
        
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
