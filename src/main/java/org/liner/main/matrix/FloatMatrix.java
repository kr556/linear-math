package org.liner.main.matrix;

import org.liner.main.ArithmeticFloat;
import org.liner.main.ArrayFloat;

public abstract class FloatMatrix<V extends FloatMatrix<V, TRNS> & ArrayFloat, TRNS extends FloatMatrix<TRNS, V> & ArrayFloat>
        extends AbsMatrix<Float, V, TRNS>
        implements ArithmeticFloat<V>, ArrayFloat {
    public FloatMatrix(V copy) {
        if (copy != null) {
            this.copy(copy);
        }
    }

    public abstract float reduction();

    @Override
    public float[] newArray() {
        return toArray(new float[elementsSize()]);
    }
}
