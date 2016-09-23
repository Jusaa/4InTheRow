package com.intherow.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.intherow.ui.Piirtaja;
import com.intherow.logiikka.UserPelaaja;
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
        UserPelaaja playerone = new UserPelaaja("playerone", "X", new Piirtaja(), new Scanner(System.in), 1);

        assertEquals(playerone.getNimi(), "playerone");
        assertEquals(playerone.getOmaMerkki(), "X");
    }

    @Test
    public void vastustajanMerkkiOikein() {
        UserPelaaja playerone = new UserPelaaja("playerone", "X", new Piirtaja(), new Scanner(System.in), 1);
        playerone.asetaVastustajanMerkki("O");

        assertEquals(playerone.getVastustajanMerkki(), "O");
        assertEquals("playerone, oma merkki X, vastustajan merkki O", playerone.toString());
    }

    @Test
    public void uudenCPUPelaajanTiedotOikein() {
        CPUPelaaja cpuplayer = new CPUPelaaja("cpuplayer", "O", new Piirtaja(), 2);
        cpuplayer.asetaVastustajanMerkki("X");

        assertEquals(cpuplayer.getNimi(), "cpuplayer");
        assertEquals(cpuplayer.getOmaMerkki(), "O");
        assertEquals(cpuplayer.getVastustajanMerkki(), "X");
    }
}
