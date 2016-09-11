package aserdyuchenko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для поворота матрицы на 90 градусов.
 * Подробное описание алгоритма, расписано в классе RotationMatrix.
 */
public class RotationMatrixTest {
    @Test
    public void whenMatrixTurnNinetyDegrees() {
        RotationMatrix rotation = new RotationMatrix();
        int[][] result = rotation.rotationMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        assertThat(result, is(new int[][]{{3,6,9},{2,5,8},{1,4,7}}));
    }
}