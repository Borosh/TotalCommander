import fajl.FajlAdatok;
import fajl.FajlLista;
import fajl.Operaciok;
import navigacio.Navigacio;

import javax.swing.*;
import java.io.File;
import java.nio.file.Paths;

public class Main {

    private static FajlLista balLista = new FajlLista(new File("C:\\"));

    public static void main(String[] args) throws Exception {
        Navigacio.belelep(new File("C:\\Users"), balLista);
        Navigacio.belelep(new File("C:\\Users\\Boros"), balLista);
        Navigacio.belelep(new File("C:\\Users\\Boros\\Downloads"), balLista);
        for (File i : balLista.lista) {
            FajlAdatok.getAdatok(i, balLista);
        }

        try {
            Operaciok.ujMappa(Paths.get(balLista.helyzet.getAbsolutePath() + "\\mappa1"));
            Operaciok.ujMappa(Paths.get(balLista.helyzet.getAbsolutePath() + "\\mappa2"));
            Operaciok.torol(Paths.get(balLista.helyzet.getAbsolutePath() + "\\mappa1"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);

        }

    }
}
