package org.liner.main.vector;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class Vectornf extends FloatVector<Vectornf> {
    public float[] v;
    private final int dim;

    public Vectornf(Vectornf copy) {
        super(copy);
        dim = v.length;
    }

    public Vectornf(Float... fs) {
        super(null);
        this.v = new float[fs.length];
        this.dim = this.v.length;

        for (int i = 0; i < fs.length; i++) {
            this.v[i] = fs[i];
        }
    }

    public Vectornf(float... fs) {
        super(null);
        this.v = fs;
        this.dim = this.v.length;
    }

    public Vectornf(double... fs) {
        super(null);
        float[] in = new float[fs.length];
        for (int i = 0; i < fs.length; i++) {
            in[i] = (float) fs[i];
        }
        this.v = in;
        this.dim = this.v.length;
    }

    public Vectornf(int dimensional) {
        super(null);
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
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

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
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

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

        for (int i = 0; i < dimensional(); i++) {
            x[i] = x[i] - value.v[i];
        }

        return new Vectornf(x).len();
    }

    public double len() {
        double sum = 0;

        for (float f : v) {
            sum += f * f;
        }

        return sqrt(sum);
    }

    public double length(int plot) { // If want XYZ for XYZW vector, input 4.
        double[] in = new double[dimensional() - 1];

        for (int i = 0; i < in.length; i++) {
            if (i != plot) {
                in[i] = this.v[i];
            }
        }

        return new Vectornf(in).len();
    }

    public double dot(Vectornf value) {
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

    public double angle(int plot) {
        double[] in = new double[dimensional() - 1];

        for (int i = 0; i < in.length; i++) {
            if (i != plot) {
                in[i] = this.v[i];
            }
        }

        double re = acos(new Vectornf(in).len() / this.len());

        if (Double.isNaN(re)) return 0;

        return re;
    }

    public double angle(Vectornf value) {
        if (this.dimensional() != value.dimensional()) throw new ArrayIndexOutOfBoundsException();

        return acos(IntStream.range(0, dimensional()).mapToDouble(i -> this.v[i] * value.v[i]).sum() / (this.len() * value.len()));
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
    public int dimensional() {
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

    public FloatVector<?> toVectorf(int dimension) {
        return switch (dimension) {
            case 2 -> new Vector2f(v[0], v[1]);
            case 3 -> new Vector3f(v[0], v[1], v[2]);
            case 4 -> new Vector4f(v[0], v[1], v[2], v[3]);
            default -> this;
        };
    }

    @Override
    public Buffer get(Buffer pointer) {
        for (int i = 0; i < dimensional(); i++) {
            ((FloatBuffer) pointer).put(i, v[i]);
        }
        return pointer;
    }

    @Override
    public Float[] get(Float[] pointer) {
        for (int i = 0; i < v.length; i++) {
            pointer[i] = v[i];
        }
        return pointer;
    }

    @Override
    public Float[] toArray() {
        Float[] re = new Float[dimensional()];
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
    public void copy(Vectornf copy) {
        this.v = copy.v;
    }

    @Override
    public Vectornf copy() {
        return new Vectornf(v);
    }

    @Override
    public Vectornf abs() {
        for (int i = 0; i < dimensional(); i++) {
            this.v[i] = Math.abs(this.v[i]);
        }

        return this;
    }

    @Override
    public Vectornf abs(Vectornf pointer) {
        for (int i = 0; i < dimensional(); i++) {
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