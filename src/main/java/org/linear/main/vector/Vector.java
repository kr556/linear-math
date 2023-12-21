package org.linear.main.vector;

import org.linear.main.Linear;
import org.liner.annotation.PropertiesMethod;

public interface Vector<E extends Number, V extends Vector<E, V>>
        extends Linear<E, V> {
    @PropertiesMethod
    int dimension();

    default void map(VectorForEach<E> map) {
        for (int i = 0; i < dimension(); i++) {
            set(i, map.set(i));
        }
    }

    @FunctionalInterface
    interface VectorForEach<E> {
        E set(int i);
    }
}
