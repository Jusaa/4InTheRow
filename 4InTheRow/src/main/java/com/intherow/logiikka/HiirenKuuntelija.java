package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jusaa
 */
public class HiirenKuuntelija implements MouseListener {

    private int pylvas;
    private VoitonTarkistaja voitonTarkistaja;
    private int tarkistusnro;
    private Peli peli;
    private Piirtaja piirtaja;
    private Pelaaja playerone;
    private Pelaaja playertwo;

    public HiirenKuuntelija(int pylvas, Peli peli) {
        this.pylvas = pylvas;
        piirtaja = peli.getPiirtaja();
        voitonTarkistaja = peli.getVoitonTarkistaja();
        tarkistusnro = 0;
        playerone = peli.getPlayerOne();
        playertwo = peli.getPlayerTwo();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (pylvas < 10) {
            if (playertwo.getClass().equals(playerone.getClass())) {
                if (playerone.omaVuoro()) {
                    playertwo.omaVuoro();
                    piirtaja.vuoronPiirto(pylvas, 1);
                    tarkistusnro = voitonTarkistaja.tarkasta(1, piirtaja);
                    if (tarkistusnro == 1) {
                        playerone.voitti();
                    }
                } else if (playertwo.omaVuoro()) {
                    piirtaja.vuoronPiirto(pylvas, 2);
                    tarkistusnro = voitonTarkistaja.tarkasta(2, piirtaja);
                    if (tarkistusnro == 2) {
                        playertwo.voitti();
                    }
                }
            } else {
                piirtaja.vuoronPiirto(pylvas, 1);
                tarkistusnro = voitonTarkistaja.tarkasta(1, piirtaja);
                if (tarkistusnro == 1) {
                    playerone.voitti();
                } else {
                    playertwo.laitaMerkki(piirtaja);
                    tarkistusnro = voitonTarkistaja.tarkasta(2, piirtaja);
                    if (tarkistusnro == 2) {
                        playertwo.voitti();
                    }
                }

            }

            if (tarkistusnro != 0) {
                piirtaja.menuPiirto(playerone.getScanner());
            }
        } else {
            if (pylvas == 11) {
                peli.aloita();

            }
        }

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
