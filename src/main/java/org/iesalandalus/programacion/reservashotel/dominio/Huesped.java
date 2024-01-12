package org.iesalandalus.programacion.reservashotel.dominio;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.util.Objects;

public class Huesped {
    private final String ER_TELEFONO="[0-9]{9}";
    private final String ER_CORREO="[\\w.-]+[@][\\w.-]+[.][a-zA-Z]+";
    private final String ER_DNI="([\\d]{8})([a-zA-Z])";
    public final String FORMATO_FECHA="dd/MM/yyyy";
    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;




    //constructor con parámentros
    public Huesped(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento){
        this.nombre=nombre;
        this.dni=dni;
        this.correo=correo;
        this.telefono=telefono;
        this.fechaNacimiento=fechaNacimiento;
    }

    //constructor copia
    public Huesped(Huesped huesped){
        this.nombre=huesped.getNombre();
        this.dni=huesped.getDni();
        this.correo=huesped.getCorreo();
        this.telefono=huesped.getTelefono();
        this.fechaNacimiento=huesped.getFechaNacimiento();

    }

    //TODO cambiar nombre del array
    private String formateaNombre(String nombre){
        String nombreFormateado="";
        //quito espacio de la izquierda y derecha (no toca los espacios de en medio)
        //pasar el texto a minuscula
        String nombreEnMinusSinEspacios = nombre.toLowerCase().trim();
        //split, separar cuando haya un espacio, 1 o mas
        String[] nombreArray = nombreEnMinusSinEspacios.split("\\s+");
        //poner en mayuscula la primera letra
        for(int i=0; i<nombreArray.length; i++)
            if (!nombreArray[i].isEmpty()) {
                char inicialMayuscula = Character.toUpperCase(nombreArray[i].charAt(0));
                nombreFormateado += inicialMayuscula + nombreArray[i].substring(1) + " ";
            }

        return nombreFormateado.trim();
    }





    //METODO COMPROBAR LETRA DNI
    private Boolean comprobarLetraDni() {
        String [] LETRAS_DNI = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        int dni;
        do {
            System.out.print("Dime el número de tu DNI: ");
            dni = Entrada.entero();
        } while (dni < 1 || dni > 99999999);
            System.out.println("La letra de tu DNI es: " + LETRAS_DNI[dni % 23]);

//TODO EL DNI ES UN STRING NO UN INT ASI QUE HAY QUE CAMBIARLO, TAMBIEN LETRAS_DNI ERAN CHAR
        return null;
    }
    private String getIniciales(){
        return null;
    }



    //GETTER

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    //SETTER

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //equals, hasCode, toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Huesped huesped = (Huesped) o;
        return Objects.equals(dni, huesped.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
