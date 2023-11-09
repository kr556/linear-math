package org.liner.main;

public interface Arithmetic<V> {
    /**
     * Assignment this instance.
     * @param copy right side.
     */
    void copy(V copy);
    V copy();

    V add(V value);
    V add(V value, V pointer);
    V sub(V value);
    V sub(V value, V pointer);
    V mul(V value);
    V mul(V value, V pointer);
    V div(V value);
    V div(V value, V pointer);
    V abs();
    V abs(V pointer);

    default V add(Arithmetic<?> value) {
        return this.add((V) value.copy());
    }

    default V add(Arithmetic<?> value, Arithmetic<V> pointer) {
        pointer.copy(this.copy());

        return pointer.add(value);
    }


    default V div(Arithmetic<?> value) {
        return this.div((V) value.copy());
    }

    default V div(Arithmetic<?> value, Arithmetic<V> pointer) {
        pointer.copy(this.copy());

        return pointer.div(value);
    }

    default V mul(Arithmetic<?> value) {
        return this.mul((V) value.copy());
    }

    default V mul(Arithmetic<?> value, Arithmetic<V> pointer) {
        pointer.copy(this.copy());

        return pointer.mul(value);
    }

    default V sub(Arithmetic<?> value) {
        return this.sub((V) value.copy());
    }

    default V sub(Arithmetic<?> value, Arithmetic<V> pointer) {
        pointer.copy(this.copy());

        return pointer.sub(value);
    }
}
