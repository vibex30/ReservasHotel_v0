package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;

public class Habitaciones {
    private int capacidad;
    private int tamano;
    private Habitacion[] listaHabitaciones;

    // Constructor
    public Habitaciones(int capacidad) {
        this.capacidad = capacidad;
        this.tamano = 0;
        this.listaHabitaciones = new Habitacion[capacidad];
    }

    // M�todo para obtener la lista de habitaciones
    public Habitacion[] get() {
        return copiaProfundaHabitaciones();
    }

    // M�todo para realizar una copia profunda de la lista de habitaciones
    private Habitacion[] copiaProfundaHabitaciones() {
        Habitacion[] copia = new Habitacion[capacidad];
        for (int i = 0; i < tamano; i++) {
            copia[i] = listaHabitaciones[i];
        }
        return copia;
    }

    // M�todo para obtener el tama�o actual de la lista
    public int getTamano() {
        return tamano;
    }

    // M�todo para obtener la capacidad de la lista
    public int getCapacidad() {
        return capacidad;
    }

    // M�todo para insertar una habitacion
    public void insertar(Habitacion habitacion) {
        if (tamanoSuperado(tamano)) {
            throw new IllegalStateException("ERROR: Se ha superado el tama�o permitido.");
        }

        if (buscarIndice(habitacion) == -1) {
            listaHabitaciones[tamano++] = habitacion;
        }
    }

    // M�todo para buscar el �ndice de una habitacion
    private int buscarIndice(Habitacion habitacion) {
        for (int i = 0; i < tamano; i++) {
            if (listaHabitaciones[i].equals(habitacion)) {
                return i;
            }
        }
        return -1;
    }

    // M�todo para verificar si el tama�o ha sido superado
    private boolean tamanoSuperado(int indice) {
        return indice >= capacidad;
    }

    // M�todo para buscar una habitacion
    public Habitacion buscar(Habitacion habitacion) {
        int indice = buscarIndice(habitacion);
        return (indice != -1) ? listaHabitaciones[indice] : null;
    }

    // M�todo para borrar una habitacion
    public void borrar(Habitacion habitacion) {
        int indice = buscarIndice(habitacion);
        if (indice != -1) {
            desplazarUnaPosicionHaciaIzquierda(indice);
            tamano--;
        }
    }

    // M�todo para desplazar una posici�n hacia la izquierda
    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < tamano - 1; i++) {
            listaHabitaciones[i] = listaHabitaciones[i + 1];
        }
    }

}
