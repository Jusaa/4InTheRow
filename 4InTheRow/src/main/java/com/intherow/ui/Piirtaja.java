/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.ui;

import com.intherow.logiikka.Database;
import com.intherow.logiikka.HiirenKuuntelija;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jusaa
 */
public class Piirtaja {

    private Database database;
    private JFrame alusta;
    private ImageIcon tyhjaruutu;
    private ImageIcon pelaajan1ruutu;
    private ImageIcon pelaajan2ruutu;

    public Piirtaja() {
        database = new Database();
        database.uusiLista();

        BufferedImage bufferedTyhjaruutu = null;
        BufferedImage bufferedPelaajan1ruutu = null;
        BufferedImage bufferedPelaajan2ruutu = null;
        try {
            bufferedTyhjaruutu = ImageIO.read(new File("kuvat/tyhjaruutu.png"));
            bufferedPelaajan1ruutu = ImageIO.read(new File("kuvat/pelaajan1ruutu.png"));
            bufferedPelaajan2ruutu = ImageIO.read(new File("kuvat/pelaajan2ruutu.png"));
        } catch (IOException ex) {

        }

        tyhjaruutu = new ImageIcon(bufferedTyhjaruutu);
        pelaajan1ruutu = new ImageIcon(bufferedPelaajan1ruutu);
        pelaajan2ruutu = new ImageIcon(bufferedPelaajan2ruutu);
        alusta = new JFrame("4InTheRow");
        alusta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alusta.setLayout(new GridLayout(7, 7));

    }

    public void uusiPeli() throws IOException {
        System.out.println(" -1- -2- -3- -4- -5- -6- -7- ");
        for (int i = 0; i < 6; i++) {
            System.out.println("|   |   |   |   |   |   |   |");
            System.out.println(" --- --- --- --- --- --- --- ");
        }

        database.uusiLista();
        alusta.getContentPane().removeAll();

        for (int i = 1; i < 8; i++) {
            alusta.getContentPane().add(new JButton("" + i));
            alusta.getContentPane().getComponent(i - 1).addMouseListener(new HiirenKuuntelija(i, this));

        }

        for (int i = 0; i < 42; i++) {
            alusta.getContentPane().add(new JLabel(tyhjaruutu));
        }

        alusta.pack();
        alusta.setVisible(true);
    }

    public boolean vuoronPiirto(int pylvas, String merkki, String merkki2, int id) {

        if (database.lisaaListaan(pylvas, merkki, merkki2, id) == false) {
            return false;
        } else {

            System.out.println("\n\n -1- -2- -3- -4- -5- -6- -7- ");
            int ruutuId = 0;
            int nro = 6;
            for (int i = nro; i > 0; i--) {
                for (int ii = 0; ii < 7; ii++) {
                    if (database.getLista().get(ii).get(nro - 1) == 0) {
                        System.out.print("|   ");
                    } else if (database.getLista().get(ii).get(nro - 1) == 1 && id == 1) {
                        System.out.print("| " + merkki + " ");
                        ruudunMuokkaus(ruutuId + 7, id);
                    } else if (database.getLista().get(ii).get(nro - 1) == 2 && id == 1) {
                        System.out.print("| " + merkki2 + " ");
                    } else if (database.getLista().get(ii).get(nro - 1) == 2 && id == 2) {
                        ruudunMuokkaus(ruutuId + 7, id);
                        System.out.print("| " + merkki + " ");
                    } else if (database.getLista().get(ii).get(nro - 1) == 1 && id == 2) {
                        System.out.print("| " + merkki2 + " ");
                    }

                    ruutuId++;
                }
                nro--;
                System.out.println("|\n --- --- --- --- --- --- --- ");

            }
            alusta.validate();
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

    public void ruudunMuokkaus(int ruutuId, int id) {
        alusta.getContentPane().remove(ruutuId);
        if (id == 1) {
            alusta.getContentPane().add(new JLabel(pelaajan1ruutu), ruutuId);
        } else if (id == 2) {
            alusta.getContentPane().add(new JLabel(pelaajan2ruutu), ruutuId);
        }

    }

    public Database getDatabase() {
        return database;
    }

    public JFrame getAlusta() {
        return alusta;
    }

    public String toString() {
        return database.getLista().toString();
    }
}
