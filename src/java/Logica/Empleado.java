package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "empleados")
public class Empleado extends Persona implements Serializable{
    
    @Column (name = "cargo")
    private String cargo;    
    @Column (name = "sueldo")
    private double sueldo;

    
    @OneToOne (cascade = CascadeType.REMOVE)
    @JoinColumn (name = "usuario")
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(String cargo, double sueldo, Usuario usuario) {
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
    }

    public Empleado(String cargo, double sueldo, Usuario usuario, int codigo, String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email, String estado, Agencia agencia) {
        super(codigo, nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email, estado, agencia);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
