package org.liner.main.matrix;

import org.jetbrains.annotations.NotNull;

public class Matrix4f extends FloatMatrix<Matrix4f, Matrix4f> implements SquareMatrix<Float, Matrix4f> {
    public float
            m11, m12, m13, m14,
            m21, m22, m23, m24,
            m31, m32, m33, m34,
            m41, m42, m43, m44;

    public Matrix4f(float m00, float m01, float m02, float m03,
                    float m10, float m11, float m12, float m13,
                    float m20, float m21, float m22, float m23,
                    float m30, float m31, float m32, float m33) {
        super(null);
        this.m11 = m00; this.m12 = m01; this.m13 = m02; this.m14 = m03;
        this.m21 = m10; this.m22 = m11; this.m23 = m12; this.m24 = m13;
        this.m31 = m20; this.m32 = m21; this.m33 = m22; this.m34 = m23;
        this.m41 = m30; this.m42 = m31; this.m43 = m32; this.m44 = m33;
    }

    public Matrix4f(double m00, double m01, double m02, double m03,
                    double m10, double m11, double m12, double m13,
                    double m20, double m21, double m22, double m23,
                    double m30, double m31, double m32, double m33) {
        super(null);
        this.m11 = (float) m00; this.m12 = (float) m01; this.m13 = (float) m02; this.m14 = (float) m03;
        this.m21 = (float) m10; this.m22 = (float) m11; this.m23 = (float) m12; this.m24 = (float) m13;
        this.m31 = (float) m20; this.m32 = (float) m21; this.m33 = (float) m22; this.m34 = (float) m23;
        this.m41 = (float) m30; this.m42 = (float) m31; this.m43 = (float) m32; this.m44 = (float) m33;
    }

    public Matrix4f(Matrix4f copy) {
        super(copy);
    }

    public Matrix4f() {
        super(null);
        this.m11 = 0f; this.m12 = 0f; this.m13 = 0f; this.m14 = 0f;
        this.m21 = 0f; this.m22 = 0f; this.m23 = 0f; this.m24 = 0f;
        this.m31 = 0f; this.m32 = 0f; this.m33 = 0f; this.m34 = 0f;
        this.m41 = 0f; this.m42 = 0f; this.m43 = 0f; this.m44 = 0f;
    }

    @Override
    public float reduction() {
        return m11 * m22 * m33 * m44 +
                m11 * m23 * m34 * m42 +
                m11 * m24 * m32 * m43 +
                m12 * m21 * m34 * m43 +
                m12 * m23 * m31 * m44 +
                m12 * m24 * m33 * m41 +
                m13 * m21 * m32 * m44 +
                m13 * m22 * m34 * m41 +
                m13 * m24 * m31 * m42 +
                m14 * m21 * m33 * m42 +
                m14 * m22 * m31 * m43 +
                m14 * m23 * m32 * m41 -
                m11 * m22 * m34 * m43 -
                m11 * m23 * m32 * m44 -
                m11 * m24 * m33 * m42 -
                m12 * m21 * m33 * m44 -
                m12 * m23 * m34 * m41 -
                m12 * m24 * m31 * m43 -
                m13 * m21 * m34 * m42 -
                m13 * m22 * m31 * m44 -
                m13 * m24 * m32 * m41 -
                m14 * m21 * m32 * m43 -
                m14 * m22 * m33 * m41 -
                m14 * m23 * m31 * m42;
    }

    @Override
    public void copy(Matrix4f copy) {
        this.m11 = copy.m11; this.m12 = copy.m12; this.m13 = copy.m13; this.m14 = copy.m14;
        this.m21 = copy.m21; this.m22 = copy.m22; this.m23 = copy.m23; this.m24 = copy.m24;
        this.m31 = copy.m31; this.m32 = copy.m32; this.m33 = copy.m33; this.m34 = copy.m34;
        this.m41 = copy.m41; this.m42 = copy.m42; this.m43 = copy.m43; this.m44 = copy.m44;
    }

