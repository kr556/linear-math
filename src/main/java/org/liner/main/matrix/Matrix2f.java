package org.liner.main.matrix;

import org.jetbrains.annotations.NotNull;

public class Matrix2f extends FloatMatrix<Matrix2f, Matrix2f> implements SquareMatrix<Float, Matrix2f> {
    public float
            m11, m12,
            m21, m22;

    public Matrix2f(float m00, float m01,
                    float m10, float m11) {
        super(null);
        this.m11 = m00; this.m12 = m01;
        this.m21 = m10; this.m22 = m11;
    }

    public Matrix2f(double m00, double m01,
                    double m10, double m11) {
        super(null);
        this.m11 = (float) m00; this.m12 = (float) m01;
        this.m21 = (float) m10; this.m22 = (float) m11;
    }

    public Matrix2f(Matrix2f copy) {
        super(copy);
    }

    @Override
    public float reduction() {
        return m11 * m22 - m12 * m21;
    }

    public Matrix2f() {
        super(null);
        this.m11 = 0f; this.m12 = 0f;
        this.m21 = 0f; this.m22 = 0f;
    }

    @Override
    public void copy(Matrix2f copy) {
        this.m11 = copy.m11; this.m12 = copy.m12;
        this.m21 = copy.m21; this.m22 = copy.m22;
    }

    @Override
    public Matrix2f copy() {
        return new Matrix2f(this);
    }

    @Override
    public Matrix2f abs() {
        this.m11 = Math.abs(m11); this.m12 = Math.abs(m12);
        this.m21 = Math.abs(m21); this.m22 = Math.abs(m22);
        return this;
    }

    @Override
    public Matrix2f abs(Matrix2f pointer) {
        pointer.m11 = Math.abs(m11); pointer.m12 = Math.abs(m12);
        pointer.m21 = Math.abs(m21); pointer.m22 = Math.abs(m22);
        return this;
    }

    @Override
    public Matrix2f add(float value) {
        this.m11 += value; this.m12 += value;
        this.m21 += value; this.m22 += value;
        return this;
    }

    @Override
    public Matrix2f add(float value, Matrix2f pointer) {
        pointer.m11 = m11 + value; pointer.m12 = m12 + value;
        pointer.m21 = m21 + value; pointer.m22 = m22 + value;
        return pointer;
    }

    @Override
    public Matrix2f add(Matrix2f value) {
        this.m11 += value.m11; this.m12 += value.m12;
        this.m21 += value.m21; this.m22 += value.m22;
        return this;
    }

    @Override
    public Matrix2f add(Matrix2f value, Matrix2f pointer) {
        pointer.m11 = m11 + value.m11; pointer.m12 = m12 + value.m12;
        pointer.m21 = m21 + value.m21; pointer.m22 = m22 + value.m22;
        return pointer;
    }

    @Override
    public Matrix2f sub(float value) {
        this.m11 -= value; this.m12 -= value;
        this.m21 -= value; this.m22 -= value;
        return this;
    }

    @Override
    public Matrix2f sub(float value, Matrix2f pointer) {
        pointer.m11 = m11 - value; pointer.m12 = m12 - value;
        pointer.m21 = m21 - value; pointer.m22 = m22 - value;
        return pointer;
    }

    @Override
    public Matrix2f sub(Matrix2f value) {
        this.m11 -= value.m11; this.m12 -= value.m12;
        this.m21 -= value.m21; this.m22 -= value.m22;
        return this;
    }

    @Override
    public Matrix2f sub(Matrix2f value, Matrix2f pointer) {
        pointer.m11 = m11 - value.m11; pointer.m12 = m12 - value.m12;
        pointer.m21 = m21 - value.m21; pointer.m22 = m22 - value.m22;
        return pointer;
    }

    @Override
    public Matrix2f mul(float value) {
        this.m11 *= value; this.m12 *= value;
        this.m21 *= value; this.m22 *= value;
        return this;
    }

    @Override
    public Matrix2f mul(float value, Matrix2f pointer) {
        pointer.m11 = m11 * value; pointer.m12 = m12 * value;
        pointer.m21 = m21 * value; pointer.m22 = m22 * value;
        return pointer;
    }

