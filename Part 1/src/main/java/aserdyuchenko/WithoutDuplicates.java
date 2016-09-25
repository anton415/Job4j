package aserdyuchenko;

/**
 * 5.3. Создание программу удаления дубликатов в массиве.
 * Дано. Массив строк. String[] - нужно убрать дубликаты.
 *
 * @author Anton Serdyuchenko
 * @since 12.09.2016
 * @version 3.0
 *
 */
public class WithoutDuplicates {
    String[] withoutDuplicates(String[] array) {
        int count = 0;
        /**
         * Removing duplicates:
         */
        for (int FirstIndex = array.length-1; FirstIndex >= 0; FirstIndex--) {
            for (int SecondIndex = 0; SecondIndex < FirstIndex; SecondIndex++){
                if (array[FirstIndex]==array[SecondIndex]){
                    array[SecondIndex] = null;
                }
            }
        }
        /**
         * We are looking for the number of elements in the cleanArray:
         */
        for (String s : array) {
            if (s != null && s.length() > 0) {
                count++;
            }
        }
        /**
         * Remove empty elements:
         */
        String[] cleanArray = new String[count];
        for (int ThirdIndex = 0; ThirdIndex <= cleanArray.length-1; ThirdIndex++){
            for (int FouthIndex = ThirdIndex; FouthIndex <= array.length-1; FouthIndex++){
                if (array[FouthIndex]!=null ){
                    cleanArray[ThirdIndex]=array[FouthIndex];
                    ThirdIndex++;
                }
            }
        }
        return cleanArray;
   }
}