    @Override
    public Matrix4f copy() {
        return new Matrix4f(this);
    }

    @Override
    public Matrix4f abs() {
        this.m11 = Math.abs(m11); this.m12 = Math.abs(m12); this.m13 = Math.abs(m13); this.m14 = Math.abs(m14);
        this.m21 = Math.abs(m21); this.m22 = Math.abs(m22); this.m23 = Math.abs(m23); this.m24 = Math.abs(m24);
        this.m31 = Math.abs(m31); this.m32 = Math.abs(m32); this.m33 = Math.abs(m33); this.m34 = Math.abs(m34);
        this.m41 = Math.abs(m41); this.m42 = Math.abs(m42); this.m43 = Math.abs(m43); this.m44 = Math.abs(m44);
        return this;
    }

    @Override
    public Matrix4f abs(Matrix4f pointer) {
        pointer.m11 = Math.abs(m11); pointer.m12 = Math.abs(m12); pointer.m13 = Math.abs(m13); pointer.m14 = Math.abs(m14);
        pointer.m21 = Math.abs(m21); pointer.m22 = Math.abs(m22); pointer.m23 = Math.abs(m23); pointer.m24 = Math.abs(m24);
        pointer.m31 = Math.abs(m31); pointer.m32 = Math.abs(m32); pointer.m33 = Math.abs(m33); pointer.m34 = Math.abs(m34);
        pointer.m41 = Math.abs(m41); pointer.m42 = Math.abs(m42); pointer.m43 = Math.abs(m43); pointer.m44 = Math.abs(m44);
        return this;
    }

    @Override
    public Matrix4f add(float value) {
        this.m11 += value; this.m12 += value; this.m13 += value; this.m14 += value;
        this.m21 += value; this.m22 += value; this.m23 += value; this.m24 += value;
        this.m31 += value; this.m32 += value; this.m33 += value; this.m34 += value;
        this.m41 += value; this.m42 += value; this.m43 += value; this.m44 += value;
        return this;
    }

    @Override
    public Matrix4f add(float value, Matrix4f pointer) {
        pointer.m11 = m11 + value; pointer.m12 = m12 + value; pointer.m13 = m13 + value; pointer.m14 = m14 + value;
        pointer.m21 = m21 + value; pointer.m22 = m22 + value; pointer.m23 = m23 + value; pointer.m24 = m24 + value;
        pointer.m31 = m31 + value; pointer.m32 = m32 + value; pointer.m33 = m33 + value; pointer.m34 = m34 + value;
        pointer.m41 = m41 + value; pointer.m42 = m42 + value; pointer.m43 = m43 + value; pointer.m44 = m44 + value;
        return pointer;
    }

    @Override
    public Matrix4f add(Matrix4f value) {
        this.m11 += value.m11; this.m12 += value.m12; this.m13 += value.m13; this.m14 += value.m14;
        this.m21 += value.m21; this.m22 += value.m22; this.m23 += value.m23; this.m24 += value.m24;
        this.m31 += value.m31; this.m32 += value.m32; this.m33 += value.m33; this.m34 += value.m34;
        this.m41 += value.m41; this.m42 += value.m42; this.m43 += value.m43; this.m44 += value.m44;
        return this;
    }

    @Override
    public Matrix4f add(Matrix4f value, Matrix4f pointer) {
        pointer.m11 = m11 + value.m11; pointer.m12 = m12 + value.m12; pointer.m13 = m13 + value.m13; pointer.m14 = m14 + value.m14;
        pointer.m21 = m21 + value.m21; pointer.m22 = m22 + value.m22; pointer.m23 = m23 + value.m23; pointer.m24 = m24 + value.m24;
        pointer.m31 = m31 + value.m31; pointer.m32 = m32 + value.m32; pointer.m33 = m33 + value.m33; pointer.m34 = m34 + value.m34;
        pointer.m41 = m41 + value.m41; pointer.m42 = m42 + value.m42; pointer.m43 = m43 + value.m43; pointer.m44 = m44 + value.m44;
        return pointer;
    }

