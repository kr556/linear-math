package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;

// TODO: 2023/12/03 実装
// FIXME: 2023/12/03 最適化
public class Vectorni extends AbsVector<Integer, Vectorni> implements IntVector<Vectorni> {
    public int[] v;
    private final int dim;

    public Vectorni(Vectorni copy) {
        dim = v.length;
    }

    public Vectorni(Integer... v) {
        this.v = new int[v.length];
        this.dim = this.v.length;

        for (int i = 0; i < v.length; i++) {
            this.v[i] = v[i];
        }
    }

    public Vectorni(int... v) {
        this.v = v;
        this.dim = this.v.length;
    }

    public Vectorni(int dimensional) {
        this.v = new int[dimensional];
        this.dim = this.v.length;
        Arrays.fill(v, 0);
    }

    @Override
    public Vectorni add(int value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] += value;
        }

        return this;
    }

    @Override
    public Vectorni add(int value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value;
        }

        return this;
    }

    @Override
    public Vectorni add(Vectorni value) {
        if (this.dimension() != value.dimension()) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] += value.v[i];
        }

        return this;
    }

    @Override
    public Vectorni add(Vectorni value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value.v[i];
        }

        return this;
    }

    @Override
    public Vectorni sub(int value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value;
        }

        return this;
    }

    @Override
    public Vectorni sub(int value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value;
        }

        return this;
    }

    @Override
    public Vectorni sub(Vectorni value) {
        if (this.dimension() != value.dimension()) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value.v[i];
        }

        return this;
    }

    @Override
    public Vectorni sub(Vectorni value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value.v[i];
        }

        return this;
    }

    @Override
    public Vectorni mul(float value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value;
        }

        return this;
    }

    @Override
    public Vectorni mul(float value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = (int) (this.v[i] * value);
        }

        return this;
    }

    @Override
    public Vectorni mul(Vectorni value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value.v[i];
        }

        return this;
    }

    @Override
    public Vectorni mul(Vectorni value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value.v[i];
        }

        return this;
    }

    @Override
    public Vectorni div(float value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value;
        }

        return this;
    }

    @Override
    public Vectorni div(float value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = (int) (this.v[i] / value);
        }

        return this;
    }

    @Override
    public Vectorni div(Vectorni value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value.v[i];
        }

        return this;
    }

    @Override
    public Vectorni div(Vectorni value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] / value.v[i];
        }

        return this;
    }

    @Override
    public double distance(Vectorni value) {
        int[] x = new int[dim];

        for (int i = 0; i < dimension(); i++) {
            x[i] = x[i] - value.v[i];
        }

        return new Vectorni(x).len();
    }

    @Override
    public double len() {
        double sum = 0;

        for (double f : v) {
            sum += f * f;
        }

        return sqrt(sum);
    }

    @Override
    public double dot(Vectorni value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vectorni nomalize() {
        div((float) len());
        return this;
    }

    @Override
    public Vectorni nomalize(Vectorni pointer) {
        pointer.set(this);
        pointer.nomalize();
        return pointer;
    }

    @Override
    public double angle(Vectorni value) {
        if (this.dimension() != value.dimension()) throw new ArrayIndexOutOfBoundsException();

        return acos(IntStream.range(0, dimension()).mapToDouble(i -> this.v[i] * value.v[i]).sum() / (this.len() * value.len()));
    }

    @Override
    public Integer get(int index) {
        return v[index];
    }

    @Override
    public void set(int index, @NotNull Integer value) {
        this.v[index] = value;
    }

    @Override
    public boolean equals(@NotNull Vectorni value) {
        if (this.dim != value.dim) return false;
        if (this == value || this.v == value.v) return true;
        for (int i = 0; i < dim; i++) {
            if (this.v[i] != value.v[i]) return false;
        }
        return true;
    }

    @Override
    public final boolean isNaN() {
        return false;
    }

    @Override
    public final int dimension() {
        return dim;
    }

    public int[] getElements() {
        return v;
    }

    public void set(int... fs) {
        this.v = fs;
    }

    public void set(int index, int f) {
        this.v[index] = f;
    }

    @Override
    public Buffer get(Buffer pointer) {
        for (int i = 0; i < dimension(); i++) {
            ((IntBuffer) pointer).put(i, v[i]);
        }
        return pointer;
    }

    @Override
    public Integer[] toArray(Integer[] pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }

    @Override
    public Integer[] toArray() {
        Integer[] re = new Integer[dimension()];
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
    public void set(Vectorni copy) {
        this.v = copy.v;
    }

    @Override
    public Vectorni copy() {
        return new Vectorni(this);
    }

    @Override
    public Vectorni abs() {
        for (int i = 0; i < dimension(); i++) {
            this.v[i] = Math.abs(this.v[i]);
        }

        return this;
    }

    @Override
    public Vectorni abs(Vectorni pointer) {
        for (int i = 0; i < dimension(); i++) {
            pointer.v[i] = Math.abs(this.v[i]);
        }
        return pointer;
    }

    @Override
    public int[] toArray(int[] pointer) {
        for (int i = 0; i < dim; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }
}