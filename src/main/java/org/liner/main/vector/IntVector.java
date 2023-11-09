package org.liner.main.vector;

import org.liner.main.ArithmeticInt;
import org.liner.main.ArrayInt;

public abstract class IntVector<V extends IntVector<V>>
        extends AbsVector<Integer, V>
        implements ArithmeticInt<V>, ArrayInt {
    public IntVector(V copy) {
        if (copy != null) {
            this.copy(copy);
        }
    }

    @Override
    public int[] newArray() {
        return toArray(new int[dimensional()]);
    }
}
