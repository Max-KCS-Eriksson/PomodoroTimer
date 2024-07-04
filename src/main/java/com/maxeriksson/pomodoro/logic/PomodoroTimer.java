package com.maxeriksson.pomodoro.logic;

import com.maxeriksson.pomodoro.logic.settings.PomodoroSettings;
import com.maxeriksson.pomodoro.notifications.Notifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/** PomodoroTimer */
public class PomodoroTimer {

    private final Timer TIMER;
    private final Notifier NOTIFIER;

    private PomodoroSettings pomodoroSettings;
    private PomodoroState state;
    private final int NUM_OF_SETS;
    private int focusBreakSet;
    private int startSeconds;
    private int secondsLeft;

    public PomodoroTimer(PomodoroSettings pomodoroSettings) {
        this.pomodoroSettings = pomodoroSettings;
        reset(PomodoroState.FOCUS);
        NUM_OF_SETS = 4;
        focusBreakSet = 0;

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

        NOTIFIER = new Notifier();
    }

    private void runTimer() {
        if (secondsLeft > 0) {
            secondsLeft -= 1;
            if (secondsLeft == (startSeconds / PomodoroSettings.MIN_FOCUS_MINUTES)) {
                NOTIFIER.timeAlmostUp();
            }
        } else {
            determineNextState();
            TIMER.stop();
            NOTIFIER.timeIsUp();
        }
    }

    private void determineNextState() {
        if (state != PomodoroState.FOCUS) {
            reset(PomodoroState.FOCUS);
        } else {
            if (focusBreakSet < NUM_OF_SETS) {
                reset(PomodoroState.SHORT_BREAK);
            } else {
                reset(PomodoroState.LONG_BREAK);
            }
        }
    }

    private void reset(PomodoroState state) {
        int startMinutes = 0;
        switch (state) {
            case FOCUS:
                startMinutes = pomodoroSettings.getFocusMinutes();
                break;
            case SHORT_BREAK:
                startMinutes = pomodoroSettings.getShortBreakMinutes();
                focusBreakSet += 1;
                break;
            case LONG_BREAK:
                startMinutes = pomodoroSettings.getLongBreakMinutes();
                focusBreakSet = 0;
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

    public void pause() {
        if (TIMER.isRunning()) {
            TIMER.stop();
        }
    }

    public void stop() {
        if (TIMER.isRunning()) {
            TIMER.stop();
        }
        reset(PomodoroState.FOCUS);
    }

    public String getState() {
        return state.value;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public PomodoroSettings getSettings() {
        return pomodoroSettings;
    }

    public void updateSettings() {
        reset(state);
    }
}
