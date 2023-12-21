package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.LongBuffer;

import static java.lang.Math.*;

public class Vector3l extends AbsVector<Long, Vector3l> implements LongVector<Vector3l> {
    public long x, y, z;

    public Vector3l() {}

    public Vector3l(Vector3l copy) {
        set(copy);
    }

    public Vector3l(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Long get(int index) {
        switch (index) {
            case 0 : return x;
            case 1 : return y;
            case 2 : return z;
            default : throw new UnsupportedOperationException();
        }
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
    public final boolean isNaN() {
        return false;
    }

    @Override
    public final int dimension() {
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
        pointer.set(this);
        return pointer.add(value);

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
        pointer.set(this);
        return pointer.add(value);

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
        pointer.set(this);
        return pointer.sub(value);
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
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector3l mul(double value) {
        this.x *= (long) value;
        this.y *= (long) value;
        this.z *= (long) value;
        return this;
    }

    @Override
    public Vector3l mul(double value, Vector3l pointer) {
        pointer.set(this);
        return pointer.mul(value);
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
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector3l div(double value) {
        this.x /= (long) value;
        this.y /= (long) value;
        this.z /= (long) value;
        return this;
    }

    @Override
    public Vector3l div(double value, Vector3l pointer) {
        pointer.set(this);
        return pointer.div(value);
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
        pointer.set(this);
        return pointer.div(value);
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

    @Override
    public Vector3l nomalize() {
        double len = len();
        this.x /= (long) len;
        this.y /= (long) len;
        this.z /= (long) len;
        return this;
    }

    @Override
    public Vector3l nomalize(Vector3l pointer) {
        pointer.set(this);
        return pointer.nomalize();
    }

    @Override
    public double angle(Vector3l value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z) / (this.len() * value.len()));
    }

    @Override
    public Buffer get(Buffer pointer) {
        LongBuffer t = (LongBuffer) pointer;
        t.put(0, this.x);
        t.put(1, this.y);
        t.put(2, this.z);
        return pointer;
    }

    @Override
    public Long[] toArray(Long[] pointer) {
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
    public void set(Vector3l copy) {
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
        pointer.set(this);
        return pointer.abs();

    }

    @Override
    public long[] toArray(long[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }
}
