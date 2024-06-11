package com.maxeriksson.pomodoro.ui.panels;

import com.maxeriksson.pomodoro.logic.PomodoroTimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/** ControlPanel */
public class ControlPanel implements ActionListener {

    private JPanel panel;

    private PomodoroTimer timer;
    private JButton startButton;
    private JButton stopButton;

    public ControlPanel(PomodoroTimer timer) {
        panel = new JPanel();

        this.timer = timer;
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        panel.add(startButton);
        panel.add(stopButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
        } else if (e.getSource() == stopButton) {
            timer.stop();
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
