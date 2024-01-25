package org.iesalandalus.programacion.reservashotel.vista;

public enum Option {

    SALIR("1.-Salir"),
    INSERTAR_HUESPED("2.-Insertar huesped"),
    BUSCAR_HUESPED("3.-Buscar huesped"),
    BORRAR_HUESPED("4.-Borrar huesped"),
    MOSTRAR_HUESPEDES("5.-Mostrar huesped"),
    INSERTAR_HABITACION("6.-Insertar habiatación"),
    BUSCAR_HABITACION("7.-Buscar habitación"),
    BORRAR_HABITACION("8.-Borrar habitación"),
    MOSTRAR_HABITACIONES("9.-Mostrar habitaciones"),
    INSERTAR_RESERVA("10.-Insertar reserva"),
    ANULAR_RESERVA("11.-Anular reserva"),
    MOSTRAR_RESERVAS("12.-Mostrar reservas"),
    CONSULTAR_DISPONIBILIDAD("13.-Consultar disponibilidad");



    private String mensajeAmostrar;

    private Option(String mensajeAmostrar){
        this.mensajeAmostrar=mensajeAmostrar;
    }

    @Override
    public String toString() {
        return
                "mensajeAmostrar='" + mensajeAmostrar;
    }


}
