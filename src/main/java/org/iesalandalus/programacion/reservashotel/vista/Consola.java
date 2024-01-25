package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.dominio.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consola {
    private Consola() {

    }

    public static void mostrarMenu() {
        System.out.println("Menú:");
        for (Option opcionOp : Option.values())
            System.out.println(opcionOp.toString());
    }

    public static int elegirOpcion() {
        int opcionElegida = 0;
        do {
            mostrarMenu();
            System.out.println("Elija una opción entre 1 y 13");
            opcionElegida = Entrada.entero();

        } while (opcionElegida < 1 || opcionElegida > 13);
        return opcionElegida;
    }

    public static Huesped leerHuesped() {
        Huesped huesped=null;

        try {

            System.out.println("Introduce sus datos:");

            System.out.println("Nombre:");
            String nombre = Entrada.cadena();

            System.out.println("Dni:");
            String dni = Entrada.cadena();

            System.out.println("Correo:");
            String correo = Entrada.cadena();

            System.out.println("Teléfono:");
            String telefono = Entrada.cadena();

            System.out.println("Fecha de nacimiento");
            int dia;
            do {
                System.out.println("Introduce el dia de nacimiento:");
                dia = Entrada.entero();
            } while (dia < 1 || dia > 31);


            int mes;
            do {
                System.out.println("Introduce el mes de nacimiento:");
                mes = Entrada.entero();
            } while (mes < 1 || mes > 12);

            int anio;
            int anioActual = LocalDate.now().getYear();
            do {
                System.out.println("Introduce el año de nacimiento:");
                anio = Entrada.entero();
            } while (anio < 1900 || anio > anioActual);

            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            System.out.println("Fecha de nacimiento: " + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));


            huesped = new Huesped(nombre, dni, correo, telefono, fechaNacimiento);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return huesped;
    }
    public static Huesped getHuespedPorDni() {
        Huesped huesped = null;
        try {
            System.out.println("Introduzca el dni:");
            String dni = Entrada.cadena();
            return new Huesped("Nombre Ficticio", "77777777a", "correoficticio@hotmail.com", "666666666", LocalDate.of(1993, 10, 17));


        } catch (IllegalArgumentException e) {
            System.out.println("Error, no se puede leer ese dni");
        }
        return huesped;
    }

    public static LocalDate leerFecha(){
        LocalDate fecha=null;
        do{
            try{
                System.out.println("Introduzca el dia");
                int dia=Entrada.entero();
                System.out.println("Introduzca el mes");
                int mes=Entrada.entero();
                System.out.println("Introduzca el año");
                int anio=Entrada.entero();

                fecha=LocalDate.of(anio, mes , dia);


            }catch (DateTimeException e){
                System.err.println("Error, la fecha introducida no es válida");
            }
        }while (fecha==null);
       return fecha;
    }

    public static Habitacion leerHabitacion(){
        Habitacion habitacion=null;
        try{
            System.out.println("Introduzca la planta de la habitación:");
            int planta=Entrada.entero();

            System.out.println("Introduzca la puerta de la habitación:");
            int puerta=Entrada.entero();

            System.out.println("Introduzca el tipo de habitación");
            TipoHabitacion tipoHabitacion= leerTipoHabitacion();

            System.out.println("Introduzca el precio de la habitación:");
            double precio=Entrada.realDoble();

            habitacion=new Habitacion(planta, puerta, precio, tipoHabitacion);


        }catch (IllegalArgumentException e){
            System.out.println("Error, los parámetros estan mal.");
        }
        return habitacion;
    }

    public static Habitacion leerHabitacionPorIdentificador(){
        Habitacion habitacion=null;

        try{

        }
        return null;
    }

    public static TipoHabitacion leerTipoHabitacion(){
        TipoHabitacion tipoHabitacion=null;
        int opcionTipoHabitacion;

        do{
            System.out.println("Introduce el tipo de habitación:\n1.-Simple\n2.-Doble\n3.-Triple\n4.-Suite");
            opcionTipoHabitacion=Entrada.entero();
        }while (opcionTipoHabitacion<1||opcionTipoHabitacion>4);

        switch (opcionTipoHabitacion){
            case 1:
                tipoHabitacion=TipoHabitacion.SIMPLE;
                break;
            case 2:
                tipoHabitacion=TipoHabitacion.DOBLE;
                break;
            case 3:
                tipoHabitacion=TipoHabitacion.TRIPLE;
                break;
            case 4:
                tipoHabitacion=TipoHabitacion.SUITE;
                break;


        }

        return tipoHabitacion;
    }

    public static Regimen leerRegimen(){
        Regimen regimen=null;
        int opcionRegimen;
        do{
            System.out.println("Elige el régimen deseado: \n1.-Solo alojamiento\n2.-Alojamiento y desayuno\n3.-Media pensión\n4.-Pensión complenta");
            opcionRegimen=Entrada.entero();
        }while (opcionRegimen<1||opcionRegimen>4);

        switch (opcionRegimen){
            case 1:
                regimen=Regimen.SOLO_ALOJAMIENTO;
                break;
            case 2:
                regimen=Regimen.ALOJAMIENTO_DESAYUNO;
                break;
            case 3:
                regimen=Regimen.MEDIA_PENSION;
                break;
            case 4:
                regimen=Regimen.PENSION_COMPLETA;
                break;
        }

        return regimen;
    }

    public static Reserva leerReserva(){
        Reserva reserva=null;
        System.out.println("Introduza el dni del huésped");



        return null;
    }



}
