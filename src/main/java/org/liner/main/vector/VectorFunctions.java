package org.liner.main.vector;

public interface VectorFunctions<V extends Vector<?, ?>> {
    double distance(V value);
    double len();
    double angle(V value);
    double dot(V value);
    default double cross(V value) {
        return Double.NaN;
    }
}
