package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenSortAsc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Element2"));
        items.add(new Item("Element1"));
        items.add(new Item("Element3"));
        items.sort(new SortByNameAsc());
        assertEquals(items.get(0), new Item("Element1"));
    }

    @Test
    public void whenSortDec() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Element2"));
        items.add(new Item("Element1"));
        items.add(new Item("Element3"));
        items.sort(new SortByNameDec());
        assertEquals(items.get(0), new Item("Element3"));
    }

}