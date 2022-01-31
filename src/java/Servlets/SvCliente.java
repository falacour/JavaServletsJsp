
package Servlets;

import Logica.Controlador;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author falacour
 */
@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {

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
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
        
        Date fechaNacimiento = new Date();
        
        String nombre = request.getParameter("nombre"); //se realiza una request desde la interfaz grafica
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");  //double sueldo = Double.parseDouble(request.getparameter("sueldo")); casteo
        String dni = request.getParameter("dni");
        
         try {   
             fechaNacimiento = formato.parse(request.getParameter("fechaNacimiento"));
         } catch (ParseException ex) {
             Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
         }
        String nacionalidad = request.getParameter("nacionalidad");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        
//        //traigo la sesion y asigno los atributos para todas las sesiones
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("dni", dni);
//        //request.getSession().setAttribute("fechaNacimiento", fechaNacimiento);
        request.getSession().setAttribute("nacionalidad", nacionalidad);
        request.getSession().setAttribute("telefono", telefono);
        request.getSession().setAttribute("email", email);
        
        
        //no se arma el objeto en esta etapa, solo se pasan las variables
        control.crearCliente(nombre,apellido,direccion,dni,nacionalidad,telefono,email,fechaNacimiento);
        response.sendRedirect("index.jsp"); //la respuesta va a ser la redireccion si salio todo bien
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
