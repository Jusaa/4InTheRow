/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import com.intherow.logiikka.UserPelaaja;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jusaa
 */
public class Peli {

    private Scanner lukija;
    private UserPelaaja playerone;
    private UserPelaaja playertwo;
    private CPUPelaaja cpuplayer;
    private Piirtaja piirtaja;
    private int tarkistusnro;
    private VoitonTarkistaja voitonTarkistaja;

    public Peli() {
        lukija = new Scanner(System.in);
        tarkistusnro = 0;
        piirtaja = new Piirtaja();
        playerone = new UserPelaaja("playerone", "X", piirtaja, lukija, 1);
        playertwo = new UserPelaaja("playertwo", "O", piirtaja, lukija, 2);
        cpuplayer = new CPUPelaaja("playertwo", "O", piirtaja, 2);
        playerone.asetaVastustajanMerkki("O");
        playertwo.asetaVastustajanMerkki("X");
        voitonTarkistaja = new VoitonTarkistaja();

    }

    public void aloita(){
        int valinta = piirtaja.menuPiirto(lukija);
        if(valinta == 1){
            aloitaYksinPeli();
        }else if(valinta == 2){
            aloitaKaksinPeli();
        }else if(valinta == 3){
            tarkistusnro = 3;
        }else if(valinta == 4){
            tarkistusnro = 4;
        }
    }
    public void aloitaKaksinPeli() {

        // KONSTRUKTORISSA TOISTUVAT MÄÄRITTELYT VAIN TESTEJÄ VARTEN
        System.out.print("Pelaaja 1, kerro nimesi: ");
        String playeronenimi = lukija.nextLine();
        System.out.print("Entä mitä merkkiä haluat käyttää pelissä? ");
        String playeronemerkki = lukija.nextLine();
        playeronemerkki = "" + playeronemerkki.charAt(0);
        System.out.print("Pelaaja 2, kerro nimesi: ");
        String playertwonimi = lukija.nextLine();
        System.out.print("Entä mitä merkkiä haluat käyttää pelissä? ");
        String playertwomerkki = lukija.nextLine();
        playertwomerkki = "" + playertwomerkki.charAt(0);

        playerone = new UserPelaaja(playeronenimi, playeronemerkki, piirtaja, lukija, 1);
        playertwo = new UserPelaaja(playertwonimi, playertwomerkki, piirtaja, lukija, 2);
        playerone.asetaVastustajanMerkki(playertwomerkki);
        playertwo.asetaVastustajanMerkki(playeronemerkki);
        runTwoPlayer();
    }
    
    public void aloitaYksinPeli(){
        System.out.print("Kerro nimesi: ");
        String playeronenimi = lukija.nextLine();
        System.out.print("Entä mitä merkkiä haluat käyttää pelissä? ");
        String playeronemerkki = lukija.nextLine();
        playeronemerkki = "" + playeronemerkki.charAt(0);
        if(playeronemerkki.equals("O")){
            System.out.print("O on tietokoneen merkki, valitse toinen ellet halua samaa merkkiä ;)  ");
            playeronemerkki = lukija.nextLine();
            playeronemerkki = "" + playeronemerkki.charAt(0);
        }
        
        playerone = new UserPelaaja(playeronenimi, playeronemerkki, piirtaja, lukija, 1);
        cpuplayer.asetaVastustajanMerkki(playeronemerkki);
        playerone.asetaVastustajanMerkki("O");
        runOnePlayer();
    }

    public void runTwoPlayer() {

        tarkistusnro = 0;
        piirtaja.uusiPeli();
        while (true) {
            playerone.laitaMerkki();
            tarkistusnro = voitonTarkistaja.tarkasta(1, piirtaja);
            if (tarkistusnro != 0) {
                break;
            }
            playertwo.laitaMerkki();
            tarkistusnro = voitonTarkistaja.tarkasta(2, piirtaja);
            if (tarkistusnro != 0) {
                break;
            }
        }
        tarkistusnro = 0;
        aloita();
        if(tarkistusnro == 3){
            runTwoPlayer();
        }
    }
    
