package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.LongBuffer;

import static java.lang.Math.*;

public class Vector4l extends AbsVector<Long, Vector4l> implements LongVector<Vector4l> {
    public long x, y, z, w;

    public Vector4l() {}

    public Vector4l(Vector4l copy) {
        set(copy);
    }

    public Vector4l(long x, long y, long z, long w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Long get(int index) {
        switch (index) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            case 3: return w;
            default: throw new UnsupportedOperationException();
        }
    }

    @Override
    public void set(int index, @NotNull Long value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            case 3 -> this.w = value;
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector4l value) {
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
    public Vector4l add(long value) {
        this.x += value;
        this.y += value;
        this.z += value;
        this.w += value;
        return this;
    }

    @Override
    public Vector4l add(long value, Vector4l pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        pointer.z = this.z + value;
        pointer.w = this.w + value;
        return pointer;
    }

    @Override
    public Vector4l add(Vector4l value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        this.w += value.w;
        return this;
    }

    @Override
    public Vector4l add(Vector4l value, Vector4l pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        pointer.z = this.z + value.z;
        pointer.w = this.w + value.w;
        return pointer;
    }

    @Override
    public Vector4l sub(long value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        this.w -= value;
        return this;
    }

    @Override
    public Vector4l sub(long value, Vector4l pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector4l sub(Vector4l value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        this.w -= value.w;
        return this;
    }

    @Override
    public Vector4l sub(Vector4l value, Vector4l pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector4l mul(double value) {
        this.x *= (long) value;
        this.y *= (long) value;
        this.z *= (long) value;
        this.w *= (long) value;
        return this;
    }

    @Override
    public Vector4l mul(double value, Vector4l pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector4l mul(Vector4l value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        this.w *= value.w;
        return this;
    }

    @Override
    public Vector4l mul(Vector4l value, Vector4l pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector4l div(double value) {
        this.x /= (long) value;
        this.y /= (long) value;
        this.z /= (long) value;
        this.w /= (long) value;
        return this;
    }

    @Override
    public Vector4l div(double value, Vector4l pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Vector4l div(Vector4l value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        this.w /= value.w;
        return this;
    }

    @Override
    public Vector4l div(Vector4l value, Vector4l pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public double distance(Vector4l value) {
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
    public double dot(Vector4l value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vector4l nomalize() {
        double len = len();
        this.x /= (long) len;
        this.y /= (long) len;
        this.z /= (long) len;
        this.w /= (long) len;
        return this;
    }

    @Override
    public Vector4l nomalize(Vector4l pointer) {
        pointer.set(this);
        return pointer.nomalize();
    }

    @Override
    public double angle(Vector4l value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z + this.w * value.w) / (this.len() * value.len()));
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((LongBuffer) pointer).put(0, this.x);
        ((LongBuffer) pointer).put(1, this.y);
        ((LongBuffer) pointer).put(2, this.z);
        ((LongBuffer) pointer).put(3, this.w);
        return pointer;
    }

    @Override
    public Long[] toArray(Long[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }

    public void set(long x, long y, long z, long w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Long[] toArray() {
        return new Long[]{
                this.x,
                this.y,
                this.z,
                this.w};
    }

    @Override
    public void set(Vector4l copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    @Override
    public Vector4l copy() {
        return new Vector4l(this);
    }

    @Override
    public Vector4l abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    @Override
    public Vector4l abs(Vector4l pointer) {
        pointer.set(this);
        return pointer.abs();
    }

    @Override
    public long[] toArray(long[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }
}
