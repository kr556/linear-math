package org.linear.main.matrix;

import org.jetbrains.annotations.NotNull;
import org.linear.main.vector.Vector2f;
import org.linear.main.vector.Vector3f;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

// TODO: 2023/12/09
public class Matrix3f extends SquareMatrix<Float, Matrix3f>
        implements FloatMatrix<Matrix3f, Matrix3f> {
    public final static Matrix3f NAN = new Matrix3f(
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN);

    public final static Matrix3f DIAGONAL = new Matrix3f(
            1, 0, 0,
            0, 1, 0,
            0, 0, 1);

    public float
            m00, m01, m02,
            m10, m11, m12,
            m20, m21, m22;

    public Matrix3f(double m00, double m01, double m02,
                    double m10, double m11, double m12,
                    double m20, double m21, double m22) {
        this.m00 = (float) m00; this.m01 = (float) m01; this.m02 = (float) m02;
        this.m10 = (float) m10; this.m11 = (float) m11; this.m12 = (float) m12;
        this.m20 = (float) m20; this.m21 = (float) m21; this.m22 = (float) m22;
    }

    public Matrix3f(float m00, float m01, float m02,
                    float m10, float m11, float m12,
                    float m20, float m21, float m22) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
    }

    public Matrix3f(Matrix3f copy) {
        set(copy);
    }

    @Override
    public float determinant() {
        return m00 * m11 * m22 +
               m01 * m12 * m20 +
               m02 * m10 * m21 -
               m02 * m11 * m20 -
               m00 * m12 * m21 -
               m01 * m10 * m22;
    }

    public Matrix3f() {
        this.m00 = 0f; this.m01 = 0f; this.m02 = 0f;
        this.m10 = 0f; this.m11 = 0f; this.m12 = 0f;
        this.m20 = 0f; this.m21 = 0f; this.m22 = 0f;
    }

    @Override
    public void set(Matrix3f copy) {
        this.m00 = copy.m00; this.m01 = copy.m01; this.m02 = copy.m02;
        this.m10 = copy.m10; this.m11 = copy.m11; this.m12 = copy.m12;
        this.m20 = copy.m20; this.m21 = copy.m21; this.m22 = copy.m22;
    }

    @Override
    public Matrix3f copy() {
        return new Matrix3f(this);
    }

    @Override
    public Matrix3f abs() {
        this.m00 = Math.abs(m00); this.m01 = Math.abs(m01); this.m02 = Math.abs(m02);
        this.m10 = Math.abs(m10); this.m11 = Math.abs(m11); this.m12 = Math.abs(m12);
        this.m20 = Math.abs(m20); this.m21 = Math.abs(m21); this.m22 = Math.abs(m22);
        return this;
    }

    @Override
    public Matrix3f abs(Matrix3f pointer) {
        pointer.m00 = Math.abs(m00); pointer.m01 = Math.abs(m01); pointer.m02 = Math.abs(m02);
        pointer.m10 = Math.abs(m10); pointer.m11 = Math.abs(m11); pointer.m12 = Math.abs(m12);
        pointer.m20 = Math.abs(m20); pointer.m21 = Math.abs(m21); pointer.m22 = Math.abs(m22);
        return this;
    }

    @Override
    public Matrix3f add(float value) {
        this.m00 += value; this.m01 += value; this.m02 += value;
        this.m10 += value; this.m11 += value; this.m12 += value;
        this.m20 += value; this.m21 += value; this.m22 += value;
        return this;
    }

    @Override
    public Matrix3f add(float value, Matrix3f pointer) {
        pointer.m00 = m00 + value; pointer.m01 = m01 + value; pointer.m02 = m02 + value;
        pointer.m10 = m10 + value; pointer.m11 = m11 + value; pointer.m12 = m12 + value;
        pointer.m20 = m20 + value; pointer.m21 = m21 + value; pointer.m22 = m22 + value;
        return pointer;
    }

    @Override
    public Matrix3f add(Matrix3f value) {
        this.m00 += value.m00; this.m01 += value.m01; this.m02 += value.m02;
        this.m10 += value.m10; this.m11 += value.m11; this.m12 += value.m12;
        this.m20 += value.m20; this.m21 += value.m21; this.m22 += value.m22;
        return this;
    }

    @Override
    public Matrix3f add(Matrix3f value, Matrix3f pointer) {
        pointer.m00 = m00 + value.m00; pointer.m01 = m01 + value.m01; pointer.m02 = m02 + value.m02;
        pointer.m10 = m10 + value.m10; pointer.m11 = m11 + value.m11; pointer.m12 = m12 + value.m12;
        pointer.m20 = m20 + value.m20; pointer.m21 = m21 + value.m21; pointer.m22 = m22 + value.m22;
        return pointer;
    }

    @Override
    public Matrix3f sub(float value) {
        this.m00 -= value; this.m01 -= value; this.m02 -= value;
        this.m10 -= value; this.m11 -= value; this.m12 -= value;
        this.m20 -= value; this.m21 -= value; this.m22 -= value;
        return this;
    }

    @Override
    public Matrix3f sub(float value, Matrix3f pointer) {
        pointer.m00 = m00 - value; pointer.m01 = m01 - value; pointer.m02 = m02 - value;
        pointer.m10 = m10 - value; pointer.m11 = m11 - value; pointer.m12 = m12 - value;
        pointer.m20 = m20 - value; pointer.m21 = m21 - value; pointer.m22 = m22 - value;
        return pointer;
    }

    @Override
    public Matrix3f sub(Matrix3f value) {
        this.m00 -= value.m00; this.m01 -= value.m01; this.m02 -= value.m02;
        this.m10 -= value.m10; this.m11 -= value.m11; this.m12 -= value.m12;
        this.m20 -= value.m20; this.m21 -= value.m21; this.m22 -= value.m22;
        return this;
    }

    @Override
    public Matrix3f sub(Matrix3f value, Matrix3f pointer) {
        pointer.m00 = m00 - value.m00; pointer.m01 = m01 - value.m01; pointer.m02 = m02 - value.m02;
        pointer.m10 = m10 - value.m10; pointer.m11 = m11 - value.m11; pointer.m12 = m12 - value.m12;
        pointer.m20 = m20 - value.m20; pointer.m21 = m21 - value.m21; pointer.m22 = m22 - value.m22;
        return pointer;
    }

    @Override
    public Matrix3f mul(float value) {
        this.m00 *= value; this.m01 *= value; this.m02 *= value;
        this.m10 *= value; this.m11 *= value; this.m12 *= value;
        this.m20 *= value; this.m21 *= value; this.m22 *= value;
        return this;
    }

    @Override
    public Matrix3f mul(float value, Matrix3f pointer) {
        pointer.m00 = m00 * value; pointer.m01 = m01 * value; pointer.m02 = m02 * value;
        pointer.m10 = m10 * value; pointer.m11 = m11 * value; pointer.m12 = m12 * value;
        pointer.m20 = m20 * value; pointer.m21 = m21 * value; pointer.m22 = m22 * value;
        return pointer;
    }

    @Override
    public Matrix3f mul(Matrix3f value) {
        final float m00 = this.m00 * value.m00 + this.m01 * value.m10 + this.m02 * value.m20;
        final float m01 = this.m00 * value.m01 + this.m01 * value.m11 + this.m02 * value.m21;
        final float m02 = this.m00 * value.m02 + this.m01 * value.m12 + this.m02 * value.m22;
        final float m10 = this.m10 * value.m00 + this.m11 * value.m10 + this.m12 * value.m20;
        final float m11 = this.m10 * value.m01 + this.m11 * value.m11 + this.m12 * value.m21;
        final float m12 = this.m10 * value.m02 + this.m11 * value.m12 + this.m12 * value.m22;
        final float m20 = this.m20 * value.m00 + this.m21 * value.m10 + this.m22 * value.m20;
        final float m21 = this.m20 * value.m01 + this.m21 * value.m11 + this.m22 * value.m21;
        final float m22 = this.m20 * value.m02 + this.m21 * value.m12 + this.m22 * value.m22;
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
    public Matrix3f mul(Matrix3f value, Matrix3f pointer) {
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
    public Matrix3f div(float value) {
        this.m00 /= value; this.m01 /= value; this.m02 /= value;
        this.m10 /= value; this.m11 /= value; this.m12 /= value;
        this.m20 /= value; this.m21 /= value; this.m22 /= value;
        return this;
    }

    @Override
    public Matrix3f div(float value, Matrix3f pointer) {
        pointer.m00 = m00 / value; pointer.m01 = m01 / value; pointer.m02 = m02 / value;
        pointer.m10 = m10 / value; pointer.m11 = m11 / value; pointer.m12 = m12 / value;
        pointer.m20 = m20 / value; pointer.m21 = m21 / value; pointer.m22 = m22 / value;
        return pointer;
    }

    @Override
    public Matrix3f div(Matrix3f value) {
        return this.mul(value.copy().invert());
    }

    @Override
    public Matrix3f div(Matrix3f value, Matrix3f pointer) {
        pointer.set(this);

        return pointer.div(value);
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0  -> m00; case 1  -> m01; case 2  -> m02;
            case 3  -> m10; case 4  -> m11; case 5  -> m12;
            case 6  -> m20; case 7  -> m21; case 8 -> m22;
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public boolean equals(@NotNull Matrix3f value) {
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
    public Matrix3f transpose() {
        final float m12 = this.m10;
        final float m13 = this.m20;
        final float m21 = this.m01;
        final float m23 = this.m21;
        final float m31 = this.m02;
        final float m32 = this.m12;
        this.m01 = m12;
        this.m02 = m13;
        this.m10 = m21;
        this.m12 = m23;
        this.m20 = m31;
        this.m21 = m32;
        return this;
    }

    @Override
    public Matrix3f transpose(Matrix3f pointer) {
        pointer.m01 = m10;
        pointer.m02 = m20;
        pointer.m10 = m01;
        pointer.m12 = m21;
        pointer.m20 = m02;
        pointer.m21 = m12;
        return pointer;
    }

    public final Matrix3f mulC(float m00, float m01, float m02,
                               float m10, float m11, float m12,
                               float m20, float m21, float m22) {
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
    public Matrix3f mulC(Matrix3f value) {
        return mulC(
                value.m00, value.m01, value.m02,
                value.m10, value.m11, value.m12,
                value.m20, value.m21, value.m22);
    }

    public final Matrix3f mulR(float m00, float m01, float m02,
                               float m10, float m11, float m12,
                               float m20, float m21, float m22) {
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
    public Matrix3f mulR(Matrix3f value) {
        return mulR(
                value.m00, value.m01, value.m02,
                value.m10, value.m11, value.m12,
                value.m20, value.m21, value.m22);
    }

    @Override
    public Matrix3f create() {
        return new Matrix3f();
    }

    @PropertiesMethod
    @Override
    public int columnDimension() {
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
        return 9;
    }

    @Final
    @Override
    public Float[] getRow(int index) {
        return switch (index) {
            case 0 -> new Float[]{m00, m01, m02};
            case 1 -> new Float[]{m10, m11, m12};
            case 2 -> new Float[]{m20, m21, m22};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Final
    @Override
    public Float[] getColumn(int index) {
        return switch (index) {
            case 0 -> new Float[]{m00, m10, m20};
            case 1 -> new Float[]{m01, m11, m21};
            case 2 -> new Float[]{m02, m12, m22};
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

    public void set(float m00, float m01, float m02,
                    float m10, float m11, float m12,
                    float m20, float m21, float m22) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
    }

    @Override
    public Float get(int r, int c) {
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
    public Matrix3f invert() {
        float det = determinant();
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
    public Matrix3f invert(Matrix3f pointer) {
        pointer.set(this);
        return pointer.invert();
    }

    @Override
    public float[] toArray(float[] pointer) {
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

    public final Matrix3f translate(float x, float y) {
        m02 += x;
        m12 += y;
        return this;
    }

    public final Matrix3f translate(Vector3f transletes) {
        return translate(
                transletes.x,
                transletes.y);
    }

    public final Matrix3f translateX(float translete) {
        m02 += translete;
        return this;
    }

    public final Matrix3f translateY(float translete) {
        m12 += translete;
        return this;
    }

    public final Matrix3f setTranslate(float x, float y) {
        set(
                1, 0, x,
                0, 1, y,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f setTranslate(Vector3f transletes) {
        return setTranslate(
                transletes.x,
                transletes.y);
    }

    public final Matrix3f setTranslateX(float translete) {
        return setTranslate(translete, 0);
    }

    public final Matrix3f setTranslateY(float translete) {
        return setTranslate(0, translete);
    }

    public final Matrix3f setReverseTranslate(Vector3f transletes) {
        return setTranslate(
                - transletes.x,
                - transletes.y);
    }

    public final Matrix3f rotate90() {
        float tmp = m00;
        m00 = m01;
        m01 = -tmp;

        tmp = m10;
        m10 = m11;
        m11 = -tmp;
        return this;
    }

    public final Matrix3f rotate180() {
        m00 = -m00;
        m11 = -m11;
        return this;
    }

    public final Matrix3f rotate270() {
        float tmp = m00;
        m00 = -m01;
        m01 = tmp;

        tmp = m10;
        m10 = -m11;
        m11 = tmp;
        return this;
    }

    public final Matrix3f rotate(float z) {
        return null;
    }

    public final Matrix3f setRotate90() {
        set(
                0, -1, 0,
                1, 0, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f setRotate180() {
        set(
                -1, 0, 0,
                0, -1, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f setRotate270() {
        set(
                0, 1, 0,
                -1, 0, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f setRotate(double z) {
        final float s = (float) sin(z);
        final float c = (float) cos(z);

        set(
                c, -s, 0,
                s, c, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f scale(float x, float y) {
        m00 *= x;
        m11 *= y;
        return this;
    }

    public final Matrix3f scale(Vector2f scales) {
        m00 *= scales.x;
        m11 *= scales.y;
        return this;
    }

    public final Matrix3f scale(float scale) {
        m00 *= scale;
        m11 *= scale;
        return this;
    }

    public final Matrix3f scaleX(float scale) {
        m00 *= scale;
        return this;
    }

    public final Matrix3f scaleY(float scale) {
        m11 *= scale;
        return this;
    }

    public final Matrix3f setScale(float x, float y) {
        set(
                x, 0, 0,
                0, y, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f setScale(Vector3f scales) {
        return setScale(scales.x, scales.y);
    }

    public final Matrix3f setScale(float s) {
        set(
                s, 0, 0,
                0, s, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f setScaleX(float s) {
        set(
                s, 0, 0,
                0, 1, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f setScaleY(float s) {
        set(
                1, 0, 0,
                0, s, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f shear(float x, float y) {
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

    public final Matrix3f shear(Vector2f shears) {
        return shear(shears.x, shears.y);
    }

    public final Matrix3f setShear(float x, float y) {
        set(
                1, x, 0,
                y, 1, 0,
                0, 0, 1
        );
        return this;
    }

    public final Matrix3f setShear(Vector2f shears) {
        return setShear(shears.x, shears.y);
    }

    protected final void setXYc(float m00, float m01,
                                float m10, float m11,
                                float m20, float m21) {
        this.m00 = m00; this.m01 = m01;
        this.m10 = m10; this.m11 = m11;
        this.m20 = m20; this.m21 = m21;
    }
}
