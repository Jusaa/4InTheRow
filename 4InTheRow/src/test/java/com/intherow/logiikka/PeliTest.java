/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.util.Scanner;
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tarkistusnumeroOikein() {
        Peli peli = new Peli();
        assertEquals(peli.getTarkistusnro(), 0);
    }

    @Test
    public void pelaajatOikein() {
        Peli peli = new Peli();

        assertEquals(peli.getPlayerOneString(), "playerone, oma merkki X, vastustajan merkki O");
        assertEquals(peli.getPlayerTwoString(), "playertwo, oma merkki O, vastustajan merkki X");
    }

    @Test
    public void vaakaTarkistusToimii() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void pystyTarkistusToimii() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY2() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY3() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY4() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(1, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(7, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(7, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY5() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(1, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOY6() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(1, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(1, peli.getPiirtaja()), 1);
    }

    @Test
    public void vinoTarkistusToimiiOA() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(1, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(1, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA2() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA3() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA4() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA5() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

    @Test
    public void vinoTarkistusToimiiOA6() {
        Peli peli = new Peli();
        peli.getPiirtaja().getDatabase().uusiLista();
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", 1);
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", 2);
        assertEquals(peli.getVoitonTarkistaja().tarkasta(2, peli.getPiirtaja()), 2);
    }

}
