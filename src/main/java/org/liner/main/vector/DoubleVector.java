package org.liner.main.vector;

import org.liner.main.ArithmeticDouble;
import org.liner.main.ArrayDouble;

public abstract class DoubleVector<V extends DoubleVector<V>>
        extends AbsVector<Double, V>
        implements ArithmeticDouble<V>, ArrayDouble {
    public DoubleVector(V copy) {
        if (copy != null) {
            this.copy(copy);
        }
    }

    @Override
    public double[] newArray() {
        return toArray(new double[dimensional()]);
    }
}
