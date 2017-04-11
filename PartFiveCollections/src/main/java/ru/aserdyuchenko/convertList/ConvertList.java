package ru.aserdyuchenko.convertList;

import java.util.*;

class ConvertList {
  /**
   * Конвертация двумерного массива в коллекцию.
   */
  public List<Integer> toList(int[][] array) {
    List<Integer> list = new ArrayList<Integer>(10);
    for (int[] innerArray : array) {
      for (int number: innerArray) {
        list.add(number);
      }
    }
    return list;
  }
  /**
   * Конвертация коллекции в двумерный массив.
   */
  public int[][] toArray(List<Integer> list, int rows) {
    // Создание нового массива.
    int columns, j = 0;
    int i = 0;
    if ((list.size() % rows) == 0) {
      columns = list.size() / rows;
    } else {
      columns = (list.size() / rows) + 1;
    }
    int[][] array = new int[columns][rows];
    // Заполнение массива.
    Iterator iterator = list.iterator();
    for (int number : list) {
      array[i][j] = number;
      j++;
      if (!(j < rows)) {
        j=0;
        i++;
      }
    }
    return array;
  }
}
