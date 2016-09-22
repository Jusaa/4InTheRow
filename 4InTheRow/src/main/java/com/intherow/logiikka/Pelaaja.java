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
public class Pelaaja {

    public String nimi;
    public int id;
    public String pelaajanMerkki;
    public String vastustajanMerkki;
    public Piirtaja piirtaja;

    public Pelaaja(String nimi, String pelaajanMerkki, Piirtaja piirtaja, int id) {
        this.nimi = nimi;
        this.piirtaja = piirtaja;
        this.pelaajanMerkki = pelaajanMerkki;
        this.id = id;
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

    @Override
    public String toString() {
        return nimi + ", oma merkki " + pelaajanMerkki;
    }
}
