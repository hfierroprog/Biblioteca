package Models.dao;

import Models.entity.Libro;
import java.util.List;

public interface LibroDao {
    
    public List<Libro> listar();
    
    public Libro buscarPorId(int id);
    
    public Libro buscarPorTexto(String texto);
    
    public void guardar(Libro libro);
    
    public void eliminar(Libro libro);
}
