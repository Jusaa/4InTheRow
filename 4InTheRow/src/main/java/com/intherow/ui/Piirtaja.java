package com.intherow.ui;

import com.intherow.logiikka.Tietokanta;
import com.intherow.logiikka.HiirenKuuntelija;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Luokka hoitaa graafisen pelitoteutuksen piirtämisen
 *
 * @author Jusaa
 */
public class Piirtaja {

    private Tietokanta database;
    private JFrame alusta;
    private ImageIcon tyhjaruutu;
    private ImageIcon pelaajan1ruutu;
    private ImageIcon pelaajan2ruutu;

    public Piirtaja() {
        database = new Tietokanta();
        database.uusiLista();

        BufferedImage bufferedTyhjaruutu = null;
        BufferedImage bufferedPelaajan1ruutu = null;
        BufferedImage bufferedPelaajan2ruutu = null;
        try {
            bufferedTyhjaruutu = ImageIO.read(new File("kuvat/tyhjaruutu.png"));
            bufferedPelaajan1ruutu = ImageIO.read(new File("kuvat/pelaajan1ruutu.png"));
            bufferedPelaajan2ruutu = ImageIO.read(new File("kuvat/pelaajan2ruutu.png"));
        } catch (IOException ex) {

        }

        tyhjaruutu = new ImageIcon(bufferedTyhjaruutu);
        pelaajan1ruutu = new ImageIcon(bufferedPelaajan1ruutu);
        pelaajan2ruutu = new ImageIcon(bufferedPelaajan2ruutu);
        alusta = new JFrame("4InTheRow");
        alusta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alusta.setLayout(new GridLayout(7, 7));

    }

    /**
     * Metodi alustaa uuden pelin
     *
     * @throws IOException if MouseListener fails
     */
    public void uusiPeli() throws IOException {

        for (int i = 0; i < 42; i++) {
            alusta.getContentPane().add(new JLabel(tyhjaruutu));
        }
    }

    /**
     * Metodi lisää pelikentälle uuden merkin
     *
     * @param pylvas mihin pylvääseen merkki laitetaan
     * @param id pelaajan oma id arvo
     * @return the boolean
     */
    public boolean vuoronPiirto(int pylvas, int id) {

        if (database.lisaaListaan(pylvas, id) == false) {
            return false;
        } else {
            int ruutuId = 0;
            int nro = 6;
            for (int i = nro; i > 0; i--) {
                for (int ii = 0; ii < 7; ii++) {
                    if (database.getLista().get(ii).get(nro - 1) == 1 && id == 1) {
                        ruudunMuokkaus(ruutuId + 7, 1);
                    } else if (database.getLista().get(ii).get(nro - 1) == 2 && id == 2) {
                        ruudunMuokkaus(ruutuId + 7, 2);
                    }

                    ruutuId++;
                }
                nro--;

            }
            alusta.validate();
            return true;
        }
    }

    /**
     * Metodi piirtää menun jonka avulla pelaaja päättää miten jatketaan
     *
     * @param lukija scanner joka lukee pelaajan inputin
     * @return valinta miten jatketaan peliä
     */
    public int menuPiirto(Scanner lukija) {
        
        alusta.getContentPane().removeAll();
        alusta.add(new JButton("1"));
        alusta.pack();
        alusta.setVisible(true);
        
        
        
        
        while (true) {
            System.out.println("\n[1] Uusi yksinpeli\n[2] Uusi kaksinpeli\n[3] Uusi peli samoilla tiedoilla\n[4] Lopeta");
            String komento = lukija.nextLine();
            if (komento.equals("1")) {
                return 1;
            } else if (komento.equals("2")) {
                return 2;
            } else if (komento.equals("3")) {
                return 3;
            } else if (komento.equals("4")) {
                return 4;
            }
        }
    }

    /**
     * Metodi muuttaa graafisessa liittymässä tietyn ruudun
     *
     * @param ruutuId ruudun id numero
     * @param id pelaajan id numero
     */
    public void ruudunMuokkaus(int ruutuId, int id) {
        alusta.getContentPane().remove(ruutuId);
        if (id == 1) {
            alusta.getContentPane().add(new JLabel(pelaajan1ruutu), ruutuId);
        } else if (id == 2) {
            alusta.getContentPane().add(new JLabel(pelaajan2ruutu), ruutuId);
        }

    }

//    public void tuloksenPiirto() {
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
//    }

    public Tietokanta getDatabase() {
        return database;
    }

    public JFrame getAlusta() {
        return alusta;
    }

    public String toString() {
        return database.getLista().toString();
    }
}
