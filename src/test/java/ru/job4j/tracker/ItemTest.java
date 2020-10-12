package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenSortAsc() {
        List<Item> Items = new ArrayList<>();
        Items.add(new Item("Element2"));
        Items.add(new Item("Element1"));
        Items.add(new Item("Element3"));
        Collections.sort(Items, new SortByNameAsc());
        assertEquals(Items.get(0), new Item("Element1"));
    }

    @Test
    public void whenSortDec() {
        List<Item> Items = new ArrayList<>();
        Items.add(new Item("Element2"));
        Items.add(new Item("Element1"));
        Items.add(new Item("Element3"));
        Collections.sort(Items, new SortByNameDec());
        assertEquals(Items.get(0), new Item("Element3"));
    }

}