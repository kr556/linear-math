package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

import static java.lang.Math.*;

public class Vector4d extends DoubleVector<Vector4d> {
    public double x, y, z, w;

    public Vector4d(Vector4d copy) {
        super(copy);
    }

    public Vector4d(double x, double y, double z, double w) {
        super(null);
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4d() {
        super(null);
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
        this.w = 0f;
    }

    @Override
    public Double get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            case 3 -> w;
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public void set(int index, @NotNull Double value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            case 3 -> this.w = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector4d value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z &&
                this.w == value.w);
    }

    @Override
    public int dimensional() {
        return 4;
    }

    @Override
    public Vector4d add(double value) {
        this.x += value;
        this.y += value;
        this.z += value;
        this.w += value;
        return this;
    }

    @Override
    public Vector4d add(double value, Vector4d pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        pointer.z = this.z + value;
        pointer.w = this.w + value;
        return pointer;
    }

    @Override
    public Vector4d add(Vector4d value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        this.w += value.w;
        return this;
    }

    @Override
    public Vector4d add(Vector4d value, Vector4d pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        pointer.z = this.z + value.z;
        pointer.w = this.w + value.w;
        return pointer;
    }

    @Override
    public Vector4d sub(double value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        this.w -= value;
        return this;
    }

    @Override
    public Vector4d sub(double value, Vector4d pointer) {
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        pointer.z = this.z - value;
        pointer.w = this.w - value;
        return pointer;
    }

    @Override
    public Vector4d sub(Vector4d value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        this.w -= value.w;
        return this;
    }

    @Override
    public Vector4d sub(Vector4d value, Vector4d pointer) {
        pointer.x = this.x - value.x;
        pointer.y = this.y - value.y;
        pointer.z = this.z - value.z;
        pointer.w = this.w - value.w;
        return pointer;
    }

    @Override
    public Vector4d mul(double value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        this.w *= value;
        return this;
    }

    @Override
    public Vector4d mul(double value, Vector4d pointer) {
        pointer.x = this.x * value;
        pointer.y = this.y * value;
        pointer.z = this.z * value;
        pointer.w = this.w * value;
        return pointer;
    }

    @Override
    public Vector4d mul(Vector4d value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        this.w *= value.w;
        return this;
    }

    @Override
    public Vector4d mul(Vector4d value, Vector4d pointer) {
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        pointer.z = this.z * value.z;
        pointer.w = this.w * value.w;
        return pointer;
    }

    @Override
    public Vector4d div(double value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        this.w /= value;
        return this;
    }

    @Override
    public Vector4d div(double value, Vector4d pointer) {
        pointer.x = this.x / value;
        pointer.y = this.y / value;
        pointer.z = this.z / value;
        pointer.w = this.w / value;
        return pointer;
    }

    @Override
    public Vector4d div(Vector4d value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        this.w /= value.w;
        return this;
    }

    @Override
    public Vector4d div(Vector4d value, Vector4d pointer) {
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        pointer.z = this.z / value.z;
        pointer.w = this.w / value.w;
        return pointer;
    }

    @Override
    public double distance(Vector4d value) {
        double x = value.x - this.x;
        double y = value.y - this.y;
        double z = value.z - this.z;
        double w = value.w - this.w;
        return sqrt(x * x + y * y + z * z + w * w);
    }

    public double len() {
        return sqrt(x * x + y * y + z * z + w * w);
    }

    public double dot(Vector4d value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    public double angle(Vector4d value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z + this.w * value.w) / (this.len() * value.len()));
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((DoubleBuffer) pointer).put(0, this.x);
        ((DoubleBuffer) pointer).put(1, this.y);
        ((DoubleBuffer) pointer).put(2, this.z);
        ((DoubleBuffer) pointer).put(3, this.w);
        return pointer;
    }

    @Override
    public Double[] get(Double[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }

    public void set(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Double[] toArray() {
        return new Double[]{
                this.x,
                this.y,
                this.z,
                this.w};
    }

    @Override
    public void copy(Vector4d copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    @Override
    public Vector4d copy() {
        return new Vector4d(this);
    }

    @Override
    public Vector4d abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    @Override
    public Vector4d abs(Vector4d pointer) {
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        pointer.z = Math.abs(this.z);
        pointer.w = Math.abs(this.w);
        return pointer;
    }

    @Override
    public double[] toArray(double[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        pointer[3] = this.w;
        return pointer;
    }
}
