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

    public VoitonTarkistaja() {
        tarkistusnro = 0;
    }

    public int tarkasta(int nro, Piirtaja piirtaja) {
        String voitto = "";

        //Pystyrivien tarkistus
        pystyTarkistus(nro, voitto, piirtaja);

        //Vaakarivien tarkistus
        vaakaTarkistus(nro, voitto, piirtaja);

        //Vinorivien tarkistus OIKEALLE YLÖS
        vinoTarkistusOY(nro, voitto, 4, 2, piirtaja);
        vinoTarkistusOY(nro, voitto, 5, 1, piirtaja);
        vinoTarkistusOY(nro, voitto, 6, 0, piirtaja);
        vinoTarkistusOY(nro, voitto, 6, -1, piirtaja);
        vinoTarkistusOY(nro, voitto, 5, -2, piirtaja);
        vinoTarkistusOY(nro, voitto, 4, -3, piirtaja);

        //Vinorivien tarkistus OIKEALLE ALAS       
        vinoTarkistusOA(nro, voitto, 4, 3, 0, piirtaja);
        vinoTarkistusOA(nro, voitto, 5, 4, 0, piirtaja);
        vinoTarkistusOA(nro, voitto, 6, 5, 0, piirtaja);
        vinoTarkistusOA(nro, voitto, 6, 5, 1, piirtaja);
        vinoTarkistusOA(nro, voitto, 5, 5, 2, piirtaja);
        vinoTarkistusOA(nro, voitto, 4, 5, 3, piirtaja);
        return tarkistusnro;
    }

    public void dingDingDing(int nro, String voitto, Piirtaja piirtaja) {
        if (voitto.equals("1111")) {
            System.out.println("DINGDINGDING\nPELAAAJA " + nro + " VOITTI!");
            tarkistusnro = nro;
        }
    }

    public void vinoTarkistusOY(int nro, String voitto, int maara, int getOffset, Piirtaja piirtaja) {
        voitto = "";
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

            dingDingDing(nro, voitto, piirtaja);
        }
    }

    public void vinoTarkistusOA(int nro, String voitto, int maara, int laskeva, int nouseva, Piirtaja piirtaja) {
        voitto = "";
        int ii = laskeva;
        for (int i = nouseva; i < maara; i++) {
            if (piirtaja.getDatabase().getLista().get(i).get(ii) == nro) {
                voitto = voitto + "1";
            } else {
                voitto = "";
            }
            ii--;
            dingDingDing(nro, voitto, piirtaja);
        }
    }

    public void vaakaTarkistus(int nro, String voitto, Piirtaja piirtaja) {
        for (int i = 0; i < 6; i++) {
            voitto = "";
            for (int ii = 0; ii < 7; ii++) {
                if (piirtaja.getDatabase().getLista().get(ii).get(i) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
                dingDingDing(nro, voitto, piirtaja);
            }
        }
    }

    public void pystyTarkistus(int nro, String voitto, Piirtaja piirtaja) {
        voitto = "";
        for (int i = 6; i >= 0; i--) {
            voitto = "";
            for (int ii = 0; ii < 6; ii++) {
                if (piirtaja.getDatabase().getLista().get(i).get(ii) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
                dingDingDing(nro, voitto, piirtaja);
            }
        }
    }
}
