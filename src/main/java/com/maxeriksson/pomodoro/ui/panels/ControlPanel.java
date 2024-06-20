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
    private JButton pauseButton;
    private JButton stopButton;

    public ControlPanel(PomodoroTimer timer) {
        panel = new JPanel();

        this.timer = timer;
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");
        startButton.addActionListener(this);
        pauseButton.addActionListener(this);
        stopButton.addActionListener(this);

        pauseButton.setVisible(false);

        panel.add(startButton);
        panel.add(pauseButton);
        panel.add(stopButton);
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
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
