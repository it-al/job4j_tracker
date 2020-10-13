package ru.job4j.tracker;

public enum TrackerSingleEagerLoading1 {
    INSTANCE;
    @SuppressWarnings("checkstyle:ConstantName")
    private static final Tracker tracker = new Tracker();

    public Tracker getInstance() {
        return tracker;
    }
}