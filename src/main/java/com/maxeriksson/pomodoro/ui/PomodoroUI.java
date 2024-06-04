package com.maxeriksson.pomodoro.ui;

import com.maxeriksson.pomodoro.ui.panels.TimerPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/** PomodoroUI */
public class PomodoroUI {

    private JFrame frame;

    private TimerPanel timerPanel;

    public PomodoroUI() {
        frame = new JFrame("Pomodoro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        timerPanel = new TimerPanel();

        frame.add(timerPanel.getPanel(), BorderLayout.NORTH);
    }
}
