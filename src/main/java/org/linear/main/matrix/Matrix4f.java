package org.linear.main.matrix;


import org.jetbrains.annotations.NotNull;
import org.linear.main.vector.Vector3f;
import org.linear.main.vector.Vector4f;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

import static java.lang.Math.*;

public class Matrix4f extends SquareMatrix<Float, Matrix4f>
        implements FloatMatrix<Matrix4f, Matrix4f> {
    public final static Matrix4f NAN = new Matrix4f(
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN);

    public final static Matrix4f DIAGONAL = new Matrix4f(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1);

    public float
            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33;

    public Matrix4f(float m00, float m01, float m02, float m03,
                    float m10, float m11, float m12, float m13,
                    float m20, float m21, float m22, float m23,
                    float m30, float m31, float m32, float m33) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
    }

    public Matrix4f(Matrix4f copy) {
        set(copy);
    }

    public Matrix4f() {}

    @Override
    public final float determinant() {
        return (m00 * m11 - m01 * m10) * (m22 * m33 - m23 * m32)
               - (m00 * m12 - m02 * m10) * (m21 * m33 - m23 * m31)
               + (m00 * m13 - m03 * m10) * (m21 * m32 - m22 * m31)
               + (m01 * m12 - m02 * m11) * (m20 * m33 - m23 * m30)
               - (m01 * m13 - m03 * m11) * (m20 * m32 - m22 * m30)
               + (m02 * m13 - m03 * m12) * (m20 * m31 - m21 * m30);
    }

    @Override
    public final void set(Matrix4f copy) {
        this.m00 = copy.m00; this.m01 = copy.m01; this.m02 = copy.m02; this.m03 = copy.m03;
        this.m10 = copy.m10; this.m11 = copy.m11; this.m12 = copy.m12; this.m13 = copy.m13;
        this.m20 = copy.m20; this.m21 = copy.m21; this.m22 = copy.m22; this.m23 = copy.m23;
        this.m30 = copy.m30; this.m31 = copy.m31; this.m32 = copy.m32; this.m33 = copy.m33;
    }

    @Override
    public final Matrix4f copy() {
        return new Matrix4f(this);
    }

    @Override
    public final Matrix4f abs() {
        this.m00 = Math.abs(m00); this.m01 = Math.abs(m01); this.m02 = Math.abs(m02); this.m03 = Math.abs(m03);
        this.m10 = Math.abs(m10); this.m11 = Math.abs(m11); this.m12 = Math.abs(m12); this.m13 = Math.abs(m13);
        this.m20 = Math.abs(m20); this.m21 = Math.abs(m21); this.m22 = Math.abs(m22); this.m23 = Math.abs(m23);
        this.m30 = Math.abs(m30); this.m31 = Math.abs(m31); this.m32 = Math.abs(m32); this.m33 = Math.abs(m33);
        return this;
    }

    @Override
    public final Matrix4f abs(Matrix4f pointer) {
        pointer.set(this);
        return pointer.abs();
    }

    @Override
    public final Matrix4f add(float value) {
        this.m00 += value; this.m01 += value; this.m02 += value; this.m03 += value;
        this.m10 += value; this.m11 += value; this.m12 += value; this.m13 += value;
        this.m20 += value; this.m21 += value; this.m22 += value; this.m23 += value;
        this.m30 += value; this.m31 += value; this.m32 += value; this.m33 += value;
        return this;
    }

    @Override
    public final Matrix4f add(float value, Matrix4f pointer) {
        pointer.set(this);

        return pointer.add(value);
    }

    @Override
    public final Matrix4f add(Matrix4f value) {
        this.m00 += value.m00; this.m01 += value.m01; this.m02 += value.m02; this.m03 += value.m03;
        this.m10 += value.m10; this.m11 += value.m11; this.m12 += value.m12; this.m13 += value.m13;
        this.m20 += value.m20; this.m21 += value.m21; this.m22 += value.m22; this.m23 += value.m23;
        this.m30 += value.m30; this.m31 += value.m31; this.m32 += value.m32; this.m33 += value.m33;
        return this;
    }

    @Override
    public final Matrix4f add(Matrix4f value, Matrix4f pointer) {
        pointer.set(this);

        return pointer.add(value);
    }

    @Override
    public final Matrix4f sub(float value) {
        this.m00 -= value; this.m01 -= value; this.m02 -= value; this.m03 -= value;
        this.m10 -= value; this.m11 -= value; this.m12 -= value; this.m13 -= value;
        this.m20 -= value; this.m21 -= value; this.m22 -= value; this.m23 -= value;
        this.m30 -= value; this.m31 -= value; this.m32 -= value; this.m33 -= value;
        return this;
    }

    @Override
    public final Matrix4f sub(float value, Matrix4f pointer) {
        pointer.set(this);

        return pointer.sub(value);
    }

    @Override
    public final Matrix4f sub(Matrix4f value) {
        this.m00 -= value.m00; this.m01 -= value.m01; this.m02 -= value.m02; this.m03 -= value.m03;
        this.m10 -= value.m10; this.m11 -= value.m11; this.m12 -= value.m12; this.m13 -= value.m13;
        this.m20 -= value.m20; this.m21 -= value.m21; this.m22 -= value.m22; this.m23 -= value.m23;
        this.m30 -= value.m30; this.m31 -= value.m31; this.m32 -= value.m32; this.m33 -= value.m33;
        return this;
    }

    @Override
    public final Matrix4f sub(Matrix4f value, Matrix4f pointer) {
        pointer.set(this);

        return pointer.sub(value);
    }

    @Override
    public final Matrix4f mul(float value) {
        this.m00 *= value; this.m01 *= value; this.m02 *= value; this.m03 *= value;
        this.m10 *= value; this.m11 *= value; this.m12 *= value; this.m13 *= value;
        this.m20 *= value; this.m21 *= value; this.m22 *= value; this.m23 *= value;
        this.m30 *= value; this.m31 *= value; this.m32 *= value; this.m33 *= value;
        return this;
    }

    @Override
    public final Matrix4f mul(float value, Matrix4f pointer) {
        pointer.set(this);

        return pointer.mul(value);
    }

    public final Matrix4f mul(float m00, float m01, float m02, float m03,
                              float m10, float m11, float m12, float m13,
                              float m20, float m21, float m22, float m23,
                              float m30, float m31, float m32, float m33) {
        this.m00 *= m00 * m00; this.m01 *= m01; this.m02 *= m02; this.m03 *= m03;
        this.m10 *= m10 * m10; this.m11 *= m11; this.m12 *= m12; this.m13 *= m13;
        this.m20 *= m20 * m20; this.m21 *= m21; this.m22 *= m22; this.m23 *= m23;
        this.m30 *= m30 * m30; this.m31 *= m31; this.m32 *= m32; this.m33 *= m33;
        return this;
    }

    @Override
    public final Matrix4f mul(Matrix4f value) {
        mul(value.m00, value.m01, value.m02, value.m03,
                value.m10, value.m11, value.m12, value.m13,
                value.m20, value.m21, value.m22, value.m23,
                value.m30, value.m31, value.m32, value.m33);
        return this;
    }

    @Override
    public final Matrix4f mul(Matrix4f value, Matrix4f pointer) {
        pointer.set(this);
        pointer.mul(value);
        return pointer;
    }

    @Override
    public final Matrix4f div(float value) {
        this.m00 /= value; this.m01 /= value; this.m02 /= value; this.m03 /= value;
        this.m10 /= value; this.m11 /= value; this.m12 /= value; this.m13 /= value;
        this.m20 /= value; this.m21 /= value; this.m22 /= value; this.m23 /= value;
        this.m30 /= value; this.m31 /= value; this.m32 /= value; this.m33 /= value;
        return this;
    }

    @Override
    public final Matrix4f div(float value, Matrix4f pointer) {
        pointer.set(this);

        return pointer.div(value);
    }

    @Override
    public final Matrix4f div(Matrix4f value) {
        this.m00 /= value.m00; this.m01 /= value.m01; this.m02 /= value.m02; this.m03 /= value.m03;
        this.m10 /= value.m10; this.m11 /= value.m11; this.m12 /= value.m12; this.m13 /= value.m13;
        this.m20 /= value.m20; this.m21 /= value.m21; this.m22 /= value.m22; this.m23 /= value.m23;
        this.m30 /= value.m30; this.m31 /= value.m31; this.m32 /= value.m32; this.m33 /= value.m33;
        return this;
    }

    @Override
    public final Matrix4f div(Matrix4f value, Matrix4f pointer) {
        pointer.set(this);

        return pointer.div(value);
    }

    @Override
    public final Float get(int index) {
        switch (index) {
            case 0  : return m00;
            case 1  : return m01;
            case 2  : return m02;
            case 3  : return m03;
            case 4  : return m10;
            case 5  : return m11;
            case 6  : return m12;
            case 7  : return m13;
            case 8  : return m20;
            case 9  : return m21;
            case 10 : return m22;
            case 11 : return m23;
            case 12 : return m30;
            case 13 : return m31;
            case 14 : return m32;
            case 15 : return m33;
            default : throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public final boolean equals(@NotNull Matrix4f value) {
        if (this == value) return true;
        return this.m00 == value.m00 &&
               this.m01 == value.m01 &&
               this.m02 == value.m02 &&
               this.m03 == value.m03 &&
               this.m10 == value.m10 &&
               this.m11 == value.m11 &&
               this.m12 == value.m12 &&
               this.m13 == value.m13 &&
               this.m20 == value.m20 &&
               this.m21 == value.m21 &&
               this.m22 == value.m22 &&
               this.m23 == value.m23 &&
               this.m30 == value.m30 &&
               this.m31 == value.m31 &&
               this.m32 == value.m32 &&
               this.m33 == value.m33;
    }

    @Override
    public final boolean isNaN() {
        return equals(NAN);
    }

    @Override
    public final Matrix4f transpose() {
        float tmp = m01;
        m01 = m10;
        m10 = tmp;

        tmp = m02;
        m02 = m20;
        m20 = tmp;

        tmp = m03;
        m03 = m30;
        m30 = tmp;

        tmp = m12;
        m12 = m21;
        m21 = tmp;

        tmp = m13;
        m13 = m31;
        m31 = tmp;

        m23 = m32;
        m32 = tmp;
        return this;
    }

    @Override
    public final Matrix4f transpose(Matrix4f pointer) {
        pointer.m00 = m00;
        pointer.m01 = m10;
        pointer.m02 = m20;
        pointer.m03 = m30;
        pointer.m10 = m01;
        pointer.m11 = m11;
        pointer.m12 = m21;
        pointer.m13 = m31;
        pointer.m20 = m02;
        pointer.m21 = m12;
        pointer.m22 = m22;
        pointer.m23 = m32;
        pointer.m30 = m03;
        pointer.m31 = m13;
        pointer.m32 = m23;
        pointer.m33 = m33;
        return this;
    }

    public final Matrix4f mulC(float m00, float m01, float m02, float m03,
                               float m10, float m11, float m12, float m13,
                               float m20, float m21, float m22, float m23,
                               float m30, float m31, float m32, float m33) {
        set(
                this.m00 * m00 + this.m01 * m10 + this.m02 * m20 + this.m03 * m30,
                this.m00 * m01 + this.m01 * m11 + this.m02 * m21 + this.m03 * m31,
                this.m00 * m02 + this.m01 * m12 + this.m02 * m22 + this.m03 * m32,
                this.m00 * m03 + this.m01 * m13 + this.m02 * m23 + this.m03 * m33,
                this.m10 * m00 + this.m11 * m10 + this.m12 * m20 + this.m13 * m30,
                this.m10 * m01 + this.m11 * m11 + this.m12 * m21 + this.m13 * m31,
                this.m10 * m02 + this.m11 * m12 + this.m12 * m22 + this.m13 * m32,
                this.m10 * m03 + this.m11 * m13 + this.m12 * m23 + this.m13 * m33,
                this.m20 * m00 + this.m21 * m10 + this.m22 * m20 + this.m23 * m30,
                this.m20 * m01 + this.m21 * m11 + this.m22 * m21 + this.m23 * m31,
                this.m20 * m02 + this.m21 * m12 + this.m22 * m22 + this.m23 * m32,
                this.m20 * m03 + this.m21 * m13 + this.m22 * m23 + this.m23 * m33,
                this.m30 * m00 + this.m31 * m10 + this.m32 * m20 + this.m33 * m30,
                this.m30 * m01 + this.m31 * m11 + this.m32 * m21 + this.m33 * m31,
                this.m30 * m02 + this.m31 * m12 + this.m32 * m22 + this.m33 * m32,
                this.m30 * m03 + this.m31 * m13 + this.m32 * m23 + this.m33 * m33
        );
        return this;
    }

    @Override
    public final Matrix4f mulC(Matrix4f value) {
        mulC(value.m00, value.m01, value.m02, value.m03,
                value.m10, value.m11, value.m12, value.m13,
                value.m20, value.m21, value.m22, value.m23,
                value.m30, value.m31, value.m32, value.m33);
        return this;
    }

    public final Matrix4f mulR(float m00, float m01, float m02, float m03,
                               float m10, float m11, float m12, float m13,
                               float m20, float m21, float m22, float m23,
                               float m30, float m31, float m32, float m33) {
        set(
                m00 * this.m00 + m01 * this.m10 + m02 * this.m20 + m03 * this.m30,
                m00 * this.m01 + m01 * this.m11 + m02 * this.m21 + m03 * this.m31,
                m00 * this.m02 + m01 * this.m12 + m02 * this.m22 + m03 * this.m32,
                m00 * this.m03 + m01 * this.m13 + m02 * this.m23 + m03 * this.m33,
                m10 * this.m00 + m11 * this.m10 + m12 * this.m20 + m13 * this.m30,
                m10 * this.m01 + m11 * this.m11 + m12 * this.m21 + m13 * this.m31,
                m10 * this.m02 + m11 * this.m12 + m12 * this.m22 + m13 * this.m32,
                m10 * this.m03 + m11 * this.m13 + m12 * this.m23 + m13 * this.m33,
                m20 * this.m00 + m21 * this.m10 + m22 * this.m20 + m23 * this.m30,
                m20 * this.m01 + m21 * this.m11 + m22 * this.m21 + m23 * this.m31,
                m20 * this.m02 + m21 * this.m12 + m22 * this.m22 + m23 * this.m32,
                m20 * this.m03 + m21 * this.m13 + m22 * this.m23 + m23 * this.m33,
                m30 * this.m00 + m31 * this.m10 + m32 * this.m20 + m33 * this.m30,
                m30 * this.m01 + m31 * this.m11 + m32 * this.m21 + m33 * this.m31,
                m30 * this.m02 + m31 * this.m12 + m32 * this.m22 + m33 * this.m32,
                m30 * this.m03 + m31 * this.m13 + m32 * this.m23 + m33 * this.m33
        );
        return this;
    }

    @Override
    public final Matrix4f mulR(Matrix4f value) {
        mulR(value.m00, value.m01, value.m02, value.m03,
                value.m10, value.m11, value.m12, value.m13,
                value.m20, value.m21, value.m22, value.m23,
                value.m30, value.m31, value.m32, value.m33);
        return this;
    }

    @Override
    public final Matrix4f create() {
        return new Matrix4f();
    }

    @Override
    @PropertiesMethod
    public final int columnDimension() {
        return 4;
    }

    @Override
    @PropertiesMethod
    public final int rowDimension() {
        return 4;
    }

    @PropertiesMethod
    @Override
    public final int elementsSize() {
        return 16;
    }

    @Final
    @Override
    public final Float[] getRow(int index) {
        switch (index) {
            case 0 :  return new Float[]{m00, m01, m02, m03};
            case 1 : return new Float[]{m10, m11, m12, m13};
            case 2 : return new Float[]{m20, m21, m22, m23};
            case 3 : return new Float[]{m30, m31, m32, m33};
            default : throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Final
    @Override
    public final Float[] getColumn(int index) {
        switch (index) {
            case 0 : return new Float[]{m00, m10, m20, m30};
            case 1 : return new Float[]{m01, m11, m21, m31};
            case 2 : return new Float[]{m02, m12, m22, m32};
            case 3 : return new Float[]{m03, m13, m23, m33};
            default : throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public final float[] toArray(float[] pointer) {
        pointer[0] = this.m00;
        pointer[1] = this.m01;
        pointer[2] = this.m02;
        pointer[3] = this.m03;
        pointer[4] = this.m10;
        pointer[5] = this.m11;
        pointer[6] = this.m12;
        pointer[7] = this.m13;
        pointer[8] = this.m20;
        pointer[9] = this.m21;
        pointer[10] = this.m22;
        pointer[11] = this.m23;
        pointer[12] = this.m30;
        pointer[13] = this.m31;
        pointer[14] = this.m32;
        pointer[15] = this.m33;
        return pointer;
    }

    @Final
    @Override
    public final void set(int r, int c, Float value) {
        switch (r) {
            case 0 -> {
                switch (c) {
                    case 0 -> m00 = value;
                    case 1 -> m01 = value;
                    case 2 -> m02 = value;
                    case 3 -> m03 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 1 -> {
                switch (c) {
                    case 0 -> m10 = value;
                    case 1 -> m11 = value;
                    case 2 -> m12 = value;
                    case 3 -> m13 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 2 -> {
                switch (c) {
                    case 0 -> m20 = value;
                    case 1 -> m21 = value;
                    case 2 -> m22 = value;
                    case 3 -> m23 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 3 -> {
                switch (c) {
                    case 0 -> m30 = value;
                    case 1 -> m31 = value;
                    case 2 -> m32 = value;
                    case 3 -> m33 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final void set(float m00, float m01, float m02, float m03,
                          float m10, float m11, float m12, float m13,
                          float m20, float m21, float m22, float m23,
                          float m30, float m31, float m32, float m33) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
    }

    @Override
    public final Float get(int r, int c) {
        switch (r) {
            case 0 : {
                switch (c) {
                    case 0 : return m00;
                    case 1 : return m01;
                    case 2 : return m02;
                    case 3 : return m03;
                    default : throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 1 : {
                switch (c) {
                    case 0 : return m10;
                    case 1 : return m11;
                    case 2 : return m12;
                    case 3 : return m13;
                    default : throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 2 : {
                switch (c) {
                    case 0 : return m20;
                    case 1 : return m21;
                    case 2 : return m22;
                    case 3 : return m23;
                    default : throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 3 : {
                switch (c) {
                    case 0 : return m30;
                    case 1 : return m31;
                    case 2 : return m32;
                    case 3 : return m33;
                    default : throw new ArrayIndexOutOfBoundsException();
                }
            }
            default : throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public final Matrix4f invert() {
        final float det = determinant();
        if (det != 0) {
            set(
                    m11 * (m22 * m33 - m23 * m32) + m12 * (m23 * m31 - m21 * m33) + m13 * (m21 * m32 - m22 * m31),
                    m21 * (m02 * m33 - m03 * m32) + m22 * (m03 * m31 - m01 * m33) + m23 * (m01 * m32 - m02 * m31),
                    m31 * (m02 * m13 - m03 * m12) + m32 * (m03 * m11 - m01 * m13) + m33 * (m01 * m12 - m02 * m11),
                    m01 * (m13 * m22 - m12 * m23) + m02 * (m11 * m23 - m13 * m21) + m03 * (m12 * m21 - m11 * m22),
                    m12 * (m20 * m33 - m23 * m30) + m13 * (m22 * m30 - m20 * m32) + m10 * (m23 * m32 - m22 * m33),
                    m22 * (m00 * m33 - m03 * m30) + m23 * (m02 * m30 - m00 * m32) + m20 * (m03 * m32 - m02 * m33),
                    m32 * (m00 * m13 - m03 * m10) + m33 * (m02 * m10 - m00 * m12) + m30 * (m03 * m12 - m02 * m13),
                    m02 * (m13 * m20 - m10 * m23) + m03 * (m10 * m22 - m12 * m20) + m00 * (m12 * m23 - m13 * m22),
                    m13 * (m20 * m31 - m21 * m30) + m10 * (m21 * m33 - m23 * m31) + m11 * (m23 * m30 - m20 * m33),
                    m23 * (m00 * m31 - m01 * m30) + m20 * (m01 * m33 - m03 * m31) + m21 * (m03 * m30 - m00 * m33),
                    m33 * (m00 * m11 - m01 * m10) + m30 * (m01 * m13 - m03 * m11) + m31 * (m03 * m10 - m00 * m13),
                    m03 * (m11 * m20 - m10 * m21) + m00 * (m13 * m21 - m11 * m23) + m01 * (m10 * m23 - m13 * m20),
                    m10 * (m22 * m31 - m21 * m32) + m11 * (m20 * m32 - m22 * m30) + m12 * (m21 * m30 - m20 * m31),
                    m20 * (m02 * m31 - m01 * m32) + m21 * (m00 * m32 - m02 * m30) + m22 * (m01 * m30 - m00 * m31),
                    m30 * (m02 * m11 - m01 * m12) + m31 * (m00 * m12 - m02 * m10) + m32 * (m01 * m10 - m00 * m11),
                    m00 * (m11 * m22 - m12 * m21) + m01 * (m12 * m20 - m10 * m22) + m02 * (m10 * m21 - m11 * m20));
            return mul(1 / det);
        }

        return NAN;
    }

    @Override
    public final Matrix4f invert(Matrix4f pointer) {
        set(pointer);
        pointer.set(this);
        return pointer.invert();
    }

    public final Matrix4f translate(float x, float y, float z) {
        m03 += x;
        m13 += y;
        m23 += z;
        return this;
    }

    public final Matrix4f translate(Vector4f transletes) {
        return translate(
                transletes.x,
                transletes.y,
                transletes.z);
    }

    public final Matrix4f translateX(float translete) {
        m03 += translete;
        return this;
    }

    public final Matrix4f translateY(float translete) {
        m13 += translete;
        return this;
    }

    public final Matrix4f translateZ(float translete) {
        m23 += translete;
        return this;
    }

    public final Matrix4f setTranslate(float x, float y, float z) {
        set(
                1, 0, 0, x,
                0, 1, 0, y,
                0, 0, 1, z,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setTranslate(Vector4f transletes) {
        return setTranslate(
                transletes.x,
                transletes.y,
                transletes.z);
    }

    public final Matrix4f setTranslateX(float translete) {
        return setTranslate(translete, 0, 0);
    }

    public final Matrix4f setTranslateY(float translete) {
        return setTranslate(0, translete, 0);
    }

    public final Matrix4f setTranslateZ(float translete) {
        return setTranslate(0, 0, translete);
    }

    public final Matrix4f setReverseTranslate(Vector4f transletes) {
        return setTranslate(
                - transletes.x,
                - transletes.y,
                - transletes.z);
    }

    public final Matrix4f rotateX90() {
        float tmp = m11;
        m11 = m12;
        m12 = -tmp;

        tmp = m21;
        m21 = m22;
        m22 = -tmp;
        return this;
    }

    public final Matrix4f rotateY90() {
        float tmp = m00;
        m00 = m02;
        m02 = -tmp;

        tmp = m20;
        m20 = m22;
        m22 = -tmp;
        return this;
    }

    public final Matrix4f rotateZ90() {
        float tmp = m00;
        m00 = m01;
        m01 = -tmp;

        tmp = m10;
        m10 = m11;
        m11 = -tmp;
        return this;
    }

    public final Matrix4f rotateX180() {
        m11 = -m11;
        m22 = -m22;
        return this;
    }

    public final Matrix4f rotateY180() {
        m00 = -m00;
        m22 = -m22;
        return this;
    }

    public final Matrix4f rotateZ180() {
        m00 = -m00;
        m11 = -m11;
        return this;
    }

    public final Matrix4f rotateX270() {
        float tmp = m11;
        m11 = -m12;
        m12 = tmp;

        tmp = m21;
        m21 = -m22;
        m22 = tmp;
        return this;
    }

    public final Matrix4f rotateY270() {
        float tmp = m00;
        m00 = -m02;
        m02 = tmp;

        tmp = m20;
        m20 = -m22;
        m22 = tmp;
        return this;
    }

    public final Matrix4f rotateZ270() {
        float tmp = m00;
        m00 = -m01;
        m01 = tmp;

        tmp = m10;
        m10 = -m11;
        m11 = tmp;
        return this;
    }

    public final Matrix4f rotate(final double radian, Vector4f axis) {
        if (axis.w != 0) throw new UnsupportedOperationException("axis element 'w' is not 0.");
        axis.nomalize();
        final float c = (float) cos(radian);
        final float s = (float) sin(radian);
        final float ver = 1 - c;
        final float sx = s * axis.x;
        final float sy = s * axis.y;
        final float sz = s * axis.z;

        setXYZc(
                m00 * (c + ver * axis.x * axis.x) + m01 * (sz + ver * axis.x * axis.y) + m02 * (ver * axis.x * axis.z - sy),
                m01 * (c + ver * axis.y * axis.y) + m00 * (ver * axis.x * axis.y - sz) + m02 * (sx + ver * axis.y * axis.z),
                m02 * (c + ver * axis.z * axis.z) + m00 * (sy + ver * axis.x * axis.z) + m01 * (ver * axis.y * axis.z - sx),
                m10 * (c + ver * axis.x * axis.x) + m11 * (sz + ver * axis.x * axis.y) + m12 * (ver * axis.x * axis.z - sy),
                m11 * (c + ver * axis.y * axis.y) + m10 * (ver * axis.x * axis.y - sz) + m12 * (sx + ver * axis.x * axis.z),
                m12 * (c + ver * axis.z * axis.z) + m10 * (sy + ver * axis.x * axis.z) + m11 * (ver * axis.y * axis.z - sx),
                m20 * (c + ver * axis.x * axis.x) + m21 * (sz + ver * axis.x * axis.y) + m22 * (ver * axis.x * axis.z - sy),
                m21 * (c + ver * axis.y * axis.y) + m20 * (ver * axis.x * axis.y - sz) + m22 * (sx + ver * axis.y * axis.z),
                m22 * (c + ver * axis.z * axis.z) + m20 * (sy + ver * axis.x * axis.z) + m21 * (ver * axis.y * axis.z - sx),
                m30 * (c + ver * axis.x * axis.x) + m31 * (sz + ver * axis.x * axis.y) + m32 * (ver * axis.x * axis.z - sy),
                m31 * (c + ver * axis.y * axis.y) + m30 * (ver * axis.x * axis.y - sz) + m32 * (sx + ver * axis.y * axis.z),
                m32 * (c + ver * axis.z * axis.z) + m30 * (sy + ver * axis.x * axis.z) + m31 * (ver * axis.y * axis.z - sx)
        );
        return this;
    }

    public final Matrix4f rotateX(double x) {
        final float s = (float) sin(x);
        final float c = (float) cos(x);

        setYZc( m01 * c + m02 * s,
                m11 * c + m12 * s,
                m21 * c + m22 * s,
                m31 * c + m32 * s,
                m02 * c - m01 * s,
                m12 * c - m11 * s,
                m22 * c - m21 * s,
                m32 * c - m31 * s);
        return this;
    }

    public final Matrix4f rotateY(double y) {
        final float s = (float) sin(y);
        final float c = (float) cos(y);

        setXZc( m00 * c + m02 * s,
                m10 * c + m12 * s,
                m20 * c + m22 * s,
                m30 * c + m32 * s,
                m02 * c - m00 * s,
                m12 * c - m10 * s,
                m22 * c - m20 * s,
                m32 * c - m30 * s);
        return this;
    }

    public final Matrix4f rotateZ(double z) {
        final float s = (float) sin(z);
        final float c = (float) cos(z);

        setXYc( m00 * c + m01 * s,
                m10 * c + m11 * s,
                m20 * c + m21 * s,
                m30 * c + m31 * s,
                m01 * c - m00 * s,
                m11 * c - m10 * s,
                m21 * c - m20 * s,
                m31 * c - m30 * s);
        return this;
    }

    public final Matrix4f setRotateX90() {
        set(
                1, 0, 0, 0,
                0, 0, -1, 0,
                0, 1, 0, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateY90() {
        set(
                0, 0, -1, 0,
                0, 1, 0, 0,
                1, 0, 0, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateZ90() {
        set(
                0, -1, 0, 0,
                1, 0, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateX180() {
        set(
                1, 0, 0, 0,
                0, -1, 0, 0,
                0, 0, -1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateY180() {
        set(
                -1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, -1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateZ180() {
        set(
                -1, 0, 0, 0,
                0, -1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateX270() {
        set(
                1, 0, 0, 0,
                0, 0, 1, 0,
                0, -1, 0, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateY270() {
        set(
                0, 0, 1, 0,
                0, 1, 0, 0,
                -1, 0, 0, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateZ270() {
        set(
                0, 1, 0, 0,
                -1, 0, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotate(final double radian, Vector4f axis) {
        if (axis.w != 0) throw new UnsupportedOperationException("axis element 'w' is not 0.");
        axis.nomalize();
        final float c = (float) cos(radian);
        final float s = (float) sin(radian);
        final float ver = 1 - c;
        final float sx = s * axis.x;
        final float sy = s * axis.y;
        final float sz = s * axis.z;

        set(
                m00 * (c + ver * axis.x * axis.x) + m01 * (sz + ver * axis.x * axis.y) + m02 * (ver * axis.x * axis.z - sy),
                m01 * (c + ver * axis.y * axis.y) + m00 * (ver * axis.x * axis.y - sz) + m02 * (sx + ver * axis.y * axis.z),
                m02 * (c + ver * axis.z * axis.z) + m00 * (sy + ver * axis.x * axis.z) + m01 * (ver * axis.y * axis.z - sx),
                0,
                m10 * (c + ver * axis.x * axis.x) + m11 * (sz + ver * axis.x * axis.y) + m12 * (ver * axis.x * axis.z - sy),
                m11 * (c + ver * axis.y * axis.y) + m10 * (ver * axis.x * axis.y - sz) + m12 * (sx + ver * axis.x * axis.z),
                m12 * (c + ver * axis.z * axis.z) + m10 * (sy + ver * axis.x * axis.z) + m11 * (ver * axis.y * axis.z - sx),
                0,
                m20 * (c + ver * axis.x * axis.x) + m21 * (sz + ver * axis.x * axis.y) + m22 * (ver * axis.x * axis.z - sy),
                m21 * (c + ver * axis.y * axis.y) + m20 * (ver * axis.x * axis.y - sz) + m22 * (sx + ver * axis.y * axis.z),
                m22 * (c + ver * axis.z * axis.z) + m20 * (sy + ver * axis.x * axis.z) + m21 * (ver * axis.y * axis.z - sx),
                0,
                m30 * (c + ver * axis.x * axis.x) + m31 * (sz + ver * axis.x * axis.y) + m32 * (ver * axis.x * axis.z - sy),
                m31 * (c + ver * axis.y * axis.y) + m30 * (ver * axis.x * axis.y - sz) + m32 * (sx + ver * axis.y * axis.z),
                m32 * (c + ver * axis.z * axis.z) + m30 * (sy + ver * axis.x * axis.z) + m31 * (ver * axis.y * axis.z - sx),
                1
        );
        return this;
    }

    public final Matrix4f setRotateX(double x) {
        final float s = (float) sin(x);
        final float c = (float) cos(x);

        set(
                1, 0, 0, 0,
                0, c, -s, 0,
                0, s, c, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateY(double y) {
        final float s = (float) sin(y);
        final float c = (float) cos(y);

        set(
                c, 0, -s, 0,
                0, 1, 0, 0,
                s, 0, c, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setRotateZ(double z) {
        final float s = (float) sin(z);
        final float c = (float) cos(z);

        set(
                c, -s, 0, 0,
                s, c, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f scale(float x, float y, float z) {
        m00 *= x;
        m11 *= y;
        m22 *= z;
        return this;
    }

    public final Matrix4f scale(Vector4f scales) {
        m00 *= scales.x;
        m11 *= scales.y;
        m22 *= scales.z;
        return this;
    }

    public final Matrix4f scale(float scale) {
        m00 *= scale;
        m11 *= scale;
        m22 *= scale;
        return this;
    }

    public final Matrix4f scaleX(float scale) {
        m00 *= scale;
        return this;
    }

    public final Matrix4f scaleY(float scale) {
        m11 *= scale;
        return this;
    }

    public final Matrix4f scaleZ(float scale) {
        m22 *= scale;
        return this;
    }

    public final Matrix4f setScale(float x, float y, float z) {
        set(
                x, 0, 0, 0,
                0, y, 0, 0,
                0, 0, z, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setScale(Vector4f scales) {
        return setScale(scales.x, scales.y, scales.z);
    }

    public final Matrix4f setScale(float s) {
        set(
                s, 0, 0, 0,
                0, s, 0, 0,
                0, 0, s, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setScaleX(float s) {
        set(
                s, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setScaleY(float s) {
        set(
                1, 0, 0, 0,
                0, s, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setScaleZ(float s) {
        set(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, s, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f shear(float x, float y, float z) {
        setXYZc(
                m00 + m01 * y + m02 * z,  m00 * x + m01 + m02 * z,  m00 * x + m01 * y + m02,
                m10 + m11 * y + m12 * z,  m10 * x + m11 + m12 * z,  m10 * x + m11 * y + m12,
                m20 + m21 * y + m22 * z,  m20 * x + m21 + m22 * z,  m20 * x + m21 * y + m22,
                m30 + m31 * y + m32 * z,  m30 * x + m31 + m32 * z,  m30 * x + m31 * y + m32
        );
        return this;
    }

    public final Matrix4f shear(Vector4f shears) {
        return shear(shears.x, shears.y, shears.z);
    }

    public final Matrix4f shearXY(float x, float y) {
        setXYc(
                m01 * y + m00,
                m11 * y + m10,
                m21 * y + m20,
                m31 * y + m30,
                m01 + m00 * x,
                m11 + m10 * x,
                m21 + m20 * x,
                m31 + m30 * x
        );
        return this;
    }

    public final Matrix4f shearXZ(float x, float z) {
        setXZc(
                m02 * z + m00,
                m12 * z + m10,
                m22 * z + m20,
                m32 * z + m30,
                m02 + m00 * x,
                m12 + m10 * x,
                m22 + m20 * x,
                m32 + m30 * x
        );
        return this;
    }

    public final Matrix4f shearYZ(float y, float z) {
        setYZc(
                m02 * z + m01,
                m12 * z + m11,
                m22 * z + m21,
                m32 * z + m31,
                m02 + m01 * y,
                m12 + m11 * y,
                m22 + m21 * y,
                m32 + m31 * y
        );
        return this;
    }

    public final Matrix4f setShear(float x, float y, float z) {
        set(
                1, x, x, 0,
                y, 1, y, 0,
                z, z, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setShear(Vector4f shears) {
        return setShear(shears.x, shears.y, shears.z);
    }

    public final Matrix4f setShearXY(float x, float y) {
        set(
                1, x, 0, 0,
                y, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setShearXZ(float x, float z) {
        set(
                1, 0, x, 0,
                0, 1, 0, 0,
                z, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4f setShearYZ(float y, float z) {
        set(
                1, 0, 0, 0,
                0, 1, y, 0,
                0, z, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Vector4f transformation(Vector4f vector) {
        vector.set(
                m00 * vector.x + m01 * vector.y + m02 * vector.z + m03 * vector.w,
                m10 * vector.x + m11 * vector.y + m12 * vector.z + m13 * vector.w,
                m20 * vector.x + m21 * vector.y + m22 * vector.z + m23 * vector.w,
                m30 * vector.x + m31 * vector.y + m32 * vector.z + m33 * vector.w
        );
        return vector;
    }

    public final Vector3f transformation(Vector3f vector) {
        vector.set(
                m00 * vector.x + m01 * vector.y + m02 * vector.z + m03,
                m10 * vector.x + m11 * vector.y + m12 * vector.z + m13,
                m20 * vector.x + m21 * vector.y + m22 * vector.z + m23
        );
        return vector;
    }

    protected final void setXYc(float m00, float m10, float m20, float m30,
                                float m01, float m11, float m21, float m31) {
        this.m00 = m00; this.m10 = m10; this.m20 = m20; this.m30 = m30;
        this.m01 = m01; this.m11 = m11; this.m21 = m21; this.m31 = m31;
    }

    protected final void setXZc(float m00, float m10, float m20, float m30,
                                float m02, float m12, float m22, float m32) {
        this.m00 = m00; this.m10 = m10; this.m20 = m20; this.m30 = m30;
        this.m02 = m02; this.m12 = m12; this.m22 = m22; this.m32 = m32;
    }

    protected final void setYZc(float m01, float m11, float m21, float m31,
                                float m02, float m12, float m22, float m32) {
        this.m01 = m01; this.m11 = m11; this.m21 = m21; this.m31 = m31;
        this.m02 = m02; this.m12 = m12; this.m22 = m22; this.m32 = m32;
    }

    protected final void set3(float m00, float m01, float m02,
                              float m10, float m11, float m12,
                              float m20, float m21, float m22) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
    }

    protected final void setXYZc(float m00, float m01, float m02,
                                 float m10, float m11, float m12,
                                 float m20, float m21, float m22,
                                 float m30, float m31, float m32) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
        this.m30 = m30; this.m31 = m31; this.m32 = m32;
    }
}
