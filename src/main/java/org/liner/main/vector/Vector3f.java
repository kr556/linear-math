package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.FloatBuffer;

import static java.lang.Math.*;

public class Vector3f extends FloatVector<Vector3f> {
    public float x, y, z;

    public Vector3f(Vector3f copy) {
        super(copy);
    }

    public Vector3f(float x, float y, float z) {
        super(null);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f() {
        super(null);
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new UnsupportedOperationException("Index '" + index + "' is unsupported.");
        };
    }

    @Override
    public void set(int index, @NotNull Float value) {
        switch (index) {
            case 0 -> this.x = value;
            case 1 -> this.y = value;
            case 2 -> this.z = value;
            default ->  throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(@NotNull Vector3f value) {
        return (this.x == value.x &&
                this.y == value.y &&
                this.z == value.z);

    }

    @Override
    public int dimensional() {
        return 3;
    }

    @Override
    public Vector3f add(float value) {
        this.x += value;
        this.y += value;
        this.z += value;
        return this;
    }

    @Override
    public Vector3f add(float value, Vector3f pointer) {
        pointer.x = this.x + value;
        pointer.y = this.y + value;
        pointer.z = this.z + value;
        return pointer;
    }

    @Override
    public Vector3f add(Vector3f value) {
        this.x += value.x;
        this.y += value.y;
        this.z += value.z;
        return this;
    }

    @Override
    public Vector3f add(Vector3f value, Vector3f pointer) {
        pointer.x = this.x + value.x;
        pointer.y = this.y + value.y;
        pointer.z = this.z + value.z;
        return pointer;
    }

    @Override
    public Vector3f sub(float value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
        return this;
    }

    @Override
    public Vector3f sub(float value, Vector3f pointer) {
        pointer.x = this.x - value;
        pointer.y = this.y - value;
        pointer.z = this.z - value;
        return pointer;
    }

    @Override
    public Vector3f sub(Vector3f value) {
        this.x -= value.x;
        this.y -= value.y;
        this.z -= value.z;
        return this;
    }

    @Override
    public Vector3f sub(Vector3f value, Vector3f pointer) {
        pointer.x = this.x - value.x;
        pointer.y = this.y - value.y;
        pointer.z = this.z - value.z;
        return pointer;
    }

    @Override
    public Vector3f mul(float value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        return this;
    }

    @Override
    public Vector3f mul(float value, Vector3f pointer) {
        pointer.x = this.x * value;
        pointer.y = this.y * value;
        pointer.z = this.z * value;
        return pointer;
    }

    @Override
    public Vector3f mul(Vector3f value) {
        this.x *= value.x;
        this.y *= value.y;
        this.z *= value.z;
        return this;
    }

    @Override
    public Vector3f mul(Vector3f value, Vector3f pointer) {
        pointer.x = this.x * value.x;
        pointer.y = this.y * value.y;
        pointer.z = this.z * value.z;
        return pointer;
    }

    @Override
    public Vector3f div(float value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        return this;
    }

    @Override
    public Vector3f div(float value, Vector3f pointer) {
        pointer.x = this.x / value;
        pointer.y = this.y / value;
        pointer.z = this.z / value;
        return pointer;
    }

    @Override
    public Vector3f div(Vector3f value) {
        this.x /= value.x;
        this.y /= value.y;
        this.z /= value.z;
        return this;
    }

    @Override
    public Vector3f div(Vector3f value, Vector3f pointer) {
        pointer.x = this.x / value.x;
        pointer.y = this.y / value.y;
        pointer.z = this.z / value.z;
        return pointer;
    }

    @Override
    public double distance(Vector3f value) {
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
    public double dot(Vector3f value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public double cross(Vector3f value) {
        return new Vector3f(
                this.y * value.z - this.z * value.y,
                this.z * value.x - this.x * value.z,
                this.x * value.y - this.y * value.x
        ).len();
    }

    @Override
    public double angle(Vector3f value) {
        return acos((this.x * value.x + this.y * value.y + this.z * value.z) / (this.len() * value.len()));
    }

    @Override
    public Buffer get(Buffer pointer) {
        ((FloatBuffer) pointer).put(0, this.x);
        ((FloatBuffer) pointer).put(1, this.y);
        ((FloatBuffer) pointer).put(2, this.z);
        return pointer;
    }

    @Override
    public Float[] get(Float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }

    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Float[] toArray() {
        return new Float[]{
                this.x,
                this.y,
                this.z};
    }

    @Override
    public void copy(Vector3f copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    @Override
    public Vector3f copy() {
        return new Vector3f(this);
    }

    @Override
    public Vector3f abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    @Override
    public Vector3f abs(Vector3f pointer) {
        pointer.x = Math.abs(this.x);
        pointer.y = Math.abs(this.y);
        pointer.z = Math.abs(this.z);
        return pointer;
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.x;
        pointer[1] = this.y;
        pointer[2] = this.z;
        return pointer;
    }
}
