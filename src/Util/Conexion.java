package Util;

import java.sql.*;

public class Conexion {
    
    Connection con;
    
    private String url = "jdbc:mysql://localhost:3306/proyecto_algoritmos";
    private String usuario = "root";
    private String clave = "bbc9117";

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, clave);

        } catch (Exception e) {
            System.out.println("No ingreso:  " + e.getMessage());
        }

        return con;
    }
    
    //Prueba para ver si conecta o no
    public static void main(String[] args) {
        Conexion connect = new Conexion();
        System.out.println("Coneccion:  " + connect.getConnection());
    }
}
