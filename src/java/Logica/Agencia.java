package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "agencias")
public class Agencia implements Serializable{
    
    @Id
    @Column (name = "codigo")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "direccion")
    private String direccion;
    @Column (name = "telefono")
    private String telefono;
    
    @OneToMany (mappedBy = "agencia")
    private List<Empleado> misEmpleados;
    
    @OneToMany (mappedBy = "agencia")
    private List<Cliente> misClientes;
    

    public Agencia() {
    }

    public Agencia(int codigo, String nombre, String direccion, String telefono, List<Empleado> misEmpleados, List<Cliente> misClientes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.misEmpleados = misEmpleados;
        this.misClientes = misClientes;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Empleado> getMisEmpleados() {
        return misEmpleados;
    }

    public void setMisEmpleados(List<Empleado> misEmpleados) {
        this.misEmpleados = misEmpleados;
    }

    public List<Cliente> getMisClientes() {
        return misClientes;
    }

    public void setMisClientes(List<Cliente> misClientes) {
        this.misClientes = misClientes;
    }

    
    
}
