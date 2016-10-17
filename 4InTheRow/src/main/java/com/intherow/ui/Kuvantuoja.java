/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.ui;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Kuvantuoja {

    private ArrayList<ImageIcon> kuvat;

    /**
     * Kuvantuojan konstruktori joka hakee kaikki kuvat.
     */
    public Kuvantuoja() {
        kuvat = new ArrayList<>();

        kuvat.add(new ImageIcon("kuvat/ruudut/tyhjaruutu.png"));
        kuvat.add(new ImageIcon("kuvat/ruudut/pelaajan1ruutu.png"));
        kuvat.add(new ImageIcon("kuvat/ruudut/pelaajan2ruutu.png"));
        kuvat.add(new ImageIcon("kuvat/pylvasnumerot/numero1.png"));
        kuvat.add(new ImageIcon("kuvat/pylvasnumerot/numero2.png"));
        kuvat.add(new ImageIcon("kuvat/pylvasnumerot/numero3.png"));
        kuvat.add(new ImageIcon("kuvat/pylvasnumerot/numero4.png"));
        kuvat.add(new ImageIcon("kuvat/pylvasnumerot/numero5.png"));
        kuvat.add(new ImageIcon("kuvat/pylvasnumerot/numero6.png"));
        kuvat.add(new ImageIcon("kuvat/pylvasnumerot/numero7.png"));
        kuvat.add(new ImageIcon("kuvat/menunapit/yksinpeli.png"));
        kuvat.add(new ImageIcon("kuvat/menunapit/kaksinpeli.png"));
    }

    public ImageIcon getImageIcon(int index) {
        return kuvat.get(index);
    }
}
