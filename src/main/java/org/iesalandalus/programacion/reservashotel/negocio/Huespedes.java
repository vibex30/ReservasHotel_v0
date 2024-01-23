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

        // M�todo para obtener la lista de hu�spedes
        public Huesped[] get() {
            return copiaProfundaHuespedes();
        }

        // M�todo para realizar una copia profunda de la lista de hu�spedes
        private Huesped[] copiaProfundaHuespedes() {
            Huesped[] copia = new Huesped[capacidad];
            for (int i = 0; i < tamano; i++) {
                copia[i] = listaHuespedes[i];
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

        // M�todo para insertar un hu�sped
        public void insertar(Huesped huesped) {
            if (tamanoSuperado(tamano)) {
                throw new IllegalStateException("ERROR: Se ha superado el tama�o permitido.");
            }

            if (buscarIndice(huesped) == -1) {
                listaHuespedes[tamano++] = huesped;
            }
        }

        // M�todo para buscar el �ndice de un hu�sped
        private int buscarIndice(Huesped huesped) {
            for (int i = 0; i < tamano; i++) {
                if (listaHuespedes[i].equals(huesped)) {
                    return i;
                }
            }
            return -1;
        }

        // M�todo para verificar si el tama�o ha sido superado
        private boolean tamanoSuperado(int indice) {
            return indice >= capacidad;
        }

        // M�todo para buscar un hu�sped
        public Huesped buscar(Huesped huesped) {
            int indice = buscarIndice(huesped);
            return (indice != -1) ? listaHuespedes[indice] : null;
        }

        // M�todo para borrar un hu�sped
        public void borrar(Huesped huesped) {
            int indice = buscarIndice(huesped);
            if (indice != -1) {
                desplazarUnaPosicionHaciaIzquierda(indice);
                tamano--;
            }
        }

        // M�todo para desplazar una posici�n hacia la izquierda
        private void desplazarUnaPosicionHaciaIzquierda(int indice) {
            for (int i = indice; i < tamano - 1; i++) {
                listaHuespedes[i] = listaHuespedes[i + 1];
            }
        }



}


