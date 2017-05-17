import fajl.*;
import navigacio.Navigacio;
import javax.swing.*;
import GUI.*;
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
