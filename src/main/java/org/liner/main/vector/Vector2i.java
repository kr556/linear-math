package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.LongBuffer;

import static java.lang.Math.*;

public class Vector2i extends IntVector<Vector2i> {
    public int x, y;

    public Vector2i(Vector2i copy) {
        super(copy);
    }

    public Vector2i(int x, int y) {
        super(null);
        this.x = x;
        this.y = y;
    }

    public Vector2i() {
        super(null);
        this.x = 0;
        this.y = 0;
    }

    @Override
    public Vector2i add(int value) {
        this.x += value;
        this.y += value;
        return this;
    }

    @Override
    public Vector2i add(int value, Vector2i pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        return pointer;
    }

    @Override
    public Vector2i add(Vector2i value) {
        this.x += value.x;
        this.y += value.y;
        return this;
    }

    @Override
    public Vector2i add(Vector2i value, Vector2i pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        return pointer;
    }

    @Override
    public Vector2i sub(int value) {
        this.x -= value;
        this.y -= value;
        return this;
    }

    @Override
    public Vector2i sub(int value, Vector2i pointer) {
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        return pointer;
    }

    @Override
    public Vector2i sub(Vector2i value) {
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    @Override
    public Vector2i sub(Vector2i value, Vector2i pointer) {
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    @Override
    public Vector2i mul(int value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    @Override
    public Vector2i mul(int value, Vector2i pointer) {
        pointer.x = this.x * value;
        pointer.y = this.y * value;
        return pointer;
    }

    @Override
    public Vector2i mul(Vector2i value) {
        this.x *= value.x;
        this.y *= value.y;
        return this;
    }

    @Override
    public Vector2i mul(Vector2i value, Vector2i pointer) {
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        return pointer;
    }

    @Override
    public Vector2i div(int value) {
        this.x /= value;
        this.y /= value;
        return this;
    }

    @Override
    public Vector2i div(int value, Vector2i pointer) {
        pointer.x = this.x / value;
        pointer.y = this.y / value;
        return pointer;
    }

    @Override
    public Vector2i div(Vector2i value) {
        this.x /= value.x;
        this.y /= value.y;
        return this;
    }

    @Override
    public Vector2i div(Vector2i value, Vector2i pointer) {
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        return pointer;
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((LongBuffer)pointer).put(0, x);
        ((LongBuffer)pointer).put(1, y);
        return pointer;
    }

    @Override
    public Integer[] get(Integer[] pointer) {
        pointer[0] = x;
        pointer[1] = y;
        return pointer;
    }

    @Override
    public Integer[] toArray() {
        return new Integer[]{
                this.x,
                this.y};
    }

    @Override
    public Integer get(int index) {
        return switch (index) {
            case 0 -> this.x;
            case 1 -> this.y;
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Integer value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector2i value) {
        return (this.x == value.x &&
                this.y == value.y);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int dimensional() {
        return 2;
    }

    @Override
    public double distance(Vector2i value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        return sqrt(x * x + y * y);
    }

    public double len() {
        return sqrt(x * x + y * y);
    }

    public double angle() {
        return acos(this.y / this.len());
    }

    public double angle(Vector2i value) {
        return this.angle() - value.angle();
    }

    @Override
    public double dot(Vector2i value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    public double cross(Vector2i value) {
        return new Vector2d(0, this.len() * value.len() * Math.sin(this.angle(value))).len();
    }

    @Override
    public void copy(Vector2i copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    @Override
    public Vector2i copy() {
        return new Vector2i(this);
    }

    @Override
    public Vector2i abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    @Override
    public Vector2i abs(Vector2i pointer) {
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        return pointer;
    }

    @Override
    public int[] toArray(int[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        return pointer;
    }
}
