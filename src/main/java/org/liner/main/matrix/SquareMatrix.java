package org.liner.main.matrix;

import org.liner.main.Array;

public interface SquareMatrix<E extends Number, R extends NonVextorMatrix<E, R, R> & Array<E>> extends NonVextorMatrix<E, R, R> {
    R invert();
    R invert(R pointer);

    @Override
    default boolean isSquare() {
        return true;
    }
}
