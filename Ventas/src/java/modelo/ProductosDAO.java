/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony
 */
public class ProductosDAO  {
    
    Connection conexion;
    
    public ProductosDAO() {
        Conexion  con = new Conexion();
       conexion = con.conectar();
    }

    public List<Productos> listarProductos(){
        PreparedStatement ps;
        ResultSet rs;
        
        List<Productos> lista = new ArrayList<>();
        
        try {
            
            ps = conexion.prepareStatement("SELECT id, producto, cantidad, precio, total FROM productos");
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String producto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                Double precio = rs.getDouble("precio");
                Double total = rs.getDouble("total");
                
                Productos productos = new Productos(id, producto, precio, cantidad, total);
                lista.add(productos);
            }
            
            return lista; 
        
        }catch(SQLException e){
            System.out.println (e.toString());
            return null;
        }
    }
    
        public Productos mostrarProductos(int _id){
        PreparedStatement ps;
        ResultSet rs;
        Productos productos = null;
        
        
        try {
            ps = conexion.prepareStatement ("SELECT id, producto, cantidad, precio, total FROM productos WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String producto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                Double precio = rs.getDouble("precio");
                Double total = rs.getDouble("total");
                
                productos = new Productos(id, producto, precio, cantidad, total);
            }
            
            return productos; 
        
        }catch(SQLException e){
            System.out.println (e.toString());
            return null;
        }
    
    
    }
}