    @Override
    public Matrix4f sub(float value) {
        this.m11 -= value; this.m12 -= value; this.m13 -= value; this.m14 -= value;
        this.m21 -= value; this.m22 -= value; this.m23 -= value; this.m24 -= value;
        this.m31 -= value; this.m32 -= value; this.m33 -= value; this.m34 -= value;
        this.m41 -= value; this.m42 -= value; this.m43 -= value; this.m44 -= value;
        return this;
    }

    @Override
    public Matrix4f sub(float value, Matrix4f pointer) {
        pointer.m11 = m11 - value; pointer.m12 = m12 - value; pointer.m13 = m13 - value; pointer.m14 = m14 - value;
        pointer.m21 = m21 - value; pointer.m22 = m22 - value; pointer.m23 = m23 - value; pointer.m24 = m24 - value;
        pointer.m31 = m31 - value; pointer.m32 = m32 - value; pointer.m33 = m33 - value; pointer.m34 = m34 - value;
        pointer.m41 = m41 - value; pointer.m42 = m42 - value; pointer.m43 = m43 - value; pointer.m44 = m44 - value;
        return pointer;
    }

    @Override
    public Matrix4f sub(Matrix4f value) {
        this.m11 -= value.m11; this.m12 -= value.m12; this.m13 -= value.m13; this.m14 -= value.m14;
        this.m21 -= value.m21; this.m22 -= value.m22; this.m23 -= value.m23; this.m24 -= value.m24;
        this.m31 -= value.m31; this.m32 -= value.m32; this.m33 -= value.m33; this.m34 -= value.m34;
        this.m41 -= value.m41; this.m42 -= value.m42; this.m43 -= value.m43; this.m44 -= value.m44;
        return this;
    }

    @Override
    public Matrix4f sub(Matrix4f value, Matrix4f pointer) {
        pointer.m11 = m11 - value.m11; pointer.m12 = m12 - value.m12; pointer.m13 = m13 - value.m13; pointer.m14 = m14 - value.m14;
        pointer.m21 = m21 - value.m21; pointer.m22 = m22 - value.m22; pointer.m23 = m23 - value.m23; pointer.m24 = m24 - value.m24;
        pointer.m31 = m31 - value.m31; pointer.m32 = m32 - value.m32; pointer.m33 = m33 - value.m33; pointer.m34 = m34 - value.m34;
        pointer.m41 = m41 - value.m41; pointer.m42 = m42 - value.m42; pointer.m43 = m43 - value.m43; pointer.m44 = m44 - value.m44;
        return pointer;
    }

    @Override
    public Matrix4f mul(float value) {
        this.m11 *= value; this.m12 *= value; this.m13 *= value; this.m14 *= value;
        this.m21 *= value; this.m22 *= value; this.m23 *= value; this.m24 *= value;
        this.m31 *= value; this.m32 *= value; this.m33 *= value; this.m34 *= value;
        this.m41 *= value; this.m42 *= value; this.m43 *= value; this.m44 *= value;
        return this;
    }

    @Override
    public Matrix4f mul(float value, Matrix4f pointer) {
        pointer.m11 = m11 * value; pointer.m12 = m12 * value; pointer.m13 = m13 * value; pointer.m14 = m14 * value;
        pointer.m21 = m21 * value; pointer.m22 = m22 * value; pointer.m23 = m23 * value; pointer.m24 = m24 * value;
        pointer.m31 = m31 * value; pointer.m32 = m32 * value; pointer.m33 = m33 * value; pointer.m34 = m34 * value;
        pointer.m41 = m41 * value; pointer.m42 = m42 * value; pointer.m43 = m43 * value; pointer.m44 = m44 * value;
        return pointer;
    }

