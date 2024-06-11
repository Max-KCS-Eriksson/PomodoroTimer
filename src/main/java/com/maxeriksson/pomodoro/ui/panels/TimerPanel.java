package com.maxeriksson.pomodoro.ui.panels;

import com.maxeriksson.pomodoro.logic.PomodoroTimer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/** TimerPanel */
public class TimerPanel {

    private JPanel panel;

    private PomodoroTimer timer;
    private JLabel stateLabel;
    private JLabel timerLabel;

    public TimerPanel(PomodoroTimer timer) {
        panel = new JPanel(new GridLayout(2, 1, 0, 25));

        this.timer = timer;
        stateLabel = new JLabel();
        timerLabel = new JLabel();
        setTimerLabelTexts(timer);

        stateLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(stateLabel);
        panel.add(timerLabel);

        refreshingPanel();
    }

    private void setTimerLabelTexts(PomodoroTimer timer) {
        stateLabel.setText(timer.getState());
        timerLabel.setText(formatSecondsToClock(timer.getSecondsLeft()));
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

    private void refreshingPanel() {
        final int SECOND_IN_MILLISECONDS = 1000;
        Timer panelRefresher =
                new Timer(
                        SECOND_IN_MILLISECONDS,
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                setTimerLabelTexts(timer);
                            }
                        });
        panelRefresher.start();
    }

    public JPanel getPanel() {
        return panel;
    }
}
