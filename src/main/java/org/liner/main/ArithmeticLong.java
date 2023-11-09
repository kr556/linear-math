package org.liner.main;

public interface ArithmeticLong<V extends Linear<Long, V>> extends Arithmetic<V> {
    V add(long value);
    V add(long value, V pointer);
    V sub(long value);
    V sub(long value, V pointer);
    V mul(long value);
    V mul(long value, V pointer);
    V div(long value);
    V div(long value, V pointer);
}
