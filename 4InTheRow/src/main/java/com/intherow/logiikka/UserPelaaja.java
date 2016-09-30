package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.Scanner;

/**
 *
 * @author Jusaa
 */
public class UserPelaaja implements Pelaaja {

    private Scanner lukija;
    private String nimi;
    private int id;
    private String pelaajanMerkki;
    private String vastustajanMerkki;
    private Piirtaja piirtaja;
    private int voitot;

    public UserPelaaja(String nimi, String pelaajanMerkki, Piirtaja piirtaja, Scanner lukija, int id) {
        this.nimi = nimi;
        this.piirtaja = piirtaja;
        this.pelaajanMerkki = pelaajanMerkki;
        this.id = id;
        this.lukija = lukija;
        voitot = 0;
        //this.vastustajanMerkki = null;
    }

    /**
     * Metodi lisää pelaajan haluaman merkin peliin
     *
     * @param piirtaja hakee alustan mihin laittaa merkin
     */
    public void laitaMerkki(Piirtaja piirtaja) {
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

    /**
     * Metodi lisää vastustajan merkin
     *
     * @param merkki asettaa vastustajan merkin jotta piirtäminen onnistuu
     */
    public void asetaVastustajanMerkki(String merkki) {
        vastustajanMerkki = merkki;
    }

    /**
     * Lisää pelaajan voittojen määrää
     */
    public void voitti() {
        voitot++;
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

    public int getVoitot() {
        return voitot;
    }

    @Override
    public Piirtaja getPiirtaja() {
        return piirtaja;
    }

    @Override
    public String toString() {
        if (vastustajanMerkki != null) {
            return nimi + ", oma merkki " + pelaajanMerkki + ", vastustajan merkki " + vastustajanMerkki;
        }
        return nimi + ", oma merkki " + pelaajanMerkki;
    }

}
