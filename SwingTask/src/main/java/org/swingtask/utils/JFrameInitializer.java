package org.swingtask.utils;

import org.swingtask.forms.SortApp;

import javax.swing.*;
import java.awt.*;

public class JFrameInitializer {

    public static void initialize() {
        JFrame jFrame = new JFrame("SortApp");
        jFrame.setContentPane(new SortApp().getPanelMain());
        jFrame.setPreferredSize(new Dimension(500, 200));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}
