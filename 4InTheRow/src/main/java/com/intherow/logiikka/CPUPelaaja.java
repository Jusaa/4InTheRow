package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jusaa
 */
public class CPUPelaaja implements Pelaaja {

    Random random;
    private String nimi;
    private int id;
    private String pelaajanMerkki;
    private String vastustajanMerkki;
    private Piirtaja piirtaja;
    private int voitot;
    private boolean omaVuoro;

    public CPUPelaaja(String nimi, String pelaajanMerkki, Piirtaja piirtaja, int id) {
        this.nimi = nimi;
        this.piirtaja = piirtaja;
        this.pelaajanMerkki = pelaajanMerkki;
        this.id = id;
        voitot = 0;
        random = new Random();
        this.vastustajanMerkki = null;
        if(id == 1){
            omaVuoro = true;
        }else{
            omaVuoro = false;
        }
    }

    /**
     * Metodi laittaa merkin cpupelaajan tahdon mukaisesti
     *
     * @param piirtaja hakee alustan mihin laittaa merkin
     */
    public void laitaMerkki(Piirtaja piirtaja) {
        //Graafiseen liittymään siirtymisen jälkeen tämän parantaminen
        while (true) {
            int pylvas = random.nextInt(6) + 1;
            if (piirtaja.vuoronPiirto(pylvas, id) == true) {
                break;
            }
        }
    }

    /**
     * Metodi asettaa vastustajan merkin
     *
     * @param merkki asettaa vastustajan merkin jotta piirtäminen onnistuu
     */
    public void asetaVastustajanMerkki(String merkki) {
        vastustajanMerkki = merkki;
    }

    /**
     * lisää voittojen määrää
     */
    public void voitti() {
        voitot++;
    }

    public String getNimi() {
        return nimi;
    }

    public String getOmaMerkki() {
        return pelaajanMerkki;
    }

    public String getVastustajanMerkki() {
        return vastustajanMerkki;
    }

    public int getVoitot() {
        return voitot;
    }

    @Override
    public Piirtaja getPiirtaja() {
        return piirtaja;
    }
    
    @Override
    public boolean omaVuoro() {
        if(omaVuoro){
            omaVuoro = false;
            return true;
        }else{
            omaVuoro = true;
            return false;
        }
    }

    @Override
    public String toString() {
        if (vastustajanMerkki != null) {
            return nimi + ", oma merkki " + pelaajanMerkki + ", vastustajan merkki " + vastustajanMerkki;
        }
        return nimi + ", oma merkki " + pelaajanMerkki;
    }

    @Override
    public Scanner getScanner() {
        return null;
    }

    

}
