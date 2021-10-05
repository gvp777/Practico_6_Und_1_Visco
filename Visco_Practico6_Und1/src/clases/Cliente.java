/**
 *
 * @author Guillermo
 */
package clases;

//---Clase Cliente--------------------------------------------------------------

import java.util.Objects;

public class Cliente {                                               
    
    //---Declaracion de Variables-----------------------------------------------
    
    private long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;

    
    //---Constructor------------------------------------------------------------
    
    public Cliente(long dni, String nombre, String apellido, String direccion, String ciudad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
        
    //---Getters y Setters------------------------------------------------------  

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return  "\n\nApellido:\t" + apellido
                +"\nNombre:\t\t" + nombre 
                + "\nD.N.I:\t\t" + dni 
                + "\nDireccion:\t" + direccion 
                + "\nCiudad:\t\t" + ciudad
                + "\n";
    }
    
    
 

    
    
    
    
}
//------------------------------------------------------------------------------