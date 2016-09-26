/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jusaa
 */
public class CPUPelaaja implements Pelaaja {

    Random random;
    private String nimi;
    private int id;
    private String pelaajanMerkki;
    private String vastustajanMerkki;
    private Piirtaja piirtaja;
    private int voitot;

    public CPUPelaaja(String nimi, String pelaajanMerkki, Piirtaja piirtaja, int id) {
        this.nimi = nimi;
        this.piirtaja = piirtaja;
        this.pelaajanMerkki = pelaajanMerkki;
        this.id = id;
        voitot = 0;
        random = new Random();
    }

    public void laitaMerkki() {
        while (true) {
            int pylvas = random.nextInt(6) + 1;
            if (piirtaja.vuoronPiirto(pylvas, pelaajanMerkki, vastustajanMerkki, id) == true) {
                break;
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

    public void voitti() {
        voitot++;
    }
    
    public int getVoitot() {
        return voitot;
    }
    
    @Override
    public String toString() {
        if (vastustajanMerkki != null) {
            return nimi + ", oma merkki " + pelaajanMerkki + ", vastustajan merkki " + vastustajanMerkki;
        }
        return nimi + ", oma merkki " + pelaajanMerkki;
    }

    

}
