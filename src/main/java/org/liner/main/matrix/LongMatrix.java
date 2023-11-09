package org.liner.main.matrix;

import org.liner.main.ArithmeticLong;
import org.liner.main.Array;
import org.liner.main.ArrayLong;

public abstract class LongMatrix<V extends LongMatrix<V, TRNS> & ArrayLong, TRNS extends LongMatrix<TRNS, V> & ArrayLong>
        extends AbsMatrix<Long, V, TRNS>
        implements ArithmeticLong<V>, ArrayLong {
    public LongMatrix(V copy) {
        if (copy != null) {
            this.copy(copy);
        }
    }

    public abstract long reduction();

    @Override
    public long[] newArray() {
        return toArray(new long[elementsSize()]);
    }
}
