package org.liner.main.matrix;

import org.jetbrains.annotations.NotNull;

public class Matrix3d extends DoubleMatrix<Matrix3d, Matrix3d> implements SquareMatrix<Double, Matrix3d> {
    public double
            m11, m12, m13,
            m21, m22, m23,
            m31, m32, m33;

    public Matrix3d(double m00, double m01, double m02,
                    double m10, double m11, double m12,
                    double m20, double m21, double m22) {
        super(null);
        this.m11 = m00; this.m12 = m01; this.m13 = m02;
        this.m21 = m10; this.m22 = m11; this.m23 = m12;
        this.m31 = m20; this.m32 = m21; this.m33 = m22;
    }

    public Matrix3d(float m00, float m01, float m02,
                    float m10, float m11, float m12,
                    float m20, float m21, float m22) {
        super(null);
        this.m11 = m00; this.m12 = m01; this.m13 = m02;
        this.m21 = m10; this.m22 = m11; this.m23 = m12;
        this.m31 = m20; this.m32 = m21; this.m33 = m22;
    }

    public Matrix3d(Matrix3d copy) {
        super(copy);
    }

    @Override
    public double reduction() {
        return m11 * m22 * m33 +
                m12 * m23 * m31 +
                m13 * m21 * m32 -
                m13 * m22 * m31 -
                m11 * m23 * m32 -
                m12 * m21 * m33;
    }

    public Matrix3d() {
        super(null);
        this.m11 = 0f; this.m12 = 0f; this.m13 = 0f;
        this.m21 = 0f; this.m22 = 0f; this.m23 = 0f;
        this.m31 = 0f; this.m32 = 0f; this.m33 = 0f;
    }

    @Override
    public void copy(Matrix3d copy) {
        this.m11 = copy.m11; this.m12 = copy.m12; this.m13 = copy.m13;
        this.m21 = copy.m21; this.m22 = copy.m22; this.m23 = copy.m23;
        this.m31 = copy.m31; this.m32 = copy.m32; this.m33 = copy.m33;
    }

    @Override
    public Matrix3d copy() {
        return new Matrix3d(this);
    }

    @Override
    public Matrix3d abs() {
        this.m11 = Math.abs(m11); this.m12 = Math.abs(m12); this.m13 = Math.abs(m13);
        this.m21 = Math.abs(m21); this.m22 = Math.abs(m22); this.m23 = Math.abs(m23);
        this.m31 = Math.abs(m31); this.m32 = Math.abs(m32); this.m33 = Math.abs(m33);
        return this;
    }

    @Override
    public Matrix3d abs(Matrix3d pointer) {
        pointer.m11 = Math.abs(m11); pointer.m12 = Math.abs(m12); pointer.m13 = Math.abs(m13);
        pointer.m21 = Math.abs(m21); pointer.m22 = Math.abs(m22); pointer.m23 = Math.abs(m23);
        pointer.m31 = Math.abs(m31); pointer.m32 = Math.abs(m32); pointer.m33 = Math.abs(m33);
        return this;
    }

    @Override
    public Matrix3d add(double value) {
        this.m11 += value; this.m12 += value; this.m13 += value;
        this.m21 += value; this.m22 += value; this.m23 += value;
        this.m31 += value; this.m32 += value; this.m33 += value;
        return this;
    }

    @Override
    public Matrix3d add(double value, Matrix3d pointer) {
        pointer.m11 = m11 + value; pointer.m12 = m12 + value; pointer.m13 = m13 + value;
        pointer.m21 = m21 + value; pointer.m22 = m22 + value; pointer.m23 = m23 + value;
        pointer.m31 = m31 + value; pointer.m32 = m32 + value; pointer.m33 = m33 + value;
        return pointer;
    }

    @Override
    public Matrix3d add(Matrix3d value) {
        this.m11 += value.m11; this.m12 += value.m12; this.m13 += value.m13;
        this.m21 += value.m21; this.m22 += value.m22; this.m23 += value.m23;
        this.m31 += value.m31; this.m32 += value.m32; this.m33 += value.m33;
        return this;
    }

    @Override
    public Matrix3d add(Matrix3d value, Matrix3d pointer) {
        pointer.m11 = m11 + value.m11; pointer.m12 = m12 + value.m12; pointer.m13 = m13 + value.m13;
        pointer.m21 = m21 + value.m21; pointer.m22 = m22 + value.m22; pointer.m23 = m23 + value.m23;
        pointer.m31 = m31 + value.m31; pointer.m32 = m32 + value.m32; pointer.m33 = m33 + value.m33;
        return pointer;
    }

    @Override
    public Matrix3d sub(double value) {
        this.m11 -= value; this.m12 -= value; this.m13 -= value;
        this.m21 -= value; this.m22 -= value; this.m23 -= value;
        this.m31 -= value; this.m32 -= value; this.m33 -= value;
        return this;
    }

