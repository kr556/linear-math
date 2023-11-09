package org.liner.main.vector;

import org.liner.main.ArithmeticFloat;
import org.liner.main.ArrayFloat;

public abstract class FloatVector<V extends FloatVector<V>>
        extends AbsVector<Float, V>
        implements ArithmeticFloat<V>, ArrayFloat {
    public FloatVector(V copy) {
        if (copy != null) {
            this.copy(copy);
        }
    }

    @Override
    public float[] newArray() {
        return toArray(new float[dimensional()]);
    }
}
