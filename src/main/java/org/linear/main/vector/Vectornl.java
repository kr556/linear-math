package org.linear.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;

// TODO: 2023/12/03 実装
// FIXME: 2023/12/03 最適化
public class Vectornl extends AbsVector<Long, Vectornl> implements LongVector<Vectornl> {
    public long[] v;
    private final int dim;

    public Vectornl(Vectornl copy) {
        this.dim = copy.dim;
    }

    public Vectornl(Long... v) {
        this.v = new long[v.length];

        System.arraycopy(v, 0, this.v, 0, v.length);

        this.dim = v.length;
    }

    public Vectornl(long... v) {
        this.v = new long[v.length];

        System.arraycopy(v, 0, this.v, 0, v.length);

        this.dim = v.length;
    }

    public Vectornl(int dimensional) {
        this.v = new long[dimensional];
        this.dim = this.v.length;
    }

    @Override
    public Vectornl add(long value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] += value;
        }

        return this;
    }

    @Override
    public Vectornl add(long value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value;
        }

        return this;
    }

    @Override
    public Vectornl add(Vectornl value) {
        if (this.dimension() != value.dimension()) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] += value.v[i];
        }

        return this;
    }

    @Override
    public Vectornl add(Vectornl value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value.v[i];
        }

        return this;
    }

    @Override
    public Vectornl sub(long value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value;
        }

        return this;
    }

    @Override
    public Vectornl sub(long value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value;
        }

        return this;
    }

    @Override
    public Vectornl sub(Vectornl value) {
        if (this.dimension() != value.dimension()) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornl sub(Vectornl value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value.v[i];
        }

        return this;
    }

    @Override
    public Vectornl mul(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value;
        }

        return this;
    }

    @Override
    public Vectornl mul(double value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = (long) (this.v[i] * value);
        }

        return this;
    }

    @Override
    public Vectornl mul(Vectornl value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornl mul(Vectornl value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value.v[i];
        }

        return this;
    }

    @Override
    public Vectornl div(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value;
        }

        return this;
    }

    @Override
    public Vectornl div(double value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = (long) (this.v[i] / value);
        }

        return this;
    }

    @Override
    public Vectornl div(Vectornl value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornl div(Vectornl value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] / value.v[i];
        }

        return this;
    }

    @Override
    public double distance(Vectornl value) {
        long[] x = new long[dim];

        for (int i = 0; i < dimension(); i++) {
            x[i] = x[i] - value.v[i];
        }

        return new Vectornl(x).len();
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
    public double dot(Vectornl value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

    @Override
    public Vectornl nomalize() {
        div(len());
        return this;
    }

    @Override
    public Vectornl nomalize(Vectornl pointer) {
        pointer.set();
        pointer.nomalize();
        return pointer;
    }

    @Override
    public double angle(Vectornl value) {
        if (this.dimension() != value.dimension()) throw new ArrayIndexOutOfBoundsException();

        return acos(IntStream.range(0, dimension()).mapToDouble(i -> this.v[i] * value.v[i]).sum() / (this.len() * value.len()));
    }

    @Override
    public Long get(int index) {
        return v[index];
    }

    @Override
    public void set(int index, @NotNull Long value) {
        this.v[index] = value;
    }

    @Override
    public final int dimension() {
        return dim;
    }

    @Override
    public boolean equals(@NotNull Vectornl value) {
        if (this.dim != value.dim) return false;
        for (int i = 0; i < dim; i++) {
            if (this.v[i] != value.v[i]) return false;
        }
        return true;
    }

    @Override
    public final boolean isNaN() {
        return false;
    }

    public long[] getElements() {
        return v;
    }

    public void set(long... fs) {
        this.v = fs;
    }

    public void set(int index, long f) {
        this.v[index] = f;
    }

    @Override
    public Buffer get(Buffer pointer) {
        for (int i = 0; i < dimension(); i++) {
            ((DoubleBuffer) pointer).put(i, v[i]);
        }
        return pointer;
    }

    @Override
    public Long[] toArray(Long[] pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }

    @Override
    public Long[] toArray() {
        Long[] re = new Long[dimension()];
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
    public void set(Vectornl copy) {
        this.v = copy.v;
    }

    @Override
    public Vectornl copy() {
        return new Vectornl(v);
    }

    @Override
    public Vectornl abs() {
        for (int i = 0; i < dimension(); i++) {
            this.v[i] = Math.abs(this.v[i]);
        }
        return this;
    }

    @Override
    public Vectornl abs(Vectornl pointer) {
        for (int i = 0; i < dimension(); i++) {
            pointer.v[i] = Math.abs(this.v[i]);
        }
        return pointer;
    }

    @Override
    public long[] toArray(long[] pointer) {
        for (int i = 0; i < dim; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }
}