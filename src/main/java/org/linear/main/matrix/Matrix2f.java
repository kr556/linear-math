package org.linear.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

// TODO: 2023/12/09
public class Matrix2f extends SquareMatrix<Float, Matrix2f>
        implements FloatMatrix<Matrix2f, Matrix2f> {
    public final static Matrix2f NAN = new Matrix2f(
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN);

    public final static Matrix2f DIAGONAL = new Matrix2f(
            1, 0,
            0, 1);

    public float
            m00, m01,
            m10, m11;

    public Matrix2f(float m00, float m01,
                    float m10, float m11) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
    }

    public Matrix2f(double m00, double m01,
                    double m10, double m11) {
        this.m00 = (float) m00; this.m01 = (float) m01;
        this.m10 = (float) m10; this.m11 = (float) m11;
    }

    public Matrix2f(Matrix2f copy) {
        set(copy);
    }

    @Override
    public float determinant() {
        return m00 * m11 - m01 * m10;
    }

    public Matrix2f() {}

    @Override
    public void set(Matrix2f copy) {
        this.m00 = copy.m00; this.m01 = copy.m01;
        this.m10 = copy.m10; this.m11 = copy.m11;
    }

    @Override
    public Matrix2f copy() {
        return new Matrix2f(this);
    }

    @Override
    public Matrix2f abs() {
        this.m00 = Math.abs(m00); this.m01 = Math.abs(m01);
        this.m10 = Math.abs(m10); this.m11 = Math.abs(m11);
        return this;
    }

    @Override
    public Matrix2f abs(Matrix2f pointer) {
        pointer.m00 = Math.abs(m00); pointer.m01 = Math.abs(m01);
        pointer.m10 = Math.abs(m10); pointer.m11 = Math.abs(m11);
        return this;
    }

    @Override
    public Matrix2f add(float value) {
        this.m00 += value; this.m01 += value;
        this.m10 += value; this.m11 += value;
        return this;
    }

    @Override
    public Matrix2f add(float value, Matrix2f pointer) {
        pointer.m00 = m00 + value; pointer.m01 = m01 + value;
        pointer.m10 = m10 + value; pointer.m11 = m11 + value;
        return pointer;
    }

    @Override
    public Matrix2f add(Matrix2f value) {
        this.m00 += value.m00; this.m01 += value.m01;
        this.m10 += value.m10; this.m11 += value.m11;
        return this;
    }

    @Override
    public Matrix2f add(Matrix2f value, Matrix2f pointer) {
        pointer.m00 = m00 + value.m00; pointer.m01 = m01 + value.m01;
        pointer.m10 = m10 + value.m10; pointer.m11 = m11 + value.m11;
        return pointer;
    }

    @Override
    public Matrix2f sub(float value) {
        this.m00 -= value; this.m01 -= value;
        this.m10 -= value; this.m11 -= value;
        return this;
    }

    @Override
    public Matrix2f sub(float value, Matrix2f pointer) {
        pointer.m00 = m00 - value; pointer.m01 = m01 - value;
        pointer.m10 = m10 - value; pointer.m11 = m11 - value;
        return pointer;
    }

    @Override
    public Matrix2f sub(Matrix2f value) {
        this.m00 -= value.m00; this.m01 -= value.m01;
        this.m10 -= value.m10; this.m11 -= value.m11;
        return this;
    }

    @Override
    public Matrix2f sub(Matrix2f value, Matrix2f pointer) {
        pointer.m00 = m00 - value.m00; pointer.m01 = m01 - value.m01;
        pointer.m10 = m10 - value.m10; pointer.m11 = m11 - value.m11;
        return pointer;
    }

    @Override
    public Matrix2f mul(float value) {
        this.m00 *= value; this.m01 *= value;
        this.m10 *= value; this.m11 *= value;
        return this;
    }

    @Override
    public Matrix2f mul(float value, Matrix2f pointer) {
        pointer.m00 = m00 * value; pointer.m01 = m01 * value;
        pointer.m10 = m10 * value; pointer.m11 = m11 * value;
        return pointer;
    }

    @Override
    public Matrix2f div(float value) {
        this.m00 /= value; this.m01 /= value;
        this.m10 /= value; this.m11 /= value;
        return this;
    }

    @Override
    public Matrix2f div(float value, Matrix2f pointer) {
        pointer.set(this);
        return pointer.div(value);
    }

    @Override
    public Matrix2f div(Matrix2f value) {
        this.m00 /= value.m00; this.m01 /= value.m01;
        this.m10 /= value.m10; this.m11 /= value.m11;
        return this;
    }

    @Override
    public Matrix2f div(Matrix2f value, Matrix2f pointer) {
        pointer.set(this);

        return pointer.div(value);
    }

    @Override
    public Matrix2f mul(Matrix2f value) {
        this.m00 *= value.m00; this.m01 *= value.m01;
        this.m10 *= value.m10; this.m11 *= value.m11;
        return this;
    }

    @Override
    public Matrix2f mul(Matrix2f value, Matrix2f pointer) {
        pointer.set(this);
        return pointer.mul(value);
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0  -> m00; case 2  -> m01;
            case 4  -> m10; case 3  -> m11;
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public boolean equals(@NotNull Matrix2f value) {
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
    public Matrix2f transpose() {
        final float m12 = this.m10;
        final float m21 = this.m01;
        this.m01 = m12;
        this.m10 = m21;
        return this;
    }

    @Override
    public Matrix2f transpose(Matrix2f pointer) {
        pointer.m00 = m00;
        pointer.m01 = m10;
        pointer.m11 = m11;
        pointer.m10 = m01;
        return pointer;
    }

    public final Matrix2f mulC(float m00, float m01,
                               float m10, float m11) {
        set(
                this.m00 * m00 + this.m01 * m10, this.m00 * m01 + this.m01 * m11,
                this.m10 * m00 + this.m11 * m10, this.m10 * m01 + this.m11 * m11
        );
        return this;
    }

    @Override
    public Matrix2f mulC(Matrix2f value) {
        return mulC(
                value.m00, value.m01,
                value.m10, value.m11);
    }

    public final Matrix2f mulR(float m00, float m01,
                               float m10, float m11) {
        set(
                m00 * this.m00 + m01 * this.m10, m00 * this.m01 + m01 * this.m11,
                m10 * this.m00 + m11 * this.m10, m10 * this.m01 + m11 * this.m11
        );
        return this;
    }

    @Override
    public Matrix2f mulR(Matrix2f value) {
        return mulR(
                value.m00, value.m01,
                value.m10, value.m11);
    }

    @Override
    public Matrix2f create() {
        return new Matrix2f();
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
    public int elementsSize() {
        return 2;
    }

    @Final
    @Override
    public Float[] getRow(int index) {
        return switch (index) {
            case 0 -> new Float[]{m00, m01};
            case 1 -> new Float[]{m10, m11};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Final
    @Override
    public Float[] getColumn(int index) {
        return switch (index) {
            case 0 -> new Float[]{m00, m10};
            case 1 -> new Float[]{m01, m11};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Final
    @Override
    public void set(int r, int c, Float value) {
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

    public void set(float m00, float m01,
                    float m10, float m11) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
    }

    @Override
    public Float get(int r, int c) {
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
    public Matrix2f invert() {
        float det = determinant();
        if (det != 0) {
            set(
                    m11, -m01,
                    -m10, m00);

            return this.mul(1 / det);
        }

        return null;
    }

    @Override
    public Matrix2f invert(Matrix2f pointer) {
        pointer.set(this);
        return pointer.invert();
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.m00;
        pointer[1] = this.m01;
        pointer[4] = this.m10;
        pointer[5] = this.m11;
        return pointer;
    }
}
