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
public class VoitonTarkistaja {

    private int tarkistusnro;
    private Piirtaja piirtaja;

    public VoitonTarkistaja() {
        tarkistusnro = 0;
    }

    public int tarkasta(int nro, Piirtaja piirtaja) {
        String voitto = "";
        this.piirtaja = piirtaja;
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

        if (tarkistusnro == 0) {
            int apunumero = 0;
            for (int i = 0; i < 7; i++) {
                if (!piirtaja.getDatabase().getLista().get(i).contains(0)) {
                    apunumero++;
                }
                if (apunumero == 7) {
                    System.out.println("TASAPELI!");
                    tarkistusnro = 3;
                }
            }
        }

        return tarkistusnro;
    }

    public void dingDingDing(int nro, String voitto) {
        if (voitto.equals("1111")) {
            tarkistusnro = nro;
        }
    }

    public void vinoTarkistusOY(int nro, int maara, int getOffset) {
        String voitto = "";
        for (int i = 0; i < maara; i++) {
            if (getOffset < 0) {
                if (piirtaja.getDatabase().getLista().get(i - getOffset).get(i) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
            } else {
                if (piirtaja.getDatabase().getLista().get(i).get(i + getOffset) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
            }

            dingDingDing(nro, voitto);
        }
    }

    public void vinoTarkistusOA(int nro, int maara, int laskeva, int nouseva) {
        String voitto = "";
        int ii = laskeva;
        for (int i = nouseva; i < maara + nouseva; i++) {
            if (piirtaja.getDatabase().getLista().get(i).get(ii) == nro) {
                voitto = voitto + "1";
            } else {
                voitto = "";
            }
            ii--;
            dingDingDing(nro, voitto);
        }
    }

    public void vaakaTarkistus(int nro) {
        String voitto;
        for (int i = 0; i < 6; i++) {
            voitto = "";
            for (int ii = 0; ii < 7; ii++) {
                if (piirtaja.getDatabase().getLista().get(ii).get(i) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
                dingDingDing(nro, voitto);
            }
        }
    }

    public void pystyTarkistus(int nro) {
        String voitto;
        for (int i = 6; i >= 0; i--) {
            voitto = "";
            for (int ii = 0; ii < 6; ii++) {
                if (piirtaja.getDatabase().getLista().get(i).get(ii) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
                dingDingDing(nro, voitto);
            }
        }
    }
}
