package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.Scanner;

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
    
    public Scanner getScanner();
    
    public boolean omaVuoro();
}
