package aserdyuchenko;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 5.3. Создание программу удаления дубликатов в массиве.
 * Дано. Массив строк. String[] - нужно убрать дубликаты.
 *
 * @author Anton Serdyuchenko
 * @since 12.09.2016
 * @version 2.0
 *
 */
public class WithoutDuplicates {
    List<String> withoutDuplicates(String[] array) {
        /**
         * Removing duplicates:
         */
        HashSet<String> hash = new HashSet<String>();
        for (int index = 0; index < array.length; index++) {
            array[index] = hash.add(array[index]) ? array[index] : null;
        }
        /**
         * Remove empty elements:
         */
        List<String> cleanArray = new ArrayList<String>();
        for (String s : array) {
            if (s != null && s.length() > 0) {
                cleanArray.add(s);
            }
        }
        return cleanArray;
   }
}
