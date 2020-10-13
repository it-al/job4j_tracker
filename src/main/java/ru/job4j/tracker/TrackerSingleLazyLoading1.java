package ru.job4j.tracker;

public class TrackerSingleLazyLoading1 {

    @SuppressWarnings("checkstyle:StaticVariableName")
    private static Tracker INSTANCE;

    private TrackerSingleLazyLoading1() {
    }

    public static Tracker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Tracker();
        }
        return INSTANCE;
    }
}