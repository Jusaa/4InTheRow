package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;

public class IhmisPelaaja implements Pelaaja {

    private int id;
    private Piirtaja piirtaja;
    private int voitot;

    /**
     * Konstruktori ihmispelaajan luomiselle.
     *
     * @param piirtaja kertoo mihin vuorot piirretään
     * @param id kertoo onko kyseessä pelaaja 1 vai 2
     */
    public IhmisPelaaja(Piirtaja piirtaja, int id) {
        this.piirtaja = piirtaja;
        this.id = id;
        voitot = 0;
    }

    @Override
    public void laitaMerkki(Piirtaja piirtaja, int pylvas) {
        piirtaja.vuoronPiirto(pylvas, id);

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
