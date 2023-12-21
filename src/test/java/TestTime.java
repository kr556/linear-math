import org.linear.main.matrix.Matrix4f;
import org.linear.main.matrix.MatrixUtil;
import org.linear.main.vector.Vector3f;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class TestTime extends MatrixUtil {
    public static void main(String[] args) throws InterruptedException {
        var m = new TestMatrix(
                0,  1,  2,  3,
                4,  5,  6,  7,
                8,  9,  10, 11,
                12, 13, 14, 15
        );

        Matrix4f m1 = null;

        var v = new Vector3f(
                1, 2, 3
        );

        int len = 200;
        int tLen = 1_000;

        int[] n = new int[]{0};
        String from = "a, b\n";

        Thread.sleep(1_000);
        from += Arrays.toString(IntStream.range(0, len)
                        .parallel()
                        .mapToObj(i -> {
                            synchronized (n) {
                                System.out.println(n[0]++);
                            }
                            return (timeA(tLen, m, v) / 10E8) + "," + (timeB(tLen, m, v) / 10E8) + "\n";
                        })
                        .toArray())
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "");

        log(from, LocalDateTime.now().toString().replace(":", "") + "-rotatez=" + len);
    }

    static long timeA(int len, TestMatrix m, Vector3f v) {
        long s = System.nanoTime();

        for (int i = 0; i < len; i++) {
            timeAMethods(m, v);
            timeAMethods(m, v);
            timeAMethods(m, v);
            timeAMethods(m, v);
            timeAMethods(m, v);
            timeAMethods(m, v);
        }

        long e = System.nanoTime();
        return e - s;
    }

    static long timeB(int len, TestMatrix m, Vector3f v) {
        long s = System.nanoTime();

        for (int i = 0; i < len; i++) {
            timeBMethods(m, v);
            timeBMethods(m, v);
            timeBMethods(m, v);
            timeBMethods(m, v);
            timeBMethods(m, v);
            timeBMethods(m, v);
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

    static void timeAMethods(TestMatrix m, Vector3f v) {
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
        m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1); m.a(1);
    }

    static void timeBMethods(TestMatrix m, Vector3f v) {
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
        m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1); m.b(1);
    }
}

class TestMatrix extends Matrix4f {
    public TestMatrix(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
        super(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
    }

    public Matrix4f a(double d) {
        final float s = (float) sin(d);
        final float c = (float) cos(d);

        m01 = m01 * c + m02 * s;
        m11 = m11 * c + m12 * s;
        m21 = m21 * c + m22 * s;
        m31 = m31 * c + m32 * s;

        m02 = m01 * -s + m02 * c;
        m12 = m11 * -s + m12 * c;
        m22 = m21 * -s + m22 * c;
        m32 = m31 * -s + m32 * c;
        return this;
    }

    public Matrix4f b(double d) {
        final float s = (float) sin(d);
        final float c = (float) cos(d);

        set(
                m00,
                m01 = m01 * c + m02 * s,
                m02 = m01 * -s + m02 * c,
                m03,

                m10,
                m11 = m11 * c + m12 * s,
                m12 = m11 * -s + m12 * c,
                m13,

                m20,
                m21 = m21 * c + m22 * s,
                m22 = m21 * -s + m22 * c,
                m23,

                m30,
                m31 = m31 * c + m32 * s,
                m32 = m31 * -s + m32 * c,
                m33
        );


        return this;
    }
}