    // TODO: 2023/10/26 軽量化
    @Override
    public Matrix4f mul(Matrix4f value) {
        final float m00 = this.m11 * value.m11 + this.m12 * value.m21 + this.m13 * value.m31 + this.m14 * value.m41;
        final float m01 = this.m11 * value.m12 + this.m12 * value.m22 + this.m13 * value.m32 + this.m14 * value.m42;
        final float m02 = this.m11 * value.m13 + this.m12 * value.m23 + this.m13 * value.m33 + this.m14 * value.m43;
        final float m03 = this.m11 * value.m14 + this.m12 * value.m24 + this.m13 * value.m34 + this.m14 * value.m44;
        final float m10 = this.m21 * value.m11 + this.m22 * value.m21 + this.m23 * value.m31 + this.m24 * value.m41;
        final float m11 = this.m21 * value.m12 + this.m22 * value.m22 + this.m23 * value.m32 + this.m24 * value.m42;
        final float m12 = this.m21 * value.m13 + this.m22 * value.m23 + this.m23 * value.m33 + this.m24 * value.m43;
        final float m13 = this.m21 * value.m14 + this.m22 * value.m24 + this.m23 * value.m34 + this.m24 * value.m44;
        final float m20 = this.m31 * value.m11 + this.m32 * value.m21 + this.m33 * value.m31 + this.m34 * value.m41;
        final float m21 = this.m31 * value.m12 + this.m32 * value.m22 + this.m33 * value.m32 + this.m34 * value.m42;
        final float m22 = this.m31 * value.m13 + this.m32 * value.m23 + this.m33 * value.m33 + this.m34 * value.m43;
        final float m23 = this.m31 * value.m14 + this.m32 * value.m24 + this.m33 * value.m34 + this.m34 * value.m44;
        final float m30 = this.m41 * value.m11 + this.m42 * value.m21 + this.m43 * value.m31 + this.m44 * value.m41;
        final float m31 = this.m41 * value.m12 + this.m42 * value.m22 + this.m43 * value.m32 + this.m44 * value.m42;
        final float m32 = this.m41 * value.m13 + this.m42 * value.m23 + this.m43 * value.m33 + this.m44 * value.m43;
        this.m11 = m00;
        this.m12 = m01;
        this.m13 = m02;
        this.m14 = m03;
        this.m21 = m10;
        this.m22 = m11;
        this.m23 = m12;
        this.m24 = m13;
        this.m31 = m20;
        this.m32 = m21;
        this.m33 = m22;
        this.m34 = m23;
        this.m41 = m30;
        this.m42 = m31;
        this.m43 = m32;
        this.m44 = this.m41 * value.m14 + this.m42 * value.m24 + this.m43 * value.m34 + this.m44 * value.m44;
        return this;
    }

    @Override
    public Matrix4f mul(Matrix4f value, Matrix4f pointer) {
        pointer.m11 = this.m11 * value.m11 + this.m12 * value.m21 + this.m13 * value.m31 + this.m14 * value.m41;
        pointer.m12 = this.m11 * value.m12 + this.m12 * value.m22 + this.m13 * value.m32 + this.m14 * value.m42;
        pointer.m13 = this.m11 * value.m13 + this.m12 * value.m23 + this.m13 * value.m33 + this.m14 * value.m43;
        pointer.m14 = this.m11 * value.m14 + this.m12 * value.m24 + this.m13 * value.m34 + this.m14 * value.m44;
        pointer.m21 = this.m21 * value.m11 + this.m22 * value.m21 + this.m23 * value.m31 + this.m24 * value.m41;
        pointer.m22 = this.m21 * value.m12 + this.m22 * value.m22 + this.m23 * value.m32 + this.m24 * value.m42;
        pointer.m23 = this.m21 * value.m13 + this.m22 * value.m23 + this.m23 * value.m33 + this.m24 * value.m43;
        pointer.m24 = this.m21 * value.m14 + this.m22 * value.m24 + this.m23 * value.m34 + this.m24 * value.m44;
        pointer.m31 = this.m31 * value.m11 + this.m32 * value.m21 + this.m33 * value.m31 + this.m34 * value.m41;
        pointer.m32 = this.m31 * value.m12 + this.m32 * value.m22 + this.m33 * value.m32 + this.m34 * value.m42;
        pointer.m33 = this.m31 * value.m13 + this.m32 * value.m23 + this.m33 * value.m33 + this.m34 * value.m43;
        pointer.m34 = this.m31 * value.m14 + this.m32 * value.m24 + this.m33 * value.m34 + this.m34 * value.m44;
        pointer.m41 = this.m41 * value.m11 + this.m42 * value.m21 + this.m43 * value.m31 + this.m44 * value.m41;
        pointer.m42 = this.m41 * value.m12 + this.m42 * value.m22 + this.m43 * value.m32 + this.m44 * value.m42;
        pointer.m43 = this.m41 * value.m13 + this.m42 * value.m23 + this.m43 * value.m33 + this.m44 * value.m43;
        pointer.m44 = this.m41 * value.m14 + this.m42 * value.m24 + this.m43 * value.m34 + this.m44 * value.m44;
        return pointer;
    }

