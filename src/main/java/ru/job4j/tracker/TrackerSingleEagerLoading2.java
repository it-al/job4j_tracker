package ru.job4j.tracker;

public class TrackerSingleEagerLoading2 {

    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleEagerLoading2() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

}

