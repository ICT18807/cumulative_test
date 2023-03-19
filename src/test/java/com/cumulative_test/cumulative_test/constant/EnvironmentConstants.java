package com.cumulative_test.cumulative_test.constant;

public class EnvironmentConstants {

    public static final boolean HEADLESS = false;
    public static int PAGE_LOAD_TIMEOUT = 10;
    public static int IMPLICIT_WAIT = 10;
    public static int EXPLICIT_WAIT = 10;

    public static String BROWSER = "Chrome";

    public static void manualwait(int time) {
        try {
            Thread.sleep(1000 * time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
