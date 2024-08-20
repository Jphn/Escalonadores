/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores;

import java.time.Duration;
import java.time.Instant;
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
    private Instant tempoChegada, tempoInicio, tempoTermino;
    private Duration tempoEspera, tempoExecucao, turnaround;

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

    public Instant getTempoChegada() {
        return tempoChegada;
    }

    public Duration getTempoExecucao() {
        return tempoExecucao;
    }

    public Instant getTempoInicio() {
        return tempoInicio;
    }

    public Instant getTempoTermino() {
        return tempoTermino;
    }

    public Duration getTurnaround() {
        return turnaround;
    }

    public Duration getTempoEspera() {
        return tempoEspera;
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

    public void setTempoChegada() {
        this.tempoChegada = Instant.now();
    }

    public void setTempoInicio() {
        this.tempoInicio = Instant.now();
    }

    public void setTempoTermino() {
        this.tempoTermino = Instant.now();

        this.setTempoEspera();
        this.setTempoExecucao();
        this.setTurnaround();
    }

    private void setTempoExecucao() {
        this.tempoExecucao = Duration.between(this.tempoInicio, this.tempoTermino);
    }

    private void setTurnaround() {
        this.turnaround = Duration.between(this.tempoChegada, this.tempoTermino);
    }

    private void setTempoEspera() {
        this.tempoEspera = Duration.between(this.tempoChegada, this.tempoInicio);
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
