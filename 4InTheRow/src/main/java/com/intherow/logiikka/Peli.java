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
        tarkistusnro = 0;
        aloita();
        if(tarkistusnro == 3){
            runOnePlayer();
        }
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
    
    public VoitonTarkistaja getVoitonTarkistaja(){
        return voitonTarkistaja;
    }
}
