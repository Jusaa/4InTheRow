/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.intherow;

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
        assertEquals(peli.getPlayerOneString(), new Pelaaja("playerone", "X", new Piirtaja(), new Scanner(System.in)).toString());
        assertEquals(peli.getPlayerOneString(), "playerone, oma merkki X");

        assertEquals(peli.getPlayerTwoString(), new Pelaaja("playertwo", "O", new Piirtaja(), new Scanner(System.in)).toString());
        assertEquals(peli.getPlayerTwoString(), "playertwo, oma merkki O");
    }

    @Test
    public void vaakaTarkistusToimii() {
        Peli peli = new Peli();
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", "playerone");
        peli.voitonTarkistaja(1);
        assertEquals(peli.getTarkistusnro(), 1);
    }

    @Test
    public void pystyTarkistusToimii() {
        Peli peli = new Peli();
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", "playerone");
        peli.voitonTarkistaja(1);
        assertEquals(peli.getTarkistusnro(), 1);
    }

    @Test
    public void vinoTarkistusToimii() {
        Peli peli = new Peli();
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", "playertwo");
        peli.getPiirtaja().vuoronPiirto(4, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(5, "O", "X", "playertwo");
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(7, "O", "X", "playertwo");
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", "playertwo");
        peli.getPiirtaja().vuoronPiirto(5, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(6, "O", "X", "playertwo");
        peli.getPiirtaja().vuoronPiirto(6, "X", "O", "playerone");
        peli.voitonTarkistaja(1);
        assertEquals(peli.getTarkistusnro(), 1);
    }

    @Test
    public void vinoTarkistusToimii2() {
        Peli peli = new Peli();
        peli.getPiirtaja().vuoronPiirto(3, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(4, "O", "X", "playertwo");
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(3, "O", "X", "playertwo");
        peli.getPiirtaja().vuoronPiirto(2, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(2, "O", "X", "playertwo");
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(1, "O", "X", "playertwo");
        peli.getPiirtaja().vuoronPiirto(1, "X", "O", "playerone");
        peli.getPiirtaja().vuoronPiirto(1, "O", "X", "playertwo");
        peli.voitonTarkistaja(2);
        assertEquals(peli.getTarkistusnro(), 2);
    }

}
