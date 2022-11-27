/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Anthony
 */
public class Conexion {
    private static String url = "jdbc:mysql://localhost:3306/productos_bd";
    private static String usuario = "root";
    private static String contrasena = "12345";
    
    private static Connection conexion;
    private static PreparedStatement sentenciaPreparada;
    private static ResultSet resultado;
    
    public static Connection conectar(){
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,contrasena);
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error" + e);
        }
        return conexion; 
    }
    
    public static void  main (String [] args) {
     
        try{
            conexion = conectar();
            String consulta = "INSERT INTO usuarios (idusuario,nombre,contrasena) VALUES ('1','admin','12345')";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            int i = sentenciaPreparada.executeUpdate();
            
            if(i > 0) {
                System.out.println("Se guardaron los datos");
            }else{
                System.out.println("No Guardaron los datos");
            }
            conexion.close();
        }catch (SQLException e) {
            System.out.println("Error " + e);
         }
    }
    
}
