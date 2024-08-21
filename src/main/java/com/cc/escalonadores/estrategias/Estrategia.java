/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores.estrategias;

import com.cc.escalonadores.Processo;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jphn
 */
public abstract class Estrategia implements IEstrategia {

    protected List<Processo> fila, historico;
    protected String nome;
    protected DefaultTableModel modelo, modeloMedia;

    public Estrategia(List<Processo> fila, String nome) {
        this.fila = new LinkedList(fila);
        this.fila.forEach((p) -> p.setTempoChegada());

        this.historico = new LinkedList<>();
        this.nome = nome;
    }

    public void setModelo(DefaultTableModel modelo, DefaultTableModel modeloMedia) {
        this.modelo = modelo;
        this.modeloMedia = modeloMedia;
    }

    public String getNome() {
        return nome;
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
        double mediaExecucao = 0, mediaEspera = 0, mediaTurnaround = 0;

//        System.out.println("ID | SE ||| TX | TS | TR");
        for (Processo p : this.historico) {
//            System.out.printf(
//                    "%02d | %02d ||| %02d | %02d | %02d\n",
//                    p.getId(),
//                    p.getTempo(),
//                    p.getTempoExecucao().getSeconds(),
//                    p.getTempoEspera().getSeconds(),
//                    p.getTurnaround().getSeconds()
//            );

            mediaEspera += p.getTempoEspera().getSeconds();
            mediaExecucao += p.getTempoExecucao().getSeconds();
            mediaTurnaround += p.getTurnaround().getSeconds();
        }

        mediaExecucao /= this.historico.size();
        mediaEspera /= this.historico.size();
        mediaTurnaround /= this.historico.size();

//        System.out.printf(
//                "\n[MÉDIAS %s]\n"
//                + "TEX | TES | TUR\n"
//                + "%.1f | %.1f | %.1f\n\n",
//                this.nome,
//                mediaExecucao,
//                mediaEspera,
//                mediaTurnaround
//        );
        if (this.modeloMedia != null) {
            this.modeloMedia.addRow(new Object[]{
                mediaExecucao,
                mediaEspera,
                mediaTurnaround,
                null,
                null
            });
        }

    }

    public Estrategia run(boolean cpu) {
        System.out.println("[" + this.nome + " START]\n");

//        System.out.println("ID | SE | PR");
        while (!fila.isEmpty()) {
            Processo processo = this.fila.removeFirst();

            processo.setTempoInicio();

            if (cpu) {
                long fim = System.currentTimeMillis() + (processo.getTempo() * 1000);

                while (System.currentTimeMillis() <= fim) {
                    Math.sqrt(Math.random());
                }
            } else {
                try {
                    Thread.sleep(processo.getTempo() * 1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            processo.setTempoTermino();

            this.historico.add(processo);

//            System.out.printf(
//                    "%02d | %02d | %02d\n",
//                    processo.getId(),
//                    processo.getTempo(),
//                    processo.getPrioridade().getValue()
//            );
            if (this.modelo != null) {
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

        System.out.println("\n[" + this.nome + " END]\n");

        return this;
    }
}
