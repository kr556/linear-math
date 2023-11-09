package org.liner.main.matrix;

import org.liner.main.Arithmetic;
import org.liner.main.Array;
import org.liner.main.vector.*;

public class MatrixUtil {
    protected MatrixUtil() {}

    public static Vector2f transformation(Matrix2f matrix, Vector2f vector) {
        vector.set(
                matrix.m11 * vector.x + matrix.m12 * vector.y,
                matrix.m21 * vector.x + matrix.m22 * vector.y
        );
        return vector;
    }

    public static Vector2d transformation(Matrix2d matrix, Vector2d vector) {
        vector.set(
                matrix.m11 * vector.x + matrix.m12 * vector.y,
                matrix.m21 * vector.x + matrix.m22 * vector.y
        );
        return vector;
    }

    public static Vector2i transformation(Matrix4f matrix, Vector2i vector) {
        vector.set(
                (int)(matrix.m11 * vector.x + matrix.m12 * vector.y),
                (int)(matrix.m21 * vector.x + matrix.m22 * vector.y)
        );
        return vector;
    }

    public static Vector2l transformation(Matrix4d matrix, Vector2l vector) {
        vector.set(
                (long)(matrix.m11 * vector.x + matrix.m12 * vector.y),
                (long)(matrix.m21 * vector.x + matrix.m22 * vector.y)
        );
        return vector;
    }

    public static Vector3f transformation(Matrix3f matrix, Vector3f vector) {
        vector.set(
                matrix.m11 * vector.x + matrix.m12 * vector.y + matrix.m13 * vector.z,
                matrix.m21 * vector.x + matrix.m22 * vector.y + matrix.m23 * vector.z,
                matrix.m31 * vector.x + matrix.m32 * vector.y + matrix.m33 * vector.z
        );
        return vector;
    }

    public static Vector3d transformation(Matrix3d matrix, Vector3d vector) {
        vector.set(
                matrix.m11 * vector.x + matrix.m12 * vector.y + matrix.m13 * vector.z,
                matrix.m21 * vector.x + matrix.m22 * vector.y + matrix.m23 * vector.z,
                matrix.m31 * vector.x + matrix.m32 * vector.y + matrix.m33 * vector.z
        );
        return vector;
    }

    public static Vector3i transformation(Matrix4f matrix, Vector3i vector) {
        vector.set(
                (int)(matrix.m11 * vector.x + matrix.m12 * vector.y + matrix.m13 * vector.z),
                (int)(matrix.m21 * vector.x + matrix.m22 * vector.y + matrix.m23 * vector.z),
                (int)(matrix.m31 * vector.x + matrix.m32 * vector.y + matrix.m33 * vector.z)
        );
        return vector;
    }

    public static Vector3l transformation(Matrix4d matrix, Vector3l vector) {
        vector.set(
                (long)(matrix.m11 * vector.x + matrix.m12 * vector.y + matrix.m13 * vector.z),
                (long)(matrix.m21 * vector.x + matrix.m22 * vector.y + matrix.m23 * vector.z),
                (long)(matrix.m31 * vector.x + matrix.m32 * vector.y + matrix.m33 * vector.z)
        );
        return vector;
    }

    public static Vector4f transformation(Matrix4f matrix, Vector4f vector) {
        vector.set(
                matrix.m11 * vector.x + matrix.m12 * vector.y + matrix.m13 * vector.z + matrix.m14 * vector.w,
                matrix.m21 * vector.x + matrix.m22 * vector.y + matrix.m23 * vector.z + matrix.m24 * vector.w,
                matrix.m31 * vector.x + matrix.m32 * vector.y + matrix.m33 * vector.z + matrix.m34 * vector.w,
                matrix.m41 * vector.x + matrix.m42 * vector.y + matrix.m43 * vector.z + matrix.m44 * vector.w
        );
        return vector;
    }

