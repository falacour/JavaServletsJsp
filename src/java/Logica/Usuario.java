package Logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name = "usuarios")
public class Usuario implements Serializable{
    
    @Id
    @Column (name = "codigo")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column (name = "nombre")
    private String nombre;
    @Column(name = "contrasenia")
    private String contrasenia;
    
    @OneToOne (mappedBy = "usuario")
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(int codigo, String nombre, String contrasenia, Empleado empleado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.empleado = empleado;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
}
