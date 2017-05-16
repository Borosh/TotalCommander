package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DynamicPanelList {


    public static void main(String[] args) {
        new DynamicPanelList();
    }

    public DynamicPanelList() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame();


            }
        });
    }

    public static class TestPane extends JPanel {

        private JPanel mainList;

        public TestPane(int meret, String fajl) {
            setLayout(new BorderLayout());

            mainList = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.weighty = 1;
            mainList.add(new JPanel(), gbc);

            DefaultListModel<String> model = new DefaultListModel<>();
            DefaultListModel<String> model1 = new DefaultListModel<>();
            DefaultListModel<String> model2 = new DefaultListModel<>();
            DefaultListModel<String> model3 = new DefaultListModel<>();


            JLabel fajlnev = new JLabel("Fajlnev");
            String vmi = "Teszt szövegggggggggggggggggggggggggggggggggggggggggggggggg";
            final int[] hanyszor = {0};

            JPanel egySor = new JPanel(new GridLayout(1, 4));
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model.addElement(vmi);
            model1.addElement(vmi);
            model2.addElement(vmi);
            model3.addElement(vmi);
            JList<String> lista = new JList<>(model);
            JList<String> lista1 = new JList<>(model1);
            JList<String> lista2 = new JList<>(model2);
            JList<String> lista3 = new JList<>(model3);
            lista.setFixedCellWidth(5);
            lista1.setFixedCellWidth(5);
            lista2.setFixedCellWidth(5);
            lista3.setFixedCellWidth(5);
            egySor.add(lista);
            egySor.add(lista1);
            egySor.add(lista2);
            egySor.add(lista3);
            JScrollPane csuszka = new JScrollPane(egySor);
            add(csuszka);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

/*    public static void mouseClicked(MouseEvent event){
        if(event.getClickCount() == 2){
            fajlnev.setText("katt");
        }
    }*/
}