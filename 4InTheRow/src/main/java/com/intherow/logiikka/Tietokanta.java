package com.intherow.logiikka;

import java.util.ArrayList;

public class Tietokanta {

    private ArrayList<ArrayList<Integer>> lista;

    /**
     * Konstruktori tietokannalle.
     */
    public Tietokanta() {
        lista = new ArrayList<>();
    }

    /**
     * Alustaa uuden listan uutta peliä varten.
     */
    public void uusiLista() {
        lista = new ArrayList<>();
        ArrayList<Integer> sisaLista;
        for (int i = 7; i > 0; i--) {
            sisaLista = new ArrayList<>();
            for (int ii = 6; ii > 0; ii--) {
                sisaLista.add(0);
            }
            lista.add(sisaLista);
        }
    }

    /**
     * @param pylvas mihin pylvääseen merkki laitetaan
     * @param id pelaajan oma id arvo
     * @return the boolean
     */
    public boolean lisaaListaan(int pylvas, int id) {
        if (lista.get(pylvas - 1).get(5) != 0) {
            return false;
        } else {
            for (int i = 6; i >= 0; i--) {
                if (i == 0 || lista.get(pylvas - 1).get(i - 1) != 0) {
                    if (id == 1) {
                        lista.get(pylvas - 1).set(i, 1);
                    } else if (id == 2) {
                        lista.get(pylvas - 1).set(i, 2);
                    }
                    break;
                }
            }
            return true;
        }
    }

    public ArrayList<ArrayList<Integer>> getLista() {
        return lista;
    }
}
