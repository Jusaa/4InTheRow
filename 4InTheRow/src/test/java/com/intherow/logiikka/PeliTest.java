/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jusaa
 */
public class PeliTest {

    Peli peli;

    public PeliTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Peli();
        peli.getPiirtaja().getTietokanta().uusiLista();
        peli.setPelaajat(new IhmisPelaaja(peli.getPiirtaja(), 1), new TietokonePelaaja(peli.getPiirtaja(), 2));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tarkistusnumeroOikein() {
        assertEquals(peli.getTarkistusnro(), 0);
    }

    @Test
    public void pelaajienLoytaminen() {
        assertEquals(peli.getPelaajaYksi().toString(), new IhmisPelaaja(peli.getPiirtaja(), 1).toString());
        assertEquals(peli.getPelaajaKaksi().toString(), new TietokonePelaaja(peli.getPiirtaja(), 2).toString());
        assertEquals(peli.getPelaajaYksi().toString(), "1 0");
        assertEquals(peli.getPelaajaKaksi().toString(), "2 0");
    }

    @Test
    public void vuoronMuuttaminenToimii() {
        assertEquals(peli.getPelaajanVuoro(), 1);
        peli.setPelaajanVuoro();
        assertEquals(peli.getPelaajanVuoro(), 2);
        peli.setPelaajanVuoro();
        assertEquals(peli.getPelaajanVuoro(), 1);
    }

    @Test
    public void vaakaTarkistusToimii() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void pystyTarkistusToimii() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY2() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY3() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY4() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY5() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY6() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOA() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA2() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA3() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA4() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA5() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA6() {
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

//    @Test
//    public void tasapelinTunnistusOikein() {
//        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(1, 2);
//
//        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(2, 1);
//
//        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(3, 2);
//
//        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(4, 1);
//
//        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(5, 2);
//
//        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(6, 1);
//
//        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 1);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
//        peli.getPiirtaja().getTietokanta().lisaaListaan(7, 2);
//        
//        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 3);
//        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 3);
//    }
}
