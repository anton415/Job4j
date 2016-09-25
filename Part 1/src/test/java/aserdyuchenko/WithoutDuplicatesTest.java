package aserdyuchenko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для удаления дубликатов из массива строк.
 * Подробное описание алгоритма, расписано в классе WithoutDuplicates.
 */
public class WithoutDuplicatesTest {
    @Test
    public void whenRemoveDuplicatesFromAnArray() {
        WithoutDuplicates withoutDuplicates = new WithoutDuplicates();
        String[] result = withoutDuplicates.withoutDuplicates(new String[] { "1", "2", "2", "2", "3" });
        assertThat(result, is(new String[]{"1", "2", "3"}));
    }
}