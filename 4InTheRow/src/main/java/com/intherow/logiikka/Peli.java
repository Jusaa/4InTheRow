package com.intherow.logiikka;

import com.intherow.ui.Piirtaja;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Jusaa
 */
public class Peli {

    private Scanner lukija;
    private Pelaaja playerone;
    private Pelaaja playertwo;
    private Piirtaja piirtaja;
    private int pelaajanvuoro;
    private int tarkistusnro;
    private VoitonTarkistaja voitonTarkistaja;

    //Konstruktori kaksinpelin testaamiselle
    public Peli() {
        lukija = new Scanner(System.in);
        tarkistusnro = 0;
        piirtaja = new Piirtaja();
        playerone = new UserPelaaja("playerone", "X", piirtaja, lukija, 1);
        playertwo = new UserPelaaja("playertwo", "O", piirtaja, lukija, 2);
        playerone.asetaVastustajanMerkki("O");
        playertwo.asetaVastustajanMerkki("X");
        voitonTarkistaja = new VoitonTarkistaja();
        pelaajanvuoro = 1;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    
                }
            }
        }).start();
        
    }

    /**
     * Aloittaa uuden pelin pelaajan inputin mukaan
     */
    public void aloita() {
        voitonTarkistaja = new VoitonTarkistaja();
        piirtaja.getAlusta().getContentPane().removeAll();
        piirtaja.getAlusta().getContentPane().add(new JButton("1")).addMouseListener(new HiirenKuuntelija(11, this));
        int valinta = piirtaja.menuPiirto(lukija);
        if (valinta == 1) {
            aloitaYksinPeli();
        } else if (valinta == 2) {
            aloitaKaksinPeli();
        } else if (valinta == 3) {
            run();
        }
    }

    /**
     * Aloittaa uuden kaksinpelin
     */
    public void aloitaKaksinPeli() {

        // KONSTRUKTORISSA TOISTUVAT MÄÄRITTELYT VAIN TESTEJÃ„ VARTEN
        System.out.print("Pelaaja 1, kerro nimesi: ");
        String playeronenimi = lukija.nextLine();
        System.out.print("Entä mitä merkkiä haluat käyttää pelissä? ");
        String playeronemerkki = lukija.nextLine();
        playeronemerkki = "" + playeronemerkki.charAt(0);
        System.out.print("Pelaaja 2, kerro nimesi: ");
        String playertwonimi = lukija.nextLine();
        System.out.print("Entä mitä merkkiä haluat käyttää pelissä? ");
        String playertwomerkki = lukija.nextLine();
        playertwomerkki = "" + playertwomerkki.charAt(0);

        playerone = new UserPelaaja(playeronenimi, playeronemerkki, piirtaja, lukija, 1);
        playertwo = new UserPelaaja(playertwonimi, playertwomerkki, piirtaja, lukija, 2);
        playerone.asetaVastustajanMerkki(playertwomerkki);
        playertwo.asetaVastustajanMerkki(playeronemerkki);
        run();
    }

    /**
     * Aloittaa uuden yksinpelin
     */
    public void aloitaYksinPeli() {
        System.out.print("Kerro nimesi: ");
        String playeronenimi = lukija.nextLine();
        System.out.print("Entä mitä merkkiä haluat käyttää pelissä? ");
        String playeronemerkki = lukija.nextLine();
        playeronemerkki = "" + playeronemerkki.charAt(0);
        if (playeronemerkki.equals("O")) {
            System.out.print("O on tietokoneen merkki, valitse toinen ellet halua samaa merkkiä ;)  ");
            playeronemerkki = lukija.nextLine();
            playeronemerkki = "" + playeronemerkki.charAt(0);
        }

        playertwo = new CPUPelaaja("playertwo", "O", piirtaja, 2);
        playerone = new UserPelaaja(playeronenimi, playeronemerkki, piirtaja, lukija, 1);
        playertwo.asetaVastustajanMerkki(playeronemerkki);
        playerone.asetaVastustajanMerkki("O");
        run();
    }

    /**
     * Pistää pelin pyörimään
     */
    public void run() {

        tarkistusnro = 0;
        try {

            piirtaja.uusiPeli();

            piirtaja.getDatabase().uusiLista();
            piirtaja.getAlusta().getContentPane().removeAll();

            for (int i = 1; i < 8; i++) {
                piirtaja.getAlusta().getContentPane().add(new JButton("" + i));
                piirtaja.getAlusta().getContentPane().getComponent(i - 1).addMouseListener(new HiirenKuuntelija(i, this));
            }

            piirtaja.uusiPeli();

            piirtaja.getAlusta().pack();
            piirtaja.getAlusta().setVisible(true);

        } catch (IOException ex) {

        }

//        while (true) {
//            playerone.laitaMerkki(piirtaja);
//            tarkistusnro = voitonTarkistaja.tarkasta(1, piirtaja);
//            if (tarkistusnro != 0) {
//                playerone.voitti();
//                break;
//            }
//
//            playertwo.laitaMerkki(piirtaja);
//            tarkistusnro = voitonTarkistaja.tarkasta(2, piirtaja);
//            if (tarkistusnro != 0) {
//                playertwo.voitti();
//                break;
//            }
//        }
//        
//        if (playertwo.getClass().equals(playerone.getClass())) {
//            System.out.println("DINGDINGDING\nPELAAAJA " + tarkistusnro + " VOITTI!");
//            System.out.println("Pelaaja 1 voitot: " + playerone.getVoitot() + "\nPelaaja 2 voitot: " + playertwo.getVoitot());
//        } else {
//            if (tarkistusnro == 1) {
//                System.out.println("DINGDINGDING\nVOITIT PELIN");
//            } else {
//                System.out.println("DINGDINGDING\nHÄVISIT PELIN");
//            }
//            System.out.println("Pelaaja 1 voitot: " + playerone.getVoitot() + "\nTietokoneen voitot: " + playertwo.getVoitot());
//        }
//
//        tarkistusnro = 0;
//        aloita();
    }

    public ArrayList<ArrayList<Integer>> getLista() {
        return piirtaja.getDatabase().getLista();
    }

    public int getTarkistusnro() {
        return tarkistusnro;
    }

    public Pelaaja getPlayerOne() {
        return playerone;
    }

    public Pelaaja getPlayerTwo() {
        return playertwo;
    }

    public Piirtaja getPiirtaja() {
        return piirtaja;
    }

    public int getPelaajanVuoro() {
        return pelaajanvuoro;
    }

    public void setPelaajanVuoro() {
        if (pelaajanvuoro == 2) {
            pelaajanvuoro = 1;
        } else {
            pelaajanvuoro = 2;
        }
    }

    public VoitonTarkistaja getVoitonTarkistaja() {
        return voitonTarkistaja;
    }
}
