package Logica;

import Persistencia.ControladorPersistencia;
import java.util.Date;
import java.util.List;


public class Controlador {
    
    ControladorPersistencia control = new ControladorPersistencia();

    public void crearCliente(String nombre, String apellido, String direccion,String dni,String nacionalidad,String celular,String email,Date fechaNacimiento) {
        Cliente cliente = new Cliente();
        if(!nombre.equals("")&&!apellido.equals("")&&!direccion.equals("")){
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);            
            cliente.setDni(dni);
            cliente.setFechaNacimiento(fechaNacimiento);
            cliente.setEstado("alta");
            cliente.setNacionalidad(nacionalidad);
            cliente.setCelular(celular);
            cliente.setEmail(email);
            //String id = String.valueOf(cliente.getCodigo());
            control.crearCliente(cliente);
            if(cliente.getFechaNacimiento() != null){}
        }else{
            System.out.println("Debe completar todos los campos");
        }
    }
    
    public void crearEmpleado(String nombre, String apellido, String direccion,String dni,String nacionalidad,String celular,String email,String usuario,String contrasenia,double sueldo,String cargo,Date fechaNacimiento) {
        Empleado empleado = new Empleado();
        Usuario user = new Usuario();
        if(!nombre.equals("")&&!apellido.equals("")&&!direccion.equals("")){
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setDireccion(direccion);            
            empleado.setDni(dni);
            empleado.setSueldo(sueldo);
            empleado.setCargo(cargo);
            empleado.setFechaNacimiento(fechaNacimiento);
            empleado.setEstado("alta");
            empleado.setNacionalidad(nacionalidad);
            empleado.setCelular(celular);
            empleado.setEmail(email);
              
              user.setNombre(usuario);
              user.setContrasenia(contrasenia);
              
              //crear usuario primero
              
              control.crearUsuario(user);
              empleado.setUsuario(user);
              
              
              
            
            control.crearEmpleado(empleado);
            user.setEmpleado(empleado);
        }else{
            System.out.println("Debe completar todos los campos");
        }
    }
    
    public void crearMedioPago(String nombre, double comision ) {
        MedioPago medio = new MedioPago();
        
        if(!nombre.equals("")){
            medio.setNombre(nombre);
            medio.setComision(comision);         
            
            control.crearMedioPago(medio);
        }else{
            System.out.println("Debe completar todos los campos");
        }
    }
    
    public void crearTipoServicio(String nombre,String descripcion) {
        TipoServicio tipo = new TipoServicio();
        
        if(!nombre.equals("")){
            tipo.setNombre(nombre);
            tipo.setDescripcion(descripcion);
               
            
            control.crearTipoServicio(tipo);
        }else{
            System.out.println("Debe completar todos los campos");
        }
    }
    
    public void crearServicio(String nombre,String descripcion, String destino) {
        TipoServicio tipo = new TipoServicio();
        
        if(!nombre.equals("")){
            tipo.setNombre(nombre);
               
            
            control.crearTipoServicio(tipo);
        }else{
            System.out.println("Debe completar todos los campos");
        }
    }
    
    //Traer Listas

    public List<Cliente> traerClientes() {
        return control.traerClientes();
    }
    
    public List<Empleado> traerEmpleados() {
        return control.traerEmpleados();
    }
    
    
    //Baja cliente
    public void bajaCliente(int id){
        Cliente cliente = control.buscarCliente(id);
        if(cliente != null){
        control.bajaCliente(cliente);
        }
        
    }
    
    public void bajaEmpleado(int id){
        Empleado empleado = control.buscarEmpleado(id);
        if(empleado != null){
        control.bajaEmpleado(empleado);
        }
        
    }
    
    //buscar cliente
    public Cliente buscarCliente(int id){
        Cliente cliente = control.buscarCliente(id);
        return cliente;
    }
     
    public Empleado buscarEmpleado(int id){
        Empleado empleado = control.buscarEmpleado(id);
        return empleado;
    }
    
    //Modificar clientes
    public void modificarCliente(int id ,String nombre, String apellido, String direccion,String dni,String nacionalidad,String celular,String email,Date fechaNacimiento) {
        Cliente cliente = this.buscarCliente(id);
        if(!nombre.equals("")&&!apellido.equals("")&&!direccion.equals("")){
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);            
            cliente.setDni(dni);
            cliente.setFechaNacimiento(fechaNacimiento);
            cliente.setEstado("alta");
            cliente.setNacionalidad(nacionalidad);
            cliente.setCelular(celular);
            cliente.setEmail(email);
            //String id = String.valueOf(cliente.getCodigo());
            control.modificarCliente(cliente);
            
        }else{
            System.out.println("Debe completar todos los campos");
        }
    }
    
    public void modificarEmpleado(int id ,String nombre, String apellido, String direccion,String dni,String nacionalidad,String celular,String email,Date fechaNacimiento,String cargo,double sueldo,String usuario,String contrasenia) {
        Empleado e = this.buscarEmpleado(id);
        if(!nombre.equals("")&&!apellido.equals("")&&!direccion.equals("")){
            e.setNombre(nombre);
            e.setApellido(apellido);
            e.setDireccion(direccion);            
            e.setDni(dni);
            e.setFechaNacimiento(fechaNacimiento);
            e.setEstado("alta");
            e.setNacionalidad(nacionalidad);
            e.setCelular(celular);
            e.setEmail(email);
            e.setCargo(cargo);
            e.setSueldo(sueldo);
            e.getUsuario().setNombre(usuario);
            e.getUsuario().setContrasenia(contrasenia);
            //String id = String.valueOf(cliente.getCodigo());
            control.modificarEmpleado(e);
            
        }else{
            System.out.println("Debe completar todos los campos");
        }
    }
        
}
