package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.LongBuffer;

import static java.lang.Math.*;

public class Vector2l extends LongVector<Vector2l> {
    public long x, y;


    public Vector2l(Vector2l copy) {
        super(copy);
    }

    public Vector2l(long x, long y) {
        super(null);
        this.x = x;
        this.y = y;
    }

    public Vector2l() {
        super(null);
        this.x = 0;
        this.y = 0;
    }

    @Override
    public Vector2l add(long value) {
        this.x += value;
        this.y += value;
        return this;
    }

    @Override
    public Vector2l add(long value, Vector2l pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        return pointer;
    }

    @Override
    public Vector2l add(Vector2l value) {
        this.x += value.x;
        this.y += value.y;
        return this;
    }

    @Override
    public Vector2l add(Vector2l value, Vector2l pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        return pointer;
    }

    @Override
    public Vector2l sub(long value) {
        this.x -= value;
        this.y -= value;
        return this;
    }

    @Override
    public Vector2l sub(long value, Vector2l pointer) {
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        return pointer;
    }

    @Override
    public Vector2l sub(Vector2l value) {
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    @Override
    public Vector2l sub(Vector2l value, Vector2l pointer) {
        pointer.x = this.x - value.x;
        pointer.y = this.y - value.y;
        return pointer;
    }

    @Override
    public Vector2l mul(long value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    @Override
    public Vector2l mul(long value, Vector2l pointer) {
        pointer.x = this.x * value;
        pointer.y = this.y * value;
        return pointer;
    }

    @Override
    public Vector2l mul(Vector2l value) {
        this.x *= value.x;
        this.y *= value.y;
        return this;
    }

    @Override
    public Vector2l mul(Vector2l value, Vector2l pointer) {
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        return pointer;
    }

    @Override
    public Vector2l div(long value) {
        this.x /= value;
        this.y /= value;
        return this;
    }

    @Override
    public Vector2l div(long value, Vector2l pointer) {
        pointer.x = this.x / value;
        pointer.y = this.y / value;
        return pointer;
    }

    @Override
    public Vector2l div(Vector2l value) {
        this.x /= value.x;
        this.y /= value.y;
        return this;
    }

    @Override
    public Vector2l div(Vector2l value, Vector2l pointer) {
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        return pointer;
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((LongBuffer) pointer).put(0, x);
        ((LongBuffer) pointer).put(1, y);
        return pointer;
    }

    @Override
    public Long[] get(Long[] pointer) {
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
        return switch (index) {
            case 0 -> this.x;
            case 1 -> this.y;
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
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
    public int dimensional() {
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
    public void copy(Vector2l copy) {
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
