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
public class PS extends Estrategia {

    public PS(List<Processo> fila) {
        super(fila, "PS");
    }

    public void sort() {
        Collections.sort(this.fila, new ComparadorProcesso(ComparadorProcesso.Tipo.PS));

        this.fila = this.fila.reversed();
    }

    public PS run(boolean cpu) {
        this.sort();

        super.run(cpu);

        return this;
    }
}
