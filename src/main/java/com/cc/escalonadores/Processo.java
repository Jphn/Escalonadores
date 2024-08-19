/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores;

import java.util.Random;

/**
 *
 * @author jphn
 */
public class Processo {

    public enum Prioridade {
        HIGH(3),
        MED(2),
        LOW(1);

        private int value;

        Prioridade(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static Prioridade random() {
            return Prioridade.values()[new Random().nextInt(0, 2)];
        }
    }

    public int id, tempo;
    public Prioridade prioridade;

    public Processo(int id, int tempo, Prioridade prioridade) {
        this.id = id;
        this.tempo = tempo;
        this.prioridade = prioridade;
    }
}
