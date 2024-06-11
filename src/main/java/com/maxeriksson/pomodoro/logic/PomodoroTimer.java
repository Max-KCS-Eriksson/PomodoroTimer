package com.maxeriksson.pomodoro.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/** PomodoroTimer */
public class PomodoroTimer {

    private final Timer TIMER;

    private PomodoroState state;
    private int startSeconds;
    private int secondsLeft;

    public PomodoroTimer() {
        state = PomodoroState.FOCUS;
        startSeconds = 25 * 60;
        secondsLeft = startSeconds;

        final int SECOND_IN_MILLISECONDS = 1000;
        TIMER =
                new Timer(
                        SECOND_IN_MILLISECONDS,
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                secondsLeft -= 1;
                            }
                        });
    }

    public void start() {
        if (!TIMER.isRunning()) {
            TIMER.start();
        }
    }

    public String getState() {
        return state.value;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }
}
