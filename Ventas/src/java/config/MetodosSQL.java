 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anthony
 */
public class MetodosSQL {

    private Connection conexion;
    private PreparedStatement sentenciaPreparada;
    private ResultSet resultado;

    public boolean registrarUsuario(String idusuario, String nombre, String contrasena) {
        boolean registro = false;

        try {
            conexion = Conexion.conectar();
            String consulta = "INSERT INTO usuarios (idusuario,nombre,contrasena) VALUES (?,?,?,?,?)";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, idusuario);
            sentenciaPreparada.setString(2, nombre);
            sentenciaPreparada.setString(3, contrasena);

            int resultadoInsercion = sentenciaPreparada.executeUpdate();

            if (resultadoInsercion > 0) {
                registro = true; // EL usuario se ah registrado
                System.out.println("Se hizo el alta del usuario");
            } else {
                registro = false; // EL usuario NO se ah registrado
                System.out.println("NO se hizo el alta del usuario");
            }

            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro: " + registro);
        return registro;
    }

    public boolean buscarUsuarioRepetidoBD(String idusuario) {
        boolean usuarioRepetido = false;
        try {
            conexion = Conexion.conectar();
            String consulta = "SELECT idusuario FROM usuarios WHERE idusuario = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, idusuario);
            resultado = sentenciaPreparada.executeQuery();

            if (resultado.next()) {
                usuarioRepetido = true; // El usuario esta registrado en la BD
            } else {
                usuarioRepetido = false; // El usuario NO esta registrado en la BD
            }

            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("El valor del usuario Repetido en el METODO es: " + usuarioRepetido);
        return usuarioRepetido;
    }

    public boolean buscarUsuarioInicioSesion(String idusuario, String contrasena) {
        boolean iniciarSesion = false;

        try {
            conexion = Conexion.conectar();
            String consulta = "SELECT idusuario,contrasena FROM usuarios WHERE idusuario = ? AND contrasena = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, idusuario);
            sentenciaPreparada.setString(2, contrasena);
            resultado = sentenciaPreparada.executeQuery();
            if (resultado.next()) {
                iniciarSesion = true;//El usuario puede iniciar Sesion por que esta registrado en la BD
            } else {
                iniciarSesion = false;//El usuario NO puede iniciar sesion por que no esta registrado en la BD
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("El valor de iniciarSesion en el metodo es: " + iniciarSesion);
        return iniciarSesion;
    }

    
    
    public String buscarNombre(String usuario) {
        String nombre = null;
        try {
            conexion = Conexion.conectar();
            String consulta = "SELECT nombre FROM usuarios WHERE nombre = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, usuario);
            resultado =  sentenciaPreparada.executeQuery();
            if(resultado.next()){// El usuario fue encontrado y obtenemos el nombre 
                nombre = resultado.getString("nombre");
            }else{
                nombre = null; //EL usuario no fue encontrado y NO obtenemos el nombre
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " +e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
        
        System.out.println("El valor del nombre en los Metodos SQL es : "  + nombre);
        return nombre;
    }

}

