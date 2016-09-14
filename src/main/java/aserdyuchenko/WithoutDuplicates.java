package aserdyuchenko;

import java.util.ArrayList;

/**
 * 5.3. Создание программу удаления дубликатов в массиве.
 * Дано. Массив строк. String[] - нужно убрать дубликаты.
 *
 * @author Anton Serdyuchenko
 * @since 12.09.2016
 * @version 1.0
 *
 */
public class WithoutDuplicates {
   ArrayList withoutDuplicates(ArrayList array){
       for (int i = array.size() - 1; i >= 0; i--){
           for (int j = i - 1; j>=0; j--) {
               if (array.get(i) == array.get(j)) array.remove(j);
           }
       }
       return array;
   }
}
