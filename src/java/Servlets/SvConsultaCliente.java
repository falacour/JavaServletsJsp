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


import java.util.List;

/**
 *
 * @author falacour
 */
@WebServlet(name = "SvConsultaCliente", urlPatterns = {"/SvConsultaCliente"})
public class SvConsultaCliente extends HttpServlet {
    
    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cliente> listaClientes = control.traerClientes();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaClientes", listaClientes);
        response.sendRedirect("verClientes.jsp");
        
       
        
    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
