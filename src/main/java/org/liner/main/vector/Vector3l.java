package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.LongBuffer;

import static java.lang.Math.*;

public class Vector3l extends LongVector<Vector3l> {
    public long x, y, z;

    public Vector3l(Vector3l copy) {
        super(copy);
    }

    public Vector3l(long x, long y, long z) {
        super(null);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3l(int x, int y, int z) {
        super(null);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3l() {
        super(null);
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    @Override
    public Long get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new UnsupportedOperationException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Long value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector3l value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z);
    }

    @Override
    public int dimensional() {
        return 3;
    }

    @Override
    public Vector3l add(long value) {
        this.x += value;
        this.y += value;
        this.z += value;
        return this;
    }

    @Override
    public Vector3l add(long value, Vector3l pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        pointer.z = this.z + value;
        return pointer;
    }

    @Override
    public Vector3l add(Vector3l value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        return this;
    }

    @Override
    public Vector3l add(Vector3l value, Vector3l pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        pointer.z = this.z + value.z;
        return pointer;
    }

    @Override
    public Vector3l sub(long value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        return this;
    }

    @Override
    public Vector3l sub(long value, Vector3l pointer) {
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        pointer.z = this.z - value;
        return pointer;
    }

    @Override
    public Vector3l sub(Vector3l value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        return this;
    }

    @Override
    public Vector3l sub(Vector3l value, Vector3l pointer) {
        pointer.x = this.x - value.x;
        pointer.y = this.y - value.y;
        pointer.z = this.z - value.z;
        return pointer;
    }

    @Override
    public Vector3l mul(long value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        return this;
    }

    @Override
    public Vector3l mul(long value, Vector3l pointer) {
        pointer.x = this.x * value;
        pointer.y = this.y * value;
        pointer.z = this.z * value;
        return pointer;
    }

    @Override
    public Vector3l mul(Vector3l value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        return this;
    }

    @Override
    public Vector3l mul(Vector3l value, Vector3l pointer) {
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        pointer.z = this.z * value.z;
        return pointer;
    }

    @Override
    public Vector3l div(long value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        return this;
    }

    @Override
    public Vector3l div(long value, Vector3l pointer) {
        pointer.x = this.x / value;
        pointer.y = this.y / value;
        pointer.z = this.z / value;
        return pointer;
    }

    @Override
    public Vector3l div(Vector3l value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        return this;
    }

    @Override
    public Vector3l div(Vector3l value, Vector3l pointer) {
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        pointer.z = this.z / value.z;
        return pointer;
    }

    @Override
    public double distance(Vector3l value) {
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
    public double dot(Vector3l value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public double cross(Vector3l value) {
        return new Vector3l(
                this.y * value.z - this.z * value.y,
                this.z * value.x - this.x * value.z,
                this.x * value.y - this.y * value.x
        ).len();
    }

    public double angle(Vector3l value) {
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
    public Long[] get(Long[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }

    public void set(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Long[] toArray() {
        return new Long[]{
                this.x,
                this.y,
                this.z};
    }

    @Override
    public void copy(Vector3l copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3l copy() {
        return new Vector3l(this);
    }

    @Override
    public Vector3l abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    @Override
    public Vector3l abs(Vector3l pointer) {
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        pointer.z = Math.abs(this.z);
        return pointer;
    }

    @Override
    public long[] toArray(long[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }
}
