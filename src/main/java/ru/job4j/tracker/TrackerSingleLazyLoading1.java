package ru.job4j.tracker;

public class TrackerSingleLazyLoading1 {

    private static TrackerSingleLazyLoading1 instance;
    private static Tracker tracker;

    private TrackerSingleLazyLoading1() {
    }

    public static TrackerSingleLazyLoading1 getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazyLoading1();
            tracker = new Tracker();
        }
        return instance;
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