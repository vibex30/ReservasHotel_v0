package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Reserva {
    private final int MAX_NUMERO_MESES_RESERVA=12;
    private final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
    public final String FORMATO_FECHA_RESERVA="dd/MM/yyyy";
    private Huesped huesped;
    private Habitacion habitacion;
    private Regimen regimen;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinReserva;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private double precio;
    private int numeroPersonas;



    //Constructor con parámetros
    public Reserva(Huesped huesped, Habitacion habitacion, Regimen regimen, LocalDate fechaInicioReserva, LocalDate fechaFinReserva, int numeroPersonas){
        /*
        this.huesped=huesped;
        this.habitacion=habitacion;
        this.regimen=regimen;
        this.fechaInicioReserva=fechaInicioReserva;
        this.fechaFinReserva=fechaFinReserva;
        this.numeroPersonas=numeroPersonas;
         */
        setHuesped(huesped);
        setHabitacion(habitacion);
        setRegimen(regimen);
        setFechaInicioReserva(fechaInicioReserva);
        setFechaFinReserva(fechaFinReserva);
        setNumeroPersonas(numeroPersonas);

    }
    //Constructor copia
    public Reserva(Reserva reserva){
        /*
        this.huesped=reserva.getHuesped();
        this.habitacion=reserva.getHabitacion();
        this.regimen=reserva.getRegimen();
        this.fechaInicioReserva=reserva.getFechaInicioReserva();
        this.fechaFinReserva=reserva.getFechaFinReserva();
        this.numeroPersonas=reserva.getNumeroPersonas();
        */
        setHuesped(reserva.getHuesped());
        setHabitacion(reserva.getHabitacion());
        setRegimen(reserva.getRegimen());
        setFechaInicioReserva(reserva.getFechaInicioReserva());
        setFechaFinReserva(reserva.getFechaFinReserva());
        setNumeroPersonas(reserva.getNumeroPersonas());
    }





    //GETTER Y SETTER


    public Huesped getHuesped() {
        return huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public LocalDate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }


    //Setter

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioReserva) {
        if (fechaInicioReserva==null)
            throw new NullPointerException("ERROR: la fecha de inicio de la reserva no puede ser anterior al dia que se intenta hacer la reserva");
        if(fechaInicioReserva.isBefore (LocalDate.now()))
            throw new IllegalArgumentException("ERROR: la fecha de inicio de la reserva no puede ser posterior al numero de meses indicado por la constante MAX_NUMERO_MESES_RESERVA");
        if(fechaInicioReserva.isAfter(LocalDate.now().plusMonths(MAX_NUMERO_MESES_RESERVA)))
            throw new IllegalArgumentException("ERROR: la fecha de inicio de la reserva no puede ser posterior al constante");
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public void setFechaFinReserva(LocalDate fechaFinReserva) {
        if(fechaFinReserva==null)
            throw new NullPointerException("Error: El valor no puede ser nulo");
        if(fechaFinReserva.isBefore(fechaInicioReserva))
            throw new IllegalArgumentException("ERROR: la fecha de fin de reserva no puede ser anterior a la fecha de inicio");
        this.fechaFinReserva = fechaFinReserva;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        if(checkIn==null)
            throw new NullPointerException("Error: El checkIn no puede ser nulo");
        if(checkIn.isBefore(fechaInicioReserva.atStartOfDay()))
            throw new IllegalArgumentException("Error: El checkIn no puede ser anterior a la fecha de inicio de la reserva");

        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        if(checkOut==null)
            throw new NullPointerException("Error: El checkOut no puede ser nulo");
        if(checkIn.isAfter(checkOut))
            throw new IllegalArgumentException("Error: El CheckIn no puede ser posterior al CheckOut");
        if(checkOut.isAfter(fechaFinReserva.atStartOfDay().plusHours(MAX_HORAS_POSTERIOR_CHECKOUT)))
            throw new IllegalArgumentException("Error: El checkOut debe hacerse como máximo a las 12");
        this.checkOut = checkOut;
    }

    private void setPrecio(double precio) {
        precio = habitacion.getPrecio() * (fechaFinReserva.toEpochDay() - fechaInicioReserva.toEpochDay()) * regimen.getIncrementoPrecio();
        this.precio = precio;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        if (numeroPersonas>habitacion.getCapacidad())
            throw new IllegalArgumentException("Error: El numero de personas sobrepasas la capacidad");

        this.numeroPersonas = numeroPersonas;
    }

    //Equals, hashCode

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Reserva reserva)) return false;
        return Objects.equals(getHabitacion(), reserva.getHabitacion()) && Objects.equals(getFechaInicioReserva(), reserva.getFechaInicioReserva());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHabitacion(), getFechaInicioReserva());
    }

    //toString

    @Override
    public String toString() {
        return "Reserva{" +
                "MAX_NUMERO_MESES_RESERVA=" + MAX_NUMERO_MESES_RESERVA +
                ", MAX_HORAS_POSTERIOR_CHECKOUT=" + MAX_HORAS_POSTERIOR_CHECKOUT +
                ", FORMATO_FECHA_RESERVA='" + FORMATO_FECHA_RESERVA + '\'' +
                ", huesped=" + huesped +
                ", habitacion=" + habitacion +
                ", regimen=" + regimen +
                ", fechaInicioReserva=" + fechaInicioReserva +
                ", fechaFinReserva=" + fechaFinReserva +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", precio=" + precio +
                ", numeroPersonas=" + numeroPersonas +
                '}';
    }
}
