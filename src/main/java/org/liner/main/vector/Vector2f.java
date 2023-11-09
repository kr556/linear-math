package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.FloatBuffer;

import static java.lang.Math.cos;
import static java.lang.Math.sqrt;

public class Vector2f extends FloatVector<Vector2f> {
    public float x, y;

    public Vector2f(Vector2f copy) {
        super(copy);
    }

    public Vector2f(float x, float y) {
        super(null);
        this.x = x;
        this.y = y;
    }

    public Vector2f() {
        super(null);
        this.x = 0f;
        this.y = 0f;
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            default -> throw new ArrayIndexOutOfBoundsException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Float value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector2f value) {
        return (this.x == value.x &&
                this.y == value.y);
    }

    @Override
    public int dimensional() {
        return 2;
    }

    @Override
    public Vector2f add(float value) {
        this.x += value;
        this.y += value;
        return this;
    }

    @Override
    public Vector2f add(float value, Vector2f pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        return pointer;
    }

    @Override
    public Vector2f add(Vector2f value) {
        this.x += value.x;
        this.y += value.y;
        return this;
    }

    @Override
    public Vector2f add(Vector2f value, Vector2f pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        return pointer;
    }

    @Override
    public Vector2f sub(float value) {
        this.x -= value;
        this.y -= value;
        return this;
    }

    @Override
    public Vector2f sub(float value, Vector2f pointer) {
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        return pointer;
    }

    @Override
    public Vector2f sub(Vector2f value) {
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    @Override
    public Vector2f sub(Vector2f value, Vector2f pointer) {
        pointer.x = this.x - value.x;
        pointer.y = this.y - value.y;
        return pointer;
    }

    @Override
    public Vector2f mul(float value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    @Override
    public Vector2f mul(float value, Vector2f pointer) {
        pointer.x = this.x * value;
        pointer.y = this.y * value;
        return pointer;
    }

    @Override
    public Vector2f mul(Vector2f value) {
        this.x *= value.x;
        this.y *= value.y;
        return this;
    }

    @Override
    public Vector2f mul(Vector2f value, Vector2f pointer) {
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        return pointer;
    }

    @Override
    public Vector2f div(float value) {
        this.x /= value;
        this.y /= value;
        return this;
    }

    @Override
    public Vector2f div(float value, Vector2f pointer) {
        pointer.x = this.x / value;
        pointer.y = this.y / value;
        return pointer;
    }

    @Override
    public Vector2f div(Vector2f value) {
        this.x /= value.x;
        this.y /= value.y;
        return this;
    }

    @Override
    public Vector2f div(Vector2f value, Vector2f pointer) {
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        return pointer;
    }

    @Override
    public double distance(Vector2f value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        return sqrt(x * x + y * y);
    }

    public double len() {
        return Math.sqrt(x * x + y * y);
    }

    public double dot(Vector2f value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    public double cross(Vector2f value) {
        return new Vector2f(0, (float) (this.len() * value.len() * Math.sin(this.angle(value)))).len();
    }

    public double angle() {
        return Math.acos(this.y / this.len());
    }

    public double angle(Vector2f value) {
        return Math.abs(this.angle() - value.angle());
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((FloatBuffer) pointer).put(0, this.x);
        ((FloatBuffer) pointer).put(1, this.y);
        return pointer;
    }

    @Override
    public Float[] get(Float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        return pointer;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Float[] toArray() {
        return new Float[]{
                this.x,
                this.y};
    }

    @Override
    public void copy(Vector2f copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    @Override
    public Vector2f copy() {
        return new Vector2f(this);
    }

    @Override
    public Vector2f abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    @Override
    public Vector2f abs(Vector2f pointer) {
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        return pointer;
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        return pointer;
    }
}
