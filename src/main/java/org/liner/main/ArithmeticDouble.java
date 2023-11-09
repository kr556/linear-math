package org.liner.main;

public interface ArithmeticDouble<V extends Linear<Double, V>> extends Arithmetic<V> {
    V add(double value);
    V add(double value, V pointer);
    V sub(double value);
    V sub(double value, V pointer);
    V mul(double value);
    V mul(double value, V pointer);
    V div(double value);
    V div(double value, V pointer);
}
