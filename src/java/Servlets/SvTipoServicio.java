
package Servlets;

import Logica.Controlador;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "SvTipoServicio", urlPatterns = {"/SvTipoServicio"})
public class SvTipoServicio extends HttpServlet {

    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre"); 
        String descripcion = request.getParameter("descripcion");
        
        control.crearTipoServicio(nombre,descripcion);
        response.sendRedirect("index.jsp"); //la respuesta va a ser la redireccion si salio todo bien
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
