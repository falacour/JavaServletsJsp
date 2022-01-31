package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "servicios")
public class ServicioTuristico implements Serializable{
    
    @Id
    @Column (name = "codigo")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    @ManyToOne
    @JoinColumn (name = "tipo_servicio")    
    private TipoServicio tipoServicio;
    @Column (name = "destino")
    private String destino;
    @Column (name = "fecha")
    @Temporal (TemporalType.DATE)
    private Date fecha;
    @Column( name = "costo")
    private double costo;

    public ServicioTuristico() {
    }

    public ServicioTuristico(int codigo, TipoServicio tipoServicio, String destino, Date fecha, double costo) {
        this.codigo = codigo;
        this.tipoServicio = tipoServicio;
        this.destino = destino;
        this.fecha = fecha;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

   
    
}
