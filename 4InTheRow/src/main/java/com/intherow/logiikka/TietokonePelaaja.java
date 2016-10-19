package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.Random;

public class TietokonePelaaja implements Pelaaja {

    Random random;
    private int id;
    private Piirtaja piirtaja;
    private int voitot;
    private VuoronTarkistaja vuoronTarkistaja;

    /**
     * Metodi lisää pelaajan haluaman merkin peliin.
     *
     * @param piirtaja hakee alustan mihin laittaa merkin
     * @param id kertoo onko kyseessä pelaaja 1 vai 2
     */
    public TietokonePelaaja(Piirtaja piirtaja, int id) {
        this.piirtaja = piirtaja;
        vuoronTarkistaja = new VuoronTarkistaja(piirtaja);
        this.id = id;
        voitot = 0;
        random = new Random();
    }

    @Override
    public void laitaMerkki(Piirtaja piirtaja, int pylvas) {
        vuoronTarkistaja.tarkasta(1);
        while (true) {
            int suurinArvo = -1;
            int valittuPylvas = 0;
            System.out.println(vuoronTarkistaja.getPylvaat());
            for (Integer i : vuoronTarkistaja.getPylvaat().values()) {
                pylvas++;
                if (i > suurinArvo) {
                    suurinArvo = i;
                    valittuPylvas = pylvas;
                } else if (i == suurinArvo) {
                    if (random.nextBoolean()) {
                        valittuPylvas = pylvas;
                    }
                }
            }
            if (suurinArvo == 0) {
                valittuPylvas = random.nextInt(6) + 1;
            }
            if (piirtaja.getTietokanta().getLista().get(valittuPylvas - 1).get(5) != 0) {
                valittuPylvas = random.nextInt(6) + 1;
            }
            System.out.println(vuoronTarkistaja.getPylvaat());
            if (piirtaja.vuoronPiirto(valittuPylvas, id) == true) {
                break;
            }

            vuoronTarkistaja.resetArvot();
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
