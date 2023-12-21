package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

import static java.lang.Math.*;

public class Vector2d extends AbsVector<Double, Vector2d> implements DoubleVector<Vector2d> {
    public static final Vector2d NAN = new Vector2d(Double.NaN, Double.NaN);

    public double x, y;

    public Vector2d() {}

    public Vector2d(Vector2d copy) {
        set(copy);
    }

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Double get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            default -> throw new UnsupportedOperationException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Double value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector2d value) {
        return (this.x == value.x &&
                this.y == value.y);
    }

    @Override
    public final boolean isNaN() {
        return equals(NAN);
    }

    @Override
    public final int dimension() {
        return 2;
    }

    @Override
    public Vector2d add(double value) {
        this.x += value;
        this.y += value;
        return this;
    }

    @Override
    public Vector2d add(double value, Vector2d pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        return pointer;
    }

    @Override
    public Vector2d add(Vector2d value) {
        this.x += value.x;
        this.y += value.y;
        return this;
    }

    @Override
    public Vector2d add(Vector2d value, Vector2d pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        return pointer;
    }

    @Override
    public Vector2d sub(double value) {
        this.x -= value;
        this.y -= value;
        return this;
    }

    @Override
    public Vector2d sub(double value, Vector2d pointer) {
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        return pointer;
    }

    @Override
    public Vector2d sub(Vector2d value) {
        this.x -= value.x;
        this.y -= value.y;
        return this;
    }

    @Override
    public Vector2d sub(Vector2d value, Vector2d pointer) {
        pointer.x = this.x - value.x;
        pointer.y = this.y - value.y;
        return pointer;
    }

    @Override
    public Vector2d mul(double value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    @Override
    public Vector2d mul(double value, Vector2d pointer) {
        pointer.x = this.x * value;
        pointer.y = this.y * value;
        return pointer;
    }

    @Override
    public Vector2d mul(Vector2d value) {
        this.x *= value.x;
        this.y *= value.y;
        return this;
    }

    @Override
    public Vector2d mul(Vector2d value, Vector2d pointer) {
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        return pointer;
    }

    @Override
    public Vector2d div(double value) {
        this.x /= value;
        this.y /= value;
        return this;
    }

    @Override
    public Vector2d div(double value, Vector2d pointer) {
        pointer.x = this.x / value;
        pointer.y = this.y / value;
        return pointer;
    }

    @Override
    public Vector2d div(Vector2d value) {
        this.x /= value.x;
        this.y /= value.y;
        return this;
    }

    @Override
    public Vector2d div(Vector2d value, Vector2d pointer) {
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        return pointer;
    }

    @Override
    public double distance(Vector2d value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        return sqrt(x * x + y * y);
    }

    @Override
    public double len() {
        return sqrt(x * x + y * y);
    }

    @Override
    public double dot(Vector2d value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public double cross(Vector2d value) {
        double theta = this.angle(value);

        return this.len() * value.len() * sin(theta);
    }

    @Override
    public Vector2d nomalize() {
        return null;
    }

    @Override
    public Vector2d nomalize(Vector2d pointer) {
        return null;
    }

    public double angle() {
        return acos(this.y / this.len());
    }

    @Override
    public double angle(Vector2d value) {
        return Math.abs(this.angle() - value.angle());
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((DoubleBuffer) pointer).put(0, this.x);
        ((DoubleBuffer) pointer).put(1, this.y);
        return pointer;
    }

    @Override
    public Double[] toArray(Double[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        return pointer;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Double[] toArray() {
        return new Double[]{
                this.x,
                this.y};
    }

    @Override
    public void set(Vector2d copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    @Override
    public Vector2d copy() {
        return new Vector2d(this);
    }

    @Override
    public Vector2d abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    @Override
    public Vector2d abs(Vector2d pointer) {
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        return pointer;
    }

    @Override
    public double[] toArray(double[] pointer) {
        return new double[0];
    }
}
