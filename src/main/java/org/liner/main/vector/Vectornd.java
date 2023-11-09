package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class Vectornd extends DoubleVector<Vectornd> {
    public double[] v;
    private final int dim;

    public Vectornd(Vectornd copy) {
        super(copy);
        this.dim = v.length;
    }

    public Vectornd(Double... v) {
        super(null);
        this.v = new double[v.length];
        this.dim = this.v.length;

        for (int i = 0; i < v.length; i++) {
            this.v[i] = v[i];
        }
    }

    public Vectornd(double... v) {
        super(null);
        this.v = v;
        this.dim = this.v.length;
    }

    public Vectornd(int dimensional) {
        super(null);
        this.v = new double[dimensional];
        this.dim = this.v.length;
        Arrays.fill(v, 0);
    }

    @Override
    public Vectornd add(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] += value;
        }

        return this;
    }

    @Override
    public Vectornd add(double value, Vectornd pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value;
        }

        return this;
    }

    @Override
    public Vectornd add(Vectornd value) {
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] += value.v[i];
        }

        return this;
    }

    @Override
    public Vectornd add(Vectornd value, Vectornd pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value.v[i];
        }

        return pointer;
    }

    @Override
    public Vectornd sub(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value;
        }

        return this;
    }

    @Override
    public Vectornd sub(double value, Vectornd pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value;
        }

        return pointer;
    }

    @Override
    public Vectornd sub(Vectornd value) {
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < v.length; i++) {
            this.v[i] -= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornd sub(Vectornd value, Vectornd pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] - value.v[i];
        }

        return pointer;
    }

    @Override
    public Vectornd mul(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value;
        }

        return this;
    }

    @Override
    public Vectornd mul(double value, Vectornd pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value;
        }

        return pointer;
    }

    @Override
    public Vectornd mul(Vectornd value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornd mul(Vectornd value, Vectornd pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value.v[i];
        }

        return pointer;
    }

    @Override
    public Vectornd div(double value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value;
        }

        return this;
    }

    @Override
    public Vectornd div(double value, Vectornd pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] / value;
        }

        return pointer;
    }

    @Override
    public Vectornd div(Vectornd value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value.v[i];
        }

        return this;
    }

    @Override
    public Vectornd div(Vectornd value, Vectornd pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] + value.v[i];
        }

        return pointer;
    }

    @Override
    public double distance(Vectornd value) {
        double[] x = new double[dim];

        for (int i = 0; i < dimensional(); i++) {
            x[i] = x[i] - value.v[i];
        }

        return new Vectornd(x).len();
    }

    public double len() {
        double sum = 0;

        for (double f : v) {
            sum += f * f;
        }

        return sqrt(sum);
    }

    public double length(int plot) { // if want XYZ for XYZW vector, input 4.
        double[] in = new double[dimensional() - 1];

        for (int i = 0; i < in.length; i++) {
            if (i != plot) {
                in[i] = this.v[i];
            }
        }

        return new Vectornd(in).len();
    }

    public double dot(Vectornd value) {
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
        double[] in = new double[dimensional() - 1];

        for (int i = 0; i < in.length; i++) {
            if (i != plot) {
                in[i] = this.v[i];
            }
        }

        double re = acos(new Vectornd(in).len() / this.len());

        if (Double.isNaN(re)) {
            return 0;
        }

        return re;
    }

    public double angle(Vectornd value) {
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

        return acos(IntStream.range(0, dimensional()).mapToDouble(i -> this.v[i] * value.v[i]).sum() / (this.len() * value.len()));
    }

    public Double get(int index) {
        return v[index];
    }

    @Override
    public void set(int index, @NotNull Double value) {
        this.v[index] = value;
    }

    @Override
    public boolean equals(@NotNull Vectornd value) {
        if (this.dim != value.dim) return false;
        for (int i = 0; i < dim; i++) {
            if (this.v[i] != value.v[i]) return false;
        }
        return true;
    }

    @Override
    public int dimensional() {
        return dim;
    }

    public double[] getElements() {
        return v;
    }


    public void set(double... fs) {
        this.v = fs;
    }

    public void set(int index, double f) {
        this.v[index] = f;
    }

    public DoubleVector<?> toVectord(int dimension) {
        return switch (dimension) {
            case 2 -> new Vector2d(v[0], v[1]);
            case 3 -> new Vector3d(v[0], v[1], v[2]);
            case 4 -> new Vector4d(v[0], v[1], v[2], v[3]);
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
    public Double[] get(Double[] pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer[i] = v[i];
        }

        return pointer;
    }

    @Override
    public Double[] toArray() {
        Double[] re = new Double[dimensional()];
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
    public void copy(Vectornd copy) {
        this.v = copy.v;
    }

    @Override
    public Vectornd copy() {
        return new Vectornd(v);
    }

    @Override
    public Vectornd abs() {
        for (int i = 0; i < dimensional(); i++) {
            this.v[i] = Math.abs(this.v[i]);
        }

        return this;
    }

    @Override
    public Vectornd abs(Vectornd pointer) {
        for (int i = 0; i < dimensional(); i++) {
            pointer.v[i] = Math.abs(this.v[i]);
        }

        return pointer;
    }

    @Override
    public double[] toArray(double[] pointer) {
        for (int i = 0; i < dim; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }
}