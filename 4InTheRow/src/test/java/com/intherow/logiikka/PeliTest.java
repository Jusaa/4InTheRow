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
        peli.getPiirtaja().getDatabase().uusiLista();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tarkistusnumeroOikein() {
        assertEquals(peli.getTarkistusnro(), 0);
    }

    @Test
    public void pelaajatOikein() {

        assertEquals(peli.getPlayerOne().toString(), "playerone, oma merkki X, vastustajan merkki O");
        assertEquals(peli.getPlayerTwo().toString(), "playertwo, oma merkki O, vastustajan merkki X");
    }

    @Test
    public void vaakaTarkistusToimii() {
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void pystyTarkistusToimii() {
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY() {
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY2() {
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY3() {
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY4() {
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY5() {
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY6() {
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOA() {
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA2() {
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA3() {
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA4() {
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA5() {
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA6() {
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void tasapelinTunnistusOikein() {
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(1, "X", "O", 2);

        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(2, "X", "O", 1);

        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(3, "X", "O", 2);

        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(4, "X", "O", 1);

        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(5, "X", "O", 2);

        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(6, "X", "O", 1);

        peli.getPiirtaja().getDatabase().lisaaListaan(7, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "X", "O", 1);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "X", "O", 2);
        peli.getPiirtaja().getDatabase().lisaaListaan(7, "X", "O", 2);

        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 3);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 3);
    }

}
