package org.linear.main;

// TODO: 2023/11/23 mul, divの引数をdoubleに
public interface ArithmeticInt<V extends Linear<Integer, V>> extends Arithmetic<Integer, V> {
    V add(int value);
    V add(int value, V pointer);
    V sub(int value);
    V sub(int value, V pointer);
    V mul(float value);
    V mul(float value, V pointer);
    V div(float value);
    V div(float value, V pointer);
}
