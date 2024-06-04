package com.maxeriksson.pomodoro.logic;

/** PomodoroState */
public enum PomodoroState {
    FOCUS("FOCUS"),
    SHORT_BREAK("SHORT BREAK"),
    LONG_BREAK("LONG BREAK");

    public final String value;

    private PomodoroState(String value) {
        this.value = value;
    }
}