    public void runOnePlayer() {

        tarkistusnro = 0;
        piirtaja.uusiPeli();
        while (true) {
            playerone.laitaMerkki();
            tarkistusnro = voitonTarkistaja.tarkasta(1, piirtaja);
            if (tarkistusnro != 0) {
                break;
            }
            cpuplayer.laitaMerkki();
            tarkistusnro = voitonTarkistaja.tarkasta(2, piirtaja);
            if (tarkistusnro != 0) {
                break;
            }
        }
        aloita();
        if(tarkistusnro == 3){
            runOnePlayer();
        }
    }

//    public void voitonTarkistaja(int nro) {
//        String voitto = "";
//
//        //Pystyrivien tarkistus
//        pystyTarkistus(nro, voitto);
//
//        //Vaakarivien tarkistus
//        vaakaTarkistus(nro, voitto);
//
//        //Vinorivien tarkistus OIKEALLE YLÖS
//        vinoTarkistusOY(nro, voitto, 4, 2);
//        vinoTarkistusOY(nro, voitto, 5, 1);
//        vinoTarkistusOY(nro, voitto, 6, 0);
//        vinoTarkistusOY(nro, voitto, 6, -1);
//        vinoTarkistusOY(nro, voitto, 5, -2);
//        vinoTarkistusOY(nro, voitto, 4, -3);
//
//        //Vinorivien tarkistus OIKEALLE ALAS       
//        vinoTarkistusOA(nro, voitto, 4, 3, 0);
//        vinoTarkistusOA(nro, voitto, 5, 4, 0);
//        vinoTarkistusOA(nro, voitto, 6, 5, 0);
//        vinoTarkistusOA(nro, voitto, 6, 5, 1);
//        vinoTarkistusOA(nro, voitto, 5, 5, 2);
//        vinoTarkistusOA(nro, voitto, 4, 5, 3);
//
//    }
//
//    public void dingDingDing(int nro, String voitto) {
//        if (voitto.equals("1111")) {
//            System.out.println("DINGDINGDING\nPELAAAJA " + nro + " VOITTI!");
//            tarkistusnro = nro;
//        }
//    }
//
//    public void vinoTarkistusOY(int nro, String voitto, int maara, int getOffset) {
//        voitto = "";
//        for (int i = 0; i < maara; i++) {
//            if (getOffset < 0) {
//                if (piirtaja.getDatabase().getLista().get(i - getOffset).get(i) == nro) {
//                    voitto = voitto + "1";
//                } else {
//                    voitto = "";
//                }
//            } else {
//                if (piirtaja.getDatabase().getLista().get(i).get(i + getOffset) == nro) {
//                    voitto = voitto + "1";
//                } else {
//                    voitto = "";
//                }
//            }
//
//            dingDingDing(nro, voitto);
//        }
//    }
//
//    public void vinoTarkistusOA(int nro, String voitto, int maara, int laskeva, int nouseva) {
//        voitto = "";
//        int ii = laskeva;
//        for (int i = nouseva; i < maara; i++) {
//            if (piirtaja.getDatabase().getLista().get(i).get(ii) == nro) {
//                voitto = voitto + "1";
//            } else {
//                voitto = "";
//            }
//            ii--;
//            dingDingDing(nro, voitto);
//        }
//    }
//
//    public void vaakaTarkistus(int nro, String voitto) {
//        for (int i = 0; i < 6; i++) {
//            voitto = "";
//            for (int ii = 0; ii < 7; ii++) {
//                if (piirtaja.getDatabase().getLista().get(ii).get(i) == nro) {
//                    voitto = voitto + "1";
//                } else {
//                    voitto = "";
//                }
//                dingDingDing(nro, voitto);
//            }
//        }
//    }
//
//    public void pystyTarkistus(int nro, String voitto) {
//        voitto = "";
//        for (int i = 6; i >= 0; i--) {
//            voitto = "";
//            for (int ii = 0; ii < 6; ii++) {
//                if (piirtaja.getDatabase().getLista().get(i).get(ii) == nro) {
//                    voitto = voitto + "1";
//                } else {
//                    voitto = "";
//                }
//                dingDingDing(nro, voitto);
//            }
//        }
//    }

    public ArrayList<ArrayList<Integer>> getLista() {
        return piirtaja.getDatabase().getLista();
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
    
    public VoitonTarkistaja getVoitonTarkistaja(){
        return voitonTarkistaja;
    }
}
