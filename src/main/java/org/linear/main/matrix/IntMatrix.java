package org.linear.main.matrix;

import org.linear.main.ArithmeticInt;
import org.linear.main.ArrayInt;
import org.liner.annotation.Final;

public interface IntMatrix<V extends IntMatrix<V, TRNS>, TRNS extends IntMatrix<TRNS, V>>
        extends Matrix<Integer, V, TRNS>, ArithmeticInt<V>, ArrayInt {
    @Final
    int determinant();

    @Override
    default int[] toNewArray() {
        return toArray(new int[elementsSize()]);
    }
}
