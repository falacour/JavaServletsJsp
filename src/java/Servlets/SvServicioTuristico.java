package Servlets;

import Logica.Controlador;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author falacour
 */
@WebServlet(name = "SvServicioTuristico", urlPatterns = {"/SvServicioTuristico"})
public class SvServicioTuristico extends HttpServlet {
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
        
        String nombre = request.getParameter("nombre"); //se realiza una request desde la interfaz grafica
        String descripcion = request.getParameter("descripcion");
        String destino = request.getParameter("destino");  //double sueldo = Double.parseDouble(request.getparameter("sueldo")); casteo
        //Date fecha = request.getParameter("fecha");
        //double costo = Double.parseDouble(request.getParameter("costo"));     
        //TipoServicio tipoServicio = request.getParameter("tipoServicio");
       
        
        
        control.crearServicio(nombre,descripcion,destino);
        response.sendRedirect("index.jsp"); //la respuesta va a ser la redireccion si salio todo bien
    
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
