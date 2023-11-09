package org.liner.main.matrix;

import org.liner.main.Array;

/**
 * Matrix where this interface was implemented is for row dimension is not single and column dimension is not single.
 */
public non-sealed interface NonVextorMatrix<E extends Number, R extends NonVextorMatrix<E, R, TRNS> & Array<E>, TRNS extends NonVextorMatrix<E, TRNS, R> & Array<E>>
        extends Matrix<E, R, TRNS>{
    E get(int r, int c);

    @Override
    default boolean isSquare() {
        return false;
    }
}
