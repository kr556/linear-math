package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.IntBuffer;

import static java.lang.Math.*;

public class Vector4i extends AbsVector<Integer, Vector4i> implements IntVector<Vector4i> {
    public int x, y, z, w;

    public Vector4i() {}

    public Vector4i(Vector4i copy) {
        set(copy);
    }

    public Vector4i(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Integer get(int index) {
        switch (index) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            case 3: return w;
            default: throw new UnsupportedOperationException();
        }
    }

    @Override
    public void set(int index, @NotNull Integer value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            case 3 -> this.w = value;
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector4i value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z &&
                this.w == value.w);
    }

    @Override
    public final boolean isNaN() {
        return false;
    }

    @Override
    public final int dimension() {
        return 4;
    }

    @Override
    public Vector4i add(int value) {
        this.x += value;
        this.y += value;
        this.z += value;
        this.w += value;
        return this;
    }

    @Override
    public Vector4i add(int value, Vector4i pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        pointer.z = this.z + value;
        pointer.w = this.w + value;
        return pointer;
    }

    @Override
    public Vector4i add(Vector4i value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        this.w += value.w;
        return this;
    }

    @Override
    public Vector4i add(Vector4i value, Vector4i pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        pointer.z = this.z + value.z;
        pointer.w = this.w + value.w;
        return pointer;
    }

    @Override
    public Vector4i sub(int value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        this.w -= value;
        return this;
    }

    @Override
    public Vector4i sub(int value, Vector4i pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector4i sub(Vector4i value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        this.w -= value.w;
        return this;
    }

    @Override
    public Vector4i sub(Vector4i value, Vector4i pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector4i mul(float value) {
        this.x *= (int) value;
        this.y *= (int) value;
        this.z *= (int) value;
        this.w *= (int) value;
        return this;
    }

    @Override
    public Vector4i mul(float value, Vector4i pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector4i mul(Vector4i value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        this.w *= value.w;
        return this;
    }

    @Override
    public Vector4i mul(Vector4i value, Vector4i pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector4i div(float value) {
        this.x /= (int) value;
        this.y /= (int) value;
        this.z /= (int) value;
        this.w /= (int) value;
        return this;
    }

    @Override
    public Vector4i div(float value, Vector4i pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Vector4i div(Vector4i value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        this.w /= value.w;
        return this;
    }

    @Override
    public Vector4i div(Vector4i value, Vector4i pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public double distance(Vector4i value) {
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
    public double dot(Vector4i value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vector4i nomalize() {
        double len = len();
        this.x /= (int) len;
        this.y /= (int) len;
        this.z /= (int) len;
        this.w /= (int) len;
        return this;
    }

    @Override
    public Vector4i nomalize(Vector4i pointer) {
        pointer.set(this);
        return pointer.nomalize();
    }

    @Override
    public double angle(Vector4i value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z + this.w * value.w) / (this.len() * value.len()));
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((IntBuffer) pointer).put(0, this.x);
        ((IntBuffer) pointer).put(1, this.y);
        ((IntBuffer) pointer).put(2, this.z);
        ((IntBuffer) pointer).put(3, this.w);
        return pointer;
    }

    @Override
    public Integer[] toArray(Integer[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }

    public void set(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Integer[] toArray() {
        return new Integer[]{
                this.x,
                this.y,
                this.z,
                this.w};
    }

    @Override
    public void set(Vector4i copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    @Override
    public Vector4i copy() {
        return new Vector4i(this);
    }

    @Override
    public Vector4i abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    @Override
    public Vector4i abs(Vector4i pointer) {
        pointer.set(this);
        return pointer.abs();
    }

    @Override
    public int[] toArray(int[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }
}
