import GUI.Ablak;
import fajl.FajlAdatok;
import fajl.FajlLista;
import navigacio.Navigacio;

import javax.swing.*;
import java.io.File;

public class Main {
    private static FajlLista balLista = new FajlLista(new File("C:\\"));
    public static JFrame ablak = new Ablak("Total Commander");

    public static void main(String[] args) throws Exception {
        Navigacio.belelep(new File("C:\\"), balLista);
        for (File i : balLista.lista) {
            FajlAdatok.getAdatok(i, balLista);
        }

        try {
            System.out.println();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
        }
    }
}
