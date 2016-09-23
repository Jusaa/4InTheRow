/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import java.util.ArrayList;

/**
 *
 * @author Jusaa
 */
public class Database {

    private ArrayList<ArrayList<Integer>> lista;

    public Database() {

    }

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

    public boolean lisaaListaan(int pylvas, String merkki, String merkki2, int id) {
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

    public String toString() {
        return lista.toString();
    }
}
