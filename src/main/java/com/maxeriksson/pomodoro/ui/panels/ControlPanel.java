package com.maxeriksson.pomodoro.ui.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

/** ControlPanel */
public class ControlPanel {

    private JPanel panel;

    private JButton startButton;

    public ControlPanel() {
        panel = new JPanel();

        startButton = new JButton("Start");

        panel.add(startButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
