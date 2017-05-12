package fajl;

import fajl.kepFajlok.*;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;

public class FajlNezegeto {
    static JFrame ablak = new JFrame();

    public FajlNezegeto(String file) {
        final int[] x = {600};
        final int[] y = {600};

        JPanel fajl = null;
        if (file.contains(".jpg")) {
            fajl = new JPG(file, x[0], y[0]);
        } else if (file.contains(".ico")) {
            fajl = new Ikon.megnyit(file, x[0], y[0]);
        }

        ablak.add(fajl);
        ablak.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                x[0] = ablak.getWidth();
                y[0] = ablak.getHeight();
                ablak.add(new JPG(file, x[0], y[0]));

            }
        });
        init();
    }

    private static void init() {
        ablak.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ablak.setSize(ablak.getPreferredSize());
        ablak.setVisible(true);
    }
}
