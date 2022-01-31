package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paquetes_turisticos")
public class PaqueteTuristico implements Serializable{
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column (name = "costo")
    private double costo;
    @Column (name = "descuento")
    private double descuento;
    
    @ManyToMany
    @JoinTable(name="servicios_por_paquetes",
            joinColumns = @JoinColumn (name = "paquete_turistico"),
            inverseJoinColumns = @JoinColumn(name="servicio_turistico"))//creamos tabla nueva y le asignamos las claves foraneas de las tablas asociados
    private List<ServicioTuristico> misServicios;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int codigo, double costo, double descuento, List<ServicioTuristico> misServicios) {
        this.codigo = codigo;
        this.costo = costo;
        this.descuento = descuento;
        this.misServicios = misServicios;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public List<ServicioTuristico> getMisServicios() {
        return misServicios;
    }

    public void setMisServicios(List<ServicioTuristico> misServicios) {
        this.misServicios = misServicios;
    }
    
    
    
    
}
