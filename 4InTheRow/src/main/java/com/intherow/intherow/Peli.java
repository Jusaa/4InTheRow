/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.intherow;

import java.util.Scanner;

/**
 *
 * @author Jusaa
 */
public class Peli {

    private Scanner lukija;
    private Pelaaja playerone;
    private Pelaaja playertwo;
    private Piirtaja piirtaja;
    private int tarkistusnro;

    public Peli() {
        lukija = new Scanner(System.in);
    }

    public void Aloita() {
        System.out.print("Pelaaja 1, mitä merkkiä haluat käyttää pelissä? ");
        String playeronemerkki = lukija.nextLine();
        playeronemerkki = "" + playeronemerkki.charAt(0);
        System.out.print("Pelaaja 2, mitä merkkiä haluat käyttää pelissä? ");
        String playertwomerkki = lukija.nextLine();
        playertwomerkki = "" + playertwomerkki.charAt(0);

        piirtaja = new Piirtaja();
        playerone = new Pelaaja("playerone", playeronemerkki, piirtaja, lukija);
        playertwo = new Pelaaja("playertwo", playertwomerkki, piirtaja, lukija);
        playerone.AsetaVastustajanMerkki(playertwomerkki);
        playertwo.AsetaVastustajanMerkki(playeronemerkki);

        while (true) {
            playerone.LaitaMerkki();
            VoitonTarkistaja(1);
            if (tarkistusnro != 0) {
                break;
            }
            playertwo.LaitaMerkki();
            VoitonTarkistaja(2);
            if (tarkistusnro != 0) {
                break;
            }
        }
    }

    public void VoitonTarkistaja(int nro) {
        //Pystyrivien tarkistus
        String voitto = "";
        for (int i = 6; i >= 0; i--) {
            voitto = "";
            for (int ii = 0; ii < 6; ii++) {
                if (piirtaja.getLista().get(i).get(ii) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
                DingDingDing(nro, voitto);
            }
        }

        //Vaakarivien tarkistus
        for (int i = 0; i < 6; i++) {
            voitto = "";
            for (int ii = 0; ii < 7; ii++) {
                if (piirtaja.getLista().get(ii).get(i) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
                DingDingDing(nro, voitto);
            }
        }

        //Vinorivien tarkistus OIKEALLE YLÖS
        VinoTarkistusOY(nro, voitto, 4, 2);
        VinoTarkistusOY(nro, voitto, 5, 1);
        VinoTarkistusOY(nro, voitto, 6, 0);
        VinoTarkistusOY(nro, voitto, 6, -1);
        VinoTarkistusOY(nro, voitto, 5, -2);
        VinoTarkistusOY(nro, voitto, 4, -3);

        //Vinorivien tarkistus OIKEALLE ALAS       
        VinoTarkistusOA(nro, voitto, 4, 3, 0);
        VinoTarkistusOA(nro, voitto, 5, 4, 0);
        VinoTarkistusOA(nro, voitto, 6, 5, 0);
        VinoTarkistusOA(nro, voitto, 6, 5, 1);
        VinoTarkistusOA(nro, voitto, 5, 5, 2);
        VinoTarkistusOA(nro, voitto, 4, 5, 3);

    }

    public void DingDingDing(int nro, String voitto) {
        if (voitto.equals("1111")) {
            System.out.println("DINGDINGDING\nPELAAAJA " + nro + " VOITTI!");
            tarkistusnro = nro;
        }
    }

    public void VinoTarkistusOY(int nro, String voitto, int maara, int getOffset) {
        voitto = "";
        for (int i = 0; i < maara; i++) {
            if (getOffset < 0) {
                if (piirtaja.getLista().get(i - getOffset).get(i) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
            } else {
                if (piirtaja.getLista().get(i).get(i + getOffset) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
            }

            DingDingDing(nro, voitto);
        }
    }

    public void VinoTarkistusOA(int nro, String voitto, int maara, int laskeva, int nouseva) {
        voitto = "";
        int ii = laskeva;
        for (int i = nouseva; i < maara; i++) {
            if (piirtaja.getLista().get(i).get(ii) == nro) {
                voitto = voitto + "1";
            } else {
                voitto = "";
            }
            ii--;
            DingDingDing(nro, voitto);
        }
    }
}
