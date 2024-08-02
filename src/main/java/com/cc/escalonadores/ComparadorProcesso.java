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
    @Override
    public int compare(Processo a, Processo b) {
        return a.tempo - b.tempo;
    }
}
