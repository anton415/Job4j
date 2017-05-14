package ru.aserdyuchenko.testTaskByQuestion;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by anton on 14.05.17.
 */
public class SortTest {
    @Test
    public void whenAddNewUser() {
        Sort sort = new Sort();
        List<String> list = Arrays.asList("a a", "a   a", "a", "a a a");
        List<String> result = sort.sort(list, ' ');
        assertThat(result.toString(), is("[a, a a, a a a, a   a]"));
    }
}