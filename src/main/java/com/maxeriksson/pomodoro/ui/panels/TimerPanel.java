package com.maxeriksson.pomodoro.ui.panels;

import com.maxeriksson.pomodoro.logic.PomodoroTimer;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/** TimerPanel */
public class TimerPanel {

    private JPanel panel;

    private PomodoroTimer timer;
    private JLabel stateLabel;
    private JLabel timerLabel;

    public TimerPanel() {
        panel = new JPanel(new GridLayout(2, 1, 0, 25));

        timer = new PomodoroTimer();
        stateLabel = new JLabel();
        timerLabel = new JLabel();
        stateLabel.setText(timer.getState());
        timerLabel.setText(formatSecondsToClock(timer.getSecondsLeft()));

        stateLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(stateLabel);
        panel.add(timerLabel);
    }

    private String formatSecondsToClock(int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;

        final String FMT = "%02d";
        return new StringBuilder()
                .append(String.format(FMT, minutes))
                .append(':')
                .append(String.format(FMT, seconds))
                .toString();
    }

    public JPanel getPanel() {
        return panel;
    }
}
