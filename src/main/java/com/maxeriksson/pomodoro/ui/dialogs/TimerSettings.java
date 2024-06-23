package com.maxeriksson.pomodoro.ui.dialogs;

import com.maxeriksson.pomodoro.logic.PomodoroTimer;
import com.maxeriksson.pomodoro.logic.settings.PomodoroSettings;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

/** TimerSettings */
public class TimerSettings implements ActionListener {

    private JDialog dialog;

    private PomodoroTimer timer;
    private PomodoroSettings settings;

    private JLabel heading;
    private JLabel infoLabel;

    private JPanel timePanel;
    private JLabel focusMinutesLabel;
    private JLabel shortBreakMinutesLabel;
    private JLabel longBreakMinutesLabel;

    private BasicArrowButton increaseFocusMinutes;
    private BasicArrowButton decreaseFocusMinutes;

    public TimerSettings(PomodoroTimer timer) {
        dialog = new JDialog();
        dialog.setTitle("PomodoroSettings");
        dialog.setLocationRelativeTo(null);
        dialog.setMinimumSize(new Dimension(400, 400));
        dialog.setVisible(true);

        this.timer = timer;
        settings = timer.getSettings();

        heading = new JLabel("Timer settings");

        timePanel = new JPanel(new GridLayout(4, 1, 0, 0));
        infoLabel = new JLabel();
        focusMinutesLabel = new JLabel();
        shortBreakMinutesLabel = new JLabel();
        longBreakMinutesLabel = new JLabel();
        populateTimePanel();

        JPanel controls = new JPanel();
        increaseFocusMinutes = new BasicArrowButton(BasicArrowButton.NORTH);
        decreaseFocusMinutes = new BasicArrowButton(BasicArrowButton.SOUTH);
        increaseFocusMinutes.addActionListener(this);
        decreaseFocusMinutes.addActionListener(this);
        controls.add(increaseFocusMinutes);
        controls.add(decreaseFocusMinutes);

        heading.setHorizontalAlignment(JLabel.CENTER);
        focusMinutesLabel.setHorizontalAlignment(JLabel.CENTER);

        dialog.add(heading, BorderLayout.NORTH);
        dialog.add(timePanel, BorderLayout.CENTER);
        dialog.add(controls, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int focusMinutes = settings.getFocusMinutes();
        if (event.getSource() == increaseFocusMinutes) {
            focusMinutes += 5;
        } else if (event.getSource() == decreaseFocusMinutes) {
            focusMinutes -= 5;
        }

        boolean exception = false;
        try {
            settings.setFocusMinutes(focusMinutes);
        } catch (IllegalArgumentException e) {
            infoLabel.setText("Minimum minutes focus: 5");
            exception = true;
        }
        if (!exception) {
            populateTimePanel();
        }
    }

    private void populateTimePanel() {
        infoLabel.setText("Increase/Decrease focus time");

        focusMinutesLabel.setText("Focus: " + settings.getFocusMinutes() + " minutes");
        shortBreakMinutesLabel.setText(
                "Short break: " + settings.getShortBreakMinutes() + " minutes");
        longBreakMinutesLabel.setText("Long break: " + settings.getLongBreakMinutes() + " minutes");

        infoLabel.setHorizontalAlignment(JLabel.CENTER);
        focusMinutesLabel.setHorizontalAlignment(JLabel.CENTER);
        shortBreakMinutesLabel.setHorizontalAlignment(JLabel.CENTER);
        longBreakMinutesLabel.setHorizontalAlignment(JLabel.CENTER);

        timePanel.add(infoLabel);
        timePanel.add(focusMinutesLabel);
        timePanel.add(shortBreakMinutesLabel);
        timePanel.add(longBreakMinutesLabel);
    }
}
