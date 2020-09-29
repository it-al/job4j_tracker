package ru.job4j.tracker;

public class TrackerSingleEagerLoading2 {
    private static final TrackerSingleEagerLoading2 INSTANCE = new TrackerSingleEagerLoading2();
    private static final Tracker tracker = new Tracker();

    private TrackerSingleEagerLoading2() {
    }

    public static TrackerSingleEagerLoading2 getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return tracker.add(model);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}