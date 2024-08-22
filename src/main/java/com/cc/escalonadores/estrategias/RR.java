/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores.estrategias;

import com.cc.escalonadores.ComparadorProcesso;
import com.cc.escalonadores.Processo;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jphn
 */
public class RR extends Estrategia {

    private int quantum;
    private final List<Integer> mapa = new ArrayList<>();

    public RR(List<Processo> fila, int quantum) {
        super(fila, "RR");

//        this.fila.forEach((p) -> System.out.println(p.getId() + " - " + p.getTempoChegada()));
        this.quantum = quantum;
    }

    public void sort() {
        Collections.sort(this.fila, new ComparadorProcesso(ComparadorProcesso.Tipo.PS));

        this.fila = this.fila.reversed();
    }

    @Override
    public RR run(boolean cpu) {
        System.out.println("[" + this.nome + " START]\n");

        this.sort();

        this.resetTemposDeChegada();

//        System.out.println("ID | SE | PR");
        while (!fila.isEmpty()) {
            Processo processo = this.fila.removeFirst();

            if (processo.getTempo() == processo.getTempoRestante()) {

                System.out.println(processo.getTempo() + "==" + processo.getTempoRestante());

                long tempoInicio = System.currentTimeMillis();

                processo.setTempoInicio(tempoInicio);

                long tempoEspera = (long) processo.getTempoInicio() - (long) processo.getTempoChegada();

                processo.setTempoEspera(tempoEspera);

                System.out.println(processo.getId() + " = " + ((long) processo.getTempoInicio() - (long) processo.getTempoChegada()));
                System.out.println(processo.getId() + " = " + ((long) System.currentTimeMillis() - (long) processo.getTempoChegada()));
                System.out.println(tempoInicio - processo.getTempoChegada());
            }

            int delay = (processo.getTempoRestante() < this.quantum) || (this.fila.size() == 0)
                    ? processo.getTempoRestante()
                    : this.quantum;

            long fim = System.currentTimeMillis() + (delay * 1000);

            while (System.currentTimeMillis() <= fim) {
                if (cpu) {
                    Math.sqrt(Math.random());

                    this.usoCpu.add(ManagementFactory
                            .getPlatformMXBean(OperatingSystemMXBean.class)
                            .getCpuLoad());
                }
            }

            processo.setTempoRestante(delay);

            this.mapa.add(processo.getId());

            if (processo.getTempoRestante() <= 0) {
                long tempoFinal = System.currentTimeMillis();

                processo.setTempoTermino(tempoFinal);
                processo.setTempoExecucao(tempoFinal - processo.getTempoInicio());
                processo.setTurnaround(tempoFinal - processo.getTempoChegada());

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
                    processo.getTempoExecucao(),
                    processo.getTempoEspera(),
                    processo.getTurnaround()
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
