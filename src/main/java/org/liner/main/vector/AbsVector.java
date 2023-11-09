package org.liner.main.vector;

import org.liner.main.Array;

public abstract non-sealed class AbsVector<E extends Number, V extends AbsVector<E, V>  & Array<E>> implements Vector<E, V> {
    @Override
    public String toString() {
        StringBuilder re = new StringBuilder("{");

        E[] es = toArray();
        for (int i = 0; i < es.length; i++) {
            re.append(es[i]);
            if (i != es.length - 1) re.append(", ");
        }

        return re + "}";
    }

    @Override
    public boolean isScalar() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof AbsVector<?,?>)) return false;
        return this.equals((V)obj);
    }
}
