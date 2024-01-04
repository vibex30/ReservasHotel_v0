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
        private double precio=40.0;
        private TipoHabitacion tipoHabitacion;


    //Constructores
    //Constructor con parámetros
    public Habitacion(int planta, int puerta, double precio){
        if (identificador==null){
            throw new NullPointerException("ERROR:el identificador no puede ser null");
        }
            this.planta=planta;
            this.puerta=puerta;
            this.precio=precio;
            this.identificador=String.format("%d-%d",planta,puerta);

    }

    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion ){
        this.planta=planta;
        this.puerta=puerta;
        this.precio=precio;
        this.tipoHabitacion=tipoHabitacion;
    }

    //Constructor copia
    public Habitacion(Habitacion habitacion) {
        if(habitacion==null){
            throw new NullPointerException("ERROR:habitacion no puede ser null");
        }
        this.identificador = habitacion.identificador;
        this.planta = habitacion.planta;
        this.puerta = habitacion.puerta;
        this.precio = habitacion.precio;
        this.tipoHabitacion = habitacion.tipoHabitacion;
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
        this.identificador = identificador;
    }
    //TODO: HACER LOS NULOS BIEEEEEEEEEEEEEEEEN
    private void setPlanta(int planta) {

        if(planta<MIN_NUMERO_PLANTA || planta>MAX_NUMERO_PLANTA){
            throw new IllegalArgumentException("ERROR: El número de planta no es correcto");
        }

        this.planta = planta;
    }

    private void setPuerta(int puerta) {

        if(puerta<MIN_NUMERO_PUERTA||puerta>MAX_NUMERO_PUERTA){
            throw new IllegalArgumentException("ERROR: El número de puerta no corresponde");
        }
        this.puerta = puerta;
    }

    //Setter +


    public void setPrecio(double precio) {

        if (precio<MIN_PRECIO_HABITACION || precio>MAX_PRECIO_HABITACION)
            throw new IllegalArgumentException("ERROR: precio fuera de la horquilla");

        this.precio = precio;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        if(tipoHabitacion==null){
            throw new NullPointerException("ERROR: el tipo de habitacion no puede ser nula");
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
        return "Habitacion{" +
                "identificador='" + identificador + '\'' +
                ", planta=" + planta +
                ", puerta=" + puerta +
                ", precio=" + precio +
                ", tipoHabitacion=" + tipoHabitacion +
                '}';
    }
}

