package com.intherow.intherow;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class PelaajaTest {

    public PelaajaTest() {
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
    public void uudenPelaajanTiedotOikein() {
        Pelaaja playerone = new Pelaaja("playerone", "X", new Piirtaja(), new Scanner(System.in));

        assertEquals(playerone.getNimi(), "playerone");
        assertEquals(playerone.getOmaMerkki(), "X");
    }

    @Test
    public void vastustajanMerkkiOikein() {
        Pelaaja playerone = new Pelaaja("playerone", "X", new Piirtaja(), new Scanner(System.in));
        playerone.asetaVastustajanMerkki("O");

        assertEquals(playerone.getVastustajanMerkki(), "O");
    }
}
