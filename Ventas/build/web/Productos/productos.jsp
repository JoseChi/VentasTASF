 <%-- 
    Document   : productos
    Created on : 9/11/2022, 10:52:57 AM
    Author     : Anthony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <h1>Consulta Ventas</h1>
        <h3>Folio de venta:</h3>
       <input>
        <button>Consultar</button>
        
        <br/><br/>
        <table border ="1" width="80%">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Precio Unitario</th>
                    <th>Total</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="productos" items="${lista}">
                    <tr>
                        <td><c:out value="${productos.id}" /></td>
                         <td><c:out value="${productos.producto}" /></td>
                          <td><c:out value="${productos.cantidad}" /></td>
                          <td><c:out value="${productos.precio}" /></td>
                          <td><c:out value="${productos.total}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <p>Total Productos</p> <input type="text" id="Name" name="Name" />
        <p>Total Venta</p> <input type="text" id="Name" name="Name" />
        
        <a href="ProductosControlador?accion=login">Login</a>

    </body>
</html>