    @Override
    public Matrix3d sub(double value, Matrix3d pointer) {
        pointer.m11 = m11 - value; pointer.m12 = m12 - value; pointer.m13 = m13 - value;
        pointer.m21 = m21 - value; pointer.m22 = m22 - value; pointer.m23 = m23 - value;
        pointer.m31 = m31 - value; pointer.m32 = m32 - value; pointer.m33 = m33 - value;
        return pointer;
    }

    @Override
    public Matrix3d sub(Matrix3d value) {
        this.m11 -= value.m11; this.m12 -= value.m12; this.m13 -= value.m13;
        this.m21 -= value.m21; this.m22 -= value.m22; this.m23 -= value.m23;
        this.m31 -= value.m31; this.m32 -= value.m32; this.m33 -= value.m33;
        return this;
    }

    @Override
    public Matrix3d sub(Matrix3d value, Matrix3d pointer) {
        pointer.m11 = m11 - value.m11; pointer.m12 = m12 - value.m12; pointer.m13 = m13 - value.m13;
        pointer.m21 = m21 - value.m21; pointer.m22 = m22 - value.m22; pointer.m23 = m23 - value.m23;
        pointer.m31 = m31 - value.m31; pointer.m32 = m32 - value.m32; pointer.m33 = m33 - value.m33;
        return pointer;
    }

    @Override
    public Matrix3d mul(double value) {
        this.m11 *= value; this.m12 *= value; this.m13 *= value;
        this.m21 *= value; this.m22 *= value; this.m23 *= value;
        this.m31 *= value; this.m32 *= value; this.m33 *= value;
        return this;
    }

    @Override
    public Matrix3d mul(double value, Matrix3d pointer) {
        pointer.m11 = m11 * value; pointer.m12 = m12 * value; pointer.m13 = m13 * value;
        pointer.m21 = m21 * value; pointer.m22 = m22 * value; pointer.m23 = m23 * value;
        pointer.m31 = m31 * value; pointer.m32 = m32 * value; pointer.m33 = m33 * value;
        return pointer;
    }

    @Override
    public Matrix3d mul(Matrix3d value) {
        final double m00 = this.m11 * value.m11 + this.m12 * value.m21 + this.m13 * value.m31;
        final double m01 = this.m11 * value.m12 + this.m12 * value.m22 + this.m13 * value.m32;
        final double m02 = this.m11 * value.m13 + this.m12 * value.m23 + this.m13 * value.m33;
        final double m10 = this.m21 * value.m11 + this.m22 * value.m21 + this.m23 * value.m31;
        final double m11 = this.m21 * value.m12 + this.m22 * value.m22 + this.m23 * value.m32;
        final double m12 = this.m21 * value.m13 + this.m22 * value.m23 + this.m23 * value.m33;
        final double m20 = this.m31 * value.m11 + this.m32 * value.m21 + this.m33 * value.m31;
        final double m21 = this.m31 * value.m12 + this.m32 * value.m22 + this.m33 * value.m32;
        final double m22 = this.m31 * value.m13 + this.m32 * value.m23 + this.m33 * value.m33;
        this.m11 = m00;
        this.m12 = m01;
        this.m13 = m02;
        this.m21 = m10;
        this.m22 = m11;
        this.m23 = m12;
        this.m31 = m20;
        this.m32 = m21;
        this.m33 = m22;
        return this;
    }

    @Override
    public Matrix3d mul(Matrix3d value, Matrix3d pointer) {
        pointer.m11 = this.m11 * value.m11 + this.m12 * value.m21 + this.m13 * value.m31;
        pointer.m12 = this.m11 * value.m12 + this.m12 * value.m22 + this.m13 * value.m32;
        pointer.m13 = this.m11 * value.m13 + this.m12 * value.m23 + this.m13 * value.m33;
        pointer.m21 = this.m21 * value.m11 + this.m22 * value.m21 + this.m23 * value.m31;
        pointer.m22 = this.m21 * value.m12 + this.m22 * value.m22 + this.m23 * value.m32;
        pointer.m23 = this.m21 * value.m13 + this.m22 * value.m23 + this.m23 * value.m33;
        pointer.m31 = this.m31 * value.m11 + this.m32 * value.m21 + this.m33 * value.m31;
        pointer.m32 = this.m31 * value.m12 + this.m32 * value.m22 + this.m33 * value.m32;
        pointer.m33 = this.m31 * value.m13 + this.m32 * value.m23 + this.m33 * value.m33;
        return pointer;
    }

    @Override
    public Matrix3d div(double value) {
        this.m11 /= value; this.m12 /= value; this.m13 /= value;
        this.m21 /= value; this.m22 /= value; this.m23 /= value;
        this.m31 /= value; this.m32 /= value; this.m33 /= value;
        return this;
    }

