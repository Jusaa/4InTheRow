/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private VoitonTarkistaja voitonTarkistaja;

    //Konstruktori kaksinpelin testaamiselle
    public Peli() {
        lukija = new Scanner(System.in);
        tarkistusnro = 0;
        piirtaja = new Piirtaja();
        playerone = new UserPelaaja("playerone", "X", piirtaja, lukija, 1);
        playertwo = new UserPelaaja("playertwo", "O", piirtaja, lukija, 2);
        playerone.asetaVastustajanMerkki("O");
        playertwo.asetaVastustajanMerkki("X");
        voitonTarkistaja = new VoitonTarkistaja();
    }
    
    //Konstruktori yksinpelin testaamiselle
    public Peli(String o) {
        lukija = new Scanner(System.in);
        tarkistusnro = 0;
        piirtaja = new Piirtaja();
        playerone = new UserPelaaja("playerone", "X", piirtaja, lukija, 1);
        playertwo = new CPUPelaaja("playertwo", "O", piirtaja, 2);
        playerone.asetaVastustajanMerkki("O");
        playertwo.asetaVastustajanMerkki("X");
        voitonTarkistaja = new VoitonTarkistaja();
    }

    public void aloita() {
        voitonTarkistaja = new VoitonTarkistaja();
        int valinta = piirtaja.menuPiirto(lukija);
        if (valinta == 1) {
            aloitaYksinPeli();
        } else if (valinta == 2) {
            aloitaKaksinPeli();
        } else if (valinta == 3) {
            run();
        } else if (valinta == 4) {
        }
    }

    public void aloitaKaksinPeli() {

        // KONSTRUKTORISSA TOISTUVAT MÄÄRITTELYT VAIN TESTEJÃ„ VARTEN
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
        run();
    }

    public void aloitaYksinPeli() {
        System.out.print("Kerro nimesi: ");
        String playeronenimi = lukija.nextLine();
        System.out.print("Entä mitä merkkiä haluat käyttää pelissä? ");
        String playeronemerkki = lukija.nextLine();
        playeronemerkki = "" + playeronemerkki.charAt(0);
        if (playeronemerkki.equals("O")) {
            System.out.print("O on tietokoneen merkki, valitse toinen ellet halua samaa merkkiä ;)  ");
            playeronemerkki = lukija.nextLine();
            playeronemerkki = "" + playeronemerkki.charAt(0);
        }

        playertwo = new CPUPelaaja("playertwo", "O", piirtaja, 2);
        playerone = new UserPelaaja(playeronenimi, playeronemerkki, piirtaja, lukija, 1);
        playertwo.asetaVastustajanMerkki(playeronemerkki);
        playerone.asetaVastustajanMerkki("O");
        run();
    }

    public void run() {
        
        tarkistusnro = 0;
        try {
            piirtaja.uusiPeli();
        } catch (IOException ex) {
            
        }
        while (true) {
            playerone.laitaMerkki();
            tarkistusnro = voitonTarkistaja.tarkasta(1, piirtaja);
            if (tarkistusnro != 0) {
                playerone.voitti();
                break;
            }
            playertwo.laitaMerkki();
            tarkistusnro = voitonTarkistaja.tarkasta(2, piirtaja);
            if (tarkistusnro != 0) {
                playertwo.voitti();
                break;
            }
        }
        if(playertwo.getClass().equals(playerone.getClass())){
            System.out.println("DINGDINGDING\nPELAAAJA " + tarkistusnro + " VOITTI!");
            System.out.println("Pelaaja 1 voitot: " + playerone.getVoitot() + "\nPelaaja 2 voitot: " + playertwo.getVoitot());
        }else{
            if(tarkistusnro == 1){
                System.out.println("DINGDINGDING\nVOITIT PELIN");
            }else{
                System.out.println("DINGDINGDING\nHÄVISIT PELIN");
            }
            System.out.println("Pelaaja 1 voitot: " + playerone.getVoitot() + "\nTietokoneen voitot: " + playertwo.getVoitot());
        }
        
        tarkistusnro = 0;
        aloita();
        
    }

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

    public VoitonTarkistaja getVoitonTarkistaja() {
        return voitonTarkistaja;
    }
}
