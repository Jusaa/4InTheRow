package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.io.IOException;
import java.util.ArrayList;

public class Peli {

    private Pelaaja pelaajayksi;
    private Pelaaja pelaajakaksi;
    private Piirtaja piirtaja;
    private int pelaajanvuoro;
    private int tarkistusnro;
    private VoitonTarkistaja voitonTarkistaja;

    /**
     * Konstruktori pelille.
     */
    public Peli() {
        tarkistusnro = 0;
        piirtaja = new Piirtaja(this);
        voitonTarkistaja = new VoitonTarkistaja();
        pelaajanvuoro = 1;

    }

    /**
     * Aloittaa ensimmäisen pelin pelaajan inputin mukaan.
     */
    public void aloita() {
        voitonTarkistaja = new VoitonTarkistaja();
        piirtaja.aloitusMenunPiirto();
    }

    /**
     * Aloittaa uuden pelin pelaajan inputin mukaan.
     */
    public void aloitaUudestaan() {
        voitonTarkistaja = new VoitonTarkistaja();
        piirtaja.valiMenunPiirto();
    }

    /**
     * Aloittaa uuden kaksinpelin.
     */
    public void aloitaKaksinPeli() {
        setPelaajat(new IhmisPelaaja(piirtaja, 1), new IhmisPelaaja(piirtaja, 2));
        run();
    }

    /**
     * Aloittaa uuden yksinpelin.
     */
    public void aloitaYksinPeli() {
        setPelaajat(new IhmisPelaaja(piirtaja, 1), new TietokonePelaaja(piirtaja, 2));
        run();
    }

    /**
     * Pistää pelin pyörimään.
     */
    public void run() {

        tarkistusnro = 0;
        try {
            piirtaja.getTietokanta().uusiLista();
            piirtaja.uusiPeli();
        } catch (IOException ex) {

        }
    }

    /**
     * Aloittaa vuoron suorittamisen.
     * @param pylvas 
     */
    public void vuoro(int pylvas) {
        if (pelaajakaksi.getClass().equals(pelaajayksi.getClass())) {
            kaksinPeliVuoro(pylvas);
        } else {
            yksinPeliVuoro(pylvas);
        }
        piirtaja.getAlusta().revalidate();
        if (tarkistusnro != 0) {
            piirtaja.tuloksenPiirto(tarkistusnro);
        }
    }

    /**
     * Suorittaa vuoron kaksinpelissä.
     * @param pylvas 
     */
    public void kaksinPeliVuoro(int pylvas) {
        if (getPelaajanVuoro() == 1) {
            if (piirtaja.vuoronPiirto(pylvas, 1)) {
                setPelaajanVuoro();
                tarkistusnro = voitonTarkistaja.tarkasta(1, piirtaja);
                if (tarkistusnro == 1) {
                    pelaajayksi.voitti();
                }
            }

        } else if (getPelaajanVuoro() == 2) {
            if (piirtaja.vuoronPiirto(pylvas, 2)) {
                setPelaajanVuoro();
                tarkistusnro = voitonTarkistaja.tarkasta(2, piirtaja);
                if (tarkistusnro == 2) {
                    pelaajakaksi.voitti();
                }
            }
        }

    }

    /**
     * Suorittaa vuoron yksinpelissä.
     * @param pylvas 
     */
    public void yksinPeliVuoro(int pylvas) {
        piirtaja.vuoronPiirto(pylvas, 1);
        tarkistusnro = voitonTarkistaja.tarkasta(1, piirtaja);
        if (tarkistusnro == 1) {
            pelaajayksi.voitti();
        } else {
            pelaajakaksi.laitaMerkki(piirtaja, 1);
            tarkistusnro = voitonTarkistaja.tarkasta(2, piirtaja);
            if (tarkistusnro == 2) {
                pelaajakaksi.voitti();
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getLista() {
        return piirtaja.getTietokanta().getLista();
    }

    public int getTarkistusnro() {
        return tarkistusnro;
    }

    public Pelaaja getPelaajaYksi() {
        return pelaajayksi;
    }

    public Pelaaja getPelaajaKaksi() {
        return pelaajakaksi;
    }

    public Piirtaja getPiirtaja() {
        return piirtaja;
    }

    public int getPelaajanVuoro() {
        return pelaajanvuoro;
    }

    /**
     * Kutsuttaessa muuttaa pelissä pelaajan vuoron toiselle.
     */
    public void setPelaajanVuoro() {
        if (pelaajanvuoro == 2) {
            pelaajanvuoro = 1;
        } else {
            pelaajanvuoro = 2;
        }
    }

    /**
     * Määrittelee pelin pelaajat.
     * @param pelaajayksi määrittää pelaajan yksi
     * @param pelaajakaksi määrittää pelaajan kaksi
     */
    public void setPelaajat(Pelaaja pelaajayksi, Pelaaja pelaajakaksi) {
        this.pelaajayksi = pelaajayksi;
        this.pelaajakaksi = pelaajakaksi;
    }

    public VoitonTarkistaja getVoitonTarkistaja() {
        return voitonTarkistaja;
    }
}
