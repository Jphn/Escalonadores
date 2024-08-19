/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores.estrategias;

import com.cc.escalonadores.ComparadorProcesso;
import com.cc.escalonadores.Processo;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jphn
 */
public class SJF extends Estrategia {

    public SJF(List<Processo> fila) {
        super(fila, "SJF");
    }

    private void sort() {
        Collections.sort(this.fila, new ComparadorProcesso(ComparadorProcesso.Tipo.SJF));
    }

    public void run() {
        this.sort();

        super.run();
    }
}
