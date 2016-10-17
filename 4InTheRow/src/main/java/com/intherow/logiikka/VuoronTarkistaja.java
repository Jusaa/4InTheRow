/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;

/**
 *
 * @author Jusaa
 */
public class VuoronTarkistaja {
    
    private Piirtaja piirtaja;
    private int pylvas;
    private int priority;
    
    /**
     * Konstruktori voitontarkastajalle.
     * 
     * @param piirtaja piirtaja jossa pelikenttä tallessa
     */
    public VuoronTarkistaja(Piirtaja piirtaja) {
        this.piirtaja = piirtaja;
        pylvas = -1;
        priority = -1;
    }

    /**
     * Metodi tarkastaa onko pelaaja voittanut.
     *
     * @param nro pelaajan id numero kumpi laittoi viime merkin
     */
    public void tarkasta(int nro) {
        String voitto = "";
        //Pystyrivien tarkistus
        pystyTarkistus(nro);

        //Vaakarivien tarkistus
        vaakaTarkistus(nro);

        //Vinorivien tarkistus OIKEALLE YLÖS
//        vinoTarkistusOY(nro, 4, 2);
//        vinoTarkistusOY(nro, 5, 1);
//        vinoTarkistusOY(nro, 6, 0);
//        vinoTarkistusOY(nro, 6, -1);
//        vinoTarkistusOY(nro, 5, -2);
//        vinoTarkistusOY(nro, 4, -3);

        //Vinorivien tarkistus OIKEALLE ALAS       
//        vinoTarkistusOA(nro, 4, 3, 0);
//        vinoTarkistusOA(nro, 5, 4, 0);
//        vinoTarkistusOA(nro, 6, 5, 0);
//        vinoTarkistusOA(nro, 6, 5, 1);
//        vinoTarkistusOA(nro, 5, 5, 2);
//        vinoTarkistusOA(nro, 4, 5, 3);
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
                    if (piirtaja.getTietokanta().getLista().get(ii).get(i) == 2) {
                        voitto = voitto + 2;
                    }
                    if (voitto.equals("1112") && priority < 4 || voitto.equals("2111") && priority < 4) {
                        pylvas = -1;
                    }else if (voitto.equals("112") && priority < 3 || voitto.equals("211") && priority < 3) {
                        pylvas = -1;
                    }
                    voitto = "";
                }
                if (voitto.equals("111") && priority < 3) {
                    if(ii == 6){
                        pylvas = ii - 2;
                    }else{
                        pylvas = ii + 2;
                    }                    
                } else if (voitto.equals("11") && priority < 2) {
                    if(ii == 6){
                        pylvas = ii - 1;
                    }else{
                        pylvas = ii + 2;
                    }  
                }
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
                    if (piirtaja.getTietokanta().getLista().get(i).get(ii) == 2) {
                        voitto = voitto + 2;
                    }
                    if (voitto.equals("1112") && pylvas == i + 1 && priority < 4) {
                        resetArvot();
                    }else if(voitto.equals("112") && pylvas == i + 1 && priority < 3){
                        resetArvot();
                    }
                    voitto = "";
                }
                if (voitto.equals("111")) {
                    priority = 3;
                    pylvas = i + 1;
                } else if (pylvas == -1 && voitto.equals("11") && priority < 3) {
                    priority = 2;
                    pylvas = i + 1;
                }
            }
        }
    }

    public int getPylvas() {
        return pylvas;
    }

    /**
     * Palauttaa pylvään arvoksi -1.
     */
    public void resetArvot() {
        pylvas = -1;
        priority = -1;
    }

}

