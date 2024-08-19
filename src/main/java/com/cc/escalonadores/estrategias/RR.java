/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores.estrategias;

import com.cc.escalonadores.Processo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jphn
 */
public class RR extends Estrategia {

    private int quantum;
    private final List<Integer> mapa;

    public RR(List<Processo> fila, int quantum) {
        super(fila, "RR");

        this.quantum = quantum;
        this.mapa = new ArrayList<>();
    }

    @Override
    public RR run() {
        System.out.println("[" + this.nome + " START]\n");

        System.out.println("ID | SE | PR");

        while (!fila.isEmpty()) {
            Processo processo = this.fila.removeFirst();

            if (processo.getTempo() == processo.getTempoRestante()) {
                processo.setTempoInicio();
            }

            try {
                int delay = (processo.getTempoRestante() < this.quantum) || (this.fila.size() == 0)
                        ? processo.getTempoRestante()
                        : this.quantum;

                processo.setTempoRestante(delay);

                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.mapa.add(processo.getId());

            if (processo.getTempoRestante() == 0) {
                processo.setTempoTermino();
                this.historico.add(processo);
            } else {
                this.fila.add(processo);
            }

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

    public int getQuantum() {
        return quantum;
    }

    public List<Integer> getMapa() {
        return mapa;
    }

}
