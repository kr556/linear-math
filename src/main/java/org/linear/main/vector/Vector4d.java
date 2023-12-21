package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

import static java.lang.Math.*;

public class Vector4d extends AbsVector<Double, Vector4d> implements DoubleVector<Vector4d> {
    public double x, y, z, w;

    private static final Vector4d NAN = new Vector4d(Double.NaN, Double.NaN, Double.NaN, Double.NaN);

    public Vector4d() {}

    public Vector4d(Vector4d copy) {
        set(copy);
    }

    public Vector4d(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public Double get(int index) {
        switch (index) {
            case 0 : return x;
            case 1 : return y;
            case 2 : return z;
            case 3 : return w;
            default : throw new UnsupportedOperationException();
        }
    }

    @Override
    public void set(int index, @NotNull Double value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            case 3 -> this.w = value;
            default -> throw new ArrayIndexOutOfBoundsException();
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
    public final boolean isNaN() {
        return equals(NAN);
    }

    @Override
    public final int dimension() {
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
        pointer.set(this);
        return pointer.sub(value);
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
        pointer.set(this);
        return pointer.sub(value);
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
        pointer.set(this);
        return pointer.mul(value);
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
        pointer.set(this);
        return pointer.mul(value);
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
        pointer.set(this);
        return pointer.div(value);
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
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public double distance(Vector4d value) {
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
    public double dot(Vector4d value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vector4d nomalize() {
        double len = len();
        this.x /= len;
        this.y /= len;
        this.z /= len;
        this.w /= len;
        return this;
    }

    @Override
    public Vector4d nomalize(Vector4d pointer) {
        pointer.set(this);
        return pointer.nomalize();
    }

    @Override
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
    public Double[] toArray(Double[] pointer) {
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
    public void set(Vector4d copy) {
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
        pointer.set(this);
        return pointer.abs();
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
