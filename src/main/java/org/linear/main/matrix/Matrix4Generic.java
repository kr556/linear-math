//package org.linear.main.matrix;
//
//import org.linear.main.Array;
//import org.linear.main.ArrayGeneric;
//import org.linear.main.ArithmeticGeneric;
//
//// TODO: 2023/12/04
///*public*/ class Matrix4Generic<E extends Number & ArithmeticGeneric<E, ? extends ArithmeticGeneric<E, ?>>>
//        extends SquareMatrix<E, Matrix4Generic<E>>
//        implements Matrix<E, Matrix4Generic<E>, Matrix4Generic<E>>, ArithmeticGeneric<E, Matrix4Generic<E>>, ArrayGeneric<E> {
//    public E m00, m01, m02, m03,
//            m10, m11, m12, m13,
//            m20, m21, m22, m23,
//            m30, m31, m32, m33;
//
//    public Matrix4Generic(E m00, E m01, E m02, E m03,
//                          E m10, E m11, E m12, E m13,
//                          E m20, E m21, E m22, E m23,
//                          E m30, E m31, E m32, E m33) {
//        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
//        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
//        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
//        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
//    }
//
//    public Matrix4Generic(Matrix4Generic<E> copy) {
//        set(copy);
//    }
//
//    public Matrix4Generic() {}
//
//    @Override
//    public E get(int index) {
//        return switch (index) {
//            case 0  -> m00; case 1  -> m01; case 2  -> m02; case 3  -> m03;
//            case 4  -> m10; case 5  -> m11; case 6  -> m12; case 7  -> m13;
//            case 8  -> m20; case 9  -> m21; case 10 -> m22; case 11 -> m23;
//            case 12 -> m30; case 13 -> m31; case 14 -> m32; case 15 -> m33;
//            default -> throw new ArrayIndexOutOfBoundsException();
//        };
//    }
//
//    @Override
//    public boolean equals(Matrix4Generic<E> value) {
//        if (this == value) return true;
//        return this.m00.equals(value.m00) &&
//               this.m01.equals(value.m01) &&
//               this.m02.equals(value.m02) &&
//               this.m03.equals(value.m03) &&
//               this.m10.equals(value.m10) &&
//               this.m11.equals(value.m11) &&
//               this.m12.equals(value.m12) &&
//               this.m13.equals(value.m13) &&
//               this.m20.equals(value.m20) &&
//               this.m21.equals(value.m21) &&
//               this.m22.equals(value.m22) &&
//               this.m23.equals(value.m23) &&
//               this.m30.equals(value.m30) &&
//               this.m31.equals(value.m31) &&
//               this.m32.equals(value.m32) &&
//               this.m33.equals(value.m33);
//    }
//
//    @Override
//    public boolean isNaN() {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public void set(Matrix4Generic<E> copy) {
//        this.m00 = copy.m00; this.m01 = copy.m01; this.m02 = copy.m02; this.m03 = copy.m03;
//        this.m10 = copy.m10; this.m11 = copy.m11; this.m12 = copy.m12; this.m13 = copy.m13;
//        this.m20 = copy.m20; this.m21 = copy.m21; this.m22 = copy.m22; this.m23 = copy.m23;
//        this.m30 = copy.m30; this.m31 = copy.m31; this.m32 = copy.m32; this.m33 = copy.m33;
//    }
//
//    @Override
//    public Matrix4Generic<E> copy() {
//        return new Matrix4Generic<>(this);
//    }
//
//    @Override
//    public Matrix4Generic<E> add(Matrix4Generic<E> value) {
//        this.m00.add(value.m00); this.m01.add(value.m01); this.m02.add(value.m02); this.m03.add(value.m03);
//        this.m10.add(value.m10); this.m11.add(value.m11); this.m12.add(value.m12); this.m13.add(value.m13);
//        this.m20.add(value.m20); this.m21.add(value.m21); this.m22.add(value.m22); this.m23.add(value.m23);
//        this.m30.add(value.m30); this.m31.add(value.m31); this.m32.add(value.m32); this.m33.add(value.m33);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> add(Matrix4Generic<E> value, Matrix4Generic<E> pointer) {
//        pointer.m00.add(value.m00); pointer.m01.add(value.m01); pointer.m02.add(value.m02); pointer.m03.add(value.m03);
//        pointer.m10.add(value.m10); pointer.m11.add(value.m11); pointer.m12.add(value.m12); pointer.m13.add(value.m13);
//        pointer.m20.add(value.m20); pointer.m21.add(value.m21); pointer.m22.add(value.m22); pointer.m23.add(value.m23);
//        pointer.m30.add(value.m30); pointer.m31.add(value.m31); pointer.m32.add(value.m32); pointer.m33.add(value.m33);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> sub(Matrix4Generic<E> value) {
//        this.m00.sub(value.m00); this.m01.sub(value.m01); this.m02.sub(value.m02); this.m03.sub(value.m03);
//        this.m10.sub(value.m10); this.m11.sub(value.m11); this.m12.sub(value.m12); this.m13.sub(value.m13);
//        this.m20.sub(value.m20); this.m21.sub(value.m21); this.m22.sub(value.m22); this.m23.sub(value.m23);
//        this.m30.sub(value.m30); this.m31.sub(value.m31); this.m32.sub(value.m32); this.m33.sub(value.m33);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> sub(Matrix4Generic<E> value, Matrix4Generic<E> pointer) {
//        pointer.m00.sub(value.m00); pointer.m01.sub(value.m01); pointer.m02.sub(value.m02); pointer.m03.sub(value.m03);
//        pointer.m10.sub(value.m10); pointer.m11.sub(value.m11); pointer.m12.sub(value.m12); pointer.m13.sub(value.m13);
//        pointer.m20.sub(value.m20); pointer.m21.sub(value.m21); pointer.m22.sub(value.m22); pointer.m23.sub(value.m23);
//        pointer.m30.sub(value.m30); pointer.m31.sub(value.m31); pointer.m32.sub(value.m32); pointer.m33.sub(value.m33);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> mul(Matrix4Generic<E> value) {
//        this.m00.mul(value.m00); this.m01.mul(value.m01); this.m02.mul(value.m02); this.m03.mul(value.m03);
//        this.m10.mul(value.m10); this.m11.mul(value.m11); this.m12.mul(value.m12); this.m13.mul(value.m13);
//        this.m20.mul(value.m20); this.m21.mul(value.m21); this.m22.mul(value.m22); this.m23.mul(value.m23);
//        this.m30.mul(value.m30); this.m31.mul(value.m31); this.m32.mul(value.m32); this.m33.mul(value.m33);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> mul(Matrix4Generic<E> value, Matrix4Generic<E> pointer) {
//        pointer.m00.mul(value.m00); pointer.m01.mul(value.m01); pointer.m02.mul(value.m02); pointer.m03.mul(value.m03);
//        pointer.m10.mul(value.m10); pointer.m11.mul(value.m11); pointer.m12.mul(value.m12); pointer.m13.mul(value.m13);
//        pointer.m20.mul(value.m20); pointer.m21.mul(value.m21); pointer.m22.mul(value.m22); pointer.m23.mul(value.m23);
//        pointer.m30.mul(value.m30); pointer.m31.mul(value.m31); pointer.m32.mul(value.m32); pointer.m33.mul(value.m33);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> div(Matrix4Generic<E> value) {
//        this.m00.div(value.m00); this.m01.div(value.m01); this.m02.div(value.m02); this.m03.div(value.m03);
//        this.m10.div(value.m10); this.m11.div(value.m11); this.m12.div(value.m12); this.m13.div(value.m13);
//        this.m20.div(value.m20); this.m21.div(value.m21); this.m22.div(value.m22); this.m23.div(value.m23);
//        this.m30.div(value.m30); this.m31.div(value.m31); this.m32.div(value.m32); this.m33.div(value.m33);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> div(Matrix4Generic<E> value, Matrix4Generic<E> pointer) {
//        pointer.m00.div(value.m00); pointer.m01.div(value.m01); pointer.m02.div(value.m02); pointer.m03.div(value.m03);
//        pointer.m10.div(value.m10); pointer.m11.div(value.m11); pointer.m12.div(value.m12); pointer.m13.div(value.m13);
//        pointer.m20.div(value.m20); pointer.m21.div(value.m21); pointer.m22.div(value.m22); pointer.m23.div(value.m23);
//        pointer.m30.div(value.m30); pointer.m31.div(value.m31); pointer.m32.div(value.m32); pointer.m33.div(value.m33);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> abs() {
//        this.m00.abs(); this.m01.abs(); this.m02.abs(); this.m03.abs();
//        this.m10.abs(); this.m11.abs(); this.m12.abs(); this.m13.abs();
//        this.m20.abs(); this.m21.abs(); this.m22.abs(); this.m23.abs();
//        this.m30.abs(); this.m31.abs(); this.m32.abs(); this.m33.abs();
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> abs(Matrix4Generic<E> pointer) {
//        pointer.set(this);
//        return pointer.abs();
//    }
//
//    @Override
//    public Matrix4Generic<E> add(E value) {
//        this.m00.add(value); this.m01.add(value); this.m02.add(value); this.m03.add(value);
//        this.m10.add(value); this.m11.add(value); this.m12.add(value); this.m13.add(value);
//        this.m20.add(value); this.m21.add(value); this.m22.add(value); this.m23.add(value);
//        this.m30.add(value); this.m31.add(value); this.m32.add(value); this.m33.add(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> add(E value, Matrix4Generic<E> pointer) {
//        pointer.m00.add(value); pointer.m01.add(value); pointer.m02.add(value); pointer.m03.add(value);
//        pointer.m10.add(value); pointer.m11.add(value); pointer.m12.add(value); pointer.m13.add(value);
//        pointer.m20.add(value); pointer.m21.add(value); pointer.m22.add(value); pointer.m23.add(value);
//        pointer.m30.add(value); pointer.m31.add(value); pointer.m32.add(value); pointer.m33.add(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> sub(E value) {
//        this.m00.sub(value); this.m01.sub(value); this.m02.sub(value); this.m03.sub(value);
//        this.m10.sub(value); this.m11.sub(value); this.m12.sub(value); this.m13.sub(value);
//        this.m20.sub(value); this.m21.sub(value); this.m22.sub(value); this.m23.sub(value);
//        this.m30.sub(value); this.m31.sub(value); this.m32.sub(value); this.m33.sub(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> sub(E value, Matrix4Generic<E> pointer) {
//        pointer.m00.sub(value); pointer.m01.sub(value); pointer.m02.sub(value); pointer.m03.sub(value);
//        pointer.m10.sub(value); pointer.m11.sub(value); pointer.m12.sub(value); pointer.m13.sub(value);
//        pointer.m20.sub(value); pointer.m21.sub(value); pointer.m22.sub(value); pointer.m23.sub(value);
//        pointer.m30.sub(value); pointer.m31.sub(value); pointer.m32.sub(value); pointer.m33.sub(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> mul(double value) {
//        this.m00.mul(value); this.m01.mul(value); this.m02.mul(value); this.m03.mul(value);
//        this.m10.mul(value); this.m11.mul(value); this.m12.mul(value); this.m13.mul(value);
//        this.m20.mul(value); this.m21.mul(value); this.m22.mul(value); this.m23.mul(value);
//        this.m30.mul(value); this.m31.mul(value); this.m32.mul(value); this.m33.mul(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> mul(double value, Matrix4Generic<E> pointer) {
//        pointer.m00.mul(value); pointer.m01.mul(value); pointer.m02.mul(value); pointer.m03.mul(value);
//        pointer.m10.mul(value); pointer.m11.mul(value); pointer.m12.mul(value); pointer.m13.mul(value);
//        pointer.m20.mul(value); pointer.m21.mul(value); pointer.m22.mul(value); pointer.m23.mul(value);
//        pointer.m30.mul(value); pointer.m31.mul(value); pointer.m32.mul(value); pointer.m33.mul(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> mul(E value) {
//        this.m00.mul(value); this.m01.mul(value); this.m02.mul(value); this.m03.mul(value);
//        this.m10.mul(value); this.m11.mul(value); this.m12.mul(value); this.m13.mul(value);
//        this.m20.mul(value); this.m21.mul(value); this.m22.mul(value); this.m23.mul(value);
//        this.m30.mul(value); this.m31.mul(value); this.m32.mul(value); this.m33.mul(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> mul(E value, Matrix4Generic<E> pointer) {
//        return null;
//    }
//
//    @Override
//    public Matrix4Generic<E> div(double value) {
//        this.m00.div(value); this.m01.div(value); this.m02.div(value); this.m03.div(value);
//        this.m10.div(value); this.m11.div(value); this.m12.div(value); this.m13.div(value);
//        this.m20.div(value); this.m21.div(value); this.m22.div(value); this.m23.div(value);
//        this.m30.div(value); this.m31.div(value); this.m32.div(value); this.m33.div(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> div(double value, Matrix4Generic<E> pointer) {
//        pointer.m00.div(value); pointer.m01.div(value); pointer.m02.div(value); pointer.m03.div(value);
//        pointer.m10.div(value); pointer.m11.div(value); pointer.m12.div(value); pointer.m13.div(value);
//        pointer.m20.div(value); pointer.m21.div(value); pointer.m22.div(value); pointer.m23.div(value);
//        pointer.m30.div(value); pointer.m31.div(value); pointer.m32.div(value); pointer.m33.div(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> div(E value) {
//        this.m00.div(value); this.m01.div(value); this.m02.div(value); this.m03.div(value);
//        this.m10.div(value); this.m11.div(value); this.m12.div(value); this.m13.div(value);
//        this.m20.div(value); this.m21.div(value); this.m22.div(value); this.m23.div(value);
//        this.m30.div(value); this.m31.div(value); this.m32.div(value); this.m33.div(value);
//        return this;    }
//
//    @Override
//    public Matrix4Generic<E> div(E value, Matrix4Generic<E> pointer) {
//        pointer.m00.div(value); pointer.m01.div(value); pointer.m02.div(value); pointer.m03.div(value);
//        pointer.m10.div(value); pointer.m11.div(value); pointer.m12.div(value); pointer.m13.div(value);
//        pointer.m20.div(value); pointer.m21.div(value); pointer.m22.div(value); pointer.m23.div(value);
//        pointer.m30.div(value); pointer.m31.div(value); pointer.m32.div(value); pointer.m33.div(value);
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> create() {
//        return new Matrix4Generic<>();
//    }
//
//    @Override
//    public int columnDimension() {
//        return 4;
//    }
//
//    @Override
//    public int rowDimension() {
//        return 4;
//    }
//
//    @Override
//    public E[] getRow(int index) {
//        return switch (index) {
//            case 0 -> (E[]) new Object[]{m00, m01, m02, m03};
//            case 1 -> (E[]) new Object[]{m10, m11, m12, m13};
//            case 2 -> (E[]) new Object[]{m20, m21, m22, m23};
//            case 3 -> (E[]) new Object[]{m30, m31, m32, m33};
//            default -> throw new ArrayIndexOutOfBoundsException();
//        };
//    }
//
//    @Override
//    public E[] getColumn(int index) {
//        return switch (index) {
//            case 0 -> (E[]) new Object[]{m00, m10, m20, m30};
//            case 1 -> (E[]) new Object[]{m01, m11, m21, m31};
//            case 2 -> (E[]) new Object[]{m02, m12, m22, m32};
//            case 3 -> (E[]) new Object[]{m03, m13, m23, m33};
//            default -> throw new ArrayIndexOutOfBoundsException();
//        };
//    }
//
//    private void set(E m00, E m01, E m02, E m03,
//                     E m10, E m11, E m12, E m13,
//                     E m20, E m21, E m22, E m23,
//                     E m30, E m31, E m32, E m33) {
//        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
//        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
//        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
//        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
//    }
//
//    @Override
//    public void set(int r, int c, E value) {
//        switch (r) {
//            case 0 -> {
//                switch (c) {
//                    case 0 -> m00 = value;
//                    case 1 -> m01 = value;
//                    case 2 -> m02 = value;
//                    case 3 -> m03 = value;
//                    default -> throw new ArrayIndexOutOfBoundsException();
//                }
//            }
//            case 1 -> {
//                switch (c) {
//                    case 0 -> m10 = value;
//                    case 1 -> m11 = value;
//                    case 2 -> m12 = value;
//                    case 3 -> m13 = value;
//                    default -> throw new ArrayIndexOutOfBoundsException();
//                }
//            }
//            case 2 -> {
//                switch (c) {
//                    case 0 -> m20 = value;
//                    case 1 -> m21 = value;
//                    case 2 -> m22 = value;
//                    case 3 -> m23 = value;
//                    default -> throw new ArrayIndexOutOfBoundsException();
//                }
//            }
//            case 3 -> {
//                switch (c) {
//                    case 0 -> m30 = value;
//                    case 1 -> m31 = value;
//                    case 2 -> m32 = value;
//                    case 3 -> m33 = value;
//                    default -> throw new ArrayIndexOutOfBoundsException();
//                }
//            }
//            default -> throw new ArrayIndexOutOfBoundsException();
//        }
//    }
//
//    @Override
//    public Matrix4Generic<E> transpose() {
//        E tmp = m01;
//        m01 = m10;
//        m10 = tmp;
//
//        tmp = m02;
//        m02 = m20;
//        m20 = tmp;
//
//        tmp = m03;
//        m03 = m30;
//        m30 = tmp;
//
//        tmp = m12;
//        m12 = m21;
//        m21 = tmp;
//
//        tmp = m13;
//        m13 = m31;
//        m31 = tmp;
//
//        m23 = m32;
//        m32 = tmp;
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> transpose(Matrix4Generic<E> pointer) {
//        pointer.m00 = m00;
//        pointer.m01 = m10;
//        pointer.m02 = m20;
//        pointer.m03 = m30;
//        pointer.m10 = m01;
//        pointer.m11 = m11;
//        pointer.m12 = m21;
//        pointer.m13 = m31;
//        pointer.m20 = m02;
//        pointer.m21 = m12;
//        pointer.m22 = m22;
//        pointer.m23 = m32;
//        pointer.m30 = m03;
//        pointer.m31 = m13;
//        pointer.m32 = m23;
//        pointer.m33 = m33;
//        return this;
//    }
//
//    public Matrix4Generic<E> mulC(E m00, E m01, E m02, E m03,
//                         E m10, E m11, E m12, E m13,
//                         E m20, E m21, E m22, E m23,
//                         E m30, E m31, E m32, E m33) {
//        set(
//                (E) this.m00.copy().mul(m00).add(this.m01.mul(m10)).add(this.m02.mul(m20)).add(this.m03.mul(m30)),
//                (E) this.m00.copy().mul(m01).add(this.m01.mul(m11)).add(this.m02.mul(m21)).add(this.m03.mul(m31)),
//                (E) this.m00.copy().mul(m02).add(this.m01.mul(m12)).add(this.m02.mul(m22)).add(this.m03.mul(m32)),
//                (E) this.m00.copy().mul(m03).add(this.m01.mul(m13)).add(this.m02.mul(m23)).add(this.m03.mul(m33)),
//                (E) this.m10.copy().mul(m00).add(this.m11.mul(m10)).add(this.m12.mul(m20)).add(this.m13.mul(m30)),
//                (E) this.m10.copy().mul(m01).add(this.m11.mul(m11)).add(this.m12.mul(m21)).add(this.m13.mul(m31)),
//                (E) this.m10.copy().mul(m02).add(this.m11.mul(m12)).add(this.m12.mul(m22)).add(this.m13.mul(m32)),
//                (E) this.m10.copy().mul(m03).add(this.m11.mul(m13)).add(this.m12.mul(m23)).add(this.m13.mul(m33)),
//                (E) this.m20.copy().mul(m00).add(this.m21.mul(m10)).add(this.m22.mul(m20)).add(this.m23.mul(m30)),
//                (E) this.m20.copy().mul(m01).add(this.m21.mul(m11)).add(this.m22.mul(m21)).add(this.m23.mul(m31)),
//                (E) this.m20.copy().mul(m02).add(this.m21.mul(m12)).add(this.m22.mul(m22)).add(this.m23.mul(m32)),
//                (E) this.m20.copy().mul(m03).add(this.m21.mul(m13)).add(this.m22.mul(m23)).add(this.m23.mul(m33)),
//                (E) this.m30.copy().mul(m00).add(this.m31.mul(m10)).add(this.m32.mul(m20)).add(this.m33.mul(m30)),
//                (E) this.m30.copy().mul(m01).add(this.m31.mul(m11)).add(this.m32.mul(m21)).add(this.m33.mul(m31)),
//                (E) this.m30.copy().mul(m02).add(this.m31.mul(m12)).add(this.m32.mul(m22)).add(this.m33.mul(m32)),
//                (E) this.m30.copy().mul(m03).add(this.m31.mul(m13)).add(this.m32.mul(m23)).add(this.m33.mul(m33))
//        );
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> mulC(Matrix4Generic<E> value) {
//        return mulC(value.m00, value.m01, value.m02, value.m03,
//                value.m10, value.m11, value.m12, value.m13,
//                value.m20, value.m21, value.m22, value.m23,
//                value.m30, value.m31, value.m32, value.m33);
//    }
//
//    @Override
//    public Matrix4Generic<E> mulC(Matrix4Generic<E> value, Matrix4Generic<E> pointer) {
//        pointer.set(this);
//        return pointer.mulC(value);
//    }
//
//    public Matrix4Generic<E> mulR(E m00, E m01, E m02, E m03,
//                                  E m10, E m11, E m12, E m13,
//                                  E m20, E m21, E m22, E m23,
//                                  E m30, E m31, E m32, E m33) {
//        set(
//                (E) this.m00.copy().mul(m00).add(this.m10.mul(m10)).add(this.m20.mul(m20)).add(this.m30.mul(m30)),
//                (E) this.m00.copy().mul(m01).add(this.m10.mul(m11)).add(this.m20.mul(m21)).add(this.m30.mul(m31)),
//                (E) this.m00.copy().mul(m02).add(this.m10.mul(m12)).add(this.m20.mul(m22)).add(this.m30.mul(m32)),
//                (E) this.m00.copy().mul(m03).add(this.m10.mul(m13)).add(this.m20.mul(m23)).add(this.m30.mul(m33)),
//                (E) this.m01.copy().mul(m00).add(this.m11.mul(m10)).add(this.m21.mul(m20)).add(this.m31.mul(m30)),
//                (E) this.m01.copy().mul(m01).add(this.m11.mul(m11)).add(this.m21.mul(m21)).add(this.m31.mul(m31)),
//                (E) this.m01.copy().mul(m02).add(this.m11.mul(m12)).add(this.m21.mul(m22)).add(this.m31.mul(m32)),
//                (E) this.m01.copy().mul(m03).add(this.m11.mul(m13)).add(this.m21.mul(m23)).add(this.m31.mul(m33)),
//                (E) this.m02.copy().mul(m00).add(this.m12.mul(m10)).add(this.m22.mul(m20)).add(this.m32.mul(m30)),
//                (E) this.m02.copy().mul(m01).add(this.m12.mul(m11)).add(this.m22.mul(m21)).add(this.m32.mul(m31)),
//                (E) this.m02.copy().mul(m02).add(this.m12.mul(m12)).add(this.m22.mul(m22)).add(this.m32.mul(m32)),
//                (E) this.m02.copy().mul(m03).add(this.m12.mul(m13)).add(this.m22.mul(m23)).add(this.m32.mul(m33)),
//                (E) this.m03.copy().mul(m00).add(this.m13.mul(m10)).add(this.m23.mul(m20)).add(this.m33.mul(m30)),
//                (E) this.m03.copy().mul(m01).add(this.m13.mul(m11)).add(this.m23.mul(m21)).add(this.m33.mul(m31)),
//                (E) this.m03.copy().mul(m02).add(this.m13.mul(m12)).add(this.m23.mul(m22)).add(this.m33.mul(m32)),
//                (E) this.m03.copy().mul(m03).add(this.m13.mul(m13)).add(this.m23.mul(m23)).add(this.m33.mul(m33))
//        );
//        return this;
//    }
//
//    @Override
//    public Matrix4Generic<E> mulR(Matrix4Generic<E> value) {
//        return mulR(value.m00, value.m01, value.m02, value.m03,
//                value.m10, value.m11, value.m12, value.m13,
//                value.m20, value.m21, value.m22, value.m23,
//                value.m30, value.m31, value.m32, value.m33);
//    }
//
//    @Override
//    public Matrix4Generic<E> mulR(Matrix4Generic<E> value, Matrix4Generic<E> pointer) {
//        pointer.set(this);
//        return pointer.mulR(value);
//    }
//
//    @Override
//    public Matrix4Generic<E> invert() {
//        return null;
//    }
//
//    @Override
//    public Matrix4Generic<E> invert(Matrix4Generic<E> pointer) {
//        return null;
//    }
//
//    @Override
//    public E get(int r, int c) {
//        return null;
//    }
//}
