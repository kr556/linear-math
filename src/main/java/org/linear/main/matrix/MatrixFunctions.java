package org.linear.main.matrix;

public interface MatrixFunctions<E extends Number, V, TRNS> {
    E get(int r, int c);

    TRNS transpose();

    TRNS transpose(TRNS pointer);
}
