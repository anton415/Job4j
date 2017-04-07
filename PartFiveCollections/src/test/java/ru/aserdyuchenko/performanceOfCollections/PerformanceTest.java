package ru.aserdyuchenko.performanceOfCollections;
/**
 * @author Anton Serdyuchenko (anton415@gmail.com   +7 (916) 154-92-00)
 */
import java.util.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PerformanceTest {
/**
 * Тестирование времени на добавление новых эллементов.
 * Метод возвращает true, если скорость на добавление такая:
 * ArrayList < LinkedList < TreeSet
 */
  @Test
  public void whenFindPerformanceOfAdd() {
    Collection<String> arrayList = new ArrayList<String>();
    Collection<String> linkedList = new LinkedList<String>();
    Collection<String> treeSet = new TreeSet<String>();
    Performance performance = new Performance();
    long resultForArrayList = performance.add(arrayList, "May the Force be with you", 10000);
    long resultForLinkedList = performance.add(linkedList, "May the Force be with you", 10000);
    long resultForTreeSet = performance.add(treeSet, "May the Force be with you", 10000);
    boolean result = (resultForArrayList < resultForLinkedList) && (resultForLinkedList < resultForTreeSet) ? true : false;
    assertThat(result, is(true));
  }
/**
 * Тестирование времени на удаление первых элементов.
 * Тестируются только ArrayList и LinkedList.
 * Потому что, в TreeSet хранятся уникальные и отсортированные элементы.
 * Тоесть в нашем случае, он имеет только один элемент.
 * Метод возвращает true, если скорость на добавление такая:
 * ArrayList < LinkedList
 */
  @Test
  public void whenFindPerformanceOfRemove() {
    Collection<String> arrayList = new ArrayList<String>();
    Collection<String> linkedList = new LinkedList<String>();
    Performance performance = new Performance();
    performance.add(arrayList, "May the Force be with you", 10000);
    long resultForArrayList = performance.delete(arrayList, 1000);
    performance.add(linkedList, "May the Force be with you", 10000);
    long resultForLinkedList = performance.delete(linkedList, 1000);
    boolean result = resultForArrayList < resultForLinkedList ? true : false;
    assertThat(result, is(true));
  }
}
