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
public class Pelaaja {

    private String nimi;
    private int id;
    private String pelaajanMerkki;
    private String vastustajanMerkki;
    private Piirtaja piirtaja;
    private Scanner lukija;

    public Pelaaja(String nimi, String pelaajanMerkki, Piirtaja piirtaja, Scanner lukija, int id) {
        this.nimi = nimi;
        this.piirtaja = piirtaja;
        this.pelaajanMerkki = pelaajanMerkki;
        this.lukija = lukija;
        this.id = id;
    }

    public void laitaMerkki() {
        System.out.print(nimi + "\nMihin laitetaan merkki? ");
        int pylvas;
        while (true) {
            try {
                pylvas = Integer.parseInt(lukija.nextLine());
            } catch (Exception exception) {
                pylvas = 0;
            }

            if (pylvas >= 1 && pylvas <= 7) {
                if (piirtaja.vuoronPiirto(pylvas, pelaajanMerkki, vastustajanMerkki, id) == true) {
                    break;
                }else {
                    System.out.print("Valitsemasi pylväs on täynnä, valitse toinen: ");
                }
            } else {
                System.out.print("Kirjoita numero 1-7, haluamasi kohdan mukaan: ");
            }
        }
    }

    public void asetaVastustajanMerkki(String merkki) {
        vastustajanMerkki = merkki;
    }

    public String getNimi() {
        return nimi;
    }

    public String getOmaMerkki() {
        return pelaajanMerkki;
    }

    public String getVastustajanMerkki() {
        return vastustajanMerkki;
    }

    public String toString() {
        return nimi + ", oma merkki " + pelaajanMerkki;
    }
}
