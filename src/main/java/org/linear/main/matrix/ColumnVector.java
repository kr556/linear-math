package org.linear.main.matrix;

import org.linear.main.vector.Vector;
import org.linear.main.vector.VectorFunctions;
import org.liner.annotation.PropertiesMethod;

/**
 * Matrix where this interface was implemented is for row dimension is single or column dimension is single. Matrix
 * that implements this interface implements {@link VectorFunctions}.
 * @param <V> Type of vector converted from matrix.
 */
public abstract class ColumnVector<E extends Number, V extends Vector<E, V>>
        extends AbsMatrix<E, ColumnVector<E, V>, VectorMatrix<E, V>>
        implements VectorFunctions<V> {
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
