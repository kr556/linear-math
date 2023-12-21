import org.linear.main.matrix.Matrix4f;
import org.linear.main.vector.Vector4f;
import org.linear.main.vector.Vector4i;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;
import static org.linear.main.matrix.MatrixUtil.diagonal4f;
import static org.linear.main.matrix.MatrixUtil.transformation;

public class test02 {
    public static boolean dark = true;
    public static int ovalR = 3;
    public static long frameTime = 15;
    public static int axisLen = 2;

    public static void main(String[] args) throws Exception {
        Matrix4f m = diagonal4f();
        Vector4f[] plys = donut(1, .4f, 64, 16);
//        Vector4f[] plys = cube(1);

        dark = true;

        plot(   plys,
                diagonal4f(),
                diagonal4f()
                        .rotate(0.04f, new Vector4f(1, 1, 1, 0))
        );
    }

    public static void plot(Vector4f[] vs, Matrix4f world, Matrix4f... ms) {
        final Thread[] timer = new Thread[1];
        Matrix4f ans = Matrix4f.DIAGONAL.copy();
        Matrix4f viewport = Matrix4f.DIAGONAL.copy();
        Vector4f[] ps = new Vector4f[vs.length];
        Vector4f[] axisXYZ = new Vector4f[]{ // model axis
                new Vector4f(-axisLen,  0,          0,          1), new Vector4f(axisLen,   0,          0,          1),
                new Vector4f(0,         -axisLen,   0,          1), new Vector4f(0,         axisLen,    0,          1),
                new Vector4f(0,         0,          -axisLen,   1), new Vector4f(0,         0,          axisLen,    1),
        };
        Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
        final int w = (int) (sc.width / 1.2);
        final int h = (int) (sc.height / 1.2);
        final int dw = w / 2;
        final int dh = h / 2;
        final int scale = (int) (w * 0.1);
        Vector4i[] ba = new Vector4i[]{ // world axis
                new Vector4i(-dw,   0,      0,      1).mul(new Vector4i(4, 4, 4, 1)),
                new Vector4i(dw,    0,      0,      1).mul(new Vector4i(4, 4, 4, 1)),
                new Vector4i(0,     -dh,    0,      1).mul(new Vector4i(4, 4, 4, 1)),
                new Vector4i(0,     dh,     0,      1).mul(new Vector4i(4, 4, 4, 1)),
                new Vector4i(0,     0,      -dh,    1).mul(new Vector4i(4, 4, 4, 1)),
                new Vector4i(0,     0,      dh,     1).mul(new Vector4i(4, 4, 4, 1)),
        };

        System.arraycopy(vs, 0, ps, 0, vs.length);

        for (Vector4f p: ps) {
            transformation(p, world);
        }

        for (Vector4f a: axisXYZ) {
            transformation(a, world);
        }

        for (Vector4i v: ba) {
            transformation(v, world);
        }

        for (Matrix4f m: ms) {
            ans.mulR(m);
        }

        class Plot extends JFrame {
            private GraphicsR g = new GraphicsR((Graphics2D) getGraphics());
            private Events events= new Events();

            public Plot() {
                setSize(w, h);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setTitle("test-plot");
                setVisible(true);
                setResizable(false);
                setBackground(Color.BLACK);
                addMouseListener(events);
            }

            @Override
            public void paint(Graphics _g) {
                if (frameTime != 0) {
                    timer[0] = new Thread(() -> {
                        try {
                            Thread.sleep(frameTime);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    timer[0].start();
                }
                super.paint(_g);
                g.setGraphics((Graphics2D) _g);

                if (dark) {
                    g.fillRect(-w, -h, w, h);
                }

                g.setColor(new Color(255, 175, 175));
                g.drawLine(ba[0].x, ba[0].y, ba[1].x, ba[1].y); // x axis
                g.setColor(new Color(175, 255, 175));
                g.drawLine(ba[2].x, ba[2].y, ba[3].x, ba[3].y); // y axis
                g.setColor(new Color(175, 175, 255));
                g.drawLine(ba[4].x, ba[4].y, ba[5].x, ba[5].y); // z axis

                for (int i = 0; i < 5; i++) {
                    g.drawLine(scale * i, 30, scale * i, -30);
                    g.drawLine(-30, scale * i, 30, scale * i);
                    g.drawLine(-scale * i, 30, -scale * i, -30);
                    g.drawLine(-30, -scale * i, 30, -scale * i);
                }

                g.setColor(Color.RED);

                //ポリゴンの変形
                for (Vector4f p: ps) {
                    p.set(transformation(ans, p));
                }

                //ポリゴンの変形と同じだけ軸を変形
                for (Vector4f a: axisXYZ) {
                    a.set(transformation(ans, a));
                }

                Vector4f _v0 = vs[0].copy();
                _v0.mul(scale);
                for (int i = 1; i < ps.length; i++) {
                    Vector4f _v = ps[i].copy();
                    _v.mul(scale);

                    {
                        var v = _v.copy();
                        var v0 = _v0.copy();
                        transformation(viewport, v0);
                        transformation(viewport, v);

                        double c = min(abs((dw + v0.z) / w), 1);
                        double cL = min(v0.z < 0 ? abs((dw + v0.z) / w) : 0, 1);
                        g.setColor(new Color((int) (255 * c), (int) (cL * 50), (int) (cL * 50)));
                        g.drawLine((int) (v0.x), (int) (v0.y), (int) (v.x), (int) (v.y));
                        if (ovalR  > 0) g.fillOval((int) (v0.x), (int) (v0.y), ovalR);
                        g.setColor(Color.RED);

                        // x -> red
                        // y -> green
                        // z -> blue
                        if (axisLen != 0) g.drawAxis(axisXYZ);
                    }
                    _v0 = _v;
                }

                if (!events.pressing) repaint();
                try {
                    if (frameTime != 0) timer[0].join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            private class GraphicsR  {
                private Graphics2D g;

                public GraphicsR(Graphics2D g) {
                    this.g = g;
                }

                public void setBackground(Color c) {
                    g.setBackground(c);
                }

                public void setColor(Color c) {
                    g.setColor(c);
                }

                public void fillRect(int x0, int y0, int x1, int y1) {
                    g.fillRect(x0 + dw, y0 + dh, x1 + dw, y1 + dh);
                }

                public void drawLine(int x0, int y0, int x1, int y1) {
                    g.drawLine(x0 + dw, y0 + dh, x1 + dw, y1 + dh);
                }

                public void fillOval(int x, int y, int r) {
                    g.fillOval(x - r + dw, y - r + dh, r * 2, r * 2);
                }

                public void setGraphics(Graphics2D g) {
                    this.g = g;
                }

                public void drawAxis(Vector4f[] xyzPos) {
                    Vector4f x0 = xyzPos[0].copy().mul(scale);
                    Vector4f x1 = xyzPos[1].copy().mul(scale);
                    Vector4f y0 = xyzPos[2].copy().mul(scale);
                    Vector4f y1 = xyzPos[3].copy().mul(scale);
                    Vector4f z0 = xyzPos[4].copy().mul(scale);
                    Vector4f z1 = xyzPos[5].copy().mul(scale);

                    g.setColor(Color.RED);
                    drawLine((int) x0.x, (int) x0.y, (int) x1.x, (int) x1.y);
                    g.setColor(Color.GREEN);
                    drawLine((int) y0.x, (int) y0.y, (int) y1.x, (int) y1.y);
                    g.setColor(Color.BLUE);
                    drawLine((int) z0.x, (int) z0.y, (int) z1.x, (int) z1.y);
                }
            }

            class Events implements MouseListener{
                transient boolean pressing = false;
                transient long frameTimeTmp = 0;

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON2) {
                        pressing = !pressing;
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        frameTimeTmp = frameTime;
                        frameTime *= 5;
                    } else if (e.getButton() == MouseEvent.BUTTON1) pressing = true;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    reset(e);
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    reset(e);
                }

                private void reset(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        frameTime = frameTimeTmp;
                    } else if (e.getButton() == MouseEvent.BUTTON1) pressing = false;
                    repaint();
                }
            }
        }

        new Plot();
    }

    public static double rad(double d) {
        return Math.toRadians(d);
    }

    public static Vector4f[] plygons(int...xyz) {
        Vector4f[] re = new Vector4f[xyz.length / 3];
        for (int i = 0; i < re.length; i++) {
            int g = i * 3;
            re[i] = new Vector4f(
                    xyz[g],
                    xyz[g + 1],
                    xyz[g + 2],
                    1
            );
        }

        return re;
    }

    public static Vector4f[] cube(final float d) {
        return new Vector4f[]{
                new Vector4f(-d, -d, -d, 1),
                new Vector4f(-d, -d, d, 1),
                new Vector4f(-d, d, d, 1),
                new Vector4f(-d, d, -d, 1),
                new Vector4f(-d, -d, -d, 1),
                new Vector4f(d, -d, -d, 1),
                new Vector4f(d, d, -d, 1),
                new Vector4f(-d, d, -d, 1),
                new Vector4f(d, d, -d, 1),
                new Vector4f(d, d, d, 1),
                new Vector4f(d, -d, d, 1),
                new Vector4f(d, -d, -d, 1),
                new Vector4f(d, d, -d, 1),
                new Vector4f(-d, d, -d, 1),
                new Vector4f(-d, -d, -d, 1),
                new Vector4f(-d, -d, d, 1),
                new Vector4f(d, -d, d, 1),
                new Vector4f(d, d, d, 1),
                new Vector4f(-d, d, d, 1)
        };
    }

    /**
     * @param r ドーナツの半径
     * @param th  ドーナツの円柱の半径
     * @param div ドーナツの分割数
     * @param sph 円柱の分割数
     * @return donut
     */
    public static Vector4f[] donut(float r, float th, int div, int sph) {
        Vector4f[] dPols = new Vector4f[sph * div];
        Matrix4f rMat = Matrix4f.DIAGONAL.copy();
        Matrix4f rdMat = Matrix4f.DIAGONAL.copy();
        Matrix4f tMat = Matrix4f.DIAGONAL.copy();
        final float sD = (float) (2 * PI / sph);
        final float dD = (float) (2 * PI / div);

        tMat.set(Matrix4f.DIAGONAL);
        tMat.translateX(r);
        for (int d = 0; d < div; d++) {
            rMat.set(Matrix4f.DIAGONAL);
            rdMat.rotateZ(dD);
            for (int s = 0; s < sph; s++) {
                Vector4f sl = new Vector4f(th, 0, 0, 1);
                transformation(rMat.rotateY(sD), sl);
                transformation(tMat, sl);
                transformation(rdMat, sl);

                dPols[d * sph + s] = sl;
            }
        }

        List<Vector4f> re = Arrays.stream(dPols)
                .distinct()
                .toList();
        return re.toArray(new Vector4f[0]);
    }
}
//
//class TestMat4f {
//    Matrix4f m4f;
//
//    public TestMat4f(Matrix4f scopy) {
//        m4f = scopy;
//    }
//
//    public void rotate_test(String method) throws ReflectiveOperationException {
//        Method r90Z = m4f.getClass().getDeclaredMethod("rotate" + method);
//        r90Z.setAccessible(true);
//        r90Z.invoke(m4f);
//    }
//
//    @Override
//    public String toString() {
//        return m4f.toString();
//    }
//}

