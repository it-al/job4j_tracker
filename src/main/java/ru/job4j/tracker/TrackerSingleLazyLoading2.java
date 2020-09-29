package ru.job4j.tracker;

public class TrackerSingleLazyLoading2 {
    private TrackerSingleLazyLoading2() {
    }

    public static TrackerSingleLazyLoading2 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleLazyLoading2 INSTANCE = new TrackerSingleLazyLoading2();
        private static final Tracker tracker = new Tracker();
    }

    public Item add(Item model) {
        return Holder.tracker.add(model);
    }

    public Item findById(int id) {
        return Holder.tracker.findById(id);
    }

    public Item[] findByName(String key) {
        return Holder.tracker.findByName(key);
    }

    public Item[] findAll() {
        return Holder.tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return Holder.tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return Holder.tracker.delete(id);
    }

}
