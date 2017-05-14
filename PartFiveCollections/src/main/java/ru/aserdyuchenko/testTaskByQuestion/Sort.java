package ru.aserdyuchenko.testTaskByQuestion;

import com.google.common.base.CharMatcher;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by anton on 14.05.17.
 */
public class Sort {
    /**
     * Метод сортировки коллекции, по количеству символов в строке.
     * @param list - коллекция, которую нужно отсортировать.
     * @param ch - символ, по которому будет выполняться сортировка.
     * @return list - отсортированная коллекция.
     */
    public List<String> sort(List<String> list, char ch) {
        Collections.sort(list,
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return CharMatcher.is(ch).countIn(o1) - CharMatcher.is(ch).countIn(o2);
                    }
                });
        return list;
    }
}
