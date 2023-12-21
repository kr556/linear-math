package org.linear.main.matrix;


import org.jetbrains.annotations.NotNull;
import org.linear.main.vector.Vector3d;
import org.linear.main.vector.Vector4d;
import org.linear.main.vector.Vector4f;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

import static java.lang.Math.*;

public class Matrix4d extends SquareMatrix<Double, Matrix4d>
        implements DoubleMatrix<Matrix4d, Matrix4d> {
    public final static Matrix4d NAN = new Matrix4d(
            Double.NaN, Double.NaN, Double.NaN, Double.NaN,
            Double.NaN, Double.NaN, Double.NaN, Double.NaN,
            Double.NaN, Double.NaN, Double.NaN, Double.NaN,
            Double.NaN, Double.NaN, Double.NaN, Double.NaN);

    public final static Matrix4d DIAGONAL = new Matrix4d(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1);

    public double
            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33;

    public Matrix4d(double m00, double m01, double m02, double m03,
                    double m10, double m11, double m12, double m13,
                    double m20, double m21, double m22, double m23,
                    double m30, double m31, double m32, double m33) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
    }

    public Matrix4d(Matrix4d copy) {
        set(copy);
    }

    public Matrix4d() {}

    @Override
    public final double determinant() {
        return (m00 * m11 - m01 * m10) * (m22 * m33 - m23 * m32)
               - (m00 * m12 - m02 * m10) * (m21 * m33 - m23 * m31)
               + (m00 * m13 - m03 * m10) * (m21 * m32 - m22 * m31)
               + (m01 * m12 - m02 * m11) * (m20 * m33 - m23 * m30)
               - (m01 * m13 - m03 * m11) * (m20 * m32 - m22 * m30)
               + (m02 * m13 - m03 * m12) * (m20 * m31 - m21 * m30);
    }

    @Override
    public final void set(Matrix4d copy) {
        this.m00 = copy.m00; this.m01 = copy.m01; this.m02 = copy.m02; this.m03 = copy.m03;
        this.m10 = copy.m10; this.m11 = copy.m11; this.m12 = copy.m12; this.m13 = copy.m13;
        this.m20 = copy.m20; this.m21 = copy.m21; this.m22 = copy.m22; this.m23 = copy.m23;
        this.m30 = copy.m30; this.m31 = copy.m31; this.m32 = copy.m32; this.m33 = copy.m33;
    }

    @Override
    public final Matrix4d copy() {
        return new Matrix4d(this);
    }

    @Override
    public final Matrix4d abs() {
        this.m00 = Math.abs(m00); this.m01 = Math.abs(m01); this.m02 = Math.abs(m02); this.m03 = Math.abs(m03);
        this.m10 = Math.abs(m10); this.m11 = Math.abs(m11); this.m12 = Math.abs(m12); this.m13 = Math.abs(m13);
        this.m20 = Math.abs(m20); this.m21 = Math.abs(m21); this.m22 = Math.abs(m22); this.m23 = Math.abs(m23);
        this.m30 = Math.abs(m30); this.m31 = Math.abs(m31); this.m32 = Math.abs(m32); this.m33 = Math.abs(m33);
        return this;
    }

    @Override
    public final Matrix4d abs(Matrix4d pointer) {
        pointer.set(this);
        return pointer.abs();
    }

    @Override
    public final Matrix4d add(double value) {
        this.m00 += value; this.m01 += value; this.m02 += value; this.m03 += value;
        this.m10 += value; this.m11 += value; this.m12 += value; this.m13 += value;
        this.m20 += value; this.m21 += value; this.m22 += value; this.m23 += value;
        this.m30 += value; this.m31 += value; this.m32 += value; this.m33 += value;
        return this;
    }

    @Override
    public final Matrix4d add(double value, Matrix4d pointer) {
        pointer.set(this);

        return pointer.add(value);
    }

    @Override
    public final Matrix4d add(Matrix4d value) {
        this.m00 += value.m00; this.m01 += value.m01; this.m02 += value.m02; this.m03 += value.m03;
        this.m10 += value.m10; this.m11 += value.m11; this.m12 += value.m12; this.m13 += value.m13;
        this.m20 += value.m20; this.m21 += value.m21; this.m22 += value.m22; this.m23 += value.m23;
        this.m30 += value.m30; this.m31 += value.m31; this.m32 += value.m32; this.m33 += value.m33;
        return this;
    }

    @Override
    public final Matrix4d add(Matrix4d value, Matrix4d pointer) {
        pointer.set(this);

        return pointer.add(value);
    }

    @Override
    public final Matrix4d sub(double value) {
        this.m00 -= value; this.m01 -= value; this.m02 -= value; this.m03 -= value;
        this.m10 -= value; this.m11 -= value; this.m12 -= value; this.m13 -= value;
        this.m20 -= value; this.m21 -= value; this.m22 -= value; this.m23 -= value;
        this.m30 -= value; this.m31 -= value; this.m32 -= value; this.m33 -= value;
        return this;
    }

    @Override
    public final Matrix4d sub(double value, Matrix4d pointer) {
        pointer.set(this);

        return pointer.sub(value);
    }

    @Override
    public final Matrix4d sub(Matrix4d value) {
        this.m00 -= value.m00; this.m01 -= value.m01; this.m02 -= value.m02; this.m03 -= value.m03;
        this.m10 -= value.m10; this.m11 -= value.m11; this.m12 -= value.m12; this.m13 -= value.m13;
        this.m20 -= value.m20; this.m21 -= value.m21; this.m22 -= value.m22; this.m23 -= value.m23;
        this.m30 -= value.m30; this.m31 -= value.m31; this.m32 -= value.m32; this.m33 -= value.m33;
        return this;
    }

    @Override
    public final Matrix4d sub(Matrix4d value, Matrix4d pointer) {
        pointer.set(this);

        return pointer.sub(value);
    }

    @Override
    public final Matrix4d mul(double value) {
        this.m00 *= value; this.m01 *= value; this.m02 *= value; this.m03 *= value;
        this.m10 *= value; this.m11 *= value; this.m12 *= value; this.m13 *= value;
        this.m20 *= value; this.m21 *= value; this.m22 *= value; this.m23 *= value;
        this.m30 *= value; this.m31 *= value; this.m32 *= value; this.m33 *= value;
        return this;
    }

    @Override
    public final Matrix4d mul(double value, Matrix4d pointer) {
        pointer.set(this);

        return pointer.mul(value);
    }

    public final Matrix4d mul(double m00, double m01, double m02, double m03,
                              double m10, double m11, double m12, double m13,
                              double m20, double m21, double m22, double m23,
                              double m30, double m31, double m32, double m33) {
        this.m00 *= m00 * m00; this.m01 *= m01; this.m02 *= m02; this.m03 *= m03;
        this.m10 *= m10 * m10; this.m11 *= m11; this.m12 *= m12; this.m13 *= m13;
        this.m20 *= m20 * m20; this.m21 *= m21; this.m22 *= m22; this.m23 *= m23;
        this.m30 *= m30 * m30; this.m31 *= m31; this.m32 *= m32; this.m33 *= m33;
        return this;
    }

    @Override
    public final Matrix4d mul(Matrix4d value) {
        mul(value.m00, value.m01, value.m02, value.m03,
                value.m10, value.m11, value.m12, value.m13,
                value.m20, value.m21, value.m22, value.m23,
                value.m30, value.m31, value.m32, value.m33);
        return this;
    }

    @Override
    public final Matrix4d mul(Matrix4d value, Matrix4d pointer) {
        pointer.set(this);
        pointer.mul(value);
        return pointer;
    }

    @Override
    public final Matrix4d div(double value) {
        this.m00 /= value; this.m01 /= value; this.m02 /= value; this.m03 /= value;
        this.m10 /= value; this.m11 /= value; this.m12 /= value; this.m13 /= value;
        this.m20 /= value; this.m21 /= value; this.m22 /= value; this.m23 /= value;
        this.m30 /= value; this.m31 /= value; this.m32 /= value; this.m33 /= value;
        return this;
    }

    @Override
    public final Matrix4d div(double value, Matrix4d pointer) {
        pointer.set(this);

        return pointer.div(value);
    }

    @Override
    public final Matrix4d div(Matrix4d value) {
        this.m00 /= value.m00; this.m01 /= value.m01; this.m02 /= value.m02; this.m03 /= value.m03;
        this.m10 /= value.m10; this.m11 /= value.m11; this.m12 /= value.m12; this.m13 /= value.m13;
        this.m20 /= value.m20; this.m21 /= value.m21; this.m22 /= value.m22; this.m23 /= value.m23;
        this.m30 /= value.m30; this.m31 /= value.m31; this.m32 /= value.m32; this.m33 /= value.m33;
        return this;
    }

    @Override
    public final Matrix4d div(Matrix4d value, Matrix4d pointer) {
        pointer.set(this);

        return pointer.div(value);
    }

    @Override
    public final Double get(int index) {
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
    public final boolean equals(@NotNull Matrix4d value) {
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
    public final Matrix4d transpose() {
        double tmp = m01;
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
    public final Matrix4d transpose(Matrix4d pointer) {
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

    public final Matrix4d mulC(double m00, double m01, double m02, double m03,
                               double m10, double m11, double m12, double m13,
                               double m20, double m21, double m22, double m23,
                               double m30, double m31, double m32, double m33) {
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
    public final Matrix4d mulC(Matrix4d value) {
        return mulC(value.m00, value.m01, value.m02, value.m03,
                value.m10, value.m11, value.m12, value.m13,
                value.m20, value.m21, value.m22, value.m23,
                value.m30, value.m31, value.m32, value.m33);
    }

    public final Matrix4d mulR(double m00, double m01, double m02, double m03,
                               double m10, double m11, double m12, double m13,
                               double m20, double m21, double m22, double m23,
                               double m30, double m31, double m32, double m33) {
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
    public final Matrix4d mulR(Matrix4d value) {
        return mulR(value.m00, value.m01, value.m02, value.m03,
                value.m10, value.m11, value.m12, value.m13,
                value.m20, value.m21, value.m22, value.m23,
                value.m30, value.m31, value.m32, value.m33);
    }

//    @Override
//    public Matrix3d[] submatries() {
//        Matrix3d[] re = new Matrix3d[16];
//        submatries(re);
//        return re;
//    }
//
//    @Override
//    public void submatries(Matrix<Double, ?, ?>[] pointer) {
//        pointer[0] = new Matrix3d(m11, m12, m13, m21, m22, m23, m31, m32, m33);
//        pointer[1] = new Matrix3d(m10, m12, m13, m20, m22, m23, m30, m32, m33);
//        pointer[2] = new Matrix3d(m10, m11, m13, m20, m21, m23, m30, m31, m33);
//        pointer[3] = new Matrix3d(m10, m11, m12, m20, m21, m22, m30, m31, m32);
//        pointer[4] = new Matrix3d(m01, m02, m03, m21, m22, m23, m31, m32, m33);
//        pointer[5] = new Matrix3d(m00, m02, m03, m20, m22, m23, m30, m32, m33);
//        pointer[6] = new Matrix3d(m00, m01, m03, m20, m21, m23, m30, m31, m33);
//        pointer[7] = new Matrix3d(m00, m01, m02, m20, m21, m22, m30, m31, m32);
//        pointer[8] = new Matrix3d(m01, m02, m03, m11, m12, m13, m31, m32, m33);
//        pointer[9] = new Matrix3d(m00, m02, m03, m10, m12, m13, m30, m32, m33);
//        pointer[10] = new Matrix3d(m00, m01, m03, m10, m11, m13, m30, m31, m33);
//        pointer[11] = new Matrix3d(m00, m01, m02, m10, m11, m12, m30, m31, m32);
//        pointer[12] = new Matrix3d(m01, m02, m03, m11, m12, m13, m21, m22, m23);
//        pointer[13] = new Matrix3d(m00, m02, m03, m10, m12, m13, m20, m22, m23);
//        pointer[14] = new Matrix3d(m00, m01, m03, m10, m11, m13, m20, m21, m23);
//        pointer[15] = new Matrix3d(m00, m01, m02, m10, m11, m12, m20, m21, m22);
//    }
//
//    @Override
//    public Matrix3d submatrix(int r, int c) {
//        switch (r) {
//            case 0 :
//                switch (c) {
//                    case 0 : return new Matrix3d(m11, m12, m13, m21, m22, m23, m31, m32, m33);
//                    case 1 : return new Matrix3d(m10, m12, m13, m20, m22, m23, m30, m32, m33);
//                    case 2 : return new Matrix3d(m10, m11, m13, m20, m21, m23, m30, m31, m33);
//                    case 3 : return new Matrix3d(m10, m11, m12, m20, m21, m22, m30, m31, m32);
//                    default : throw new ArrayIndexOutOfBoundsException();
//                }
//            case 1 :
//                switch (c) {
//                    case 0 : return new Matrix3d(m01, m02, m03, m21, m22, m23, m31, m32, m33);
//                    case 1 : return new Matrix3d(m00, m02, m03, m20, m22, m23, m30, m32, m33);
//                    case 2 : return new Matrix3d(m00, m01, m03, m20, m21, m23, m30, m31, m33);
//                    case 3 : return new Matrix3d(m00, m01, m02, m20, m21, m22, m30, m31, m32);
//                    default : throw new ArrayIndexOutOfBoundsException();
//                }
//            case 2 :
//                switch (c) {
//                    case 0 : return new Matrix3d(m01, m02, m03, m11, m12, m13, m31, m32, m33);
//                    case 1 : return new Matrix3d(m00, m02, m03, m10, m12, m13, m30, m32, m33);
//                    case 2 : return new Matrix3d(m00, m01, m03, m10, m11, m13, m30, m31, m33);
//                    case 3 : return new Matrix3d(m00, m01, m02, m10, m11, m12, m30, m31, m32);
//                default : throw new ArrayIndexOutOfBoundsException();
//            }
//
//            case 3 :
//                switch (c) {
//                    case 0 : return new Matrix3d(m01, m02, m03, m11, m12, m13, m21, m22, m23);
//                    case 1 : return new Matrix3d(m00, m02, m03, m10, m12, m13, m20, m22, m23);
//                    case 2 : return new Matrix3d(m00, m01, m03, m10, m11, m13, m20, m21, m23);
//                    case 3 : return new Matrix3d(m00, m01, m02, m10, m11, m12, m20, m21, m22);
//                    default : throw new ArrayIndexOutOfBoundsException();
//                }
//            default : throw new ArrayIndexOutOfBoundsException();
//        }
//    }
//
//    @Override
//    public Matrix4d cofactor() {
//        Matrix3d[] ms = submatries();
//        return new Matrix4d(
//                ms[0].determinant() * m00,
//                -ms[4].determinant() * m10,
//                ms[8].determinant() * m20,
//                -ms[12].determinant() * m30,
//
//                -ms[1].determinant() * m01,
//                ms[5].determinant() * m11,
//                -ms[9].determinant() * m21,
//                ms[13].determinant() * m31,
//
//                ms[2].determinant() * m02,
//                -ms[6].determinant() * m12,
//                ms[10].determinant() * m22,
//                -ms[14].determinant() * m32,
//
//                -ms[3].determinant() * m03,
//                ms[7].determinant() * m13,
//                -ms[11].determinant() * m23,
//                ms[15].determinant() * m33
//        );
//    }

    @Override
    public final Matrix4d create() {
        return new Matrix4d();
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
    public final Double[] getRow(int index) {
        switch (index) {
            case 0 : return new Double[]{m00, m01, m02, m03};
            case 1 : return new Double[]{m10, m11, m12, m13};
            case 2 : return new Double[]{m20, m21, m22, m23};
            case 3 : return new Double[]{m30, m31, m32, m33};
            default : throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Final
    @Override
    public final Double[] getColumn(int index) {
        switch (index) {
            case 0 : return new Double[]{m00, m10, m20, m30};
            case 1 : return new Double[]{m01, m11, m21, m31};
            case 2 : return new Double[]{m02, m12, m22, m32};
            case 3 : return new Double[]{m03, m13, m23, m33};
            default : throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public final double[] toArray(double[] pointer) {
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
    public final void set(int r, int c, Double value) {
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

    public final void set(double m00, double m01, double m02, double m03,
                          double m10, double m11, double m12, double m13,
                          double m20, double m21, double m22, double m23,
                          double m30, double m31, double m32, double m33) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
    }

    @Override
    public final Double get(int r, int c) {
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
    public final Matrix4d invert() {
        final double det = determinant();
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
    public final Matrix4d invert(Matrix4d pointer) {
        set(pointer);
        pointer.set(this);
        return pointer.invert();
    }

    public final Matrix4d translate(double x, double y, double z) {
        m03 += x;
        m13 += y;
        m23 += z;
        return this;
    }

    public final Matrix4d translate(Vector4f transletes) {
        return translate(
                transletes.x,
                transletes.y,
                transletes.z);
    }

    public final Matrix4d translateX(double translete) {
        m03 += translete;
        return this;
    }

    public final Matrix4d translateY(double translete) {
        m13 += translete;
        return this;
    }

    public final Matrix4d translateZ(double translete) {
        m23 += translete;
        return this;
    }

    public final Matrix4d setTranslate(double x, double y, double z) {
        set(
                1, 0, 0, x,
                0, 1, 0, y,
                0, 0, 1, z,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setTranslate(Vector4f transletes) {
        return setTranslate(
                transletes.x,
                transletes.y,
                transletes.z);
    }

    public final Matrix4d setTranslateX(double translete) {
        return setTranslate(translete, 0, 0);
    }

    public final Matrix4d setTranslateY(double translete) {
        return setTranslate(0, translete, 0);
    }

    public final Matrix4d setTranslateZ(double translete) {
        return setTranslate(0, 0, translete);
    }

    public final Matrix4d setReverseTranslate(Vector4f transletes) {
        return setTranslate(
                - transletes.x,
                - transletes.y,
                - transletes.z);
    }

    public final Matrix4d rotateX90() {
        double tmp = m11;
        m11 = m12;
        m12 = -tmp;

        tmp = m21;
        m21 = m22;
        m22 = -tmp;
        return this;
    }

    public final Matrix4d rotateY90() {
        double tmp = m00;
        m00 = m02;
        m02 = -tmp;

        tmp = m20;
        m20 = m22;
        m22 = -tmp;
        return this;
    }

    public final Matrix4d rotateZ90() {
        double tmp = m00;
        m00 = m01;
        m01 = -tmp;

        tmp = m10;
        m10 = m11;
        m11 = -tmp;
        return this;
    }

    public final Matrix4d rotateX180() {
        m11 = -m11;
        m22 = -m22;
        return this;
    }

    public final Matrix4d rotateY180() {
        m00 = -m00;
        m22 = -m22;
        return this;
    }

    public final Matrix4d rotateZ180() {
        m00 = -m00;
        m11 = -m11;
        return this;
    }

    public final Matrix4d rotateX270() {
        double tmp = m11;
        m11 = -m12;
        m12 = tmp;

        tmp = m21;
        m21 = -m22;
        m22 = tmp;
        return this;
    }

    public final Matrix4d rotateY270() {
        double tmp = m00;
        m00 = -m02;
        m02 = tmp;

        tmp = m20;
        m20 = -m22;
        m22 = tmp;
        return this;
    }

    public final Matrix4d rotateZ270() {
        double tmp = m00;
        m00 = -m01;
        m01 = tmp;

        tmp = m10;
        m10 = -m11;
        m11 = tmp;
        return this;
    }

    public final Matrix4d rotate(final double radian, Vector4f axis) {
        if (axis.w != 0) throw new UnsupportedOperationException("axis element 'w' is not 0.");
        axis.nomalize();
        final double c = cos(radian);
        final double s = sin(radian);
        final double ver = 1 - c;
        final double sx = s * axis.x;
        final double sy = s * axis.y;
        final double sz = s * axis.z;

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

    public final Matrix4d rotateX(double x) {
        final double s = sin(x);
        final double c = cos(x);

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

    public final Matrix4d rotateY(double y) {
        final double s = sin(y);
        final double c = cos(y);

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

    public final Matrix4d rotateZ(double z) {
        final double s = sin(z);
        final double c = cos(z);

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

    public final Matrix4d setRotateX90() {
        set(
                1, 0, 0, 0,
                0, 0, -1, 0,
                0, 1, 0, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateY90() {
        set(
                0, 0, -1, 0,
                0, 1, 0, 0,
                1, 0, 0, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateZ90() {
        set(
                0, -1, 0, 0,
                1, 0, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateX180() {
        set(
                1, 0, 0, 0,
                0, -1, 0, 0,
                0, 0, -1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateY180() {
        set(
                -1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, -1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateZ180() {
        set(
                -1, 0, 0, 0,
                0, -1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateX270() {
        set(
                1, 0, 0, 0,
                0, 0, 1, 0,
                0, -1, 0, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateY270() {
        set(
                0, 0, 1, 0,
                0, 1, 0, 0,
                -1, 0, 0, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateZ270() {
        set(
                0, 1, 0, 0,
                -1, 0, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotate(final double radian, Vector4f axis) {
        if (axis.w != 0) throw new UnsupportedOperationException("axis element 'w' is not 0.");
        axis.nomalize();
        final double c = cos(radian);
        final double s = sin(radian);
        final double ver = 1 - c;
        final double sx = s * axis.x;
        final double sy = s * axis.y;
        final double sz = s * axis.z;

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

    public final Matrix4d setRotateX(double x) {
        final double s = sin(x);
        final double c = cos(x);

        set(
                1, 0, 0, 0,
                0, c, -s, 0,
                0, s, c, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateY(double y) {
        final double s = sin(y);
        final double c = cos(y);

        set(
                c, 0, -s, 0,
                0, 1, 0, 0,
                s, 0, c, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setRotateZ(double z) {
        final double s = sin(z);
        final double c = cos(z);

        set(
                c, -s, 0, 0,
                s, c, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d scale(double x, double y, double z) {
        m00 *= x;
        m11 *= y;
        m22 *= z;
        return this;
    }

    public final Matrix4d scale(Vector4f scales) {
        m00 *= scales.x;
        m11 *= scales.y;
        m22 *= scales.z;
        return this;
    }

    public final Matrix4d scale(double scale) {
        m00 *= scale;
        m11 *= scale;
        m22 *= scale;
        return this;
    }

    public final Matrix4d scaleX(double scale) {
        m00 *= scale;
        return this;
    }

    public final Matrix4d scaleY(double scale) {
        m11 *= scale;
        return this;
    }

    public final Matrix4d scaleZ(double scale) {
        m22 *= scale;
        return this;
    }

    public final Matrix4d setScale(double x, double y, double z) {
        set(
                x, 0, 0, 0,
                0, y, 0, 0,
                0, 0, z, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setScale(Vector4f scales) {
        return setScale(scales.x, scales.y, scales.z);
    }

    public final Matrix4d setScale(double s) {
        set(
                s, 0, 0, 0,
                0, s, 0, 0,
                0, 0, s, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setScaleX(double s) {
        set(
                s, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setScaleY(double s) {
        set(
                1, 0, 0, 0,
                0, s, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setScaleZ(double s) {
        set(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, s, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d shear(double x, double y, double z) {
        setXYZc(
                m00 + m01 * y + m02 * z,  m00 * x + m01 + m02 * z,  m00 * x + m01 * y + m02,
                m10 + m11 * y + m12 * z,  m10 * x + m11 + m12 * z,  m10 * x + m11 * y + m12,
                m20 + m21 * y + m22 * z,  m20 * x + m21 + m22 * z,  m20 * x + m21 * y + m22,
                m30 + m31 * y + m32 * z,  m30 * x + m31 + m32 * z,  m30 * x + m31 * y + m32
        );
        return this;
    }

    public final Matrix4d shear(Vector4f shears) {
        return shear(shears.x, shears.y, shears.z);
    }

    public final Matrix4d shearXY(double x, double y) {
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

    public final Matrix4d shearXZ(double x, double z) {
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

    public final Matrix4d shearYZ(double y, double z) {
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

    public final Matrix4d setShear(double x, double y, double z) {
        set(
                1, x, x, 0,
                y, 1, y, 0,
                z, z, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setShear(Vector4f shears) {
        return setShear(shears.x, shears.y, shears.z);
    }

    public final Matrix4d setShearXY(double x, double y) {
        set(
                1, x, 0, 0,
                y, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setShearXZ(double x, double z) {
        set(
                1, 0, x, 0,
                0, 1, 0, 0,
                z, 0, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Matrix4d setShearYZ(double y, double z) {
        set(
                1, 0, 0, 0,
                0, 1, y, 0,
                0, z, 1, 0,
                0, 0, 0, 1
        );
        return this;
    }

    public final Vector4d transformation(Vector4d vector) {
        vector.set(
                m00 * vector.x + m01 * vector.y + m02 * vector.z + m03 * vector.w,
                m10 * vector.x + m11 * vector.y + m12 * vector.z + m13 * vector.w,
                m20 * vector.x + m21 * vector.y + m22 * vector.z + m23 * vector.w,
                m30 * vector.x + m31 * vector.y + m32 * vector.z + m33 * vector.w
        );
        return vector;
    }

    public final Vector3d transformation(Vector3d vector) {
        vector.set(
                m00 * vector.x + m01 * vector.y + m02 * vector.z + m03,
                m10 * vector.x + m11 * vector.y + m12 * vector.z + m13,
                m20 * vector.x + m21 * vector.y + m22 * vector.z + m23
        );
        return vector;
    }

    protected final void setXYc(double m00, double m10, double m20, double m30,
                                double m01, double m11, double m21, double m31) {
        this.m00 = m00; this.m10 = m10; this.m20 = m20; this.m30 = m30;
        this.m01 = m01; this.m11 = m11; this.m21 = m21; this.m31 = m31;
    }

    protected final void setXZc(double m00, double m10, double m20, double m30,
                                double m02, double m12, double m22, double m32) {
        this.m00 = m00; this.m10 = m10; this.m20 = m20; this.m30 = m30;
        this.m02 = m02; this.m12 = m12; this.m22 = m22; this.m32 = m32;
    }

    protected final void setYZc(double m01, double m11, double m21, double m31,
                                double m02, double m12, double m22, double m32) {
        this.m01 = m01; this.m11 = m11; this.m21 = m21; this.m31 = m31;
        this.m02 = m02; this.m12 = m12; this.m22 = m22; this.m32 = m32;
    }

    protected final void set3(double m00, double m01, double m02,
                              double m10, double m11, double m12,
                              double m20, double m21, double m22) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
    }

    protected final void setXYZc(double m00, double m01, double m02,
                                 double m10, double m11, double m12,
                                 double m20, double m21, double m22,
                                 double m30, double m31, double m32) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
        this.m30 = m30; this.m31 = m31; this.m32 = m32;
    }
}
