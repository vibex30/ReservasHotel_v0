package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.Objects;

public class Habitacion {

        public static final double MIN_PRECIO_HABITACION=40;
        public static final double MAX_PRECIO_HABITACION=150;
        public static final int MIN_NUMERO_PUERTA=0;
        public static final int MAX_NUMERO_PUERTA=15;

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
            /*this.planta=planta;
            this.puerta=puerta;
            this.precio=precio;
            this.identificador=String.format("%d-%d",planta,puerta);*/
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);


    }

    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion ){
        /*this.planta=planta;
        this.puerta=puerta;
        this.precio=precio;
        this.tipoHabitacion=tipoHabitacion;*/
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
    }

    //Constructor copia
    public Habitacion(Habitacion habitacion) {
        if(habitacion==null)
            throw new NullPointerException("ERROR: No es posible copiar una habitación nula.");


        /*this.planta = habitacion.planta;
        this.puerta = habitacion.puerta;
        this.precio = habitacion.precio;
        this.tipoHabitacion = habitacion.tipoHabitacion;*/
        setIdentificador(habitacion.identificador);
        setPlanta(habitacion.getPlanta());
        setPuerta(habitacion.getPuerta());
        setPrecio(habitacion.getPrecio());
        setTipoHabitacion(habitacion.getTipoHabitacion());
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


    private void setIdentificador(String identificador) {
        if(identificador==null)
            throw new NullPointerException("ERROR. el valor del identificador no puede ser nulo");
        identificador=String.valueOf(planta + puerta);
        this.identificador = identificador;
    }



    private void setPlanta(int planta) {
        if(planta<MIN_NUMERO_PLANTA || planta>MAX_NUMERO_PLANTA)
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitación un valor menor que 1 ni mayor que 3.");
        this.planta = planta;
    }

    private void setPuerta(int puerta) {
        if(puerta<MIN_NUMERO_PUERTA||puerta>MAX_NUMERO_PUERTA)
            throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitación un valor menor que 0 ni mayor que 15.");
        this.puerta = puerta;
    }


    public void setPrecio(double precio) {
        if(precio<MIN_PRECIO_HABITACION || precio>MAX_PRECIO_HABITACION)
            throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitación un valor menor que 40.0 ni mayor que 150.0.");
        this.precio = precio;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        if(tipoHabitacion==null){
            throw new NullPointerException("ERROR: No se puede establecer un tipo de habitación nula.");
        }
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    //ToString

    @Override
    public String toString() {
        return "identificador=" + identificador +  ", precio habitación=" + precio + ", tipo habitación=" + tipoHabitacion;
    }



}


