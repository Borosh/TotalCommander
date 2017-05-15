import fajl.FajlAdatok;
import fajl.FajlLista;

import java.io.File;

public class Main {

    private static FajlLista balLista = new FajlLista(new File("C:\\"));

    public static void main(String[] args) {
        for (File i : balLista.lista) {
            FajlAdatok.getAdatok(i, balLista);
        }
    }
}