    @Override
    public Matrix2f div(float value) {
        this.m11 /= value; this.m12 /= value;
        this.m21 /= value; this.m22 /= value;
        return this;
    }

    @Override
    public Matrix2f div(float value, Matrix2f pointer) {
        pointer.m11 = m11 / value; pointer.m12 = m12 / value;
        pointer.m21 = m21 / value; pointer.m22 = m22 / value;
        return pointer;
    }

    @Override
    public Matrix2f div(Matrix2f value) {
        return this.mul(value.copy().invert());
    }

    @Override
    public Matrix2f div(Matrix2f value, Matrix2f pointer) {
        pointer.copy(this);

        return pointer.div(value);
    }

    @Override
    public Matrix2f mul(Matrix2f value) {
        final float m00 = this.m11 * value.m11 + this.m12 * value.m21;
        final float m01 = this.m11 * value.m12 + this.m12 * value.m22;
        final float m10 = this.m21 * value.m11 + this.m22 * value.m21;
        final float m11 = this.m21 * value.m12 + this.m22 * value.m22;
        this.m11 = m00;
        this.m12 = m01;
        this.m21 = m10;
        this.m22 = m11;
        return this;
    }

    @Override
    public Matrix2f mul(Matrix2f value, Matrix2f pointer) {
        pointer.m11 = this.m11 * value.m11 + this.m12 * value.m21;
        pointer.m12 = this.m11 * value.m12 + this.m12 * value.m22;
        pointer.m21 = this.m21 * value.m11 + this.m22 * value.m21;
        pointer.m22 = this.m21 * value.m12 + this.m22 * value.m22;
        return pointer;
    }

    @Override
    public Float get(int index) {
        return switch (index) {
            case 0  -> m11; case 2  -> m12;
            case 4  -> m21; case 3  -> m22;
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public boolean equals(@NotNull Matrix2f value) {
        return this.m11 == value.m11 &&
                this.m12 == value.m12 &&
                this.m21 == value.m21 &&
                this.m22 == value.m22;
    }

    @Override
    public Matrix2f transpose() {
        final float m12 = this.m21;
        final float m21 = this.m12;
        this.m12 = m12;
        this.m21 = m21;
        return this;
    }

    @Override
    public Matrix2f transpose(Matrix2f pointer) {
        pointer.m11 = m11;
        pointer.m12 = m21;
        pointer.m22 = m22;
        pointer.m21 = m12;
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
        return 2;
    }

    @Override
    public Float[] getRow(int index) {
        return switch (index) {
            case 0 -> new Float[]{m11, m12};
            case 1 -> new Float[]{m21, m22};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public Float[] getColumn(int index) {
        return switch (index) {
            case 0 -> new Float[]{m11, m21};
            case 1 -> new Float[]{m12, m22};
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public void set(int r, int c, Float value) {
        switch (r) {
            case 0 -> {
                switch (c) {
                    case 0 -> m11 = value;
                    case 1 -> m12 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            case 1 -> {
                switch (c) {
                    case 0 -> m21 = value;
                    case 1 -> m22 = value;
                    default -> throw new ArrayIndexOutOfBoundsException();
                }
            }
            default -> throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(float m00, float m01,
                    float m10, float m11) {
        this.m11 = m00; this.m12 = m01;
        this.m21 = m10; this.m22 = m11;
    }

    @Override
    public Float get(int r, int c) {
        return switch (r) {
            case 0 -> switch (c) {
                case 0 -> m11;
                case 1 -> m12;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            case 1 -> switch (c) {
                case 0 -> m21;
                case 1 -> m22;
                default -> throw new ArrayIndexOutOfBoundsException();
            };
            default -> throw new ArrayIndexOutOfBoundsException();
        };
    }

    @Override
    public Matrix2f invert() {
        float det = reduction();
        if (det != 0) {
            set(
                    m22, -m12,
                    -m21, m11);

            return this.mul(1 / det);
        }

        return null;
    }

    @Override
    public Matrix2f invert(Matrix2f pointer) {
        pointer.copy(this);
        return pointer.invert();
    }

    @Override
    public float[] toArray(float[] pointer) {
        pointer[0] = this.m11;
        pointer[1] = this.m12;
        pointer[4] = this.m21;
        pointer[5] = this.m22;
        return pointer;
    }
}
