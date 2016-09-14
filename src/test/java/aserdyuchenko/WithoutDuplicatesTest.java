package aserdyuchenko;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для удаления дубликатов из массива строк.
 * Подробное описание алгоритма, расписано в классе WithoutDuplicates.
 */
public class WithoutDuplicatesTest {
    @Test
    public void whenRemoveDuplicatesFromAnArray() {
        WithoutDuplicates without = new WithoutDuplicates();
        ArrayList array = new ArrayList();
        array.add("what");
        array.add("what");
        array.add("where");
        array.add("where");
        array.add("where");
        array.add("where");
        array.add("where");
        array.add("when");
        ArrayList result = without.withoutDuplicates(array);
        ArrayList cleanArray = new ArrayList();
        cleanArray.add("what");
        cleanArray.add("where");
        cleanArray.add("when");
        assertThat(result, is(cleanArray));
    }
}