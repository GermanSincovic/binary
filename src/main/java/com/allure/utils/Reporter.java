package com.allure.utils;

import java.time.LocalDateTime;

public class Reporter {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_GREY = "\u001B[37m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[0m";

    private enum ReportingLevelEnum {
        ERROR("ERROR", ANSI_RED),
        WARN("WARN", ANSI_YELLOW),
        INFO("INFO", ANSI_WHITE),
        DEBUG("DEBUG", ANSI_GREY),

        PATH("PATH", ANSI_GREEN),
        FAIL("FAIL", ANSI_RED);

        private final String level;

        private final String color;

        ReportingLevelEnum(String level, String color) {
            this.level = level;
            this.color = color;
        }

        public String getLevel() {
            return level;
        }

        public String getColor() {
            return color;
        }
    }

    private static String getTimestamp() {
        return LocalDateTime.now().toString();
    }

    private static void print(ReportingLevelEnum level, String message) {
        System.out.printf("%s%s | [%s] | %s%s%n", level.getColor(), getTimestamp(), level.getLevel(), message, ANSI_RESET);
    }

    public static void error(String message) {
        print(ReportingLevelEnum.ERROR, message);
    }

    public static void warn(String message) {
        print(ReportingLevelEnum.WARN, message);
    }

    public static void info(String message) {
        print(ReportingLevelEnum.INFO, message);
    }

    public static void debug(String message) {
        print(ReportingLevelEnum.DEBUG, message);
    }

    public static void path(String message) {
        print(ReportingLevelEnum.PATH, message);
    }

    public static void fail(String message) {
        print(ReportingLevelEnum.FAIL, message);
    }

}
