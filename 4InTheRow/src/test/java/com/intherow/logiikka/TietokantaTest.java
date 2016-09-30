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
public class TietokantaTest {

    Tietokanta tietokanta;

    public TietokantaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tietokanta = new Tietokanta();
        tietokanta.uusiLista();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void listanOikeinGenerointi() {
        assertEquals("[[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], "
                + "[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]", tietokanta.toString());
    }

    @Test
    public void listanMuokkausKerran() {
        tietokanta.lisaaListaan(7, "X", "O", 1);
        assertEquals("[[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], "
                + "[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [1, 0, 0, 0, 0, 0]]", tietokanta.toString());
    }

    @Test
    public void listanMuokkausMontaKertaa() {
        tietokanta.lisaaListaan(1, "X", "O", 1);
        tietokanta.lisaaListaan(1, "X", "O", 1);
        tietokanta.lisaaListaan(2, "X", "O", 1);
        tietokanta.lisaaListaan(3, "X", "O", 1);
        tietokanta.lisaaListaan(1, "X", "O", 1);
        assertEquals("[[1, 1, 1, 0, 0, 0], [1, 0, 0, 0, 0, 0], [1, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], "
                + "[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]", tietokanta.toString());
    }

    @Test
    public void listanMuokkausMolemmillaPelaajilla() {
        tietokanta.lisaaListaan(1, "X", "O", 1);
        tietokanta.lisaaListaan(1, "X", "O", 2);
        tietokanta.lisaaListaan(2, "X", "O", 2);
        tietokanta.lisaaListaan(2, "X", "O", 1);
        tietokanta.lisaaListaan(3, "X", "O", 2);
        assertEquals("[[1, 2, 0, 0, 0, 0], [2, 1, 0, 0, 0, 0], [2, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], "
                + "[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]", tietokanta.toString());
    }

    @Test
    public void liianPaljonMerkkejaYhteenSarakkeeseen() {
        tietokanta.lisaaListaan(1, "X", "O", 1);
        tietokanta.lisaaListaan(1, "X", "O", 1);
        tietokanta.lisaaListaan(1, "X", "O", 1);
        tietokanta.lisaaListaan(1, "X", "O", 1);
        tietokanta.lisaaListaan(1, "X", "O", 1);
        tietokanta.lisaaListaan(1, "X", "O", 1);
        tietokanta.lisaaListaan(1, "X", "O", 1);
        assertEquals("[[1, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], "
                + "[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]", tietokanta.toString());
    }
}
