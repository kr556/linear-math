package org.linear.main.matrix;

import org.linear.main.vector.Vector;
import org.linear.main.ArrayDouble;

public interface Transfromd<M extends Transfromd<M, V> & Matrix<Double, M, M> & ArrayDouble, V extends Vector<Double, V> & ArrayDouble> {
    M translate(double x, double y, double z);

    M translate(V transletes);

    M translateX(double translete);

    M translateY(double translete);

    M translateZ(double translete);

    M reverseTranslate(V translete);

    M rotate(double x, double y, double z);

    M rotate(double x, double y, double z, V anchor);

    M rotate(double radian,  V anchor);

    M rotateX(double radian);

    M rotateY(double radian);

    M rotateZ(double radian);

    M scale(double x, double y, double z);

    M scale(double x, double y, double z, V anchor);

    M scale(V values);

    M scale(V scale, V anchor);

    M scale(double scale);

    M scale(double scale, V anchor);

    M scaleX(double scale);

    M scaleY(double scale);

    M scaleZ(double scale);

    M shear(double x, double y, double z);

    M shear(double x, double y, double z, V anchor);

    M shear(V shears);

    M shear(V shears, V anchor);

    M shearX(double shear);

    M shearY(double shear);

    M shearZ(double shear);

    V transform(V vector);
}
