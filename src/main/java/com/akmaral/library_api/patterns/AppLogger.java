package com.akmaral.library_api.patterns;

import java.time.LocalDateTime;

public class AppLogger {

    private static AppLogger instance;

    private AppLogger() {}

    public static AppLogger getInstance() {
        if (instance == null) {
            instance = new AppLogger();
        }
        return instance;
    }

    public void info(String message) {
        System.out.println(
                "[INFO] " + LocalDateTime.now() + " : " + message
        );
    }

    public void error(String message) {
        System.err.println(
                "[ERROR] " + LocalDateTime.now() + " : " + message
        );
    }
}
