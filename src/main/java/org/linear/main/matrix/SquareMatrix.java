package org.linear.main.matrix;

import org.liner.annotation.PropertiesMethod;
import org.linear.main.Array;

public abstract class SquareMatrix<E extends Number, V extends SquareMatrix<E, V> & Matrix<E, V, V>>
        extends AbsMatrix<E, V, V> {
    public abstract V invert();

    public V invert(V pointer) {
        pointer.set((V) this);
        pointer.invert();
        return pointer;
    }

    public abstract V mulC(V value);

    public V mulC(V value, V pointer) {
        pointer.set((V) this);
        pointer.mulC(value);
        return pointer;
    }

    public abstract V mulR(V value);

    public V mulR(V value, V pointer) {
        pointer.set((V) this);
        pointer.mulR(value);
        return pointer;
    }

    @PropertiesMethod
    public final boolean isSquare() {
        return true;
    }
}
