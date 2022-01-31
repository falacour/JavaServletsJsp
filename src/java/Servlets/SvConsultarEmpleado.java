
package Servlets;

import Logica.Controlador;
import Logica.Empleado;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;



@WebServlet(name = "SvConsultarEmpleado", urlPatterns = {"/SvConsultarEmpleado"})
public class SvConsultarEmpleado extends HttpServlet {

    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> listaEmpleados = control.traerEmpleados();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaEmpleados", listaEmpleados);
        response.sendRedirect("verEmpleados.jsp");
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
