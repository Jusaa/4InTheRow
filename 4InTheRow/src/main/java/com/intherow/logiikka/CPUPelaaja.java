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
public class CPUPelaaja extends Pelaaja {

    Random random;

    public CPUPelaaja(String nimi, String pelaajanMerkki, Piirtaja piirtaja, int id) {
        super(nimi, pelaajanMerkki, piirtaja, id);
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
}
