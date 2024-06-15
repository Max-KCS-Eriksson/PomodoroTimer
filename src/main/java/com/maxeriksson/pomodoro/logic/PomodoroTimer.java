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
        reset(PomodoroState.FOCUS);

        final int SECOND_IN_MILLISECONDS = 1000;
        TIMER =
                new Timer(
                        SECOND_IN_MILLISECONDS,
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                runTimer();
                            }
                        });
    }

    private void runTimer() {
        secondsLeft -= 1;
    }

    private void reset(PomodoroState state) {
        int startMinutes = 0;
        switch (state) {
            case FOCUS:
                startMinutes = 25;
                break;
            case SHORT_BREAK:
                startMinutes = 5;
                break;
            case LONG_BREAK:
                startMinutes = 15;
                break;
        }
        this.state = state;
        startSeconds = startMinutes * 60;
        secondsLeft = startSeconds;
    }

    public void start() {
        if (!TIMER.isRunning()) {
            TIMER.start();
        }
    }

    public void stop() {
        if (TIMER.isRunning()) {
            TIMER.stop();
            reset(PomodoroState.FOCUS);
        }
    }

    public String getState() {
        return state.value;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }
}
