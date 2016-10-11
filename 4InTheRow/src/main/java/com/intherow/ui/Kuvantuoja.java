/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Kuvantuoja {

    private ArrayList<ImageIcon> kuvat;

    /**
     * Kuvantuojan konstruktori joka hakee kaikki kuvat.
     */
    public Kuvantuoja() {
        kuvat = new ArrayList<>();
        BufferedImage bufferedTyhjaruutu = null;
        BufferedImage bufferedPelaajan1ruutu = null;
        BufferedImage bufferedPelaajan2ruutu = null;
        BufferedImage bufferedNumero1 = null;
        BufferedImage bufferedNumero2 = null;
        BufferedImage bufferedNumero3 = null;
        BufferedImage bufferedNumero4 = null;
        BufferedImage bufferedNumero5 = null;
        BufferedImage bufferedNumero6 = null;
        BufferedImage bufferedNumero7 = null;
        BufferedImage bufferedYksinpeli = null;
        BufferedImage bufferedKaksinpeli = null;

        try {
            bufferedTyhjaruutu = ImageIO.read(new File("kuvat/ruudut/tyhjaruutu.png"));
            bufferedPelaajan1ruutu = ImageIO.read(new File("kuvat/ruudut/pelaajan1ruutu.png"));
            bufferedPelaajan2ruutu = ImageIO.read(new File("kuvat/ruudut/pelaajan2ruutu.png"));
            bufferedNumero1 = ImageIO.read(new File("kuvat/pylvasnumerot/numero1.png"));
            bufferedNumero2 = ImageIO.read(new File("kuvat/pylvasnumerot/numero2.png"));
            bufferedNumero3 = ImageIO.read(new File("kuvat/pylvasnumerot/numero3.png"));
            bufferedNumero4 = ImageIO.read(new File("kuvat/pylvasnumerot/numero4.png"));
            bufferedNumero5 = ImageIO.read(new File("kuvat/pylvasnumerot/numero5.png"));
            bufferedNumero6 = ImageIO.read(new File("kuvat/pylvasnumerot/numero6.png"));
            bufferedNumero7 = ImageIO.read(new File("kuvat/pylvasnumerot/numero7.png"));
            bufferedYksinpeli = ImageIO.read(new File("kuvat/menunapit/yksinpeli.png"));
            bufferedKaksinpeli = ImageIO.read(new File("kuvat/menunapit/kaksinpeli.png"));
            
        } catch (IOException ex) {

        }

        kuvat.add(new ImageIcon(bufferedTyhjaruutu));
        kuvat.add(new ImageIcon(bufferedPelaajan1ruutu));
        kuvat.add(new ImageIcon(bufferedPelaajan2ruutu));
        kuvat.add(new ImageIcon(bufferedNumero1));
        kuvat.add(new ImageIcon(bufferedNumero2));
        kuvat.add(new ImageIcon(bufferedNumero3));
        kuvat.add(new ImageIcon(bufferedNumero4));
        kuvat.add(new ImageIcon(bufferedNumero5));
        kuvat.add(new ImageIcon(bufferedNumero6));
        kuvat.add(new ImageIcon(bufferedNumero7));
        kuvat.add(new ImageIcon(bufferedYksinpeli));
        kuvat.add(new ImageIcon(bufferedKaksinpeli));
    }

    public ImageIcon getImageIcon(int index) {
        return kuvat.get(index);
    }
}
