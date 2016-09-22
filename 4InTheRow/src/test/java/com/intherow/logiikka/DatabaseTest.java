/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
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
public class DatabaseTest {

    public DatabaseTest() {
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
    public void listanOikeinGenerointi() {
        Piirtaja piirtaja = new Piirtaja();
        assertEquals("[[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], "
                + "[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]", piirtaja.toString());
    }

    @Test
    public void listanMuokkausKerran() {
        Piirtaja piirtaja = new Piirtaja();
        piirtaja.vuoronPiirto(7, "X", "O", 1);
        assertEquals("[[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], "
                + "[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [1, 0, 0, 0, 0, 0]]", piirtaja.toString());
    }

    @Test
    public void listanMuokkausMontaKertaa() {
        Piirtaja piirtaja = new Piirtaja();
        piirtaja.vuoronPiirto(1, "X", "O", 1);
        piirtaja.vuoronPiirto(1, "X", "O", 1);
        piirtaja.vuoronPiirto(2, "X", "O", 1);
        piirtaja.vuoronPiirto(3, "X", "O", 1);
        piirtaja.vuoronPiirto(1, "X", "O", 1);
        assertEquals("[[1, 1, 1, 0, 0, 0], [1, 0, 0, 0, 0, 0], [1, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], "
                + "[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]", piirtaja.toString());
    }

    @Test
    public void listanMuokkausMolemmillaPelaajilla() {
        Piirtaja piirtaja = new Piirtaja();
        piirtaja.vuoronPiirto(1, "X", "O", 1);
        piirtaja.vuoronPiirto(1, "X", "O", 2);
        piirtaja.vuoronPiirto(2, "X", "O", 2);
        piirtaja.vuoronPiirto(2, "X", "O", 1);
        piirtaja.vuoronPiirto(3, "X", "O", 2);
        assertEquals("[[1, 2, 0, 0, 0, 0], [2, 1, 0, 0, 0, 0], [2, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], "
                + "[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]", piirtaja.toString());
    }
}
