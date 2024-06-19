package com.maxeriksson.pomodoro;

import com.maxeriksson.pomodoro.logic.PomodoroTimer;
import com.maxeriksson.pomodoro.ui.PomodoroUI;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        PomodoroTimer timer = new PomodoroTimer();
                        new PomodoroUI(timer);
                    }
                });
    }
}
