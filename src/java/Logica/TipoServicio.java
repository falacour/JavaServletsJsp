package Logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tipos_servicios")
public class TipoServicio implements Serializable{
   
    @Id
    @Column (name = "codigo")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "descripcion")
    private String descripcion;

    public TipoServicio() {
    }

    public TipoServicio(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}
