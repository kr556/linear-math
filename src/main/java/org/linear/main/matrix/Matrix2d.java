package org.linear.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

// TODO: 2023/12/09
public class Matrix2d extends SquareMatrix<Double, Matrix2d>
        implements DoubleMatrix<Matrix2d, Matrix2d> {
    public final static Matrix2d NAN = new Matrix2d(
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN);

    public final static Matrix2d DIAGONAL = new Matrix2d(
            1, 0,
            0, 1);

    public double
            m00, m01,
            m10, m11;

    public Matrix2d(double m00, double m01,
                    double m10, double m11) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
    }

    public Matrix2d(float m00, float m01,
                    float m10, float m11) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
    }

    public Matrix2d(Matrix2d copy) {
        set(copy);
    }

    public Matrix2d() {}

    @Override
    public double determinant() {
        return m00 * m11 - m01 * m10;
    }

    @Override
    public void set(Matrix2d copy) {
        this.m00 = copy.m00; this.m01 = copy.m01;
        this.m10 = copy.m10; this.m11 = copy.m11;
    }

    @Override
    public Matrix2d copy() {
        return new Matrix2d(this);
    }

    @Override
    public Matrix2d abs() {
        this.m00 = Math.abs(m00); this.m01 = Math.abs(m01);
        this.m10 = Math.abs(m10); this.m11 = Math.abs(m11);
        return this;
    }

    @Override
    public Matrix2d abs(Matrix2d pointer) {
        pointer.m00 = Math.abs(m00); pointer.m01 = Math.abs(m01);
        pointer.m10 = Math.abs(m10); pointer.m11 = Math.abs(m11);
        return this;
    }

    @Override
    public Matrix2d add(double value) {
        this.m00 += value; this.m01 += value;
        this.m10 += value; this.m11 += value;
        return this;
    }

    @Override
    public Matrix2d add(double value, Matrix2d pointer) {
        pointer.m00 = m00 + value; pointer.m01 = m01 + value;
        pointer.m10 = m10 + value; pointer.m11 = m11 + value;
        return pointer;
    }

    @Override
    public Matrix2d add(Matrix2d value) {
        this.m00 += value.m00; this.m01 += value.m01;
        this.m10 += value.m10; this.m11 += value.m11;
        return this;
    }

    @Override
    public Matrix2d add(Matrix2d value, Matrix2d pointer) {
        pointer.m00 = m00 + value.m00; pointer.m01 = m01 + value.m01;
        pointer.m10 = m10 + value.m10; pointer.m11 = m11 + value.m11;
        return pointer;
    }

    @Override
    public Matrix2d sub(double value) {
        this.m00 -= value; this.m01 -= value;
        this.m10 -= value; this.m11 -= value;
        return this;
    }

    @Override
    public Matrix2d sub(double value, Matrix2d pointer) {
        pointer.m00 = m00 - value; pointer.m01 = m01 - value;
        pointer.m10 = m10 - value; pointer.m11 = m11 - value;
        return pointer;
    }

    @Override
    public Matrix2d sub(Matrix2d value) {
        this.m00 -= value.m00; this.m01 -= value.m01;
        this.m10 -= value.m10; this.m11 -= value.m11;
        return this;
    }

    @Override
    public Matrix2d sub(Matrix2d value, Matrix2d pointer) {
        pointer.m00 = m00 - value.m00; pointer.m01 = m01 - value.m01;
        pointer.m10 = m10 - value.m10; pointer.m11 = m11 - value.m11;
        return pointer;
    }

    @Override
    public Matrix2d mul(double value) {
        this.m00 *= value; this.m01 *= value;
        this.m10 *= value; this.m11 *= value;
        return this;
    }

    @Override
    public Matrix2d mul(double value, Matrix2d pointer) {
        pointer.m00 = m00 * value; pointer.m01 = m01 * value;
        pointer.m10 = m10 * value; pointer.m11 = m11 * value;
        return pointer;
    }

    @Override
    public Matrix2d div(double value) {
        this.m00 /= value; this.m01 /= value;
        this.m10 /= value; this.m11 /= value;
        return this;
    }

    @Override
    public Matrix2d div(double value, Matrix2d pointer) {
        pointer.m00 = m00 / value; pointer.m01 = m01 / value;
        pointer.m10 = m10 / value; pointer.m11 = m11 / value;
        return pointer;
    }

    @Override
    public Matrix2d div(Matrix2d value) {
        this.m00 /= value.m00; this.m01 /= value.m01;
        this.m10 /= value.m10; this.m11 /= value.m11;
        return this;
    }

    @Override
    public Matrix2d div(Matrix2d value, Matrix2d pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Matrix2d mul(Matrix2d value) {
        this.m00 *= value.m00;
        this.m01 *= value.m01;
        this.m10 *= value.m10;
        this.m11 *= value.m11;
        return this;
    }

    @Override
    public Matrix2d mul(Matrix2d value, Matrix2d pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Double get(int index) {
        return switch (index) {
            case 0 -> m00; case 1 -> m01;
            case 2 -> m10; case 3 -> m11;
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public boolean equals(@NotNull Matrix2d value) {
        return this.m00 == value.m00 &&
               this.m01 == value.m01 &&
               this.m10 == value.m10 &&
               this.m11 == value.m11;
    }

    @Override
    public final boolean isNaN() {
        return equals(NAN);
    }

    @Override
    public Matrix2d transpose() {
        final double m12 = this.m10;
        final double m21 = this.m01;
        this.m01 = m12;
        this.m10 = m21;
        return this;
    }

    @Override
    public Matrix2d transpose(Matrix2d pointer) {
        pointer.m00 = m00;
        pointer.m01 = m10;
        pointer.m11 = m11;
        pointer.m10 = m01;
        return pointer;
    }

    public final Matrix2d mulC(double m00, double m01,
                               double m10, double m11) {
        set(
                this.m00 * m00 + this.m01 * m10, this.m00 * m01 + this.m01 * m11,
                this.m10 * m00 + this.m11 * m10, this.m10 * m01 + this.m11 * m11
        );
        return this;
    }

    @Override
    public Matrix2d mulC(Matrix2d value) {
        return mulC(
                value.m00, value.m01,
                value.m10, value.m11);
    }

    public final Matrix2d mulR(double m00, double m01,
                               double m10, double m11) {
        set(
                m00 * this.m00 + m01 * this.m10, m00 * this.m01 + m01 * this.m11,
                m10 * this.m00 + m11 * this.m10, m10 * this.m01 + m11 * this.m11
        );
        return this;
    }

    @Override
    public Matrix2d mulR(Matrix2d value) {
        return mulR(
                value.m00, value.m01,
                value.m10, value.m11);
    }

    @Override
    public Matrix2d create() {
        return new Matrix2d();
    }

    @PropertiesMethod
    @Override
    public final int columnDimension() {
        return 3;
    }

    @PropertiesMethod
    @Override
    public final int rowDimension() {
        return 3;
    }

    @PropertiesMethod
    @Override
    public final int elementsSize() {
        return 9;
    }

    @Final
    @Override
    public Double[] getRow(int index) {
        return switch (index) {
            case 0 -> new Double[]{m00, m01};
            case 1 -> new Double[]{m10, m11};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Final
    @Override
    public Double[] getColumn(int index) {
        return switch (index) {
            case 0 -> new Double[]{m00, m10};
            case 1 -> new Double[]{m01, m11};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Final
    @Override
    public void set(int r, int c, Double value) {
        switch (r) {
            case 0 -> {
                switch (c) {
                    case 0 -> m00 = value;
                    case 1 -> m01 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 1 -> {
                switch (c) {
                    case 0 -> m10 = value;
                    case 1 -> m11 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(double m00, double m01,
                    double m10, double m11) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
    }

    @Override
    public Double get(int r, int c) {
        return switch (r) {
            case 0 -> switch (c) {
                case 0 -> m00;
                case 1 -> m01;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 1 -> switch (c) {
                case 0 -> m10;
                case 1 -> m11;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public Matrix2d invert() {
        double det = determinant();
        if (det != 0) {
            set(
                    m11, -m01,
                    -m10, m00);

            return this.mul(1 / det);
        }

        return null;
    }

    @Override
    public Matrix2d invert(Matrix2d pointer) {
        pointer.set(this);
        return pointer.invert();
    }

    @Override
    public double[] toArray(double[] pointer) {
        pointer[0] = this.m00;
        pointer[1] = this.m01;
        pointer[4] = this.m10;
        pointer[5] = this.m11;
        return pointer;
    }
}
