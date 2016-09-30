package com.intherow.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class PelaajaTest {

    Pelaaja playerone;
    Pelaaja cpuplayer;

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
        playerone = new UserPelaaja("playerone", "X", new Piirtaja(), new Scanner(System.in), 1);
        cpuplayer = new CPUPelaaja("cpuplayer", "O", new Piirtaja(), 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void uudenPelaajanTiedotOikein() {

        assertEquals(playerone.getNimi(), "playerone");
        assertEquals(playerone.getOmaMerkki(), "X");
        assertEquals("playerone, oma merkki X", playerone.toString());
    }

    @Test
    public void vastustajanMerkkiOikein() {
        playerone.asetaVastustajanMerkki("O");

        assertEquals(playerone.getVastustajanMerkki(), "O");
        assertEquals("playerone, oma merkki X, vastustajan merkki O", playerone.toString());
    }

    @Test
    public void vastustajanMerkkiOikein2() {
        cpuplayer.asetaVastustajanMerkki("X");

        assertEquals(cpuplayer.getVastustajanMerkki(), "X");
        assertEquals("cpuplayer, oma merkki O, vastustajan merkki X", cpuplayer.toString());
    }

    @Test
    public void uudenCPUPelaajanTiedotOikein() {

        cpuplayer.asetaVastustajanMerkki("X");

        assertEquals(cpuplayer.getNimi(), "cpuplayer");
        assertEquals(cpuplayer.getOmaMerkki(), "O");
        assertEquals(cpuplayer.getVastustajanMerkki(), "X");
    }

    @Test
    public void pelaajanVoittojenMaaraOikein() {
        assertEquals(playerone.getVoitot(), 0);
        playerone.voitti();
        assertEquals(playerone.getVoitot(), 1);
        playerone.voitti();
        playerone.voitti();
        playerone.voitti();
        assertEquals(playerone.getVoitot(), 4);
    }

    @Test
    public void cpupelaajanVoittojeenMaaraOikein() {
        assertEquals(cpuplayer.getVoitot(), 0);
        cpuplayer.voitti();
        assertEquals(cpuplayer.getVoitot(), 1);
        cpuplayer.voitti();
        cpuplayer.voitti();
        cpuplayer.voitti();
        assertEquals(cpuplayer.getVoitot(), 4);
    }
}
