package org.iesalandalus.programacion.reservashotel.dominio;

import org.iesalandalus.programacion.utilidades.Entrada;

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
    //METODO FORMATEANOMBRE

    private String formateaNombre() {
        String quitarSobrante = this.nombre.trim().replaceAll("\\s+", " ");
        //Array
        String[] dividirPalabras = quitarSobrante.split(" ");
        //creo el objeto
        StringBuilder formateaNombre = new StringBuilder();
        //bucle for-each, aunque creo que no lo hemos dado aún, lo he encontrado por internet y me ha parecido util para este ejercicio
        for (String palabra : dividirPalabras) {
            formateaNombre.append(Character.toUpperCase(palabra.charAt(0)))
                    .append(palabra.substring(1).toLowerCase())
                    .append(" ");
        }
        return formateaNombre.toString().trim();
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

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
