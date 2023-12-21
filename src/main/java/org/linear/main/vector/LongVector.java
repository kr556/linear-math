package org.linear.main.vector;

import org.linear.main.ArithmeticLong;
import org.linear.main.ArrayLong;

public interface LongVector<V extends LongVector<V>>
        extends Vector<Long, V>, ArithmeticLong<V>, ArrayLong {

    @Override
    default long[] toNewArray() {
        return toArray(new long[dimension()]);
    }
}
