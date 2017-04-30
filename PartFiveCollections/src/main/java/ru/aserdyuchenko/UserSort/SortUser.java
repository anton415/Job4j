package ru.aserdyuchenko.UserSort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Anton on 30.04.17.
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> sortSet = new TreeSet<>();
        sortSet.addAll(list);
        return sortSet;
    }
}
