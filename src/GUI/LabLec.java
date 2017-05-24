package GUI;

import fajl.Operaciok;
import navigacio.Navigacio;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

class LabLec extends JPanel {

    static JButton F3 = new JButton("F3 Nézőke");
    static JButton F5 = new JButton("F5 Másolás ");
    static JButton F6 = new JButton("F6 Áthelyez");
    static JButton F7 = new JButton("F7 Új mappa");
    static JButton F8 = new JButton("F8 Törlés");
    static JButton F1 = new JButton("F1 Ablak váltás");

    LabLec() {
        setLayout(new GridLayout(1, 5));
        setMinimumSize(new Dimension(400, 50));

        add(F1);
        add(F3);
        add(F5);
        add(F6);
        add(F7);
        add(F8);

        F3.addActionListener(e -> {

            try {
                Navigacio.interakcio((Ablak.fokuszbanVan.fajlLista.lista
                        .get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex())));
            } catch (Exception e1) {
            }
            Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
            Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

            Ablak.fokuszbanVan.fajlok.transferFocus();
        });

        F5.addActionListener(e -> {
            try {
                Operaciok.masol(
                        Paths.get(Ablak.fokuszbanVan.fajlLista.lista
                                .get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()),
                        Paths.get(Ablak.nincsFokuszban.fajlLista.helyzet.getAbsolutePath()));
                Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
                Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

                Ablak.fokuszbanVan.fajlok.transferFocus();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "File másolása közbeni hiba!", "Hiba",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        F6.addActionListener(e -> {
            try {
                Operaciok.athelyez(
                        Paths.get(Ablak.fokuszbanVan.fajlLista.lista
                                .get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()),
                        Paths.get(Ablak.nincsFokuszban.fajlLista.helyzet.getAbsolutePath()));
                Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
                Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

                Ablak.fokuszbanVan.fajlok.transferFocus();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "File áthelyez közbeni hiba!", "Hiba",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        F8.addActionListener(e -> {
            try {
                int hibaUzenet = JOptionPane.showConfirmDialog(null,
                        "Biztos ki szeretné törölni a \"" + Ablak.fokuszbanVan.fajlLista.lista
                                .get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getName() + "\" nevű elemet?",
                        "Törlés", JOptionPane.YES_NO_OPTION);
                if (hibaUzenet == JOptionPane.YES_OPTION) {
                    Operaciok.torol(Paths.get(Ablak.fokuszbanVan.fajlLista.lista
                            .get(Ablak.fokuszbanVan.lista.get(0).getSelectedIndex()).getAbsolutePath()));
                    Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
                    Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);

                    Ablak.fokuszbanVan.fajlok.transferFocus();
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "File törlés közbeni hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
            }
        });

        F7.addActionListener(e -> {
            try {
                String nev = JOptionPane.showInputDialog(null, "Az új mappa neve", "Új mappa", JOptionPane.QUESTION_MESSAGE);
                if (nev != null) {
                    Operaciok.ujMappa(
                            Paths.get(Ablak.fokuszbanVan.fajlLista.helyzet.getAbsolutePath() + "\\" + nev));
                    Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
                    Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
                    Ablak.fokuszbanVan.fajlok.transferFocus();
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Új mappa létrhezása közbeni hiba!", "Hiba",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        F1.addActionListener(e -> {
            Ablak.fokuszValtas();
            Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
            Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
            for (JList<String> i : Ablak.fokuszbanVan.lista)
                i.setSelectedIndex(0);
            Ablak.fokuszbanVan.fajlok.transferFocus();
        });
    }

}
