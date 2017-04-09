package ru.aserdyuchenko.performanceOfCollections;
/**
 * @author Anton Serdyuchenko (anton415@gmail.com   +7 (916) 154-92-00)
 */
import java.util.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.Random;

public class PerformanceTest {
  public String generateRandomeString() {
    Random random = new Random();
    StringBuilder builder = new StringBuilder();
    for (int index = 0; index < random.nextInt(100); index++) {
      builder.append((char) (0 + random.nextInt(100)));
    }
    return builder.toString();
  }
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
    long resultForArrayList = performance.add(arrayList, generateRandomeString(), 100000);
    long resultForLinkedList = performance.add(linkedList, generateRandomeString(), 100000);
    long resultForTreeSet = performance.add(treeSet, generateRandomeString(), 100000);
    boolean result = (resultForArrayList < resultForTreeSet) && (resultForTreeSet < resultForLinkedList) ? true : false;
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
    Collection<String> treeSet = new TreeSet<String>();
    Performance performance = new Performance();
    performance.add(arrayList, generateRandomeString(), 10000);
    long resultForArrayList = performance.delete(arrayList, 1000);
    performance.add(linkedList, generateRandomeString(), 10000);
    long resultForLinkedList = performance.delete(linkedList, 1000);
    performance.add(treeSet, generateRandomeString(), 10000);
    long resultForTreeSet = performance.delete(treeSet, 1000);
    boolean result = (resultForTreeSet < resultForLinkedList) && (resultForLinkedList < resultForArrayList) ? true : false;
    assertThat(result, is(true));
  }
}
