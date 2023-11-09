package org.liner.main;

public interface ArithmeticGeneric<V, E extends Number> extends Arithmetic<V> {
    V add(E value);
    V add(E value, V pointer);
    V sub(E value);
    V sub(E value, V pointer);
    V mul(E value);
    V mul(E value, V pointer);
    V div(E value);
    V div(E value, V pointer);
}
