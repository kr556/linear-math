import org.liner.main.Array;
import org.liner.main.matrix.*;
import org.liner.main.vector.AbsVector;
import org.liner.main.vector.Vector4f;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.IntStream;

public class Test extends MatrixUtil{
    public static class TestMatrix extends Matrix4f{
        public TestMatrix(float m00, float m01, float m02, float m03,
                          float m10, float m11, float m12, float m13,
                          float m20, float m21, float m22, float m23,
                          float m30, float m31, float m32, float m33) {
            super(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
        }

        public Vector4f mul(Vector4f pointer) {
            pointer.set(
                    this.m11 * pointer.x + this.m12 * pointer.y + this.m13 * pointer.z + this.m14 * pointer.w,
                    this.m21 * pointer.x + this.m22 * pointer.y + this.m23 * pointer.z + this.m24 * pointer.w,
                    this.m31 * pointer.x + this.m32 * pointer.y + this.m33 * pointer.z + this.m34 * pointer.w,
                    this.m41 * pointer.x + this.m42 * pointer.y + this.m43 * pointer.z + this.m44 * pointer.w
            );
            return pointer;
        }
    }

    public static void main(String[] args) {
        var m = new TestMatrix(
                0, 2, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );

        Matrix4f m1 = null;

        var v = new Vector4f(
                1, 2, 3, 4
        );

        int len = 100;
        int tLen = 10_000;

//        int[] n = new int[]{0};
//        String from = "インスタンスメソッド, 静的メソッド & ジェネリクス, 静的メソッド & 型指定\n";
//        from += Arrays.toString(IntStream.range(0, len)
//                        .parallel()
//                        .mapToObj(i -> {
//                            synchronized (n) {
//                                System.out.println(n[0]++);
//                            }
//                            return (timeA(tLen, m, v) / 10E8) + "," + (timeB(tLen, m, v) / 10E8) + "," + (timeC(tLen, m, v) / 10E8) + "\n";
//                        })
//                        .toArray())
//                .replace("[", "")
//                .replace("]", "")
//                .replace(", ", "");
//
//        log(from, LocalDateTime.now().toString().replace(":", "") + "-el=" + len);
    }

    static long timeA(int len, Matrix4f m, Vector4f v) {
        long s = System.nanoTime();

        for (int i = 0; i < len; i++) {
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
        }

        long e = System.nanoTime();
        return e - s;
    }

    static <E extends Number, M extends AbsMatrix<E, M, M> & Array<E>, V extends AbsVector<E, V> & Array<E>> long timeB(int len, M m, V v) {
        long s = System.nanoTime();

        for (int i = 0; i < len; i++) {
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
            MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);MatrixUtil.transformation(m, v);
        }

        long e = System.nanoTime();
        return e - s;
    }

    static long timeC(int len, TestMatrix testMatrix, Vector4f v) {
        long s = System.nanoTime();

        for (int i = 0; i < len; i++) {
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
            testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);testMatrix.mul(v);
        }

        long e = System.nanoTime();
        return e - s;
    }

    public static void log(String s, String fileName) {
        try{
            File file = new File("./logs/" + fileName + ".csv");
            boolean b = file.createNewFile();
            if (b) {
                Files.writeString(file.toPath(), s, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
