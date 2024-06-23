package com.maxeriksson.pomodoro.logic.settings;

/** PomodoroSettings */
public class PomodoroSettings {

    /**
     * The minimum required length of the focus interval to ensure the break intervals are greater
     * than 0 minutes.
     */
    public static final int MIN_FOCUS_MINUTES = 5;

    private int focusMinutes;
    private int shortBreakMinutes;
    private int longBreakMinutes;

    public PomodoroSettings() {
        int defaultFocusMinutes = 25; // As per the Pomodoro technique
        setFocusMinutes(defaultFocusMinutes);
    }

    /**
     * Sets length of all other time intervals, in relation to given argument, as per the Pomodoro
     * technique:
     *
     * <ul>
     *   <li>The short break is a fifth the length of the focus interval. <br>
     *   <li>The long break is tree times the length of the short break interval.
     *
     * @param focusMinutes min accepted value: 5 <br>
     *     This is to ensure the break intervals are greater than 0.
     */
    public void setFocusMinutes(int focusMinutes) {
        if (focusMinutes >= MIN_FOCUS_MINUTES) {
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
