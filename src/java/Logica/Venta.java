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
@Table(name = "ventas")
public class Venta implements Serializable{
    
    @Id
    @Column (name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column (name = "fecha")
    @Temporal (TemporalType.DATE)
    private Date fecha;
    @ManyToOne
    @JoinColumn (name = "medio_pago")  
    private MedioPago medioPago;
    @ManyToOne
    @JoinColumn (name = "servicio")  
    private ServicioTuristico servicio;
    @ManyToOne
    @JoinColumn (name = "paquete")  
    private PaqueteTuristico paquete;
    @ManyToOne
    @JoinColumn (name = "empleado")  
    private Empleado empleado;
    @ManyToOne
    @JoinColumn (name = "cliente")  
    private Cliente cliente;

    public Venta() {
    }

    public Venta(int codigo, Date fecha, MedioPago medioPago, ServicioTuristico servicio, PaqueteTuristico paquete, Empleado empleado, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.medioPago = medioPago;
        this.servicio = servicio;
        this.paquete = paquete;
        this.empleado = empleado;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public ServicioTuristico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioTuristico servicio) {
        this.servicio = servicio;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
}
