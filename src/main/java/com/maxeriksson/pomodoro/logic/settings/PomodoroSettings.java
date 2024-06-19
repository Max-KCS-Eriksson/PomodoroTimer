package com.maxeriksson.pomodoro.logic.settings;

/** PomodoroSettings */
public class PomodoroSettings {

    private int focusMinutes;
    private int shortBreakMinutes;
    private int longBreakMinutes;

    public PomodoroSettings() {
        int defaultFocusMinutes = 25;
        setFocusMinutes(defaultFocusMinutes);
    }

    public void setFocusMinutes(int focusMinutes) {
        if (focusMinutes >= 5) {
            this.focusMinutes = focusMinutes;
            shortBreakMinutes = focusMinutes / 5;
            longBreakMinutes = shortBreakMinutes * 3;
        } else {
            throw new IllegalArgumentException("Minimum minutes focus: 5");
        }
    }

    public int getFocusMinutes() {
        return focusMinutes;
    }

    public int getShortBreakMinutes() {
        return shortBreakMinutes;
    }

    public int getLongBreakMinutes() {
        return longBreakMinutes;
    }
}
