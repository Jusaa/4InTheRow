/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Jusaa
 */
public class HiirenKuuntelija implements MouseListener {
    private int i;
    private Piirtaja piirtaja;
    public HiirenKuuntelija(int i, Piirtaja piirtaja) {
        this.i = i;
        this.piirtaja = piirtaja;
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        piirtaja.vuoronPiirto(i, "X", "O", 1);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}


