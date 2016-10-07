package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.Random;

public class TietokonePelaaja implements Pelaaja {

    Random random;
    private int id;
    private Piirtaja piirtaja;
    private int voitot;

    /**
     * Metodi lisää pelaajan haluaman merkin peliin.
     * @param piirtaja hakee alustan mihin laittaa merkin
     * @param id kertoo onko kyseessä pelaaja 1 vai 2
     */
    public TietokonePelaaja(Piirtaja piirtaja, int id) {
        this.piirtaja = piirtaja;
        this.id = id;
        voitot = 0;
        random = new Random();
    }
    
    @Override
    public void laitaMerkki(Piirtaja piirtaja, int pylvas) {
        //Graafiseen liittymään siirtymisen jälkeen tämän parantaminen
        while (true) {
            pylvas = random.nextInt(6) + 1;
            if (piirtaja.vuoronPiirto(pylvas, id) == true) {
                break;
            }
        }
    }
    
    @Override
    public void voitti() {
        voitot++;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getVoitot() {
        return voitot;
    }

    @Override
    public Piirtaja getPiirtaja() {
        return piirtaja;
    }

    @Override
    public String toString() {
        return id + " " + voitot;
    }

}