package Models.dao;

import Models.entity.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConexionJdbc;

public class LibroDaoJDBC implements LibroDao{

    private Connection conn;
    
    public void setConnection(Connection conn){
        this.conn = conn;
    }
    
    public Connection getConnection(){
        if(conn == null) {
            conn = new ConexionJdbc().getConnection();
        }
        return conn;
    }
    
    public void closeConnection() {
        try {
            getConnection().close();
            conn = null;
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Libro> listar() {
        //Creamos una nueva lista
        List<Libro> lista = new ArrayList<Libro>();
        try {
            //Creamos un Statement que nos permite realizar consultas
            Statement stmt = getConnection().createStatement();
            //Ejecutamos consulta mediante el Statement y lo guardamos en el ResultSet
            ResultSet resultado = stmt.executeQuery("SELECT * FROM Libros");
            //Si la consulta arroja resultados
            while(resultado.next()) {
                //Se crea un objeto tipo libro
                Libro libro = new Libro();
                //Asignamos los atributos obtenidos mediante la consulta
                libro.setId(resultado.getInt("ID"));
                libro.setTitulo(resultado.getString("Titulo"));
                libro.setAutor(resultado.getString("Autor"));
                
                //se añade el libro a la lista
                lista.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        
        return lista;
    }

    @Override
    public Libro buscarPorId(int id) {
        //Se crea un objeto libro y le asignamos null por el momento
        Libro libro = null;
        try{
            //Creamos un PreparedStatement que nos permite hacer select con condición
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Libros WHERE ID = ?");
            //Se le asigna al valor ? el id que recibimos en la variable de argumentacion
            stmt.setInt(1, id);
            //Se ejecuta la consulta y si se obtienen resultados se le asignan al objeto libro
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()) {
                libro = new Libro();
                libro.setId(resultado.getInt("ID"));
                libro.setTitulo(resultado.getString("Titulo"));
                libro.setAutor(resultado.getString("Autor"));
            }
            //Se cierra el PreparedStatement ya que se utilizo
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        
        return libro;
    }

    @Override
    public Libro buscarPorTexto(String texto) {
                //Se crea un objeto libro y le asignamos null por el momento
        Libro libro = null;
        try{
            //Creamos un PreparedStatement que nos permite hacer select con condición
            PreparedStatement stmt = getConnection().prepareStatement("select * from Libros where Titulo like ?");
            //Se le asigna al valor ? el text que recibimos en la variable de argumentacion
            stmt.setString(1, "%"+texto+"%");
            //Se ejecuta la consulta y si se obtienen resultados se le asignan al objeto libro
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()) {
                libro = new Libro();
                libro.setId(resultado.getInt("ID"));
                libro.setTitulo(resultado.getString("Titulo"));
                libro.setAutor(resultado.getString("Autor"));
            }
            //Se cierra el PreparedStatement ya que se utilizo
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return libro;
    }

    @Override
    public void guardar(Libro libro) {
        
    }

    @Override
    public void eliminar(Libro libro) {
        
    }
    
}
