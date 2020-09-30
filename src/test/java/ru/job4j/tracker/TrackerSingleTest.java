package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleTest {

    @Test
    public void whenNewTrackerSingleEagerLoading1() {
        assertEquals(TrackerSingleEagerLoading1.INSTANCE.getInstance(), TrackerSingleEagerLoading1.INSTANCE.getInstance());
    }

    @Test
    public void whenNewTrackerSingleEagerLoading2() {
        assertEquals(TrackerSingleEagerLoading2.getInstance(), TrackerSingleEagerLoading2.getInstance());
    }

    @Test
    public void whenNewTrackerSingleLazyLoading1() {
        assertEquals(TrackerSingleLazyLoading1.getInstance(), TrackerSingleLazyLoading1.getInstance());
    }

    @Test
    public void whenNewTrackerSingleLazyLoading2() {
        assertEquals(TrackerSingleLazyLoading2.getInstance(), TrackerSingleLazyLoading2.getInstance());
    }

}