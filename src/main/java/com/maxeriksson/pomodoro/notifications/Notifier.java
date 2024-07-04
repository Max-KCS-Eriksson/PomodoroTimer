package com.maxeriksson.pomodoro.notifications;

import java.awt.SystemTray;
import java.io.IOException;

/** Notifier */
public class Notifier {

    private final SupportedOS OS;

    public Notifier() {
        String osName = System.getProperty("os.name");
        if (osName.contains("Linux")) {
            OS = SupportedOS.LINUX;
        } else if (osName.contains("Mac")) {
            OS = SupportedOS.MAC_OS;
        } else if (SystemTray.isSupported()) {
            OS = SupportedOS.WINDOWS;
        } else {
            throw new UnsupportedOperationException("OS not supported: " + osName);
        }
    }

    public void timeAlmostUp() {
        String message = "Time is almost up";
        notification(message);
    }

    public void timeIsUp() {
        String message = "Time is up";
        notification(message);
    }

    private void notification(String message) {
        if (OS == SupportedOS.LINUX) {
            ProcessBuilder pBuilder =
                    new ProcessBuilder(
                            "notify-send", "Pomodoro Timer", message, "--icon=dialog-warning");
            pBuilder.inheritIO();
            try {
                pBuilder.start();
            } catch (IOException e) {
                throw new UnsupportedOperationException(e);
            }
        } else if (OS == SupportedOS.MAC_OS) {
            throw new UnsupportedOperationException("OS support not implemented");
        } else if (OS == SupportedOS.WINDOWS) {
            throw new UnsupportedOperationException("OS support not implemented");
        }
    }
}
