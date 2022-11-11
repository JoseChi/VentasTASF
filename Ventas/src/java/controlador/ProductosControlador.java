/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Productos;
import modelo.ProductosDAO;

/**
 *
 * @author Anthony
 */
@WebServlet(name = "ProductosControlador", urlPatterns = {"/ProductosControlador"})
public class ProductosControlador extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductosDAO productosDAO = new ProductosDAO();
        String accion;
        RequestDispatcher dispatcher =  null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()) {
        dispatcher = request.getRequestDispatcher("Productos/productos.jsp");
            List<Productos> listaProductos = productosDAO.listarProductos();
        request.setAttribute("lista", listaProductos);
        } else if ("login".equals(accion)){
            dispatcher = request.getRequestDispatcher("Productos/login.jsp");
        }
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
     }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}