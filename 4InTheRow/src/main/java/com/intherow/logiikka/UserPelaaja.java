/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.Scanner;

/**
 *
 * @author Jusaa
 */
public class UserPelaaja extends Pelaaja {

    private Scanner lukija;

    public UserPelaaja(String nimi, String pelaajanMerkki, Piirtaja piirtaja, Scanner lukija, int id) {
        super(nimi, pelaajanMerkki, piirtaja, id);
        this.lukija = lukija;
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
                } else {
                    System.out.print("Valitsemasi pylväs on täynnä, valitse toinen: ");
                }
            } else {
                System.out.print("Kirjoita numero 1-7, haluamasi kohdan mukaan: ");
            }
        }
    }

}
