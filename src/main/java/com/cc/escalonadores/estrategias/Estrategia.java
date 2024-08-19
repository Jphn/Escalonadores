/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores.estrategias;

import com.cc.escalonadores.Processo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jphn
 */
public abstract class Estrategia {

    protected List<Processo> fila, historico;
    protected String nome;

    public Estrategia(List<Processo> fila, String nome) {
        this.fila = new LinkedList(fila);
        this.fila.forEach((p) -> p.setTempoChegada());

        this.historico = new LinkedList<>();
        this.nome = nome;
    }

    protected void displayFila() {
        for (Processo p : this.fila) {
            System.out.printf(
                    "%02d | %02d",
                    p.getId(),
                    p.getTempo()
            );
        }
    }

    public void displayHistorico() {
        System.out.println("ID | SE | | TE | TR");

        for (Processo p : this.historico) {
            System.out.printf(
                    "%02d | %02d | | %02d | %02d\n",
                    p.getId(),
                    p.getTempo(),
                    p.getTempoExecucao().getSeconds(),
                    p.getTurnaround().getSeconds()
            );
        }
    }

    public Estrategia run() {
        System.out.println("[" + this.nome + " START]\n");

        System.out.println("ID | SE | PR");

        while (!fila.isEmpty()) {
            Processo processo = this.fila.removeFirst();

            processo.setTempoInicio();

            try {
                Thread.sleep(processo.getTempo() * 1000); // Simulando tempo de execução
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            processo.setTempoTermino();

            this.historico.add(processo);

            System.out.printf(
                    "%02d | %02d | %02d\n",
                    processo.getId(),
                    processo.getTempo(),
                    processo.getPrioridade().getValue()
            );
        }

        System.out.println("\n[" + this.nome + " END]");

        return this;
    }

}
