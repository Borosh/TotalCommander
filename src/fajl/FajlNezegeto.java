package fajl;

import fajl.kepFajlok.*;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;

public class FajlNezegeto {
    JFrame ablak = new JFrame();

    public FajlNezegeto(File file) {
        final int[] x = {600};
        final int[] y = {600};
        ablak.add(JPG.megnyit(file, x[0], y[0]));
        ablak.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                x[0] = ablak.getWidth();
                y[0] = ablak.getHeight();
                ablak.add(JPG.megnyit(file, x[0], y[0]));

            }
        });
        init();
    }

    private void init() {
        ablak.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ablak.setSize(ablak.getPreferredSize());
        ablak.setVisible(true);
    }
}
