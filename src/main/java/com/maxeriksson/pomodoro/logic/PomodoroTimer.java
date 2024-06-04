package com.maxeriksson.pomodoro.logic;

/** PomodoroTimer */
public class PomodoroTimer {

    private PomodoroState state;
    private int secondsLeft;

    public PomodoroTimer() {
        state = PomodoroState.FOCUS;
        secondsLeft = 25 * 60;
    }

    public String getState() {
        return state.value;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }
}
