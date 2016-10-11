package com.intherow.ui;

import com.intherow.logiikka.Tietokanta;
import com.intherow.logiikka.HiirenKuuntelija;
import com.intherow.logiikka.Peli;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Luokka hoitaa graafisen pelitoteutuksen piirtämisen.
 *
 * @author Jusaa
 */
public class Piirtaja {

    private Tietokanta tietokanta;
    private JFrame alusta;
    private Peli peli;
    private Kuvantuoja kuvantuoja;

    /**
     * Konstruktori piirtajalle.
     *
     * @param peli
     */
    public Piirtaja(Peli peli) {
        tietokanta = new Tietokanta();
        tietokanta.uusiLista();
        this.peli = peli;
        kuvantuoja = new Kuvantuoja();

        alusta = new JFrame("4InTheRow");
        alusta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alusta.setLayout(new GridLayout(2, 1));
        alusta.setPreferredSize(new Dimension(350, 350));
        alusta.setResizable(false);
    }

    /**
     * Metodi alustaa uuden pelin.
     *
     * @throws IOException if MouseListener fails
     */
    public void uusiPeli() throws IOException {

        alusta.getContentPane().removeAll();
        alusta.setLayout(new GridLayout(7, 7));
        alusta.getContentPane().add(new JButton(kuvantuoja.getImageIcon(3))).addMouseListener(new HiirenKuuntelija(1, peli));
        alusta.getContentPane().add(new JButton(kuvantuoja.getImageIcon(4))).addMouseListener(new HiirenKuuntelija(2, peli));
        alusta.getContentPane().add(new JButton(kuvantuoja.getImageIcon(5))).addMouseListener(new HiirenKuuntelija(3, peli));
        alusta.getContentPane().add(new JButton(kuvantuoja.getImageIcon(6))).addMouseListener(new HiirenKuuntelija(4, peli));
        alusta.getContentPane().add(new JButton(kuvantuoja.getImageIcon(7))).addMouseListener(new HiirenKuuntelija(5, peli));
        alusta.getContentPane().add(new JButton(kuvantuoja.getImageIcon(8))).addMouseListener(new HiirenKuuntelija(6, peli));
        alusta.getContentPane().add(new JButton(kuvantuoja.getImageIcon(9))).addMouseListener(new HiirenKuuntelija(7, peli));

        for (int i = 0; i < 42; i++) {
            alusta.getContentPane().add(new JLabel(kuvantuoja.getImageIcon(0)));
        }
        alusta.pack();
        alusta.validate();
        alusta.setVisible(true);
    }

    /**
     * Metodi lisää pelikentälle uuden merkin.
     *
     * @param pylvas mihin pylvääseen merkki laitetaan
     * @param id pelaajan oma id arvo
     * @return the boolean
     */
    public boolean vuoronPiirto(int pylvas, int id) {

        if (tietokanta.lisaaListaan(pylvas, id) == false) {
            return false;
        } else {
            int ruutuId = 0;
            int nro = 6;
            for (int i = nro; i > 0; i--) {
                for (int ii = 0; ii < 7; ii++) {
                    if (tietokanta.getLista().get(ii).get(nro - 1) == 1 && id == 1) {
                        ruudunMuokkaus(ruutuId + 7, 1);
                    } else if (tietokanta.getLista().get(ii).get(nro - 1) == 2 && id == 2) {
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
     * Metodi piirtää menun jonka avulla pelaaja päättää miten aloitetaan.
     */
    public void aloitusMenunPiirto() {

        alusta.getContentPane().removeAll();
        JButton nappi = new JButton(kuvantuoja.getImageIcon(10));
        nappi.addMouseListener(new HiirenKuuntelija(11, peli));
        alusta.getContentPane().add(nappi);
        nappi = new JButton(kuvantuoja.getImageIcon(11));
        nappi.addMouseListener(new HiirenKuuntelija(12, peli));
        alusta.getContentPane().add(nappi);
        alusta.pack();
        alusta.setVisible(true);
    }

    /**
     * Metodi piirtää menun jonka avulla pelaaja päättää miten jatketaan.
     */
    public void valiMenunPiirto() {

        alusta.getContentPane().removeAll();
        alusta.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton yksinpeli = new JButton("Uusi yksinpeli");
        yksinpeli.addMouseListener(new HiirenKuuntelija(11, peli));
        JButton kaksinpeli = new JButton("Uusi kaksinpeli");
        kaksinpeli.addMouseListener(new HiirenKuuntelija(12, peli));
        JButton uusipeli = new JButton("Jatka samoilla");
        uusipeli.addMouseListener(new HiirenKuuntelija(13, peli));
        gbc.gridy = 0;
        alusta.add(yksinpeli, gbc);
        gbc.gridy = 1;
        alusta.add(kaksinpeli, gbc);
        gbc.gridy = 2;
        alusta.add(uusipeli, gbc);
        alusta.pack();
        alusta.setVisible(true);
    }

    /**
     * Piirtää pelin loputtua tulokset.
     *
     * @param voittaja kertoo kumpi pelaajista voitti
     */
    public void tuloksenPiirto(int voittaja) {
        
        JButton voittajanTeksti;
        if (voittaja == 1) {
            voittajanTeksti = new JButton("Pelaaja 1 voitti, paina tästä jatkaaksesi");
        } else if (voittaja == 2) {
            voittajanTeksti = new JButton("Pelaaja 2 voitti, paina tästä jatkaaksesi");
        } else {
            voittajanTeksti = new JButton("Tasapeli, paina tästä jatkaaksesi");
        }
        alusta.getContentPane().removeAll();
        alusta.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.weighty = 1;

        voittajanTeksti.addMouseListener(new HiirenKuuntelija(20, peli));
        alusta.add(voittajanTeksti, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;
        gbc.weighty = 0;
        alusta.add(new JLabel("Voitot:"), gbc);
        gbc.gridy = 2;
        alusta.add(new JLabel(" Pelaaja 1: " + peli.getPelaajaYksi().getVoitot()), gbc);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 25, 0);
        alusta.add(new JLabel(" Pelaaja 2: " + peli.getPelaajaKaksi().getVoitot()), gbc);
        alusta.validate();

    }

    /**
     * Metodi muuttaa graafisessa liittymässä tietyn ruudun.
     *
     * @param ruutuId ruudun id numero
     * @param id pelaajan id numero
     */
    public void ruudunMuokkaus(int ruutuId, int id) {
        alusta.getContentPane().remove(ruutuId);
        if (id == 1) {
            alusta.getContentPane().add(new JLabel(kuvantuoja.getImageIcon(1)), ruutuId);
        } else if (id == 2) {
            alusta.getContentPane().add(new JLabel(kuvantuoja.getImageIcon(2)), ruutuId);
        }
    }

    public Tietokanta getTietokanta() {
        return tietokanta;
    }

    public JFrame getAlusta() {
        return alusta;
    }
}
