package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.LongBuffer;

import static java.lang.Math.*;

public class Vector3i extends IntVector<Vector3i> {
    public int x, y, z;

    public Vector3i(Vector3i copy) {
        super(copy);
    }

    public Vector3i(int x, int y, int z) {
        super(null);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3i() {
        super(null);
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    @Override
    public Integer get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new UnsupportedOperationException("Index '" + index + "' is unsupported.");
        };
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
    public int dimensional() {
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
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        pointer.z = this.z + value;
        return pointer;
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
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        pointer.z = this.z + value.z;
        return pointer;
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
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        pointer.z = this.z - value;
        return pointer;
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
        pointer.x = this.x - value.x;
        pointer.y = this.y - value.y;
        pointer.z = this.z - value.z;
        return pointer;
    }

    @Override
    public Vector3i mul(int value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        return this;
    }

    @Override
    public Vector3i mul(int value, Vector3i pointer) {
        pointer.x = this.x * value;
        pointer.y = this.y * value;
        pointer.z = this.z * value;
        return pointer;
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
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        pointer.z = this.z * value.z;
        return pointer;
    }

    @Override
    public Vector3i div(int value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        return this;
    }

    @Override
    public Vector3i div(int value, Vector3i pointer) {
        pointer.x = this.x / value;
        pointer.y = this.y / value;
        pointer.z = this.z / value;
        return pointer;
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
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        pointer.z = this.z / value.z;
        return pointer;
    }

    @Override
    public double distance(Vector3i value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        double z = value.z - this.z;
        return sqrt(x * x + y * y + z * z);
    }

    public double len() {
        return sqrt(x * x + y * y + z * z);
    }

    public double dot(Vector3i value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    public double cross(Vector3i value) {
        return new Vector3i(
                this.y * value.z - this.z * value.y,
                this.z * value.x - this.x * value.z,
                this.x * value.y - this.y * value.x
        ).len();
    }

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
    public Integer[] get(Integer[] pointer) {
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
    public void copy(Vector3i copy) {
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
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        pointer.z = Math.abs(this.z);
        return pointer;
    }

    @Override
    public int[] toArray(int[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }
}