    public static Vector4d transformation(Matrix4d matrix, Vector4d vector) {
        vector.set(
                matrix.m11 * vector.x + matrix.m12 * vector.y + matrix.m13 * vector.z + matrix.m14 * vector.w,
                matrix.m21 * vector.x + matrix.m22 * vector.y + matrix.m23 * vector.z + matrix.m24 * vector.w,
                matrix.m31 * vector.x + matrix.m32 * vector.y + matrix.m33 * vector.z + matrix.m34 * vector.w,
                matrix.m41 * vector.x + matrix.m42 * vector.y + matrix.m43 * vector.z + matrix.m44 * vector.w
        );
        return vector;
    }

    public static Vector4i transformation(Matrix4f matrix, Vector4i vector) {
        vector.set(
                (int)(matrix.m11 * vector.x + matrix.m12 * vector.y + matrix.m13 * vector.z + matrix.m14 * vector.w),
                (int)(matrix.m21 * vector.x + matrix.m22 * vector.y + matrix.m23 * vector.z + matrix.m24 * vector.w),
                (int)(matrix.m31 * vector.x + matrix.m32 * vector.y + matrix.m33 * vector.z + matrix.m34 * vector.w),
                (int)(matrix.m41 * vector.x + matrix.m42 * vector.y + matrix.m43 * vector.z + matrix.m44 * vector.w)
        );
        return vector;
    }

    public static Vector4l transformation(Matrix4d matrix, Vector4l vector) {
        vector.set(
                (long)(matrix.m11 * vector.x + matrix.m12 * vector.y + matrix.m13 * vector.z + matrix.m14 * vector.w),
                (long)(matrix.m21 * vector.x + matrix.m22 * vector.y + matrix.m23 * vector.z + matrix.m24 * vector.w),
                (long)(matrix.m31 * vector.x + matrix.m32 * vector.y + matrix.m33 * vector.z + matrix.m34 * vector.w),
                (long)(matrix.m41 * vector.x + matrix.m42 * vector.y + matrix.m43 * vector.z + matrix.m44 * vector.w)
        );
        return vector;
    }

    public static <E extends  Number,MAT extends AbsMatrix<E,MAT, MAT >  & Array<E>, VEC extends AbsVector<E, VEC>  & Array<E>> VEC transformation(MAT matrix, VEC vector) {
        if (matrix.columnsSize() == vector.dimensional()
                && matrix instanceof SquareMatrix<?,?>
                && matrix instanceof Arithmetic<?>) {
            MAT mTmp = ((Arithmetic<MAT>) matrix).copy();
            MAT mAns = ((Arithmetic<MAT>) matrix).copy();

            mTmp.map((r, c) -> vector.get(r));

            ((Arithmetic<MAT>) mAns).mul(mTmp);

            vector.map(i -> mAns.get(mAns.posToIndex(i, 0)));

            return vector;
        } else if (matrix instanceof Arithmetic<?>) {
            if (matrix instanceof SquareMatrix<?,?>) {
                throw new UnsupportedOperationException("this matrix is not square");
            }

            throw new ArrayIndexOutOfBoundsException();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public static <E extends  Number,MAT extends AbsMatrix<E,MAT, MAT>  & Array<E>, VEC extends AbsVector<E, VEC>  & Array<E>> VEC transformation(MAT matrix, VEC vector, VEC pointer) {
        if (matrix.columnsSize() == vector.dimensional()
                && matrix instanceof SquareMatrix<?,?>
                && matrix instanceof Arithmetic<?>) {
            MAT mTmp = ((Arithmetic<MAT>)matrix).copy();
            MAT mAns = ((Arithmetic<MAT>)matrix).copy();

            mTmp.map((r, c) -> vector.get(r));

            ((Arithmetic<MAT>)mAns).mul(mTmp);

            pointer.map(i -> mAns.get(mAns.posToIndex(i, 0)));

            return pointer;
        } else if (matrix instanceof Arithmetic<?>) {
            if (matrix instanceof SquareMatrix<?,?>) {
                throw new UnsupportedOperationException("this matrix is not square");
            }

            throw new ArrayIndexOutOfBoundsException();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
