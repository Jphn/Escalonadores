/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores.estrategias;

import com.cc.escalonadores.ComparadorProcesso;
import com.cc.escalonadores.Processo;
import java.util.ArrayList;
import java.util.Collections;
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

    public void sort() {
        Collections.sort(this.fila, new ComparadorProcesso(ComparadorProcesso.Tipo.PS));

        this.fila = this.fila.reversed();
    }

    @Override
    public RR run(boolean cpu) {
        System.out.println("[" + this.nome + " START]\n");

        this.sort();

//        System.out.println("ID | SE | PR");
        while (!fila.isEmpty()) {
            Processo processo = this.fila.removeFirst();

            if (processo.getTempo() == processo.getTempoRestante()) {
                processo.setTempoInicio();
            }

            int delay = (processo.getTempoRestante() < this.quantum) || (this.fila.size() == 0)
                    ? processo.getTempoRestante()
                    : this.quantum;

            if (cpu) {
                long fim = System.currentTimeMillis() + (long) (delay * 1000);

                while (System.currentTimeMillis() <= fim) {
                    Math.sqrt(Math.random());
                }
            } else {
                try {
                    Thread.sleep(delay * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            processo.setTempoRestante(delay);

            this.mapa.add(processo.getId());

            if (processo.getTempoRestante() <= 0) {
                processo.setTempoTermino();
                this.historico.add(processo);
            } else {
                this.fila.add(processo);
            }

//            System.out.printf(
//                    "%02d | %02d | %02d\n",
//                    processo.getId(),
//                    processo.getTempo(),
//                    processo.getPrioridade().getValue()
//            );
        }

        if (this.modelo != null) {
            for (Processo processo : this.historico) {
                this.modelo.addRow(new Object[]{
                    processo.getId(),
                    processo.getTempo(),
                    processo.getPrioridade().getValue(),
                    processo.getTempoExecucao().toSeconds(),
                    processo.getTempoEspera().toSeconds(),
                    processo.getTurnaround().toSeconds()
                });
            }
        }

        System.out.println("\n[" + this.nome + " END]");

        System.out.println(this.mapa);

        return this;
    }

    public int getQuantum() {
        return quantum;
    }

    public List<Integer> getMapa() {
        return mapa;
    }

}
