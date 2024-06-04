package com.maxeriksson.pomodoro;

import com.maxeriksson.pomodoro.ui.PomodoroUI;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new PomodoroUI();
                    }
                });
    }
}
