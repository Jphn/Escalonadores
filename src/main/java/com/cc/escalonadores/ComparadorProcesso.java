/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.escalonadores;

import java.util.Comparator;

/**
 *
 * @author jphn
 */
public class ComparadorProcesso implements Comparator<Processo> {

    public enum Tipo {
        SJF,
        PS
    }

    private Tipo tipo;

    public ComparadorProcesso(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int compare(Processo a, Processo b) {
        return this.tipo == Tipo.SJF
                ? a.tempo - b.tempo
                : a.prioridade.getValue() - b.prioridade.getValue();
    }
}
