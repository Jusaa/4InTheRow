/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.intherow;

import java.util.ArrayList;

/**
 *
 * @author Jusaa
 */
public class Piirtaja {

    private ArrayList<ArrayList<Integer>> lista;

    public Piirtaja() {
    }

    public void uusiPeli() {
        System.out.println(" -1- -2- -3- -4- -5- -6- -7- ");
        for (int i = 0; i < 6; i++) {
            System.out.println("|   |   |   |   |   |   |   |");
            System.out.println(" --- --- --- --- --- --- --- ");
        }

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

    public boolean vuoronPiirto(int pylvas, String merkki, String merkki2, int id) {

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
            System.out.println("\n\n -1- -2- -3- -4- -5- -6- -7- ");

            int nro = 6;
            for (int i = nro; i > 0; i--) {
                for (int ii = 0; ii < 7; ii++) {
                    if (lista.get(ii).get(nro - 1) == 0) {
                        System.out.print("|   ");
                    } else if (lista.get(ii).get(nro - 1) == 1 && id == 1) {
                        System.out.print("| " + merkki + " ");
                    } else if (lista.get(ii).get(nro - 1) == 2 && id == 1) {
                        System.out.print("| " + merkki2 + " ");
                    } else if (lista.get(ii).get(nro - 1) == 2 && id == 2) {
                        System.out.print("| " + merkki + " ");
                    } else if (lista.get(ii).get(nro - 1) == 1 && id == 2) {
                        System.out.print("| " + merkki2 + " ");
                    }
                }
                nro--;
                System.out.println("|\n --- --- --- --- --- --- --- ");
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
