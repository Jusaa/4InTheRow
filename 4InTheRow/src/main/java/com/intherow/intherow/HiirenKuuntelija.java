package com.intherow.intherow;

import com.intherow.logiikka.Peli;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiirenKuuntelija implements MouseListener {

    private int pylvas;
    private Peli peli;

    /**
     * Konstruktori hiirenkuuntelijalle.
     *
     * @param pylvas kertoo mihin pylvaaseen tai numeroon kuuntelija liittyy
     * @param peli kertoo pelin tiedot kuuntelijalle
     */
    public HiirenKuuntelija(int pylvas, Peli peli) {
        this.pylvas = pylvas;
        this.peli = peli;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (pylvas < 8) {
            peli.vuoro(pylvas);
        } else {
            if (pylvas == 11) {
                peli.aloitaYksinPeli();
            } else if (pylvas == 12) {
                peli.aloitaKaksinPeli();
            } else if (pylvas == 13) {
                peli.run();
            } else if (pylvas == 20) {
                peli.aloitaUudestaan();
            }
        }
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
