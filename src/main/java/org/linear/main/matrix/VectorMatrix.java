package org.linear.main.matrix;

import org.linear.main.vector.Vector;
import org.linear.main.vector.VectorFunctions;
import org.liner.annotation.PropertiesMethod;


public abstract class VectorMatrix<E extends Number, V extends Vector<E, V>>
        extends AbsMatrix<E, VectorMatrix<E, V>, ColumnVector<E, V>>
        implements VectorFunctions<V> {
    public abstract V toVector();

    @PropertiesMethod
    @Override
    public final boolean isVector() {
        return true;
    }

    @PropertiesMethod
    @Override
    public final boolean isSquare() {
        return false;
    }
}
