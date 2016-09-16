/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.intherow;

import java.util.ArrayList;
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
        tarkistusnro = 0;
        piirtaja = new Piirtaja();
        playerone = new Pelaaja("playerone", "X", piirtaja, lukija);
        playertwo = new Pelaaja("playertwo", "O", piirtaja, lukija);
        playerone.asetaVastustajanMerkki("O");
        playertwo.asetaVastustajanMerkki("X");

    }

    public void aloita() {
        
        // KONSTRUKTORISSA TOISTUVAT MÄÄRITTELYT VAIN TESTEJÄ VARTEN
        
//        System.out.print("Pelaaja 1, mitä merkkiä haluat käyttää pelissä? ");
//        String playeronemerkki = lukija.nextLine();
//        playeronemerkki = "" + playeronemerkki.charAt(0);
//        System.out.print("Pelaaja 2, mitä merkkiä haluat käyttää pelissä? ");
//        String playertwomerkki = lukija.nextLine();
//        playertwomerkki = "" + playertwomerkki.charAt(0);
//
//        piirtaja = new Piirtaja();
//        playerone = new Pelaaja("playerone", playeronemerkki, piirtaja, lukija);
//        playertwo = new Pelaaja("playertwo", playertwomerkki, piirtaja, lukija);
//        playerone.asetaVastustajanMerkki(playertwomerkki);
//        playertwo.asetaVastustajanMerkki(playeronemerkki);
//        run();        
    }

    public void run(){
        
        while (true) {
            playerone.laitaMerkki();
            voitonTarkistaja(1);
            if (tarkistusnro != 0) {
                break;
            }
            playertwo.laitaMerkki();
            voitonTarkistaja(2);
            if (tarkistusnro != 0) {
                break;
            }
        }
    }
    
    public void voitonTarkistaja(int nro) {
        String voitto = "";

        //Pystyrivien tarkistus
        pystyTarkistus(nro, voitto);

        //Vaakarivien tarkistus
        vaakaTarkistus(nro, voitto);

        //Vinorivien tarkistus OIKEALLE YLÖS
        vinoTarkistusOY(nro, voitto, 4, 2);
        vinoTarkistusOY(nro, voitto, 5, 1);
        vinoTarkistusOY(nro, voitto, 6, 0);
        vinoTarkistusOY(nro, voitto, 6, -1);
        vinoTarkistusOY(nro, voitto, 5, -2);
        vinoTarkistusOY(nro, voitto, 4, -3);

        //Vinorivien tarkistus OIKEALLE ALAS       
        vinoTarkistusOA(nro, voitto, 4, 3, 0);
        vinoTarkistusOA(nro, voitto, 5, 4, 0);
        vinoTarkistusOA(nro, voitto, 6, 5, 0);
        vinoTarkistusOA(nro, voitto, 6, 5, 1);
        vinoTarkistusOA(nro, voitto, 5, 5, 2);
        vinoTarkistusOA(nro, voitto, 4, 5, 3);

    }

    public void dingDingDing(int nro, String voitto) {
        if (voitto.equals("1111")) {
            System.out.println("DINGDINGDING\nPELAAAJA " + nro + " VOITTI!");
            tarkistusnro = nro;
        }
    }

    public void vinoTarkistusOY(int nro, String voitto, int maara, int getOffset) {
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

            dingDingDing(nro, voitto);
        }
    }

    public void vinoTarkistusOA(int nro, String voitto, int maara, int laskeva, int nouseva) {
        voitto = "";
        int ii = laskeva;
        for (int i = nouseva; i < maara; i++) {
            if (piirtaja.getLista().get(i).get(ii) == nro) {
                voitto = voitto + "1";
            } else {
                voitto = "";
            }
            ii--;
            dingDingDing(nro, voitto);
        }
    }

    public void vaakaTarkistus(int nro, String voitto) {
        for (int i = 0; i < 6; i++) {
            voitto = "";
            for (int ii = 0; ii < 7; ii++) {
                if (piirtaja.getLista().get(ii).get(i) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
                dingDingDing(nro, voitto);
            }
        }
    }

    public void pystyTarkistus(int nro, String voitto) {
        voitto = "";
        for (int i = 6; i >= 0; i--) {
            voitto = "";
            for (int ii = 0; ii < 6; ii++) {
                if (piirtaja.getLista().get(i).get(ii) == nro) {
                    voitto = voitto + "1";
                } else {
                    voitto = "";
                }
                dingDingDing(nro, voitto);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getLista() {
        return piirtaja.getLista();
    }

    public int getTarkistusnro() {
        return tarkistusnro;
    }

    public String getPlayerOneString() {
        return playerone.toString();
    }

    public String getPlayerTwoString() {
        return playertwo.toString();
    }

    public Piirtaja getPiirtaja() {
        return piirtaja;
    }
}
