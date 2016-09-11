package aserdyuchenko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для выполнения алгоритма пузырьковой сортировки.
 * Подробное описание алгоритма, расписано в классе BubbleSort.
 */
public class BubbleSortTest {
    @Test
    public void whenUsingBubbleSortAlgorithm() {
        BubbleSort bubble = new BubbleSort();
        int[] result = bubble.bubbleSort(new int[]{5, 1, 3, 2, 6, 9});
        assertThat(result, is(new int[]{1, 2, 3, 5, 6, 9}));
    }
}