package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "clientes")
public class Cliente extends Persona implements Serializable{

    public Cliente() {
    }

    public Cliente(int codigo, String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email, String estado, Agencia agencia) {
        super(codigo, nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email, estado, agencia);
    }  
    
    
        
    
}
