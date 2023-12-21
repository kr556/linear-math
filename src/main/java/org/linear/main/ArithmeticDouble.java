package org.linear.main;

// TODO: 2023/11/23 mul, divの引数をdoubleに
public interface ArithmeticDouble<V extends Linear<Double, V>> extends Arithmetic<Double, V> {
    V add(double value);
    V add(double value, V pointer);
    V sub(double value);
    V sub(double value, V pointer);
    V mul(double value);
    V mul(double value, V pointer);
    V div(double value);
    V div(double value, V pointer);
}
