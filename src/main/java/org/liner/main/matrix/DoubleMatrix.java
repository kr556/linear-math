package org.liner.main.matrix;

import org.liner.main.ArithmeticDouble;
import org.liner.main.Array;
import org.liner.main.ArrayDouble;

public abstract class DoubleMatrix<V extends DoubleMatrix<V, TRNS> & ArrayDouble, TRNS extends DoubleMatrix<TRNS, V> & ArrayDouble>
        extends AbsMatrix<Double, V, TRNS>
        implements ArithmeticDouble<V>, ArrayDouble {
    public DoubleMatrix(V copy) {
        if (copy != null) {
            this.copy(copy);
        }
    }

    public abstract double reduction();

    @Override
    public double[] newArray() {
        return toArray(new double[elementsSize()]);
    }
}
