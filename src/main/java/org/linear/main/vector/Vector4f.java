package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

import static java.lang.Math.*;

public class Vector4f extends AbsVector<Float, Vector4f> implements FloatVector<Vector4f> {
    public float x, y, z, w;

    public final Vector4f NAN = new Vector4f(Float.NaN, Float.NaN, Float.NaN, Float.NaN);

    public Vector4f() {}

    public Vector4f(Vector4f copy) {
        set(copy);
    }

    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Float get(int index) {
        switch (index) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            case 3: return w;
            default: throw new UnsupportedOperationException();
        }
    }

    @Override
    public void set(int index, @NotNull Float value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            case 3 -> this.w = value;
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector4f value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z &&
                this.w == value.w);
    }

    @Override
    public final boolean isNaN() {
        return equals(NAN);
    }

    @Override
    public final int dimension() {
        return 4;
    }

    @Override
    public Vector4f add(float value) {
        this.x += value;
        this.y += value;
        this.z += value;
        this.w += value;
        return this;
    }

    @Override
    public Vector4f add(float value, Vector4f pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        pointer.z = this.z + value;
        pointer.w = this.w + value;
        return pointer;
    }

    @Override
    public Vector4f add(Vector4f value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        this.w += value.w;
        return this;
    }

    @Override
    public Vector4f add(Vector4f value, Vector4f pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        pointer.z = this.z + value.z;
        pointer.w = this.w + value.w;
        return pointer;
    }

    @Override
    public Vector4f sub(float value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        this.w -= value;
        return this;
    }

    @Override
    public Vector4f sub(float value, Vector4f pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector4f sub(Vector4f value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        this.w -= value.w;
        return this;
    }

    @Override
    public Vector4f sub(Vector4f value, Vector4f pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector4f mul(float value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        this.w *= value;
        return this;
    }

    @Override
    public Vector4f mul(float value, Vector4f pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector4f mul(Vector4f value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        this.w *= value.w;
        return this;
    }

    @Override
    public Vector4f mul(Vector4f value, Vector4f pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector4f div(float value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        this.w /= value;
        return this;
    }

    @Override
    public Vector4f div(float value, Vector4f pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Vector4f div(Vector4f value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        this.w /= value.w;
        return this;
    }

    @Override
    public Vector4f div(Vector4f value, Vector4f pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public double distance(Vector4f value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        double z = value.z - this.z;
        double w = value.w - this.w;
        return sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public double len() {
        return sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public double dot(Vector4f value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vector4f nomalize() {
        double len = len();
        this.x /= (float) len;
        this.y /= (float) len;
        this.z /= (float) len;
        this.w /= (float) len;
        return this;
    }

    @Override
    public Vector4f nomalize(Vector4f pointer) {
        pointer.set(this);
        return pointer.nomalize();
    }

    @Override
    public double angle(Vector4f value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z + this.w * value.w) / (this.len() * value.len()));
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((DoubleBuffer) pointer).put(0, this.x);
        ((DoubleBuffer) pointer).put(1, this.y);
        ((DoubleBuffer) pointer).put(2, this.z);
        ((DoubleBuffer) pointer).put(3, this.w);
        return pointer;
    }

    @Override
    public Float[] toArray(Float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }

    public void set(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Float[] toArray() {
        return new Float[]{
                this.x,
                this.y,
                this.z,
                this.w};
    }

    @Override
    public void set(Vector4f copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    @Override
    public Vector4f copy() {
        return new Vector4f(this);
    }

    @Override
    public Vector4f abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    @Override
    public Vector4f abs(Vector4f pointer) {
        pointer.set(this);
        return pointer.abs();
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }
}
