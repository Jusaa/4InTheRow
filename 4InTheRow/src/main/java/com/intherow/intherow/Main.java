/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.intherow;

import com.intherow.logiikka.Peli;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * Peli käynnistyy.
     *
     * @param args koska main metodi
     */
    public static void main(String[] args) {
        Peli peli = new Peli();
        new Thread(new Runnable() {
            @Override
            public void run() {
                peli.aloita();
                while (true) {
                    //Ilman Thread.sleep(Tarpeeksi pitkä aika) voitontarkistus ei toimi?
                    //Voisi korvata myös Sout("Jotain"); ja toimii silloin?
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    if(peli.getTarkistusnro() != 0){
                        peli.getPiirtaja().tuloksenPiirto(peli.getTarkistusnro());
                        peli.setTarkistusnro(0);
                    }
                }
            }
        }).start();
    }
}
