/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jusaa
 */
public class VuoronTarkistaja {

    private Piirtaja piirtaja;
    private Map<Integer, Integer> pylvaat;

    /**
     * Konstruktori voitontarkastajalle.
     *
     * @param piirtaja piirtaja jossa pelikenttä tallessa
     */
    public VuoronTarkistaja(Piirtaja piirtaja) {
        this.piirtaja = piirtaja;
        pylvaat = new HashMap<>();
        for (int i = 1; i < 8; i++) {
            pylvaat.put(i, 0);
        }
    }

    /**
     * Metodi tarkastaa onko pelaaja voittanut.
     *
     * @param nro pelaajan id numero kumpi laittoi viime merkin
     */
    public void tarkasta(int nro) {
        String voitto = "";

        //Vaakarivien tarkistus
        vaakaTarkistus(nro);

        //Pystyrivien tarkistus
        pystyTarkistus(nro);

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

    //VinoTarkistukset liian edistyneitä, että enään kerkeää niitä tekemään, 
    //Jätetään hautumaan tulevaisuutta varten
//    /**
//     * Metodi tarkastaa vinorivit Oikealta Ylös.
//     *
//     * @param nro pelaajan id numero
//     * @param maara kuinka monta kohtaa vinorivissä
//     * @param getOffset säätää aloituspaikkaa
//     */
//    public void vinoTarkistusOY(int nro, int maara, int getOffset) {
//        String voitto = "";
//        for (int i = 0; i < maara; i++) {
//            if (getOffset < 0) {
//                if (piirtaja.getTietokanta().getLista().get(i - getOffset).get(i) == nro) {
//                    voitto = voitto + nro;
//                } else {
//                    voitto = "";
//                }
//            } else {
//                if (piirtaja.getTietokanta().getLista().get(i).get(i + getOffset) == nro) {
//                    voitto = voitto + nro;
//                } else {
//                    voitto = "";
//                }
//            }
//        }
//    }
//
//    /**
//     * Metodi tarkastaa vinorivit Oikealta Alas.
//     *
//     * @param nro pelaajan id numero
//     * @param maara kuinka monta kohtaa vinorivissä
//     * @param laskeva aloituspaikan määritys
//     * @param nouseva aloituspaikan määritys
//     */
//    public void vinoTarkistusOA(int nro, int maara, int laskeva, int nouseva) {
//        String voitto = "";
//        int ii = laskeva;
//        for (int i = nouseva; i < maara + nouseva; i++) {
//            if (piirtaja.getTietokanta().getLista().get(i).get(ii) == nro) {
//                voitto = voitto + nro;
//            } else {
//                voitto = "";
//            }
//            ii--;
//        }
//    }
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
                    voitto = voitto + piirtaja.getTietokanta().getLista().get(ii).get(i);
                    if (voitto.equals("1112")) {
                        pylvaat.put(ii + 1, 0);
                        pylvaat.put(ii, 0);
                        if (ii != 3) {
                            pylvaat.put(ii - 3, 4);
                        }
                        voitto = "";
                    } else if (voitto.equals("112")) {
                        pylvaat.put(ii + 1, 0);
                        if (ii != 2) {
                            pylvaat.put(ii - 2, 2);
                        }
                        voitto = "";
                    } else if (voitto.equals("110")) {
                        voitto = "";
                    } else if (voitto.equals("1110")) {
                        voitto = "";
                    } else if (voitto.equals("21110") || voitto.equals("221110")) {
                        if (ii == 6) {
                            pylvaat.put(ii + 1, 4);
                        }
                        voitto = "";
                    } else if (voitto.equals("2110") || voitto.equals("22110") || voitto.equals("222110")) {
                        if (ii != 6) {
                            pylvaat.put(ii + 1, 4);
                        }
                        voitto = "";
                    } else if (voitto.equals("2112")) {
                        pylvaat.put(ii + 1, 0);
                        if (ii != 3) {
                            pylvaat.put(ii - 3, 0);
                        }
                        voitto = "";
                    } else if (voitto.equals("21112")) {
                        pylvaat.put(ii + 1, 0);
                        if (ii != 4) {
                            pylvaat.put(ii - 4, 0);
                        }
                        voitto = "";
                    } else if (voitto.equals("20") || voitto.equals("0")) {
                        voitto = "";
                    }

                }
                if (voitto.equals("2111") || voitto.equals("22111")) {
                    pylvaat.put(ii - 2, 0);
                } else if (voitto.equals("211") || voitto.equals("2211") || voitto.equals("22211")) {
                    pylvaat.put(ii - 1, 0);
                } else if (voitto.equals("111")) {
                    if (ii == 6) {
                        pylvaat.put(ii - 2, 4);
                    } else {
                        pylvaat.put(ii + 2, 4);
                    }
                } else if (voitto.equals("11")) {
                    if (ii == 6) {
                        pylvaat.put(ii - 5, 2);
                    } else {
                        pylvaat.put(ii + 2, 3);
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
                    if (voitto.equals("1112")) {
                        pylvaat.put(i + 1, 0);
                    } else if (voitto.equals("112")) {
                        pylvaat.put(i + 1, 0);
                    }
                    voitto = "";
                }
                if (voitto.equals("111")) {
                    pylvaat.put(i + 1, 5);
                } else if (voitto.equals("11")) {
                    pylvaat.put(i + 1, 2);
                }
            }
        }
    }

    public Map<Integer, Integer> getPylvaat() {
        return pylvaat;
    }

    /**
     * Palauttaa pylväiden arvoksi 0.
     */
    public void resetArvot() {
        for (int i = 1; i < 8; i++) {
            pylvaat.put(i, 0);
        }
    }

}
