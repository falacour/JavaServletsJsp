
package Servlets;

import Logica.Controlador;
import jakarta.servlet.ServletException;
import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminarEmpleado", urlPatterns = {"/SvEliminarEmpleado"})
public class SvEliminarEmpleado extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("id"));
        control.bajaEmpleado(id);
        
        //actualizo mi lista de personas
        
        
        request.getSession().setAttribute("listaEmpleados", control.traerEmpleados());
        response.sendRedirect("verEmpleados.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
