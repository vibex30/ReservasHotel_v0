package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.Objects;

public class Habitacion {

    public static final double MIN_PRECIO_HABITACION=40.0;
    public static final double MAX_PRECIO_HABITACION=150.0;
    public static final int MIN_NUMERO_PUERTA=0;
    public static final int MAX_NUMERO_PUERTA=14;

    public static final int MIN_NUMERO_PLANTA=1;
    public static final int MAX_NUMERO_PLANTA=3;


    private String identificador;
    private int planta=1;
    private int puerta=0;
    private double precio=50.0;
    private TipoHabitacion tipoHabitacion;


    //Constructores
    //Constructor con parámetros
    public Habitacion(int planta, int puerta, double precio){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
        this.identificador=identificador(planta,puerta);

    }

    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion ){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
        this.identificador=identificador(planta,puerta);

    }

    //Constructor copia
    public Habitacion(Habitacion habitacion) {
        if(habitacion==null) {
            throw new NullPointerException("ERROR: No es posible copiar una habitación nula.");
        }
        setPlanta(habitacion.getPlanta());
        setPuerta(habitacion.getPuerta());
        setPrecio(habitacion.getPrecio());
        setTipoHabitacion(habitacion.getTipoHabitacion());
        this.identificador= habitacion.identificador;
    }





    //Getter
    public String getIdentificador() {
        return identificador;
    }

    public int getPlanta() {
        return planta;
    }

    public int getPuerta() {
        return puerta;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }




    //Setter -

    private void setIdentificador() {
        if (identificador == null)
            throw new NullPointerException("ERROR: No es posible un identificador nulo");
        this.identificador= identificador;
    }


    private  String identificador(int planta, int puerta){
        return planta+""+puerta;
    }


    private void setPlanta(int planta) {
        if(planta<MIN_NUMERO_PLANTA || planta>MAX_NUMERO_PLANTA)
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitación un valor menor que 1 ni mayor que 3.");
        this.planta = planta;
    }

    private void setPuerta(int puerta) {
        if(puerta<MIN_NUMERO_PUERTA || puerta>MAX_NUMERO_PUERTA)
            throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitación un valor menor que 0 ni mayor que 14.");
        this.puerta = puerta;
    }


    public void setPrecio(double precio) {
        if(precio<MIN_PRECIO_HABITACION || precio>MAX_PRECIO_HABITACION)
            throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitación un valor menor que 40.0 ni mayor que 150.0.");
        this.precio = precio;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        if(tipoHabitacion==null)
            throw new NullPointerException("ERROR: No se puede establecer un tipo de habitación nula.");

        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion habitacion)) return false;
        return Objects.equals(getIdentificador(), habitacion.getIdentificador());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getIdentificador());
    }

    //ToString

    @Override
    public String toString() {
        return "identificador=" + getIdentificador() +" (" + getPlanta() + "-" + getPuerta() + ")" + ", precio habitación=" + getPrecio() + ", tipo habitación=" + getTipoHabitacion();
    }



}


