package GUI;

import fajl.FajlNezegeto;
import fajl.Operaciok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.nio.file.Paths;

/**
 * Created by FANNI on 2017.05.16..
 */
class LabLec extends JPanel {

    static JButton F3 = new JButton("F3 Nézőke");
    static JButton F5 = new JButton("F5 Másolás ");
    static JButton F6 = new JButton("F6 Áthelyez");
    static JButton F7 = new JButton("F7 Új mappa");
    static JButton F8 = new JButton("F8 Törlés");
    static JButton TAB = new JButton("TAB");
    private JPanel labLec = new JPanel();


    LabLec() {
        setLayout(new GridLayout(1, 5));
        setMinimumSize(new Dimension(400, 50));
        add(F3);
        add(F5);
        add(F6);
        add(F7);
        add(F8);
        add(TAB);

        F3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FajlNezegeto(Ablak.fokuszbanVan.helyzet.getAbsolutePath());
            }
        });
        F5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Operaciok.masol(Paths.get(Ablak.fokuszbanVan.lista.get(Ablak.fokuszbanVan.aktualisFajl).getAbsolutePath()), Paths.get(Ablak.nincsFokuszban.helyzet.getAbsolutePath()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "File másolása közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        F6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Operaciok.athelyez(Paths.get(Ablak.fokuszbanVan.lista.get(Ablak.fokuszbanVan.aktualisFajl).getAbsolutePath()), Paths.get(Ablak.nincsFokuszban.helyzet.getAbsolutePath()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "File áthelyez közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        F8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Operaciok.torol(Paths.get(Ablak.fokuszbanVan.lista.get(Ablak.fokuszbanVan.aktualisFajl).getAbsolutePath()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "File törlés közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        F7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String[] nev = new String[1];
                JFrame frameUjMappa = new JFrame();
                frameUjMappa.setLayout(new GridLayout(1, 3));
                frameUjMappa.setSize(400, 80);
                JLabel ujmappa = new JLabel("Új mappa neve: ");
                JTextField mappaNev = new JTextField();
                JButton ok = new JButton("OK");
                frameUjMappa.add(ujmappa);
                frameUjMappa.add(mappaNev);
                frameUjMappa.add(ok);
                frameUjMappa.setVisible(true);
                ok.addActionListener(lambda -> {
                    nev[0] = mappaNev.getText();
                    frameUjMappa.dispatchEvent(new WindowEvent(frameUjMappa, WindowEvent.WINDOW_CLOSING));
                    try {
                        Operaciok.ujMappa(Paths.get(Ablak.fokuszbanVan.helyzet.getAbsolutePath() + "\\" + nev[0]));
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Új mappa létrhezása közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
                    }
                });

            }
        });

        TAB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ablak.fokuszValtas();
            }
        });
    }

}
