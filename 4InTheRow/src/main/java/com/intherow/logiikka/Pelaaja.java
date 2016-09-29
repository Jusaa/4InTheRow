/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;


/**
 *
 * @author Jusaa
 */
public interface Pelaaja {

    public void laitaMerkki(Piirtaja piirtaja);
    
    public String getNimi();

    public String getOmaMerkki();

    public String getVastustajanMerkki();

    public void asetaVastustajanMerkki(String o);
    
    public void voitti();
    
    public int getVoitot();
    
    public Piirtaja getPiirtaja();
}
