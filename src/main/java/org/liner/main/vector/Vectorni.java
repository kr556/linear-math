package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class Vectorni extends IntVector<Vectorni> {
    public int[] v;
    private final int dim;

    public Vectorni(Vectorni copy) {
        super(copy);
        dim = v.length;
    }

    public Vectorni(Integer... v) {
        super(null);
        this.v = new int[v.length];
        this.dim = this.v.length;

        for (int i = 0; i < v.length; i++) {
            this.v[i] = v[i];
        }
    }

    public Vectorni(int... v) {
        super(null);
        this.v = v;
        this.dim = this.v.length;
    }

    public Vectorni(int dimensional) {
        super(null);
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
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

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
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

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
    public Vectorni mul(int value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] *= value;
        }

        return this;
    }

    @Override
    public Vectorni mul(int value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] * value;
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
    public Vectorni div(int value) {
        for (int i = 0; i < v.length; i++) {
            this.v[i] /= value;
        }

        return this;
    }

    @Override
    public Vectorni div(int value, Vectorni pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer.v[i] = this.v[i] / value;
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

        for (int i = 0; i < dimensional(); i++) {
            x[i] = x[i] - value.v[i];
        }

        return new Vectorni(x).len();
    }

    public double len() {
        double sum = 0;

        for (double f : v) {
            sum += f * f;
        }

        return sqrt(sum);
    }

    public double length(int plot) { // if want XYZ for XYZW vector, input 4.
        int[] in = new int[dimensional() - 1];

        for (int i = 0; i < in.length; i++) {
            if (i != plot) {
                in[i] = this.v[i];
            }
        }

        return new Vectorni(in).len();
    }

    public double dot(Vectorni value) {
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
        int[] in = new int[dimensional() - 1];

        for (int i = 0; i < in.length; i++) {
            if (i != plot) {
                in[i] = this.v[i];
            }
        }

        double re = acos(new Vectorni(in).len() / this.len());

        if (Double.isNaN(re)) {
            return 0;
        }
        return re;
    }

    public double angle(Vectorni value) {
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

        return acos(IntStream.range(0, dimensional()).mapToDouble(i -> this.v[i] * value.v[i]).sum() / (this.len() * value.len()));
    }

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
        for (int i = 0; i < dim; i++) {
            if (this.v[i] != value.v[i]) return false;
        }
        return true;
    }

    @Override
    public int dimensional() {
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

    public IntVector<?> toVectord(int dimension) {
        return switch (dimension) {
            case 2 -> new Vector2i(v[0], v[1]);
            case 3 -> new Vector3i(v[0], v[1], v[2]);
            case 4 -> new Vector4i(v[0], v[1], v[2], v[3]);
            default -> this;
        };
    }

    @Override
    public Buffer get(Buffer pointer) {
        for (int i = 0; i < dimensional(); i++) {
            ((IntBuffer) pointer).put(i, v[i]);
        }
        return pointer;
    }

    @Override
    public Integer[] get(Integer[] pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }

    @Override
    public Integer[] toArray() {
        Integer[] re = new Integer[dimensional()];
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
    public void copy(Vectorni copy) {
        this.v = copy.v;
    }

    @Override
    public Vectorni copy() {
        return new Vectorni(this);
    }

    @Override
    public Vectorni abs() {
        for (int i = 0; i < dimensional(); i++) {
            this.v[i] = Math.abs(this.v[i]);
        }

        return this;
    }

    @Override
    public Vectorni abs(Vectorni pointer) {
        for (int i = 0; i < dimensional(); i++) {
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