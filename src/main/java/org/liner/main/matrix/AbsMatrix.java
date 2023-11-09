package org.liner.main.matrix;

import org.liner.main.Array;
import org.liner.main.vector.AbsVector;

public abstract non-sealed class AbsMatrix<E extends Number, V extends Matrix<E, V, TRNS> & Array<E>, TRNS extends Matrix<E, TRNS, V> & Array<E>>
        implements Matrix<E, V, TRNS>{
    int posToIndex(int r, int c) {
        return r * columnsSize() + c;
    }

    @Override
    public String toString() {
        StringBuilder re = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        String[] strL = new String[elementsSize()];
        int maxDigits = 0;
        E[] es = toArray();

        for (int r = 0; r < rowsSize(); r++) {
            for (int c = 0; c < columnsSize(); c++) {
                String s = String.valueOf(es[posToIndex(r, c)]);
                maxDigits = Math.max(s.length(), maxDigits);
                strL[posToIndex(r, c)] = s;
            }
        }

        for (int i = 0; i < strL.length; i++) {
            strL[i] = String.format("%" + maxDigits + "s", strL[i]);
        }

        for (int r = 0; r < rowsSize(); r++) {
            re.append('[');
            for (int c = 0; c < columnsSize(); c++) {
                re.append(strL[posToIndex(r, c)]);
                if (c != columnsSize() - 1) re.append(", ");
            }
            re.append("]\n");
        }

        return re.toString();
    }

    @Override
    public E[] toArray() {
        int esSize = elementsSize();
        Number[] el = new Number[esSize];


        for (int r = 0; r < rowsSize(); r++) {
            for (int c = 0; c < columnsSize(); c++) {
                el[posToIndex(r, c)] = get(posToIndex(r, c));
            }
        }

        return (E[]) el;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof AbsVector<?,?>)) return false;
        return this.equals((V)obj);
    }

    @Override
    public boolean isScalar() {
        return false;
    }
}