    @Override
    public Matrix4f div(float value) {
        this.m11 /= value; this.m12 /= value; this.m13 /= value; this.m14 /= value;
        this.m21 /= value; this.m22 /= value; this.m23 /= value; this.m24 /= value;
        this.m31 /= value; this.m32 /= value; this.m33 /= value; this.m34 /= value;
        this.m41 /= value; this.m42 /= value; this.m43 /= value; this.m44 /= value;
        return this;
    }

    @Override
    public Matrix4f div(float value, Matrix4f pointer) {
        pointer.m11 = m11 / value; pointer.m12 = m12 / value; pointer.m13 = m13 / value; pointer.m14 = m14 / value;
        pointer.m21 = m21 / value; pointer.m22 = m22 / value; pointer.m23 = m23 / value; pointer.m24 = m24 / value;
        pointer.m31 = m31 / value; pointer.m32 = m32 / value; pointer.m33 = m33 / value; pointer.m34 = m34 / value;
        pointer.m41 = m41 / value; pointer.m42 = m42 / value; pointer.m43 = m43 / value; pointer.m44 = m44 / value;
        return pointer;
    }

    @Override
    public Matrix4f div(Matrix4f value) {
        return this.mul(value.copy().invert());
    }

    @Override
    public Matrix4f div(Matrix4f value, Matrix4f pointer) {
        pointer.copy(this);

        return pointer.div(value);
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0  -> m11; case 1  -> m12; case 2  -> m13; case 3  -> m14;
            case 4  -> m21; case 5  -> m22; case 6  -> m23; case 7  -> m24;
            case 8  -> m31; case 9  -> m32; case 10 -> m33; case 11 -> m34;
            case 12 -> m41; case 13 -> m42; case 14 -> m43; case 15 -> m44;
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public boolean equals(@NotNull Matrix4f value) {
        return this.m11 == value.m11 &&
                this.m12 == value.m12 &&
                this.m13 == value.m13 &&
                this.m14 == value.m14 &&
                this.m21 == value.m21 &&
                this.m22 == value.m22 &&
                this.m23 == value.m23 &&
                this.m24 == value.m24 &&
                this.m31 == value.m31 &&
                this.m32 == value.m32 &&
                this.m33 == value.m33 &&
                this.m34 == value.m34 &&
                this.m41 == value.m41 &&
                this.m42 == value.m42 &&
                this.m43 == value.m43 &&
                this.m44 == value.m44;
    }

    @Override
    public Matrix4f transpose() {
        final float m12 = this.m21;
        final float m13 = this.m31;
        final float m14 = this.m41;
        final float m21 = this.m12;
        final float m23 = this.m32;
        final float m24 = this.m42;
        final float m31 = this.m13;
        final float m32 = this.m23;
        final float m34 = this.m43;
        final float m41 = this.m14;
        final float m42 = this.m24;
        final float m43 = this.m34;
        this.m12 = m21;
        this.m13 = m31;
        this.m14 = m41;
        this.m21 = m12;
        this.m23 = m32;
        this.m24 = m42;
        this.m31 = m13;
        this.m32 = m23;
        this.m34 = m43;
        this.m41 = m14;
        this.m42 = m24;
        this.m43 = m34;
        return this;
    }

    @Override
    public Matrix4f transpose(Matrix4f pointer) {
        pointer.m11 = m11;
        pointer.m12 = m21;
        pointer.m13 = m31;
        pointer.m14 = m41;
        pointer.m21 = m12;
        pointer.m22 = m22;
        pointer.m23 = m32;
        pointer.m24 = m42;
        pointer.m31 = m13;
        pointer.m32 = m23;
        pointer.m33 = m33;
        pointer.m34 = m43;
        pointer.m41 = m14;
        pointer.m42 = m24;
        pointer.m43 = m34;
        pointer.m44 = m44;
        return this;
    }

    @Override
    public int rowsSize() {
        return 4;
    }

    @Override
    public int columnsSize() {
        return 4;
    }

    @Override
    public int elementsSize() {
        return 16;
    }

    @Override
    public Float[] getRow(int index) {
        return switch (index) {
            case 0 -> new Float[]{m11, m12, m13, m14};
            case 1 -> new Float[]{m21, m22, m23, m24};
            case 2 -> new Float[]{m31, m32, m33, m34};
            case 3 -> new Float[]{m41, m42, m43, m44};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public Float[] getColumn(int index) {
        return switch (index) {
            case 0 -> new Float[]{m11, m21, m31, m41};
            case 1 -> new Float[]{m12, m22, m32, m42};
            case 2 -> new Float[]{m13, m23, m33, m43};
            case 3 -> new Float[]{m14, m24, m34, m44};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.m11;
        pointer[1] = this.m12;
        pointer[2] = this.m13;
        pointer[3] = this.m14;
        pointer[4] = this.m21;
        pointer[5] = this.m22;
        pointer[6] = this.m23;
        pointer[7] = this.m24;
        pointer[8] = this.m31;
        pointer[9] = this.m32;
        pointer[10] = this.m33;
        pointer[11] = this.m34;
        pointer[12] = this.m41;
        pointer[13] = this.m42;
        pointer[14] = this.m43;
        pointer[15] = this.m44;
        return pointer;
    }

    @Override
    public void set(int r, int c, Float value) {
        switch (r) {
            case 0 -> {
                switch (c) {
                    case 0 -> m11 = value;
                    case 1 -> m12 = value;
                    case 2 -> m13 = value;
                    case 3 -> m14 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 1 -> {
                switch (c) {
                    case 0 -> m21 = value;
                    case 1 -> m22 = value;
                    case 2 -> m23 = value;
                    case 3 -> m24 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 2 -> {
                switch (c) {
                    case 0 -> m31 = value;
                    case 1 -> m32 = value;
                    case 2 -> m33 = value;
                    case 3 -> m34 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 3 -> {
                switch (c) {
                    case 0 -> m41 = value;
                    case 1 -> m42 = value;
                    case 2 -> m43 = value;
                    case 3 -> m44 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(float m00, float m01, float m02, float m03,
                    float m10, float m11, float m12, float m13,
                    float m20, float m21, float m22, float m23,
                    float m30, float m31, float m32, float m33) {
        this.m11 = m00; this.m12 = m01; this.m13 = m02; this.m14 = m03;
        this.m21 = m10; this.m22 = m11; this.m23 = m12; this.m24 = m13;
        this.m31 = m20; this.m32 = m21; this.m33 = m22; this.m34 = m23;
        this.m41 = m30; this.m42 = m31; this.m43 = m32; this.m44 = m33;
    }

    @Override
    public Float get(int r, int c) {
        return switch (r) {
            case 0 -> switch (c) {
                case 0 -> m11;
                case 1 -> m12;
                case 2 -> m13;
                case 3 -> m14;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 1 -> switch (c) {
                case 0 -> m21;
                case 1 -> m22;
                case 2 -> m23;
                case 3 -> m24;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 2 -> switch (c) {
                case 0 -> m31;
                case 1 -> m32;
                case 2 -> m33;
                case 3 -> m34;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 3 -> switch (c) {
                case 0 -> m41;
                case 1 -> m42;
                case 2 -> m43;
                case 3 -> m44;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public Matrix4f invert() {
        float det = reduction();
        if (det != 0) {
            set(
                    m22 * m33 * m44 + m23 * m34 * m42 + m24 * m32 * m43 - m22 * m34 * m43 - m23 * m32 * m44 - m24 * m33 * m42,
                    m12 * m34 * m43 + m13 * m32 * m44 + m14 * m33 * m42 - m12 * m33 * m44 - m13 * m34 * m42 - m14 * m32 * m43,
                    m12 * m23 * m44 + m13 * m24 * m42 + m14 * m22 * m43 - m12 * m24 * m43 - m13 * m22 * m44 - m14 * m23 * m42,
                    m12 * m24 * m33 + m13 * m22 * m34 + m14 * m23 * m32 - m12 * m23 * m34 - m13 * m24 * m32 - m14 * m22 * m33,
                    m21 * m34 * m43 + m23 * m31 * m44 + m24 * m33 * m41 - m21 * m33 * m44 - m23 * m34 * m41 - m24 * m31 * m43,
                    m11 * m33 * m44 + m13 * m34 * m41 + m14 * m31 * m43 - m11 * m34 * m43 - m13 * m31 * m44 - m14 * m33 * m41,
                    m11 * m24 * m43 + m13 * m21 * m44 + m14 * m23 * m41 - m11 * m23 * m44 - m13 * m24 * m41 - m14 * m21 * m43,
                    m11 * m23 * m34 + m13 * m24 * m31 + m14 * m21 * m33 - m11 * m24 * m33 - m13 * m21 * m34 - m14 * m23 * m31,
                    m21 * m32 * m44 + m22 * m34 * m41 + m24 * m31 * m42 - m21 * m34 * m42 - m22 * m31 * m44 - m24 * m32 * m41,
                    m11 * m34 * m42 + m12 * m31 * m44 + m14 * m32 * m41 - m11 * m32 * m44 - m12 * m34 * m41 - m14 * m31 * m42,
                    m11 * m22 * m44 + m12 * m24 * m41 + m14 * m21 * m42 - m11 * m24 * m42 - m12 * m21 * m44 - m14 * m22 * m41,
                    m11 * m24 * m32 + m12 * m21 * m34 + m14 * m22 * m31 - m11 * m22 * m34 - m12 * m24 * m31 - m14 * m21 * m32,
                    m21 * m33 * m42 + m22 * m31 * m43 + m23 * m32 * m41 - m21 * m32 * m43 - m22 * m33 * m41 - m23 * m31 * m42,
                    m11 * m32 * m43 + m12 * m33 * m41 + m13 * m31 * m42 - m11 * m33 * m42 - m12 * m31 * m43 - m13 * m32 * m41,
                    m11 * m23 * m42 + m12 * m21 * m43 + m13 * m22 * m41 - m11 * m22 * m43 - m12 * m23 * m41 - m13 * m21 * m42,
                    m11 * m22 * m33 + m12 * m23 * m31 + m13 * m21 * m32 - m11 * m23 * m32 - m12 * m21 * m33 - m13 * m22 * m31);

            return this.mul(1 / det);
        }

        return null;
    }

    @Override
    public Matrix4f invert(Matrix4f pointer) {
        pointer.copy(this);
        return pointer.invert();
    }
}
