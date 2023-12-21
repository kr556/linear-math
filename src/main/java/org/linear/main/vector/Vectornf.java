package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;

// TODO: 2023/12/03 実装
// FIXME: 2023/12/03 最適化
public class Vectornf extends AbsVector<Float, Vectornf> implements FloatVector<Vectornf> {
    public float[] v;
    private final int dim;

    public Vectornf(Vectornf copy) {
        set(copy);
        this.dim = v.length;
    }

    public Vectornf(Float ... v) {
        this.v = new float[v.length];
        this.dim = this.v.length;

        for (int i = 0; i < v.length; i++) {
            this.v[i] = v[i];
        }
    }

    public Vectornf(float... v) {
        this.v = v;
        this.dim = this.v.length;
    }

    public Vectornf(int dimensional) {
        this.v = new float[dimensional];
        this.dim = this.v.length;
        Arrays.fill(v, 0);
    }

    @Override
    public Vectornf add(float value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] += value;
        }

        return this;
    }

    @Override
    public Vectornf add(float value, Vectornf pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value;
        }

        return this;
    }

    @Override
    public Vectornf add(Vectornf value) {
        if (this.dimension() != value.dimension()) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] += value.v[i];
        }

        return this;
    }

    @Override
    public Vectornf add(Vectornf value, Vectornf pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value.v[i];
        }

        return pointer;
    }

    @Override
    public Vectornf sub(float value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value;
        }

        return this;
    }

    @Override
    public Vectornf sub(float value, Vectornf pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value;
        }

        return pointer;
    }

    @Override
    public Vectornf sub(Vectornf value) {
        if (this.dimension() != value.dimension()) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornf sub(Vectornf value, Vectornf pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value.v[i];
        }

        return pointer;
    }

    @Override
    public Vectornf mul(float value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value;
        }

        return this;
    }

    @Override
    public Vectornf mul(float value, Vectornf pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value;
        }

        return pointer;
    }

    @Override
    public Vectornf mul(Vectornf value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornf mul(Vectornf value, Vectornf pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value.v[i];
        }

        return pointer;
    }

    @Override
    public Vectornf div(float value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value;
        }

        return this;
    }

    @Override
    public Vectornf div(float value, Vectornf pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] / value;
        }

        return pointer;
    }

    @Override
    public Vectornf div(Vectornf value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornf div(Vectornf value, Vectornf pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value.v[i];
        }

        return pointer;
    }

    @Override
    public double distance(Vectornf value) {
        float[] x = new float[dim];

        for (int i = 0; i < dimension(); i++) {
            x[i] = x[i] - value.v[i];
        }

        return new Vectornf(x).len();
    }

    @Override
    public double len() {
        double sum = 0;

        for (float f : v) {
            sum += f * f;
        }

        return sqrt(sum);
    }

    @Override
    public double dot(Vectornf value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vectornf nomalize() {
        div((float) len());
        return this;
    }

    @Override
    public Vectornf nomalize(Vectornf pointer) {
        pointer.set(this);
        pointer.nomalize();
        return pointer;
    }

    @Override
    public double angle(Vectornf value) {
        if (this.dimension() != value.dimension()) throw new ArrayIndexOutOfBoundsException();

        return acos(IntStream.range(0, dimension()).mapToDouble(i -> this.v[i] * value.v[i]).sum() / (this.len() * value.len()));
    }

    @Override
    public Float get(int index) {
        return v[index];
    }

    @Override
    public void set(int index, @NotNull Float value) {
        this.v[index] = value;
    }

    @Override
    public boolean equals(@NotNull Vectornf value) {
        if (this.dim != value.dim) return false;
        for (int i = 0; i < dim; i++) {
            if (this.v[i] != value.v[i]) return false;
        }
        return true;
    }

    @Override
    public final boolean isNaN() {
        for (float v : v) {
            if (Double.isNaN(v)) return true;
        }
        return false;
    }

    @Override
    public final int dimension() {
        return dim;
    }

    public float[] getElements() {
        return v;
    }

    public void set(float... fs) {
        this.v = fs;
    }

    public void set(int index, float f) {
        this.v[index] = f;
    }

    @Override
    public Buffer get(Buffer pointer) {
        for (int i = 0; i < dimension(); i++) {
            ((FloatBuffer) pointer).put(i, v[i]);
        }
        return pointer;
    }

    @Override
    public Float[] toArray(Float[] pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }

    @Override
    public Float[] toArray() {
        Float[] re = new Float[dimension()];
        Arrays.setAll(re, i -> this.v[i]);
        return re;
    }

    @Override
    public String toString() {
        return Arrays.toString(v)
                .replace("[", "{")
                .replace("]", "}");
    }

    @Override
    public void set(Vectornf copy) {
        this.v = copy.v;
    }

    @Override
    public Vectornf copy() {
        return new Vectornf(v);
    }

    @Override
    public Vectornf abs() {
        for (int i = 0; i < dimension(); i++) {
            this.v[i] = Math.abs(this.v[i]);
        }

        return this;
    }

    @Override
    public Vectornf abs(Vectornf pointer) {
        for (int i = 0; i < dimension(); i++) {
            pointer.v[i] = Math.abs(this.v[i]);
        }

        return pointer;
    }

    @Override
    public float[] toArray(float[] pointer) {
        for (int i = 0; i < dim; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }
}