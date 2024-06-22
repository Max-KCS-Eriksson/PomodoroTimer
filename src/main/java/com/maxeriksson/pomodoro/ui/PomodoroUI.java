package com.maxeriksson.pomodoro.ui;

import com.maxeriksson.pomodoro.logic.PomodoroTimer;
import com.maxeriksson.pomodoro.ui.panels.ControlPanel;
import com.maxeriksson.pomodoro.ui.panels.TimerPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/** PomodoroUI */
public class PomodoroUI {

    private JFrame frame;

    private TimerPanel timerPanel;
    private ControlPanel controlPanel;

    public PomodoroUI(PomodoroTimer timer) {
        frame = new JFrame("Pomodoro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setVisible(true);

        timerPanel = new TimerPanel(timer);
        controlPanel = new ControlPanel(timer);

        frame.add(timerPanel.getPanel(), BorderLayout.NORTH);
        frame.add(controlPanel.getPanel(), BorderLayout.SOUTH);
    }
}
