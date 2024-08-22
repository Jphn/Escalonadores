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

    private int id, tempo, tempoRestante;
    private Prioridade prioridade;
//    private Instant tempoChegada, tempoInicio, tempoTermino;
//    private Duration tempoEspera, tempoExecucao, turnaround;
    private long tempoChegada, tempoInicio, tempoTermino;
    private long tempoEspera, tempoExecucao, turnaround;

    public Processo(int id, int tempo, Prioridade prioridade) {
        this.id = id;
        this.tempo = tempo;
        this.tempoRestante = this.tempo;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public int getTempo() {
        return tempo;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public long getTempoChegada() {
        return tempoChegada;
    }

    public long getTempoInicio() {
        return tempoInicio;
    }

    public long getTempoTermino() {
        return tempoTermino;
    }

    public long getTempoEspera() {
        return tempoEspera;
    }

    public long getTempoExecucao() {
        return tempoExecucao;
    }

    public long getTurnaround() {
        return turnaround;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setTempoRestante(int tempo) {
        this.tempoRestante -= tempo;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public void setTempoChegada(long tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public void setTempoInicio(long tempoInicio) {
        this.tempoInicio = tempoInicio;
    }

    public void setTempoTermino(long tempoTermino) {
        this.tempoTermino = tempoTermino;
    }

    public void setTempoEspera(long tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public void setTempoExecucao(long tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public void setTurnaround(long turnaround) {
        this.turnaround = turnaround;
    }

    @Override
    public String toString() {
        return "Processo{"
                + "id=" + id
                + ", tempo=" + tempo
                + ", prioridade=" + prioridade
                + ", tempoChegada=" + tempoChegada
                + ", tempoInicio=" + tempoInicio
                + ", tempoTermino=" + tempoTermino
                + ", tempoExecucao=" + tempoExecucao
                + ", turnaround=" + turnaround
                + '}';
    }
}
