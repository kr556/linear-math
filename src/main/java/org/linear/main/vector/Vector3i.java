package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.LongBuffer;

import static java.lang.Math.*;

public class Vector3i extends AbsVector<Integer, Vector3i> implements IntVector<Vector3i> {
    public int x, y, z;

    public Vector3i() {}

    public Vector3i(Vector3i copy) {
        set(copy);
    }

    public Vector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Integer get(int index) {
        switch (index) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            default: throw new UnsupportedOperationException();
        }
    }

    @Override
    public void set(int index, @NotNull Integer value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector3i value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z);

    }

    @Override
    public final boolean isNaN() {
        return false;
    }

    @Override
    public final int dimension() {
        return 3;
    }

    @Override
    public Vector3i add(int value) {
        this.x += value;
        this.y += value;
        this.z += value;
        return this;
    }

    @Override
    public Vector3i add(int value, Vector3i pointer) {
        pointer.set(this);
        return pointer.add(value);
    }

    @Override
    public Vector3i add(Vector3i value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        return this;
    }

    @Override
    public Vector3i add(Vector3i value, Vector3i pointer) {
        pointer.set(this);
        return pointer.add(value);
    }

    @Override
    public Vector3i sub(int value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        return this;
    }

    @Override
    public Vector3i sub(int value, Vector3i pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector3i sub(Vector3i value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        return this;
    }

    @Override
    public Vector3i sub(Vector3i value, Vector3i pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector3i mul(float value) {
        this.x *= (int) value;
        this.y *= (int) value;
        this.z *= (int) value;
        return this;
    }

    @Override
    public Vector3i mul(float value, Vector3i pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector3i mul(Vector3i value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        return this;
    }

    @Override
    public Vector3i mul(Vector3i value, Vector3i pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector3i div(float value) {
        this.x /= (int) value;
        this.y /= (int) value;
        this.z /= (int) value;
        return this;
    }

    @Override
    public Vector3i div(float value, Vector3i pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Vector3i div(Vector3i value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        return this;
    }

    @Override
    public Vector3i div(Vector3i value, Vector3i pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public double distance(Vector3i value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        double z = value.z - this.z;
        return sqrt(x * x + y * y + z * z);
    }

    @Override
    public double len() {
        return sqrt(x * x + y * y + z * z);
    }

    @Override
    public double dot(Vector3i value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public double cross(Vector3i value) {
        return new Vector3i(
                this.y * value.z - this.z * value.y,
                this.z * value.x - this.x * value.z,
                this.x * value.y - this.y * value.x
        ).len();
    }

    @Override
    public Vector3i nomalize() {
        double len = len();
        this.x /= (int) len;
        this.y /= (int) len;
        this.z /= (int) len;
        return this;
    }

    @Override
    public Vector3i nomalize(Vector3i pointer) {
        pointer.set(this);
        return pointer.nomalize();
    }

    @Override
    public double angle(Vector3i value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z) / (this.len() * value.len()));
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((LongBuffer) pointer).put(0, this.x);
        ((LongBuffer) pointer).put(1, this.y);
        ((LongBuffer) pointer).put(2, this.z);
        return pointer;
    }

    @Override
    public Integer[] toArray(Integer[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }

    public void set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Integer[] toArray() {
        return new Integer[]{
                this.x,
                this.y,
                this.z};
    }

    @Override
    public void set(Vector3i copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3i copy() {
        return new Vector3i(this);
    }

    @Override
    public Vector3i abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    @Override
    public Vector3i abs(Vector3i pointer) {
        pointer.set(this);
        return pointer.abs();
    }

    @Override
    public int[] toArray(int[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }
}
