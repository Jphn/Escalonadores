/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cc.escalonadores;

import com.cc.escalonadores.estrategias.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jphn
 */
public class Escalonadores {

    public static void main(String[] args) {
        Random random = new Random();
        List<Processo> fila = new LinkedList();

        for (int i = 1; i <= 5; i++) {
            fila.add(new Processo(i, random.nextInt(1, 5), Processo.Prioridade.random()));
        }

        new FIFO(fila)
                .run(true)
                .displayHistorico();
        new SJF(fila)
                .run(true)
                .displayHistorico();
        new PS(fila)
                .run(true)
                .displayHistorico();
        new RR(fila, 2)
                .run(true)
                .displayHistorico();
    }
}
