package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", "1", "New item name", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new ReplaceAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new DeleteAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("test", 1);
        tracker.add(item);
        List<UserAction> actions = List.of(new FindAllAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find all items ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
                        + "Item{id=1, name='test'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find all items ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("test", 1);
        tracker.add(item);
        List<UserAction> actions = List.of(new FindByIdAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                       + "0. === Find item by Id ===" + System.lineSeparator()
                       + "1. === Exit ===" + System.lineSeparator()
                       + "Item{id=1, name='test'}" + System.lineSeparator()
                       + "Menu." + System.lineSeparator()
                       + "0. === Find item by Id ===" + System.lineSeparator()
                       + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "test", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("test", 1);
        tracker.add(item);
        List<UserAction> actions = List.of(new FindByNameAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                       + "0. === Find items by name ===" + System.lineSeparator()
                       + "1. === Exit ===" + System.lineSeparator()
                       + "Item{id=1, name='test'}" + System.lineSeparator()
                       + "Menu." + System.lineSeparator()
                       + "0. === Find items by name ===" + System.lineSeparator()
                       + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"7", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit ===%n"
                                + "Wrong input, you can select: 0 .. 1%n"
                                + "Menu.%n"
                                + "0. === Exit ===%n"
                )
        ));
    }
}