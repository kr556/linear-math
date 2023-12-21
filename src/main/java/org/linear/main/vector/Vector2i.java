package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.IntBuffer;

import static java.lang.Math.*;

public class Vector2i extends AbsVector<Integer, Vector2i> implements IntVector<Vector2i> {
    public int x, y;

    public Vector2i() {}

    public Vector2i(Vector2i copy) {
        set(copy);
    }

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2i add(int value) {
        this.x += value;
        this.y += value;
        return this;
    }

    @Override
    public Vector2i add(int value, Vector2i pointer) {
        pointer.set(this);
        return pointer.add(value);
    }

    @Override
    public Vector2i add(Vector2i value) {
        this.x += value.x;
        this.y += value.y;
        return this;
    }

    @Override
    public Vector2i add(Vector2i value, Vector2i pointer) {
        pointer.set(this);
        return pointer.add(value);
    }

    @Override
    public Vector2i sub(int value) {
        this.x -= value;
        this.y -= value;
        return this;
    }

    @Override
    public Vector2i sub(int value, Vector2i pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector2i sub(Vector2i value) {
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    @Override
    public Vector2i sub(Vector2i value, Vector2i pointer) {
        pointer.set(this);
        return pointer.sub(value);
    }

    @Override
    public Vector2i mul(float value) {
        this.x *= (int) value;
        this.y *= (int) value;
        return this;
    }

    @Override
    public Vector2i mul(float value, Vector2i pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector2i mul(Vector2i value) {
        this.x *= value.x;
        this.y *= value.y;
        return this;
    }

    @Override
    public Vector2i mul(Vector2i value, Vector2i pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Vector2i div(float value) {
        this.x /= (int) value;
        this.y /= (int) value;
        return this;
    }

    @Override
    public Vector2i div(float value, Vector2i pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Vector2i div(Vector2i value) {
        this.x /= value.x;
        this.y /= value.y;
        return this;
    }

    @Override
    public Vector2i div(Vector2i value, Vector2i pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Buffer get(Buffer pointer) {
        IntBuffer t = (IntBuffer) pointer;
        t.put(0, x);
        t.put(1, y);
        return pointer;
    }

    @Override
    public Integer[] toArray(Integer[] pointer) {
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
        switch (index) {
            case 0: return this.x;
            case 1: return this.y;
            default: throw new ArrayIndexOutOfBoundsException();
        }
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

    @Override
    public final boolean isNaN() {
        return false;
    }

    @Override
    public final int dimension() {
        return 2;
    }

    @Override
    public double distance(Vector2i value) {
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
    public double angle(Vector2i value) {
        return Math.abs(value.angle() - this.angle());
    }

    @Override
    public double dot(Vector2i value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public double cross(Vector2i value) {
        return new Vector2d(0, this.len() * value.len() * Math.sin(this.angle(value))).len();
    }

    @Override
    public Vector2i nomalize() {
        double len = len();
        this.x /= (int) len;
        this.y /= (int) len;
        return this;
    }

    @Override
    public Vector2i nomalize(Vector2i pointer) {
        pointer.set(this);
        return pointer.nomalize();
    }

    @Override
    public void set(Vector2i copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
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
