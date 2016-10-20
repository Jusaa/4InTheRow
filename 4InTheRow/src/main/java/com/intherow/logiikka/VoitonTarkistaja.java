package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;

public class VoitonTarkistaja {

    private int tarkistusnro;
    private Piirtaja piirtaja;

    /**
     * Konstruktori voitontarkastajalle.
     *
     * @param piirtaja piirtaja jossa pelikenttä tallessa
     */
    public VoitonTarkistaja(Piirtaja piirtaja) {
        this.piirtaja = piirtaja;
    }

    /**
     * Metodi tarkastaa onko pelaaja voittanut.
     *
     * @param nro pelaajan id numero kumpi laittoi viime merkin
     * @return tarkistusnumero, joka kertoo tarkastuksen tuloksen
     */
    public int tarkasta(int nro) {
        String voitto = "";
        tarkistusnro = 0;
        //Pystyrivien tarkistus
        pystyTarkistus(nro);

        //Vaakarivien tarkistus
        vaakaTarkistus(nro);

        //Vinorivien tarkistus OIKEALLE YLÖS
        vinoTarkistusOY(nro, 4, 2);
        vinoTarkistusOY(nro, 5, 1);
        vinoTarkistusOY(nro, 6, 0);
        vinoTarkistusOY(nro, 6, -1);
        vinoTarkistusOY(nro, 5, -2);
        vinoTarkistusOY(nro, 4, -3);

        //Vinorivien tarkistus OIKEALLE ALAS       
        vinoTarkistusOA(nro, 4, 3, 0);
        vinoTarkistusOA(nro, 5, 4, 0);
        vinoTarkistusOA(nro, 6, 5, 0);
        vinoTarkistusOA(nro, 6, 5, 1);
        vinoTarkistusOA(nro, 5, 5, 2);
        vinoTarkistusOA(nro, 4, 5, 3);

        return tarkistusnro;
    }

    /**
     * Metodi asettaa tarkistusnumeron pelaajan id'ksi jos tämä on voittanut.
     *
     * @param nro pelaajan id numero
     * @param voitto tarkastus String joka kertoo voittiko pelaaja
     */
    public void dingDingDing(int nro, String voitto) {
        if (voitto.equals("" + nro + nro + nro + nro)) {
            tarkistusnro = nro;
        }
    }

    /**
     * Metodi tarkastaa vinorivit Oikealta Ylös.
     *
     * @param nro pelaajan id numero
     * @param maara kuinka monta kohtaa vinorivissä
     * @param getOffset säätää aloituspaikkaa
     */
    public void vinoTarkistusOY(int nro, int maara, int getOffset) {
        String voitto = "";
        for (int i = 0; i < maara; i++) {
            if (getOffset < 0) {
                if (piirtaja.getTietokanta().getLista().get(i - getOffset).get(i) == nro) {
                    voitto = voitto + nro;
                } else {
                    voitto = "";
                }
            } else {
                if (piirtaja.getTietokanta().getLista().get(i).get(i + getOffset) == nro) {
                    voitto = voitto + nro;
                } else {
                    voitto = "";
                }
            }
            dingDingDing(nro, voitto);
        }
    }

    /**
     * Metodi tarkastaa vinorivit Oikealta Alas.
     *
     * @param nro pelaajan id numero
     * @param maara kuinka monta kohtaa vinorivissä
     * @param laskeva aloituspaikan määritys
     * @param nouseva aloituspaikan määritys
     */
    public void vinoTarkistusOA(int nro, int maara, int laskeva, int nouseva) {
        String voitto = "";
        int ii = laskeva;
        for (int i = nouseva; i < maara + nouseva; i++) {
            if (piirtaja.getTietokanta().getLista().get(i).get(ii) == nro) {
                voitto = voitto + nro;
            } else {
                voitto = "";
            }
            ii--;
            dingDingDing(nro, voitto);
        }
    }

    /**
     * Metodi tarkastaa voiton vaakariveiltä.
     *
     * @param nro pelaajan id numero
     */
    public void vaakaTarkistus(int nro) {
        String voitto;
        for (int i = 0; i < 6; i++) {
            voitto = "";
            for (int ii = 0; ii < 7; ii++) {
                if (piirtaja.getTietokanta().getLista().get(ii).get(i) == nro) {
                    voitto = voitto + nro;
                } else {
                    voitto = "";
                }
                dingDingDing(nro, voitto);
            }
        }
    }

    /**
     * Metodi tarkastaa voiton pystyriveiltä.
     *
     * @param nro pelaajan id numero
     */
    public void pystyTarkistus(int nro) {
        String voitto;
        for (int i = 6; i >= 0; i--) {
            voitto = "";
            for (int ii = 0; ii < 6; ii++) {
                if (piirtaja.getTietokanta().getLista().get(i).get(ii) == nro) {
                    voitto = voitto + nro;
                } else {
                    voitto = "";
                }
                dingDingDing(nro, voitto);
            }
        }
    }
}
