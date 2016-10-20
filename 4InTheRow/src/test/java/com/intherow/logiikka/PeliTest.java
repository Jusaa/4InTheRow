/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import java.util.ArrayList;
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
        peli.aloitaKaksinPeli();
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
        peli.vuoro(1);
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(3);
        peli.vuoro(4);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void pystyTarkistusToimii() {
        peli.vuoro(3);
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(2);
        peli.vuoro(3);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY() {
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(5);
        peli.vuoro(5);
        peli.vuoro(7);
        peli.vuoro(6);
        peli.vuoro(6);
        peli.vuoro(5);
        peli.vuoro(6);
        peli.vuoro(6);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY2() {
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(6);
        peli.vuoro(5);
        peli.vuoro(5);
        peli.vuoro(4);
        peli.vuoro(5);
        peli.vuoro(5);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY3() {
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(3);
        peli.vuoro(5);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(4);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY4() {
        peli.vuoro(4);
        peli.vuoro(5);
        peli.vuoro(5);
        peli.vuoro(6);
        peli.vuoro(6);
        peli.vuoro(1);
        peli.vuoro(7);
        peli.vuoro(7);
        peli.vuoro(6);
        peli.vuoro(7);
        peli.vuoro(7);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY5() {
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(1);
        peli.vuoro(1);
        peli.vuoro(3);
        peli.vuoro(2);
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(3);
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY6() {
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(1);
        peli.vuoro(1);
        peli.vuoro(3);
        peli.vuoro(2);
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(3);
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
    }

    @Test
    public void vinoTarkistusToimiiOA() {
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(2);
        peli.vuoro(2);
        peli.vuoro(1);
        peli.vuoro(1);
        peli.vuoro(1);
        peli.vuoro(1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA2() {
        peli.vuoro(4);
        peli.vuoro(5);
        peli.vuoro(3);
        peli.vuoro(4);
        peli.vuoro(3);
        peli.vuoro(3);
        peli.vuoro(2);
        peli.vuoro(2);
        peli.vuoro(2);
        peli.vuoro(2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA3() {
        peli.vuoro(5);
        peli.vuoro(6);
        peli.vuoro(4);
        peli.vuoro(5);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(3);
        peli.vuoro(3);
        peli.vuoro(3);
        peli.vuoro(3);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA4() {
        peli.vuoro(6);
        peli.vuoro(7);
        peli.vuoro(5);
        peli.vuoro(6);
        peli.vuoro(5);
        peli.vuoro(5);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA5() {
        peli.vuoro(4);
        peli.vuoro(5);
        peli.vuoro(6);
        peli.vuoro(7);
        peli.vuoro(6);
        peli.vuoro(7);
        peli.vuoro(5);
        peli.vuoro(6);
        peli.vuoro(5);
        peli.vuoro(5);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA6() {
        peli.vuoro(4);
        peli.vuoro(5);
        peli.vuoro(6);
        peli.vuoro(7);
        peli.vuoro(4);
        peli.vuoro(5);
        peli.vuoro(6);
        peli.vuoro(7);
        peli.vuoro(6);
        peli.vuoro(7);
        peli.vuoro(5);
        peli.vuoro(6);
        peli.vuoro(5);
        peli.vuoro(5);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        peli.vuoro(4);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
    }

    @Test
    public void tarkistusnumeronAsettaminen() {
        assertEquals(0, peli.getTarkistusnro());
        peli.setTarkistusnro(2);
        assertEquals(2, peli.getTarkistusnro());
        peli.setTarkistusnro(1);
        assertEquals(1, peli.getTarkistusnro());
    }

    @Test
    public void vuoroTesti() {
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1), 1);
        assertEquals(peli.getPelaajaYksi().getVoitot(), 1);
    }

    @Test
    public void vuoroTesti2() {
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(3);
        peli.vuoro(2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2), 2);
        assertEquals(peli.getPelaajaKaksi().getVoitot(), 1);
    }

    @Test
    public void vuoroTesti3() {
        peli.aloitaYksinPeli();
        peli.vuoro(1);
        int i = peli.getPiirtaja().getTietokanta().getLista().get(0).get(0);
        assertEquals(i, 1);
    }

    @Test
    public void uusiPeliKeskenVanhaa() {
        peli.vuoro(1);
        peli.vuoro(2);
        peli.vuoro(2);
        peli.aloitaKaksinPeli();
        peli.vuoro(2);
        assertEquals(peli.getPiirtaja().getTietokanta().getLista().get(1).toString(), "[1, 0, 0, 0, 0, 0]");
    }

}
