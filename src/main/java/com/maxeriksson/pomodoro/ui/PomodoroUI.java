package com.maxeriksson.pomodoro.ui;

import com.maxeriksson.pomodoro.ui.panels.ControlPanel;
import com.maxeriksson.pomodoro.ui.panels.TimerPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/** PomodoroUI */
public class PomodoroUI {

    private JFrame frame;

    private TimerPanel timerPanel;
    private ControlPanel controlPanel;

    public PomodoroUI() {
        frame = new JFrame("Pomodoro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        timerPanel = new TimerPanel();
        controlPanel = new ControlPanel();

        frame.add(timerPanel.getPanel(), BorderLayout.NORTH);
        frame.add(controlPanel.getPanel(), BorderLayout.SOUTH);
    }
}