    @Override
    public Matrix3d div(double value, Matrix3d pointer) {
        pointer.m11 = m11 / value; pointer.m12 = m12 / value; pointer.m13 = m13 / value;
        pointer.m21 = m21 / value; pointer.m22 = m22 / value; pointer.m23 = m23 / value;
        pointer.m31 = m31 / value; pointer.m32 = m32 / value; pointer.m33 = m33 / value;
        return pointer;
    }

    @Override
    public Matrix3d div(Matrix3d value) {
        return this.mul(value.copy().invert());
    }

    @Override
    public Matrix3d div(Matrix3d value, Matrix3d pointer) {
        pointer.copy(this);

        return pointer.div(value);
    }

    @Override
    public Double get(int index) {
        return switch (index) {
            case 0  -> m11; case 1  -> m12; case 2  -> m13;
            case 3  -> m21; case 4  -> m22; case 5  -> m23;
            case 6  -> m31; case 7  -> m32; case 8 -> m33;
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public boolean equals(@NotNull Matrix3d value) {
        return this.m11 == value.m11 &&
                this.m12 == value.m12 &&
                this.m13 == value.m13 &&
                this.m21 == value.m21 &&
                this.m22 == value.m22 &&
                this.m23 == value.m23 &&
                this.m31 == value.m31 &&
                this.m32 == value.m32 &&
                this.m33 == value.m33;
    }

    @Override
    public Matrix3d transpose() {
        final double m12 = this.m21;
        final double m13 = this.m31;
        final double m21 = this.m12;
        final double m23 = this.m32;
        final double m31 = this.m13;
        final double m32 = this.m23;
        this.m12 = m12;
        this.m13 = m13;
        this.m21 = m21;
        this.m23 = m23;
        this.m31 = m31;
        this.m32 = m32;
        return this;
    }

    @Override
    public Matrix3d transpose(Matrix3d pointer) {
        pointer.m12 = m21;
        pointer.m13 = m31;
        pointer.m21 = m12;
        pointer.m23 = m32;
        pointer.m31 = m13;
        pointer.m32 = m23;
        return pointer;
    }

    @Override
    public int rowsSize() {
        return 3;
    }

    @Override
    public int columnsSize() {
        return 3;
    }

    @Override
    public int elementsSize() {
        return 9;
    }

    @Override
    public Double[] getRow(int index) {
        return switch (index) {
            case 0 -> new Double[]{m11, m12, m13};
            case 1 -> new Double[]{m21, m22, m23};
            case 2 -> new Double[]{m31, m32, m33};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public Double[] getColumn(int index) {
        return switch (index) {
            case 0 -> new Double[]{m11, m21, m31};
            case 1 -> new Double[]{m12, m22, m32};
            case 2 -> new Double[]{m13, m23, m33};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public void set(int r, int c, Double value) {
        switch (r) {
            case 0 -> {
                switch (c) {
                    case 0 -> m11 = value;
                    case 1 -> m12 = value;
                    case 2 -> m13 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 1 -> {
                switch (c) {
                    case 0 -> m21 = value;
                    case 1 -> m22 = value;
                    case 2 -> m23 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 2 -> {
                switch (c) {
                    case 0 -> m31 = value;
                    case 1 -> m32 = value;
                    case 2 -> m33 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(double m00, double m01, double m02,
                    double m10, double m11, double m12,
                    double m20, double m21, double m22) {
        this.m11 = m00; this.m12 = m01; this.m13 = m02;
        this.m21 = m10; this.m22 = m11; this.m23 = m12;
        this.m31 = m20; this.m32 = m21; this.m33 = m22;
    }

    @Override
    public Double get(int r, int c) {
        return switch (r) {
            case 0 -> switch (c) {
                case 0 -> m11;
                case 1 -> m12;
                case 2 -> m13;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 1 -> switch (c) {
                case 0 -> m21;
                case 1 -> m22;
                case 2 -> m23;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 2 -> switch (c) {
                case 0 -> m31;
                case 1 -> m32;
                case 2 -> m33;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public Matrix3d invert() {
        double det = reduction();
        if (det != 0) {
            set(
                    m22 * m33 - m23 * m32, m13 * m32 - m12 * m33, m12 * m23 - m13 * m22,
                    m23 * m31 - m21 * m33, m11 * m33 - m13 * m31, m13 * m21 - m11 * m23,
                    m21 * m32 - m22 * m31, m12 * m31 - m11 * m32, m11 * m22 - m12 * m21
            );

            return this.mul(1 / det);
        }

        return null;
    }

    @Override
    public Matrix3d invert(Matrix3d pointer) {
        pointer.copy(this);
        return pointer.invert();
    }

    @Override
    public double[] toArray(double[] pointer) {
        pointer[0] = this.m11;
        pointer[1] = this.m12;
        pointer[2] = this.m13;
        pointer[4] = this.m21;
        pointer[5] = this.m22;
        pointer[6] = this.m23;
        pointer[8] = this.m31;
        pointer[9] = this.m32;
        pointer[10] = this.m33;
        return pointer;
    }
}
