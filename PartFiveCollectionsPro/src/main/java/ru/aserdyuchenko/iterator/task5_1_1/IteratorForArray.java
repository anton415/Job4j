package ru.aserdyuchenko.iterator.task5_1_1;

import java.util.Iterator;

/**
 * Created by anton on 16.05.17.
 */
public class IteratorForArray implements Iterator<Integer> {
    /**
     * @param externalArray - Исходный двумерный массив.
     */
    private int[][] externalArray;
    /**
     * @param innerArray - Внутренний одномерный массив.
     */
    private int[] innerArray;
    /**
     * @param innerIndex - индекс для внутреннего массива.
     */
    private int innerIndex = 0;
    /**
     * @param exernalIndex - индекс для внешнего массива.
     */
    private int externalIndex = 0;

    /**
     * Конструктор.
     * @param values - исходный двумерный массив.
     */
    public IteratorForArray(int[][] values) {
        this.externalArray = values;
        this.innerArray = nextArray();
    }

    /**
     * Проверка на наличие следующего одномерного массива.
     * @return true если существует следующий массив.
     */
    public boolean hasNextArray() {
        return externalArray.length > externalIndex;
    }

    /**
     * Возвращается следующий одномерный массив.
     * @return следующий массив.
     */
    public int[] nextArray() {
        return externalArray[externalIndex++];
    }

    @Override
    public boolean hasNext() {
        if (innerArray.length <= innerIndex) {
            if (hasNextArray()) {
                innerArray = nextArray();
                innerIndex = 0;
            }
        }
        return innerArray.length > innerIndex;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            if (hasNextArray()) {
                innerArray = nextArray();
                innerIndex = 0;
            }
        }
        return innerArray[innerIndex++];
    }
}
