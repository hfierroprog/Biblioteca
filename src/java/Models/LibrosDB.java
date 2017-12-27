package Models;

import java.util.ArrayList;
import java.util.List;

public class LibrosDB {
    List<Libro> lista = new ArrayList<>();
    
    public LibrosDB(){
        lista.add(new Libro(0, "DIOSES Y HEROES DE LA MITOLOGIA GRIEGA", "SHUE, ANA"));
        lista.add(new Libro(1, "CHILE TOP SECRET", "BASSO, CARLOS"));
        lista.add(new Libro(2, "SOMOS POLVOS DE ESTRELLAS", "MAZA, JOSE MARIA"));
        lista.add(new Libro(3, "SERVICIO SECRETO CHILENO EN LA GUERRA DEL PACIFICO", "PARVEX, GUILLERMO"));
        lista.add(new Libro(4, "HISTORIA SECRETA DE CHILE 3", "BARADIT, JORGE"));
    }
    
    public Libro buscarPorId(int id){
        Libro l = lista.get(id);
       
        return l;
    }
    
    public Libro BuscarPorTexto(String texto){
        Libro res = null;
        for(Libro l: lista){
            if(l.getTitulo().contains(texto) || l.getAutor().contains(texto)){
                res = l;
            }
        }
        return res;
    }
    
    public List<Libro> obtenerTodos(){
        return this.lista;
    }
}
