package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Huesped;

public class Huespedes {

        private int capacidad;
        private int tamano;
        private Huesped[] listaHuespedes;

        // Constructor
        public Huespedes(int capacidad) {
            this.capacidad = capacidad;
            this.tamano = 0;
            this.listaHuespedes = new Huesped[capacidad];
        }

        // Método para obtener la lista de huéspedes
        public Huesped[] get() {
            return copiaProfundaHuespedes();
        }

        // Método para realizar una copia profunda de la lista de huéspedes
        private Huesped[] copiaProfundaHuespedes() {
            Huesped[] copia = new Huesped[capacidad];
            for (int i = 0; i < tamano; i++) {
                copia[i] = listaHuespedes[i];
            }
            return copia;
        }

        // Método para obtener el tamaño actual de la lista
        public int getTamano() {
            return tamano;
        }

        // Método para obtener la capacidad de la lista
        public int getCapacidad() {
            return capacidad;
        }

        // Método para insertar un huésped
        public void insertar(Huesped huesped) {
            if (tamanoSuperado(tamano)) {
                throw new IllegalStateException("ERROR: Se ha superado el tamaño permitido.");
            }

            if (buscarIndice(huesped) == -1) {
                listaHuespedes[tamano++] = huesped;
            }
        }

        // Método para buscar el índice de un huésped
        private int buscarIndice(Huesped huesped) {
            for (int i = 0; i < tamano; i++) {
                if (listaHuespedes[i].equals(huesped)) {
                    return i;
                }
            }
            return -1;
        }

        // Método para verificar si el tamaño ha sido superado
        private boolean tamanoSuperado(int indice) {
            return indice >= capacidad;
        }

        // Método para buscar un huésped
        public Huesped buscar(Huesped huesped) {
            int indice = buscarIndice(huesped);
            return (indice != -1) ? listaHuespedes[indice] : null;
        }

        // Método para borrar un huésped
        public void borrar(Huesped huesped) {
            int indice = buscarIndice(huesped);
            if (indice != -1) {
                desplazarUnaPosicionHaciaIzquierda(indice);
                tamano--;
            }
        }

        // Método para desplazar una posición hacia la izquierda
        private void desplazarUnaPosicionHaciaIzquierda(int indice) {
            for (int i = indice; i < tamano - 1; i++) {
                listaHuespedes[i] = listaHuespedes[i + 1];
            }
        }



}


