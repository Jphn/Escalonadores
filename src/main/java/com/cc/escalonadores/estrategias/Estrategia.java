/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores.estrategias;

import com.cc.escalonadores.ComparadorProcesso;
import com.cc.escalonadores.Processo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jphn
 */
public abstract class Estrategia {

    protected List<Processo> fila;
    private String nome;

    public Estrategia(List<Processo> fila, String nome) {
        this.fila = new LinkedList(fila);

        this.nome = nome;

    }

    protected void display() {
        for (Processo p : this.fila) {
            System.out.println(p.id + " | " + p.tempo);
        }
    }

    public void run() {
        System.out.println("[" + this.nome + " START]\n");

        while (!fila.isEmpty()) {
            Processo processo = fila.removeFirst();

            System.out.printf("PROCESSO %02d | %02ds \n", processo.id, processo.tempo);

            try {
                Thread.sleep(processo.tempo * 1000); // Simulando tempo de execução
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n[" + this.nome + " END]");
    }
}
