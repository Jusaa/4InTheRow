package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Jusaa
 */
public class HiirenKuuntelija implements MouseListener {

    private int pylvas;
    private Piirtaja piirtaja;

    public HiirenKuuntelija(int i, Piirtaja piirtaja) {
        this.pylvas = i;
        this.piirtaja = piirtaja;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        piirtaja.vuoronPiirto(pylvas, "X", "O", 1);
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
