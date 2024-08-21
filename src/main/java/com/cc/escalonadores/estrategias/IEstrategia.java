/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cc.escalonadores.estrategias;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jphn
 */
public interface IEstrategia {

//    void displayFila();
    String getNome();

    void setModelo(DefaultTableModel modelo, DefaultTableModel modeloMedia);

    void displayHistorico();

    Estrategia run(boolean cpu);
}
