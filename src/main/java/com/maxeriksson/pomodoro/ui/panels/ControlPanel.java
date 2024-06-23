package com.maxeriksson.pomodoro.ui.panels;

import com.maxeriksson.pomodoro.logic.PomodoroTimer;
import com.maxeriksson.pomodoro.ui.dialogs.TimerSettings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/** ControlPanel */
public class ControlPanel implements ActionListener {

    private JPanel panel;

    private PomodoroTimer timer;
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JButton settingsButton;

    public ControlPanel(PomodoroTimer timer) {
        panel = new JPanel();

        this.timer = timer;
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");
        settingsButton = new JButton("Settings");
        startButton.addActionListener(this);
        pauseButton.addActionListener(this);
        stopButton.addActionListener(this);
        settingsButton.addActionListener(this);

        pauseButton.setVisible(false);

        panel.add(startButton);
        panel.add(pauseButton);
        panel.add(stopButton);
        panel.add(settingsButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
            startButton.setVisible(false);
            pauseButton.setVisible(true);
        } else if (e.getSource() == pauseButton) {
            timer.pause();
            startButton.setVisible(true);
            pauseButton.setVisible(false);
        } else if (e.getSource() == stopButton) {
            timer.stop();
        } else if (e.getSource() == settingsButton) {
            new TimerSettings(timer);
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
