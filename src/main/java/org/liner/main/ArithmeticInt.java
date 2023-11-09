package org.liner.main;

public interface ArithmeticInt<V extends Linear<Integer, V>> extends Arithmetic<V> {
    V add(int value);
    V add(int value, V pointer);
    V sub(int value);
    V sub(int value, V pointer);
    V mul(int value);
    V mul(int value, V pointer);
    V div(int value);
    V div(int value, V pointer);
}
