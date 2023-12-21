package org.linear.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.linear.main.vector.Vector2f;
import org.linear.main.vector.Vector3f;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Matrix3d extends SquareMatrix<Double, Matrix3d>
        implements DoubleMatrix<Matrix3d, Matrix3d> {
    public final static Matrix3d NAN = new Matrix3d(
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN);

    public final static Matrix3d DIAGONAL = new Matrix3d(
            1, 0, 0,
            0, 1, 0,
            0, 0, 1);

    public double
            m00, m01, m02,
            m10, m11, m12,
            m20, m21, m22;

    public Matrix3d(double m00, double m01, double m02,
                    double m10, double m11, double m12,
                    double m20, double m21, double m22) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
    }

    public Matrix3d(float m00, float m01, float m02,
                    float m10, float m11, float m12,
                    float m20, float m21, float m22) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
    }

    public Matrix3d(Matrix3d copy) {
        set(copy);
    }

    @Override
    public double determinant() {
        return m00 * m11 * m22 +
               m01 * m12 * m20 +
               m02 * m10 * m21 -
               m02 * m11 * m20 -
               m00 * m12 * m21 -
               m01 * m10 * m22;
    }

    public Matrix3d() {
        this.m00 = 0f; this.m01 = 0f; this.m02 = 0f;
        this.m10 = 0f; this.m11 = 0f; this.m12 = 0f;
        this.m20 = 0f; this.m21 = 0f; this.m22 = 0f;
    }

    @Override
    public void set(Matrix3d copy) {
        this.m00 = copy.m00; this.m01 = copy.m01; this.m02 = copy.m02;
        this.m10 = copy.m10; this.m11 = copy.m11; this.m12 = copy.m12;
        this.m20 = copy.m20; this.m21 = copy.m21; this.m22 = copy.m22;
    }

    @Override
    public Matrix3d copy() {
        return new Matrix3d(this);
    }

    @Override
    public Matrix3d abs() {
        this.m00 = Math.abs(m00); this.m01 = Math.abs(m01); this.m02 = Math.abs(m02);
        this.m10 = Math.abs(m10); this.m11 = Math.abs(m11); this.m12 = Math.abs(m12);
        this.m20 = Math.abs(m20); this.m21 = Math.abs(m21); this.m22 = Math.abs(m22);
        return this;
    }

    @Override
    public Matrix3d abs(Matrix3d pointer) {
        pointer.m00 = Math.abs(m00); pointer.m01 = Math.abs(m01); pointer.m02 = Math.abs(m02);
        pointer.m10 = Math.abs(m10); pointer.m11 = Math.abs(m11); pointer.m12 = Math.abs(m12);
        pointer.m20 = Math.abs(m20); pointer.m21 = Math.abs(m21); pointer.m22 = Math.abs(m22);
        return this;
    }

    @Override
    public Matrix3d add(double value) {
        this.m00 += value; this.m01 += value; this.m02 += value;
        this.m10 += value; this.m11 += value; this.m12 += value;
        this.m20 += value; this.m21 += value; this.m22 += value;
        return this;
    }

    @Override
    public Matrix3d add(double value, Matrix3d pointer) {
        pointer.m00 = m00 + value; pointer.m01 = m01 + value; pointer.m02 = m02 + value;
        pointer.m10 = m10 + value; pointer.m11 = m11 + value; pointer.m12 = m12 + value;
        pointer.m20 = m20 + value; pointer.m21 = m21 + value; pointer.m22 = m22 + value;
        return pointer;
    }

    @Override
    public Matrix3d add(Matrix3d value) {
        this.m00 += value.m00; this.m01 += value.m01; this.m02 += value.m02;
        this.m10 += value.m10; this.m11 += value.m11; this.m12 += value.m12;
        this.m20 += value.m20; this.m21 += value.m21; this.m22 += value.m22;
        return this;
    }

    @Override
    public Matrix3d add(Matrix3d value, Matrix3d pointer) {
        pointer.m00 = m00 + value.m00; pointer.m01 = m01 + value.m01; pointer.m02 = m02 + value.m02;
        pointer.m10 = m10 + value.m10; pointer.m11 = m11 + value.m11; pointer.m12 = m12 + value.m12;
        pointer.m20 = m20 + value.m20; pointer.m21 = m21 + value.m21; pointer.m22 = m22 + value.m22;
        return pointer;
    }

    @Override
    public Matrix3d sub(double value) {
        this.m00 -= value; this.m01 -= value; this.m02 -= value;
        this.m10 -= value; this.m11 -= value; this.m12 -= value;
        this.m20 -= value; this.m21 -= value; this.m22 -= value;
        return this;
    }

    @Override
    public Matrix3d sub(double value, Matrix3d pointer) {
        pointer.m00 = m00 - value; pointer.m01 = m01 - value; pointer.m02 = m02 - value;
        pointer.m10 = m10 - value; pointer.m11 = m11 - value; pointer.m12 = m12 - value;
        pointer.m20 = m20 - value; pointer.m21 = m21 - value; pointer.m22 = m22 - value;
        return pointer;
    }

    @Override
    public Matrix3d sub(Matrix3d value) {
        this.m00 -= value.m00; this.m01 -= value.m01; this.m02 -= value.m02;
        this.m10 -= value.m10; this.m11 -= value.m11; this.m12 -= value.m12;
        this.m20 -= value.m20; this.m21 -= value.m21; this.m22 -= value.m22;
        return this;
    }

    @Override
    public Matrix3d sub(Matrix3d value, Matrix3d pointer) {
        pointer.m00 = m00 - value.m00; pointer.m01 = m01 - value.m01; pointer.m02 = m02 - value.m02;
        pointer.m10 = m10 - value.m10; pointer.m11 = m11 - value.m11; pointer.m12 = m12 - value.m12;
        pointer.m20 = m20 - value.m20; pointer.m21 = m21 - value.m21; pointer.m22 = m22 - value.m22;
        return pointer;
    }

    @Override
    public Matrix3d mul(double value) {
        this.m00 *= value; this.m01 *= value; this.m02 *= value;
        this.m10 *= value; this.m11 *= value; this.m12 *= value;
        this.m20 *= value; this.m21 *= value; this.m22 *= value;
        return this;
    }

    @Override
    public Matrix3d mul(double value, Matrix3d pointer) {
        pointer.m00 = m00 * value; pointer.m01 = m01 * value; pointer.m02 = m02 * value;
        pointer.m10 = m10 * value; pointer.m11 = m11 * value; pointer.m12 = m12 * value;
        pointer.m20 = m20 * value; pointer.m21 = m21 * value; pointer.m22 = m22 * value;
        return pointer;
    }

    @Override
    public Matrix3d mul(Matrix3d value) {
        final double m00 = this.m00 * value.m00 + this.m01 * value.m10 + this.m02 * value.m20;
        final double m01 = this.m00 * value.m01 + this.m01 * value.m11 + this.m02 * value.m21;
        final double m02 = this.m00 * value.m02 + this.m01 * value.m12 + this.m02 * value.m22;
        final double m10 = this.m10 * value.m00 + this.m11 * value.m10 + this.m12 * value.m20;
        final double m11 = this.m10 * value.m01 + this.m11 * value.m11 + this.m12 * value.m21;
        final double m12 = this.m10 * value.m02 + this.m11 * value.m12 + this.m12 * value.m22;
        final double m20 = this.m20 * value.m00 + this.m21 * value.m10 + this.m22 * value.m20;
        final double m21 = this.m20 * value.m01 + this.m21 * value.m11 + this.m22 * value.m21;
        final double m22 = this.m20 * value.m02 + this.m21 * value.m12 + this.m22 * value.m22;
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        return this;
    }

    @Override
    public Matrix3d mul(Matrix3d value, Matrix3d pointer) {
        pointer.m00 = this.m00 * value.m00 + this.m01 * value.m10 + this.m02 * value.m20;
        pointer.m01 = this.m00 * value.m01 + this.m01 * value.m11 + this.m02 * value.m21;
        pointer.m02 = this.m00 * value.m02 + this.m01 * value.m12 + this.m02 * value.m22;
        pointer.m10 = this.m10 * value.m00 + this.m11 * value.m10 + this.m12 * value.m20;
        pointer.m11 = this.m10 * value.m01 + this.m11 * value.m11 + this.m12 * value.m21;
        pointer.m12 = this.m10 * value.m02 + this.m11 * value.m12 + this.m12 * value.m22;
        pointer.m20 = this.m20 * value.m00 + this.m21 * value.m10 + this.m22 * value.m20;
        pointer.m21 = this.m20 * value.m01 + this.m21 * value.m11 + this.m22 * value.m21;
        pointer.m22 = this.m20 * value.m02 + this.m21 * value.m12 + this.m22 * value.m22;
        return pointer;
    }

    @Override
    public Matrix3d div(double value) {
        this.m00 /= value; this.m01 /= value; this.m02 /= value;
        this.m10 /= value; this.m11 /= value; this.m12 /= value;
        this.m20 /= value; this.m21 /= value; this.m22 /= value;
        return this;
    }

    @Override
    public Matrix3d div(double value, Matrix3d pointer) {
        pointer.m00 = m00 / value; pointer.m01 = m01 / value; pointer.m02 = m02 / value;
        pointer.m10 = m10 / value; pointer.m11 = m11 / value; pointer.m12 = m12 / value;
        pointer.m20 = m20 / value; pointer.m21 = m21 / value; pointer.m22 = m22 / value;
        return pointer;
    }

    @Override
    public Matrix3d div(Matrix3d value) {
        return this.mul(value.copy().invert());
    }

    @Override
    public Matrix3d div(Matrix3d value, Matrix3d pointer) {
        pointer.set(this);

        return pointer.div(value);
    }

    @Override
    public Double get(int index) {
        return switch (index) {
            case 0  -> m00; case 1  -> m01; case 2  -> m02;
            case 3  -> m10; case 4  -> m11; case 5  -> m12;
            case 6  -> m20; case 7  -> m21; case 8 -> m22;
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public boolean equals(@NotNull Matrix3d value) {
        return this.m00 == value.m00 &&
               this.m01 == value.m01 &&
               this.m02 == value.m02 &&
               this.m10 == value.m10 &&
               this.m11 == value.m11 &&
               this.m12 == value.m12 &&
               this.m20 == value.m20 &&
               this.m21 == value.m21 &&
               this.m22 == value.m22;
    }

    @Override
    public final boolean isNaN() {
        return equals(NAN);
    }

    @Override
    public Matrix3d transpose() {
        final double m12 = this.m10;
        final double m13 = this.m20;
        final double m21 = this.m01;
        final double m23 = this.m21;
        final double m31 = this.m02;
        final double m32 = this.m12;
        this.m01 = m12;
        this.m02 = m13;
        this.m10 = m21;
        this.m12 = m23;
        this.m20 = m31;
        this.m21 = m32;
        return this;
    }

    @Override
    public Matrix3d transpose(Matrix3d pointer) {
        pointer.m01 = m10;
        pointer.m02 = m20;
        pointer.m10 = m01;
        pointer.m12 = m21;
        pointer.m20 = m02;
        pointer.m21 = m12;
        return pointer;
    }

    public final Matrix3d mulC(double m00, double m01, double m02,
                               double m10, double m11, double m12,
                               double m20, double m21, double m22) {
        set(
                this.m00 * m00 + this.m01 * m10 + this.m02 * m20,
                this.m00 * m01 + this.m01 * m11 + this.m02 * m21,
                this.m00 * m02 + this.m01 * m12 + this.m02 * m22,
                this.m10 * m00 + this.m11 * m10 + this.m12 * m20,
                this.m10 * m01 + this.m11 * m11 + this.m12 * m21,
                this.m10 * m02 + this.m11 * m12 + this.m12 * m22,
                this.m20 * m00 + this.m21 * m10 + this.m22 * m20,
                this.m20 * m01 + this.m21 * m11 + this.m22 * m21,
                this.m20 * m02 + this.m21 * m12 + this.m22 * m22
        );
        return this;
    }

    @Override
    public Matrix3d mulC(Matrix3d value) {
        return mulC(
                value.m00, value.m01, value.m02,
                value.m10, value.m11, value.m12,
                value.m20, value.m21, value.m22);
    }

    public final Matrix3d mulR(double m00, double m01, double m02,
                               double m10, double m11, double m12,
                               double m20, double m21, double m22) {
        set(
                m00 * this.m00 + m01 * this.m10 + m02 * this.m20,
                m00 * this.m01 + m01 * this.m11 + m02 * this.m21,
                m00 * this.m02 + m01 * this.m12 + m02 * this.m22,
                m10 * this.m00 + m11 * this.m10 + m12 * this.m20,
                m10 * this.m01 + m11 * this.m11 + m12 * this.m21,
                m10 * this.m02 + m11 * this.m12 + m12 * this.m22,
                m20 * this.m00 + m21 * this.m10 + m22 * this.m20,
                m20 * this.m01 + m21 * this.m11 + m22 * this.m21,
                m20 * this.m02 + m21 * this.m12 + m22 * this.m22
        );
        return this;
    }

    @Override
    public Matrix3d mulR(Matrix3d value) {
        return mulR(
                value.m00, value.m01, value.m02,
                value.m10, value.m11, value.m12,
                value.m20, value.m21, value.m22);
    }

    @Override
    public Matrix3d create() {
        return new Matrix3d();
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
            case 0 -> new Double[]{m00, m01, m02};
            case 1 -> new Double[]{m10, m11, m12};
            case 2 -> new Double[]{m20, m21, m22};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Final
    @Override
    public Double[] getColumn(int index) {
        return switch (index) {
            case 0 -> new Double[]{m00, m10, m20};
            case 1 -> new Double[]{m01, m11, m21};
            case 2 -> new Double[]{m02, m12, m22};
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
                    case 2 -> m02 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 1 -> {
                switch (c) {
                    case 0 -> m10 = value;
                    case 1 -> m11 = value;
                    case 2 -> m12 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 2 -> {
                switch (c) {
                    case 0 -> m20 = value;
                    case 1 -> m21 = value;
                    case 2 -> m22 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(double m00, double m01, double m02,
                    double m10, double m11, double m12,
                    double m20, double m21, double m22) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
    }

    @Override
    public Double get(int r, int c) {
        return switch (r) {
            case 0 -> switch (c) {
                case 0 -> m00;
                case 1 -> m01;
                case 2 -> m02;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 1 -> switch (c) {
                case 0 -> m10;
                case 1 -> m11;
                case 2 -> m12;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 2 -> switch (c) {
                case 0 -> m20;
                case 1 -> m21;
                case 2 -> m22;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public double[] toArray(double[] pointer) {
        pointer[0] = this.m00;
        pointer[1] = this.m01;
        pointer[2] = this.m02;
        pointer[4] = this.m10;
        pointer[5] = this.m11;
        pointer[6] = this.m12;
        pointer[8] = this.m20;
        pointer[9] = this.m21;
        pointer[10] = this.m22;
        return pointer;
    }

    @Override
    public Matrix3d invert() {
        double det = determinant();
        if (det != 0) {
            set(
                    m11 * m22 - m12 * m21, m02 * m21 - m01 * m22, m01 * m12 - m02 * m11,
                    m12 * m20 - m10 * m22, m00 * m22 - m02 * m20, m02 * m10 - m00 * m12,
                    m10 * m21 - m11 * m20, m01 * m20 - m00 * m21, m00 * m11 - m01 * m10
            );

            return this.mul(1 / det);
        }

        return null;
    }

    @Override
    public Matrix3d invert(Matrix3d pointer) {
        pointer.set(this);
        return pointer.invert();
    }

    public final Matrix3d translate(double x, double y) {
        m02 += x;
        m12 += y;
        return this;
    }

    public final Matrix3d translate(Vector3f transletes) {
        return translate(
                transletes.x,
                transletes.y);
    }

    public final Matrix3d translateX(double translete) {
        m02 += translete;
        return this;
    }

    public final Matrix3d translateY(double translete) {
        m12 += translete;
        return this;
    }

    public final Matrix3d setTranslate(double x, double y) {
        set(
                1, 0, x,
                0, 1, y,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d setTranslate(Vector3f transletes) {
        return setTranslate(
                transletes.x,
                transletes.y);
    }

    public final Matrix3d setTranslateX(double translete) {
        return setTranslate(translete, 0);
    }

    public final Matrix3d setTranslateY(double translete) {
        return setTranslate(0, translete);
    }

    public final Matrix3d setReverseTranslate(Vector3f transletes) {
        return setTranslate(
                - transletes.x,
                - transletes.y);
    }

    public final Matrix3d rotate90() {
        double tmp = m00;
        m00 = m01;
        m01 = -tmp;

        tmp = m10;
        m10 = m11;
        m11 = -tmp;
        return this;
    }

    public final Matrix3d rotate180() {
        m00 = -m00;
        m11 = -m11;
        return this;
    }

    public final Matrix3d rotate270() {
        double tmp = m00;
        m00 = -m01;
        m01 = tmp;

        tmp = m10;
        m10 = -m11;
        m11 = tmp;
        return this;
    }

    public final Matrix3d rotate(double z) {
        return null;
    }

    public final Matrix3d setRotate90() {
        set(
                0, -1, 0,
                1, 0, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d setRotate180() {
        set(
                -1, 0, 0,
                0, -1, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d setRotate270() {
        set(
                0, 1, 0,
                -1, 0, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d setRotate(double z) {
        final double s = sin(z);
        final double c = cos(z);

        set(
                c, -s, 0,
                s, c, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d scale(double x, double y) {
        m00 *= x;
        m11 *= y;
        return this;
    }

    public final Matrix3d scale(Vector2f scales) {
        m00 *= scales.x;
        m11 *= scales.y;
        return this;
    }

    public final Matrix3d scale(double scale) {
        m00 *= scale;
        m11 *= scale;
        return this;
    }

    public final Matrix3d scaleX(double scale) {
        m00 *= scale;
        return this;
    }

    public final Matrix3d scaleY(double scale) {
        m11 *= scale;
        return this;
    }

    public final Matrix3d setScale(double x, double y) {
        set(
                x, 0, 0,
                0, y, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d setScale(Vector3f scales) {
        return setScale(scales.x, scales.y);
    }

    public final Matrix3d setScale(double s) {
        set(
                s, 0, 0,
                0, s, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d setScaleX(double s) {
        set(
                s, 0, 0,
                0, 1, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d setScaleY(double s) {
        set(
                1, 0, 0,
                0, s, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d shear(double x, double y) {
        setXYc(
                m01 * y + m00,
                m11 * y + m10,
                m12 * y + m20,
                m01 + m00 * x,
                m11 + m10 * x,
                m12 + m20 * x
        );
        return this;
    }

    public final Matrix3d shear(Vector2f shears) {
        return shear(shears.x, shears.y);
    }

    public final Matrix3d setShear(double x, double y) {
        set(
                1, x, 0,
                y, 1, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3d setShear(Vector2f shears) {
        return setShear(shears.x, shears.y);
    }

    protected final void setXYc(double m00, double m01,
                                double m10, double m11,
                                double m20, double m21) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
        this.m20 = m20; this.m21 = m21;
    }
}
