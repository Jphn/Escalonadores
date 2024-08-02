/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores.estrategias;

import com.cc.escalonadores.Processo;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author jphn
 */
public class FIFO extends Estrategia{

    public FIFO(List<Processo> fila) {
        super(fila, "FIFO");
    }
}
