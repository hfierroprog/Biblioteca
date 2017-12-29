package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJdbc {

    private Connection conn;
    private String user = "hector";
    private String password = "contratest";
    private String url = "jdbc:mysql://codigosutiles.com:3306/bibliotecaBD";
    private String driverClass = "com.mysql.jdbc.Driver";

    public ConexionJdbc(String user, String password, String url,
            String driverClass) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.driverClass = driverClass;

        conectar();
    }

    public ConexionJdbc() {

        conectar();
    }

    private void conectar() {

        try {
            Class.forName(driverClass);

            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return conn;
    }
}
