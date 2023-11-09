package org.liner.main.vector;

import org.liner.main.ArithmeticLong;
import org.liner.main.ArrayLong;

public abstract class LongVector<V extends LongVector<V>>
        extends AbsVector<Long, V>
        implements ArithmeticLong<V>, ArrayLong {
    public LongVector(V copy) {
        if (copy != null) {
            this.copy(copy);
        }
    }

    @Override
    public long[] newArray() {
        return toArray(new long[dimensional()]);
    }
}
