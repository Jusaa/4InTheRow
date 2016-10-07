package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.Scanner;

public interface Pelaaja {

    /**
     * Metodi lisää pelaajan haluaman merkin peliin.
     * @param piirtaja hakee alustan mihin laittaa merkin
     * @param pylvas kertoo mihin pylvaaseen merkki laitetaan
     */
    public void laitaMerkki(Piirtaja piirtaja, int pylvas);

    /**
     * Lisää pelaajan voittojen määrää.
     */
    public void voitti();

    public int getVoitot();
    
    public int getId();

    public Piirtaja getPiirtaja();
}
