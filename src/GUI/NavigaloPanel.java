package GUI;

import fajl.FajlAdatok;
import fajl.FajlLista;
import navigacio.Navigacio;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class NavigaloPanel {

    public FajlLista fajlLista = new FajlLista(new File("C:\\"));
    ArrayList<JList<String>> lista = new ArrayList<>();
    JPanel fajlok = new JPanel(new GridLayout(1, 4));
    JPanel fejLec = new JPanel(new GridLayout(1, 2));
    private ArrayList<DefaultListModel<String>> model = new ArrayList<DefaultListModel<String>>() {
        {
            add(new DefaultListModel<>());
            add(new DefaultListModel<>());
            add(new DefaultListModel<>());
            add(new DefaultListModel<>());
        }
    };
    private JComboBox<String> particio = new JComboBox<>();
    private JLabel aktualisMappa = new JLabel();

    NavigaloPanel() {
        for (File j : File.listRoots())
            if (!FileSystemView.getFileSystemView().getSystemDisplayName(j).equals(""))
                particio.addItem(FileSystemView.getFileSystemView().getSystemDisplayName(j));
        aktualisMappa.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        particio.addActionListener(e -> {
            fajlLista.frissit(File.listRoots()[particio.getSelectedIndex()]);
            Ablak.fokuszbanVan.fajlLista.frissit(Ablak.fokuszbanVan.fajlLista.helyzet);
            Ablak.nincsFokuszban.fajlLista.frissit(Ablak.nincsFokuszban.fajlLista.helyzet);
        });
        fejLec.add(particio);
        fejLec.add(aktualisMappa);

        fajlok.setBorder(BorderFactory.createLoweredBevelBorder());
        frissit();
        for (DefaultListModel<String> i : model)
            lista.add(new JList<>(i));

        lista.get(0).setFixedCellWidth(100);
        lista.get(1).setFixedCellWidth(1);
        lista.get(2).setFixedCellWidth(20);
        lista.get(3).setFixedCellWidth(20);

        for (int i = 0; i < 4; ++i) {
            lista.get(i).setFixedCellHeight(20);
            lista.get(i).addMouseListener(this.new AkcioKezelo());
            lista.get(i).addKeyListener(new GombLenyomasKezelo());
            fajlok.add(lista.get(i));
        }

    }

    NavigaloPanel getOuter() {
        return this;
    }

    void novelo(JList<String> kimarad) {

        for (JList<String> i : lista) {
            if (!i.equals(kimarad))
                i.setSelectedIndex(kimarad.getSelectedIndex() + 1);
        }
    }

    void csokkento(JList<String> kimarad) {

        for (JList<String> i : lista) {
            if (!i.equals(kimarad)) {
                if (kimarad.getSelectedIndex() >= 0)
                    i.setSelectedIndex(kimarad.getSelectedIndex() - 1);
                else
                    i.setSelectedIndex(kimarad.getLastVisibleIndex());
            }
        }
    }

    public void frissit() {
        for (DefaultListModel<String> i : model) {
            i.removeAllElements();
        }
        boolean elso = true;

        for (File j : fajlLista.lista) {
            if (elso && fajlLista.os != null) {
                model.get(0).addElement("[ .. ]");
                model.get(1).addElement("");
                model.get(2).addElement("");
                model.get(3).addElement("");
                elso = false;
            } else {
                model.get(0).addElement(FajlAdatok.getNev(j));
                model.get(1).addElement(FajlAdatok.getKiterjesztes(j));
                model.get(2).addElement(FajlAdatok.getMeret(j));
                model.get(3).addElement(FajlAdatok.getDatum(j));
            }
        }
        aktualisMappa.setText(fajlLista.helyzet.getAbsolutePath());
    }

    class AkcioKezelo extends MouseAdapter {
        public void mouseReleased(MouseEvent e) {
            if (e.getSource() instanceof JList) {
                if (Ablak.fokuszbanVan != getOuter())
                    Ablak.fokuszValtas();
                JList<String> tempList = (JList<String>) (e.getSource());
                for (JList<String> j : lista) {
                    j.setSelectedIndex(tempList.getSelectedIndex());
                }
                for (JList<String> j : Ablak.nincsFokuszban.lista) {
                    j.clearSelection();
                }
                if (e.getClickCount() == 2) {
                    Navigacio.interakcio(Ablak.fokuszbanVan.fajlLista.lista.get(tempList.getSelectedIndex()));
                    frissit();
                }
            }
        }

    }

}
