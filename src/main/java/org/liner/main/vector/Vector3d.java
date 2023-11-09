package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

import static java.lang.Math.*;

public class Vector3d extends DoubleVector<Vector3d>{
    public double x, y, z;

    public Vector3d(Vector3d copy) {
        super(copy);
    }

    public Vector3d(double x, double y, double z) {
        super(null);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3d() {
        super(null);
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
    }

    @Override
    public Double get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new UnsupportedOperationException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Double value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector3d value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z);
    }

    @Override
    public int dimensional() {
        return 3;
    }

    @Override
    public Vector3d add(double value) {
        this.x += value;
        this.y += value;
        this.z += value;
        return this;
    }

    @Override
    public Vector3d add(double value, Vector3d pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        pointer.z = this.z + value;
        return pointer;
    }

    @Override
    public Vector3d add(Vector3d value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        return this;
    }

    @Override
    public Vector3d add(Vector3d value, Vector3d pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        pointer.z = this.z + value.z;
        return pointer;
    }

    @Override
    public Vector3d sub(double value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        return this;
    }

    @Override
    public Vector3d sub(double value, Vector3d pointer) {
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        pointer.z = this.z - value;
        return pointer;
    }

    @Override
    public Vector3d sub(Vector3d value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        return this;
    }

    @Override
    public Vector3d sub(Vector3d value, Vector3d pointer) {
        pointer.x = this.x - value.x;
        pointer.y = this.y - value.y;
        pointer.z = this.z - value.z;
        return pointer;
    }

    @Override
    public Vector3d mul(double value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        return this;
    }

    @Override
    public Vector3d mul(double value, Vector3d pointer) {
        pointer.x = this.x * value;
        pointer.y = this.y * value;
        pointer.z = this.z * value;
        return pointer;
    }

    @Override
    public Vector3d mul(Vector3d value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        return this;
    }

    @Override
    public Vector3d mul(Vector3d value, Vector3d pointer) {
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        pointer.z = this.z * value.z;
        return pointer;
    }

    @Override
    public Vector3d div(double value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        return this;
    }

    @Override
    public Vector3d div(double value, Vector3d pointer) {
        pointer.x = this.x / value;
        pointer.y = this.y / value;
        pointer.z = this.z / value;
        return pointer;
    }

    @Override
    public Vector3d div(Vector3d value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        return this;
    }

    @Override
    public Vector3d div(Vector3d value, Vector3d pointer) {
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        pointer.z = this.z / value.z;
        return pointer;
    }

    @Override
    public double distance(Vector3d value) {
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
    public double dot(Vector3d value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public double cross(Vector3d value) {
        return new Vector3d(
                this.y * value.z - this.z * value.y,
                this.z * value.x - this.x * value.z,
                this.x * value.y - this.y * value.x
        ).len();
    }

    @Override
    public double angle(Vector3d value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z) / (this.len() * value.len()));
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((DoubleBuffer) pointer).put(0, this.x);
        ((DoubleBuffer) pointer).put(1, this.y);
        ((DoubleBuffer) pointer).put(2, this.z);
        return pointer;
    }

    @Override
    public Double[] get(Double[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Double[] toArray() {
        return new Double[]{
                this.x,
                this.y,
                this.z};
    }

    @Override
    public void copy(Vector3d copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3d copy() {
        return new Vector3d(this);
    }

    @Override
    public Vector3d abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    @Override
    public Vector3d abs(Vector3d pointer) {
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        pointer.z = Math.abs(this.z);
        return pointer;
    }

    @Override
    public double[] toArray(double[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }
}
