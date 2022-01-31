package Persistencia;

import Logica.Cliente;
import Logica.Empleado;
import Logica.MedioPago;
import Logica.PaqueteTuristico;
import Logica.ServicioTuristico;
import Logica.TipoServicio;
import Logica.Usuario;
import Logica.Venta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladorPersistencia {
    
    AgenciaJpaController agenciaJpa = new AgenciaJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    MedioPagoJpaController medioJpa = new MedioPagoJpaController();
    PaqueteTuristicoJpaController paqueteJpa = new PaqueteTuristicoJpaController();
    ServicioTuristicoJpaController servicioJpa = new ServicioTuristicoJpaController();
    TipoServicioJpaController tipoServicioJpa = new TipoServicioJpaController();    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    VentaJpaController ventaJpa = new VentaJpaController();
    
    //crear
    public void crearCliente (Cliente cliente){
        clienteJpa.create(cliente);
    }
    
    public void crearEmpleado (Empleado empleado){
        empleadoJpa.create(empleado);
    }
    
    public void crearUsuario (Usuario usuario){
        usuarioJpa.create(usuario);
    }
    
    public void crearVenta (Venta venta){
        ventaJpa.create(venta);
    }
    
    public void crearPaquete (PaqueteTuristico paquete){
        paqueteJpa.create(paquete);
    }
    
    public void crearServicio (ServicioTuristico servicio){
        servicioJpa.create(servicio);
    }
    
    public void crearTipoServicio (TipoServicio tipo){
        tipoServicioJpa.create(tipo);
    }
    
    public void crearMedioPago (MedioPago medio){
        medioJpa.create(medio);
    }

    
    //traer listas
    public List<Cliente> traerClientes() {
        return clienteJpa.findClienteEntities();
    }
    
    public List<Empleado> traerEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }
    
    //baja cliente
    public void bajaCliente(Cliente cliente){
        try {
            cliente.setEstado("Baja");
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    public void bajaEmpleado(Empleado empleado){
        try {
            empleado.setEstado("Baja");
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    //buscar cliente
    public Cliente buscarCliente(int id){
        Cliente cliente = clienteJpa.findCliente(id);
        return cliente;
    }
    
    public Empleado buscarEmpleado(int id){
        Empleado empleado = empleadoJpa.findEmpleado(id);
        return empleado;
    }
    
    //modificar cliente
    public void modificarCliente (Cliente cliente){
        try {
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarEmpleado (Empleado empleado){
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                
    
}