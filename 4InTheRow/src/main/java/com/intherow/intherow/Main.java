/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.intherow;

import com.intherow.logiikka.Peli;

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
                    //Jos otan tämän Sout kutsun pois, tarkistus ei toimi?
                    System.out.print(peli.getTarkistusnro());
                    if(peli.getTarkistusnro() != 0){
                        peli.getPiirtaja().tuloksenPiirto(peli.getTarkistusnro());
                        peli.setTarkistusnro(0);
                    }
                }
            }
        }).start();
    }
}
