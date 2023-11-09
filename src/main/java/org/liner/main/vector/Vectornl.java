package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class Vectornl extends LongVector<Vectornl> {
    public long[] v;
    private final int dim;

    public Vectornl(Vectornl copy) {
        super(copy);
        this.dim = copy.dim;
    }

    public Vectornl(Long... v) {
        super(null);
        this.v = new long[v.length];

        for (int i = 0; i < v.length; i++) {
            this.v[i] = v[i];
        }

        this.dim = this.v.length;
    }

    public Vectornl(long... v) {
        super(null);
        this.v = v;
        this.dim = this.v.length;
    }

    public Vectornl(int dimensional) {
        super(null);
        this.v = new long[dimensional];
        this.dim = this.v.length;
        Arrays.fill(v, 0);
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
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

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
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

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
    public Vectornl mul(long value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value;
        }

        return this;
    }

    @Override
    public Vectornl mul(long value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value;
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
    public Vectornl div(long value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value;
        }

        return this;
    }

    @Override
    public Vectornl div(long value, Vectornl pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] / value;
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

        for (int i = 0; i < dimensional(); i++) {
            x[i] = x[i] - value.v[i];
        }

        return new Vectornl(x).len();
    }

    public double len() {
        double sum = 0;

        for (double f : v) {
            sum += f * f;
        }

        return sqrt(sum);
    }

    public double length(int plot) { // if want XYZ for XYZW vector, input 4.
        long[] in = new long[dimensional() - 1];

        for (int i = 0; i < in.length; i++) {
            if (i != plot) {
                in[i] = this.v[i];
            }
        }

        return new Vectornl(in).len();
    }

    public double dot(Vectornl value) {
        return this.len() * value.len() * cos(this.angle(value));
    }

//    public Vector<Float> cross(Vectornf value) {
//        return switch (this.dimensional()) {
//            case 2 -> new Vector2f(fs[0], fs[1]).cross((Vector2f) value.toVectorf(2));
//            case 3 -> new Vector3f(fs[0], fs[1], fs[2]).cross((Vector3f) value.toVectorf(3));
//            case 7 -> new Vectornf(
//                    fs[2] * value.fs[3] - fs[3] * value.fs[2] - fs[4] * value.fs[5] + fs[5] * value.fs[4] - fs[6] * value.fs[7] + fs[7] * value.fs[6],
//                    -fs[1] * value.fs[3] + fs[3] * value.fs[1] - fs[4] * value.fs[6] + fs[5] * value.fs[7] + fs[6] * value.fs[4] - fs[7] * value.fs[5],
//                    fs[1] * value.fs[2] - fs[2] * value.fs[1] - fs[4] * value.fs[7] - fs[5] * value.fs[6] + fs[6] * value.fs[5] + fs[7] * value.fs[4],
//                    fs[1] * value.fs[5] + fs[2] * value.fs[6] + fs[3] * value.fs[7] - fs[5] * value.fs[1] - fs[6] * value.fs[2] - fs[7] * value.fs[3],
//                    -fs[1] * value.fs[4] - fs[2] * value.fs[7] + fs[3] * value.fs[6] + fs[4] * value.fs[1] - fs[6] * value.fs[3] + fs[7] * value.fs[2],
//                    fs[1] * value.fs[7] - fs[2] * value.fs[4] - fs[3] * value.fs[5] + fs[4] * value.fs[2] + fs[5] * value.fs[3] - fs[7] * value.fs[1],
//                    -fs[1] * value.fs[6] + fs[2] * value.fs[5] - fs[3] * value.fs[4] + fs[4] * value.fs[3] - fs[5] * value.fs[2] + fs[7] * value.fs[1]
//            );
//            default -> throw new UnsupportedOperationException("Cant calculation this dimensional of vector.");
//        };
//    }

    public double angle(int plot) { // Axis to exclude.
        long[] in = new long[dimensional() - 1];

        for (int i = 0; i < in.length; i++) {
            if (i != plot) {
                in[i] = this.v[i];
            }
        }

        double re = acos(new Vectornl(in).len() / this.len());

        if (Double.isNaN(re)) {
            return 0;
        }
        return re;
    }

    public double angle(Vectornl value) {
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

        return acos(IntStream.range(0, dimensional()).mapToDouble(i -> this.v[i] * value.v[i]).sum() / (this.len() * value.len()));
    }

    public Long get(int index) {
        return v[index];
    }

    @Override
    public void set(int index, @NotNull Long value) {
        this.v[index] = value;
    }

    @Override
    public int dimensional() {
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

    public long[] getElements() {
        return v;
    }

    public void set(long... fs) {
        this.v = fs;
    }

    public void set(int index, long f) {
        this.v[index] = f;
    }

    public LongVector<?> toVectord(int dimension) {
        return switch (dimension) {
            case 2 -> new Vector2l(v[0], v[1]);
            case 3 -> new Vector3l(v[0], v[1], v[2]);
            case 4 -> new Vector4l(v[0], v[1], v[2], v[3]);
            default -> this;
        };
    }

    @Override
    public Buffer get(Buffer pointer) {
        for (int i = 0; i < dimensional(); i++) {
            ((DoubleBuffer) pointer).put(i, v[i]);
        }
        return pointer;
    }

    @Override
    public Long[] get(Long[] pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }

    @Override
    public Long[] toArray() {
        Long[] re = new Long[dimensional()];
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
    public void copy(Vectornl copy) {
        this.v = copy.v;
    }

    @Override
    public Vectornl copy() {
        return new Vectornl(v);
    }

    @Override
    public Vectornl abs() {
        for (int i = 0; i < dimensional(); i++) {
            this.v[i] = Math.abs(this.v[i]);
        }
        return this;
    }

    @Override
    public Vectornl abs(Vectornl pointer) {
        for (int i = 0; i < dimensional(); i++) {
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