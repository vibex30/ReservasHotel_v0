package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;

public class Huesped {
    private final String ER_TELEFONO="";
    private final String ER_CORREO="";
    private final String ER_DNI="";
    public final String FORMATO_FECHA="";
    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;




    //contructor con parámentros
    public Huesped(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento){
        this.nombre=nombre;
        this.dni=dni;
        this.correo=correo;
        this.telefono=telefono;
        this.fechaNacimiento=fechaNacimiento;
    }

    //constructor copia
    public Huesped(Huesped huesped){
        this.nombre=huesped.nombre;
        this.dni=huesped.dni;
        this.correo=huesped.correo;
        this.telefono=huesped.telefono;
        this.fechaNacimiento=huesped.fechaNacimiento;

    }

    //GETTER Y SETTER

}
