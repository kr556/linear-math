package org.liner.main.matrix;

import org.liner.main.Array;
import org.liner.main.vector.Vector;
import org.liner.main.vector.VectorFunctions;

/**
 * Matrix where this interface was implemented is for row dimension is single or column dimension is single. Matrix
 * that implements this interface implements {@link VectorFunctions}.
 * @param <R> Type of vector converted from matrix.
 */
public interface VectorMatrix<E extends Number, R extends Vector<E, R> & Array<E>> extends VectorFunctions<R> {
    R toVector();
    int dimensional();
}
