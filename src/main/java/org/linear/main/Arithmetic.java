package org.linear.main;

/**
 * This interface is implements basic arithmetic methods.
 * @param <E> Basic element type.
 * @param <V> Type of implemented class.
 */
public interface Arithmetic<E, V> {
    /**
     * Assignment this instance.
     * @param copy right side.
     */
    void set(V copy);

    /**
     * Copy this.
     * @return Obj deep copied of this.
     */
    V copy();

    /**
     * Add elements of an argument to corresponding elements of myself. This method can calculation same size of elements.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#add(V,V)}.
     * @param value Term of right
     * @return anser
     */
    V add(V value);

    /**
     * Add elements of an argument to corresponding elements of myself.
     * Becouse, this method can calculation same size of elements.
     * @param value Term of right
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V add(V value, V pointer);

    /**
     * Add elements of an argument to corresponding elements of myself. This method can calculation same size of elements.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#add(V,V)}.
     * @param value Term of right
     * @return anser
     */
    V sub(V value);

    /**
     * Sub elements of an argument to corresponding elements of myself.
     * Becouse, this method can calculation same size of elements.
     * @param value Term of right
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V sub(V value, V pointer);

    /**
     * Mul elements of an argument to corresponding elements of myself. This method can calculation same size of elements.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#mul(V,V)}.
     * @param value Term of right
     * @return anser
     */
    V mul(V value);

    /**
     * Mul elements of an argument to corresponding elements of myself.
     * Becouse, this method can calculation same size of elements.
     * @param value Term of right
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V mul(V value, V pointer);

    /**
     * Div elements of an argument to corresponding elements of myself. This method can calculation same size of elements.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#div(V,V)}.
     * @param value Term of right
     * @return anser
     */
    V div(V value);

    /**
     * Div elements of an argument to corresponding elements of myself.
     * Becouse, this method can calculation same size of elements.
     * @param value Term of right
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V div(V value, V pointer);

    /**
     * The all elements to absolute value.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#abs(V)}.
     * @return anser
     */
    V abs();

    /**
     * The all elements to absolute value.
     * Becouse, this method can calculation same size of elements.
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V abs(V pointer);

    /**
     * Basically this method same to {@link Arithmetic#add(V)}. If the type V and the argument are not the same, this method will not work properly.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#add(Arithmetic, Arithmetic)}.
     * @param value Term of right
     * @return anser
     */
    default V add(Arithmetic<E, V> value) {
        return this.add(value.copy());
    }

    /**
     * Basically this method same to {@link Arithmetic#add(V)}. If the type V and the argument are not the same, this method will not work properly.
     * @param value Term of right
     * @param pointer pointer
     * @return anser
     */
    default V add(Arithmetic<E, V> value, Arithmetic<E, V> pointer) {
        pointer.set(this.copy());

        return pointer.add(value);
    }

    /**
     * Basically this method same to {@link Arithmetic#sub(V)}. If the type V and the argument are not the same, this method will not work properly.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#sub(Arithmetic, Arithmetic)}.
     * @param value Term of right
     * @return anser
     */
    default V sub(Arithmetic<E, V> value) {
        return this.sub(value.copy());
    }

    /**
     * Basically this method same to {@link Arithmetic#sub(V)}. If the type V and the argument are not the same, this method will not work properly.
     * @param value Term of right
     * @param pointer pointer
     * @return anser
     */
    default V sub(Arithmetic<E, V> value, Arithmetic<E, V> pointer) {
        pointer.set(this.copy());

        return pointer.sub(value);
    }

    /**
     * Basically this method same to {@link Arithmetic#mul(V)}. If the type V and the argument are not the same, this method will not work properly.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#mul(Arithmetic, Arithmetic)}.
     * @param value Term of right
     * @return anser
     */
    default V mul(Arithmetic<E, V> value) {
        return this.mul(value.copy());
    }

    /**
     * Basically this method same to {@link Arithmetic#mul(V)}. If the type V and the argument are not the same, this method will not work properly.
     * @param value Term of right
     * @param pointer pointer
     * @return anser
     */
    default V mul(Arithmetic<E, V> value, Arithmetic<E, V> pointer) {
        pointer.set(this.copy());

        return pointer.mul(value);
    }

    /**
     * Basically this method same to {@link Arithmetic#div(V)}. If the type V and the argument are not the same, this method will not work properly.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#div(Arithmetic, Arithmetic)}.
     * @param value Term of right
     * @return anser
     */
    default V div(Arithmetic<E, V> value) {
        return this.div(value.copy());
    }

    /**
     * Basically this method same to {@link Arithmetic#div(V)}. If the type V and the argument are not the same, this method will not work properly.
     * @param value Term of right
     * @param pointer pointer
     * @return anser
     */
    default V div(Arithmetic<E, V> value, Arithmetic<E, V> pointer) {
        pointer.set(this.copy());

        return pointer.div(value);
    }
}
