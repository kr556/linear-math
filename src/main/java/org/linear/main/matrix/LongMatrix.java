package org.linear.main.matrix;

import org.linear.main.ArithmeticLong;
import org.linear.main.ArrayLong;
import org.liner.annotation.Final;

public interface LongMatrix<V extends LongMatrix<V, TRNS>, TRNS extends LongMatrix<TRNS, V>>
        extends Matrix<Long, V, TRNS>, ArithmeticLong<V>, ArrayLong {
    @Final
    long determinant();

    @Override
    default long[] toNewArray() {
        return toArray(new long[elementsSize()]);
    }
}
