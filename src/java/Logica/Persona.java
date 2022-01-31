package Logica;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
public abstract class Persona {
    
    @Id
    @Column (name = "codigo")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellido")
    private String apellido;
    @Column (name = "direccion")
    private String direccion;
    @Column (name = "dni")
    private String dni;
    @Column (name = "fecha_nacimiento")
    @Temporal (TemporalType.DATE)
    private Date fechaNacimiento;
    @Column (name = "nacionalidad")
    private String nacionalidad;
    @Column (name = "celular")
    private String celular;
    @Column (name = "email")
    private String email;
    @Column (name = "estado")
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "agencia")
    private Agencia agencia;

    public Persona() {
    }

    public Persona(int codigo, String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email, String estado, Agencia agencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
        this.estado = estado;
        this.agencia = agencia;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    
    
    
}
