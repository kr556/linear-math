package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.LongBuffer;

import static java.lang.Math.*;

public class Vector2l extends AbsVector<Long, Vector2l> implements LongVector<Vector2l> {
    public long x, y;

    public Vector2l() {}

    public Vector2l(Vector2l copy) {
        set(copy);
    }

    public Vector2l(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2l add(long value) {
        this.x += value;
        this.y += value;
        return this;
    }

    @Override
    public Vector2l add(long value, Vector2l pointer) {
        pointer.set(this);
        return pointer.add(value);
    }

    @Override
    public Vector2l add(Vector2l value) {
        this.x += value.x;
        this.y += value.y;
        return this;
    }

    @Override
    public Vector2l add(Vector2l value, Vector2l pointer) {
        pointer.set(this);
        return pointer.add(value);
    }

    @Override
    public Vector2l sub(long value) {
        this.x -= value;
        this.y -= value;
        return this;
    }

    @Override
    public Vector2l sub(long value, Vector2l pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector2l sub(Vector2l value) {
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    @Override
    public Vector2l sub(Vector2l value, Vector2l pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector2l mul(double value) {
        this.x *= (long) value;
        this.y *= (long) value;
        return this;
    }

    @Override
    public Vector2l mul(double value, Vector2l pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector2l mul(Vector2l value) {
        this.x *= value.x;
        this.y *= value.y;
        return this;
    }

    @Override
    public Vector2l mul(Vector2l value, Vector2l pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector2l div(double value) {
        this.x /= (long) value;
        this.y /= (long) value;
        return this;
    }

    @Override
    public Vector2l div(double value, Vector2l pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Vector2l div(Vector2l value) {
        this.x /= value.x;
        this.y /= value.y;
        return this;
    }

    @Override
    public Vector2l div(Vector2l value, Vector2l pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Buffer get(Buffer pointer) {
        LongBuffer t = (LongBuffer) pointer;
        t.put(0, x);
        t.put(1, y);
        return pointer;
    }

    @Override
    public Long[] toArray(Long[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        return pointer;
    }

    @Override
    public Long[] toArray() {
        return new Long[]{
                this.x,
                this.y};
    }

    @Override
    public Long get(int index) {
        switch (index) {
            case 0: return this.x;
            case 1: return this.y;
            default: throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void set(int index, @NotNull Long value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector2l value) {
        return (this.x == value.x &&
                this.y == value.y);
    }

    @Override
    public final boolean isNaN() {
        return false;
    }

    @Override
    public final int dimension() {
        return 2;
    }

    @Override
    public double distance(Vector2l value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        return sqrt(x * x + y * y);
    }

    @Override
    public double len() {
        return Math.sqrt(x * x + y * y);
    }

    public double angle() {
        return acos(this.y / this.len());
    }

    @Override
    public double angle(Vector2l value) {
        return Math.abs(value.angle() - this.angle());
    }

    @Override
    public double dot(Vector2l value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public double cross(Vector2l value) {
        return new Vector2d(0, this.len() * value.len() * Math.sin(this.angle(value))).len();
    }

    @Override
    public Vector2l nomalize() {
        double len = len();
        this.x /= (int) len;
        this.y /= (int) len;
        return this;
    }

    @Override
    public Vector2l nomalize(Vector2l pointer) {
        pointer.set(this);
        return pointer.nomalize();
    }

    @Override
    public void set(Vector2l copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    public void set(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2l copy() {
        return new Vector2l(this);
    }

    @Override
    public Vector2l abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    @Override
    public Vector2l abs(Vector2l pointer) {
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        return pointer;
    }

    @Override
    public long[] toArray(long[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        return pointer;
    }
}
