/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.ui;

import com.intherow.logiikka.Database;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jusaa
 */
public class Piirtaja {

    private Database database;

    public Piirtaja() {
        database = new Database();
        database.uusiLista();
    }

    public void uusiPeli() {
        System.out.println(" -1- -2- -3- -4- -5- -6- -7- ");
        for (int i = 0; i < 6; i++) {
            System.out.println("|   |   |   |   |   |   |   |");
            System.out.println(" --- --- --- --- --- --- --- ");
        }
        database.uusiLista();
    }

    public boolean vuoronPiirto(int pylvas, String merkki, String merkki2, int id) {

        if (database.lisaaListaan(pylvas, merkki, merkki2, id) == false) {
            return false;
        } else {
            System.out.println("\n\n -1- -2- -3- -4- -5- -6- -7- ");
            int nro = 6;
            for (int i = nro; i > 0; i--) {
                for (int ii = 0; ii < 7; ii++) {
                    if (database.getLista().get(ii).get(nro - 1) == 0) {
                        System.out.print("|   ");
                    } else if (database.getLista().get(ii).get(nro - 1) == 1 && id == 1) {
                        System.out.print("| " + merkki + " ");
                    } else if (database.getLista().get(ii).get(nro - 1) == 2 && id == 1) {
                        System.out.print("| " + merkki2 + " ");
                    } else if (database.getLista().get(ii).get(nro - 1) == 2 && id == 2) {
                        System.out.print("| " + merkki + " ");
                    } else if (database.getLista().get(ii).get(nro - 1) == 1 && id == 2) {
                        System.out.print("| " + merkki2 + " ");
                    }
                }
                nro--;
                System.out.println("|\n --- --- --- --- --- --- --- ");
            }
            return true;
        }
    }

    public int menuPiirto(Scanner lukija) {
        while (true) {
            System.out.println("\n[1] Uusi yksinpeli\n[2] Uusi kaksinpeli\n[3] Uusi peli samoilla tiedoilla\n[4] Lopeta");
            String komento = lukija.nextLine();
            if (komento.equals("1")) {
                return 1;
            } else if (komento.equals("2")) {
                return 2;
            } else if (komento.equals("3")) {
                return 3;
            } else if (komento.equals("4")) {
                return 4;
            }
        }
    }

    public Database getDatabase() {
        return database;
    }

    public String toString() {
        return database.getLista().toString();
    }
}
