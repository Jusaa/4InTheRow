/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.ui;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Kuvantuoja {

    private ArrayList<ImageIcon> kuvat;

    /**
     * Kuvantuojan konstruktori joka hakee kaikki kuvat.
     */
    public Kuvantuoja() {
//        BufferedImage kuva1 = ImageIO.read(getClass().getResourceAsStream("tyhjaruutu.png"))
        kuvat = new ArrayList<>();
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/ruudut/tyhjaruutu.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/ruudut/pelaajan1ruutu.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/ruudut/pelaajan2ruutu.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/pylvasnumerot/numero1.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/pylvasnumerot/numero2.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/pylvasnumerot/numero3.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/pylvasnumerot/numero4.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/pylvasnumerot/numero5.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/pylvasnumerot/numero6.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/pylvasnumerot/numero7.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/menunapit/yksinpeli.png")));
        kuvat.add(new javax.swing.ImageIcon(getClass().getResource("/menunapit/kaksinpeli.png")));
    }

    public ImageIcon getImageIcon(int index) {
        return kuvat.get(index);
    }
}
