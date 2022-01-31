
package Servlets;

import Logica.Cliente;
import Logica.Controlador;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author falacour
 */
@WebServlet(name = "SvEditarCliente", urlPatterns = {"/SvEditarCliente"})
public class SvEditarCliente extends HttpServlet {
    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
        
        Date fechaNacimiento = new Date();
        int id = Integer.valueOf(request.getParameter("id"));
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
       
        
        //no se arma el objeto en esta etapa, solo se pasan las variables
        control.modificarCliente(id ,nombre, apellido, direccion,dni,nacionalidad,telefono,email,fechaNacimiento);
        request.getSession().setAttribute("listaClientes", control.traerClientes());
        response.sendRedirect("verClientes.jsp"); //la respuesta va a ser la redireccion si salio todo bien
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = control.buscarCliente(id);
        
        
        HttpSession miSession = request.getSession();
        
        miSession.setAttribute("cliente", cliente);
        response.sendRedirect("modificarCliente.jsp");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
