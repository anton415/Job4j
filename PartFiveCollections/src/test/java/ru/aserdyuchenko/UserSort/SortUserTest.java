package ru.aserdyuchenko.UserSort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by anton on 30.04.17.
 */
public class SortUserTest {
    @Test
    public void whenSortInteger() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Bilbo Baggins", 111));
        list.add(new User("Frodo Baggins", 33));
        list.add(new User("Gandalf", 2000));
        list.add(new User("Gollum", 333));
        Set<User> result = sortUser.sort(list);
        assertThat(result.iterator().next().getName(), is("Frodo Baggins"));
    }
}