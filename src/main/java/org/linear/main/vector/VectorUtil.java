package org.linear.main.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

public final class VectorUtil {
    private VectorUtil() {}

    public static Vector2f create2f(float len, double angle) {
        return new Vector2f(
                (float) (len * cos(angle)),
                (float) (len * sin(angle)));
    }

    public static Vector2d create2d(double len, double angle) {
        return new Vector2d(
                len * cos(angle),
                len * sin(angle));
    }

    public static Vector2i create2i(int len, double angle) {
        return new Vector2i(
                (int) (len * cos(angle)),
                (int) (len * sin(angle)));
    }

    public static Vector2l create2l(long len, double angle) {
        return new Vector2l(
                (long) (len * cos(angle)),
                (long) (len * sin(angle)));
    }

    @SafeVarargs
    public static <E extends Number, R extends Vector<E, R>> R join(R... values) {
        if (values.length == 0) return null;

        List<E> el = new ArrayList<>();

        for (R vec : values) {
            if (vec == null) continue;

            el.addAll(Arrays.asList(vec.toArray()));
        }

        if (values[0] instanceof FloatVector<?>) {
            return switch (el.size()) {
                case 1 -> (R) new VScalar<>(el.get(0));
                case 2 -> (R) new Vector2f((float) el.get(0), (float) el.get(1));
                case 3 -> (R) new Vector3f((float) el.get(0), (float) el.get(1), (float) el.get(2));
                case 4 -> (R) new Vector4f((float) el.get(0), (float) el.get(1), (float) el.get(2), (float) el.get(3));
                default -> {
                    Vectornf re = new Vectornf(el.size());
                    for (int i = 0; i < el.size(); i++) {
                        re.set(i, el.get(i).floatValue());
                    }
                    yield (R) re;
                }
            };
        } else if (values[0] instanceof DoubleVector<?>) {
            return switch (el.size()) {
                case 1 -> (R) new VScalar<>(el.get(0));
                case 2 -> (R) new Vector2d((double) el.get(0), (double) el.get(1));
                case 3 -> (R) new Vector3d((double) el.get(0), (double) el.get(1), (double) el.get(2));
                case 4 -> (R) new Vector4d((double) el.get(0), (double) el.get(1), (double) el.get(2), (double) el.get(3));
                default -> {
                    Vectornd re = new Vectornd(el.size());
                    for (int i = 0; i < el.size(); i++) {
                        re.set(i, el.get(i).doubleValue());
                    }
                    yield (R) re;
                }
            };
        } else if (values[0] instanceof IntVector<?>) {
            return switch (el.size()) {
                case 1 -> (R) new VScalar<>(el.get(0));
                case 2 -> (R) new Vector2i((int) el.get(0), (int) el.get(1));
                case 3 -> (R) new Vector3i((int) el.get(0), (int) el.get(1), (int) el.get(2));
                case 4 -> (R) new Vector4i((int) el.get(0), (int) el.get(1), (int) el.get(2), (int) el.get(3));
                default -> {
                    Vectorni re = new Vectorni(el.size());
                    for (int i = 0; i < el.size(); i++) {
                        re.set(i, el.get(i).intValue());
                    }
                    yield (R) re;
                }
            };
        } else if (values[0] instanceof LongVector<?>) {
            return switch (el.size()) {
                case 1 -> (R) new VScalar<>(el.get(0));
                case 2 -> (R) new Vector2l((long) el.get(0), (long) el.get(1));
                case 3 -> (R) new Vector3l((long) el.get(0), (long) el.get(1), (long) el.get(2));
                case 4 -> (R) new Vector4l((long) el.get(0), (long) el.get(1), (long) el.get(2), (long) el.get(3));
                default -> {
                    Vectornl re = new Vectornl(el.size());
                    for (int i = 0; i < el.size(); i++) {
                        re.set(i, el.get(i).longValue());
                    }
                    yield (R) re;
                }
            };
        } else {
            throw new IllegalStateException("Unexpected value: " + values[0].get(0));
        }
    }

    public static Vector2f vec2f(Object... values) {
        if (values.length == 0) return null;
        List<Float> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Float) {
                re.add((float) e);
            } else if (e instanceof FloatVector<?>) {
                re.addAll(List.of(((FloatVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Float' or 'FloatVector'.");
            }
        });

        return new Vector2f(re.get(0), re.get(1));
    }

    public static Vector2d vec2d(Object... values) {
        if (values.length == 0) return null;
        List<Double> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Double) {
                re.add((double) e);
            } else if (e instanceof DoubleVector<?>) {
                re.addAll(List.of(((DoubleVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Double' or 'DoubleVector'.");
            }
        });

        return new Vector2d(re.get(0), re.get(1));
    }

    public static Vector2i vec2i(Object... values) {
        if (values.length == 0) return null;
        List<Integer> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Integer) {
                re.add((int) e);
            } else if (e instanceof IntVector<?>) {
                re.addAll(List.of(((IntVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Integer' or 'IntVector'.");
            }
        });

        return new Vector2i(re.get(0), re.get(1));
    }

    public static Vector2l vec2l(Object... values) {
        if (values.length == 0) return null;
        List<Long> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Long) {
                re.add((long) e);
            } else if (e instanceof LongVector<?>) {
                re.addAll(List.of(((LongVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Long' or 'LongVector'.");
            }
        });

        return new Vector2l(re.get(0), re.get(1));
    }

    public static Vector3f vec3f(Object... values) {
        if (values.length == 0) return null;
        List<Float> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Float) {
                re.add((float) e);
            } else if (e instanceof FloatVector<?>) {
                re.addAll(List.of(((FloatVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Float' or 'FloatVector'.");
            }
        });

        return new Vector3f(re.get(0), re.get(1), re.get(2));
    }

    public static Vector3d vec3d(Object... values) {
        if (values.length == 0) return null;
        List<Double> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Double) {
                re.add((double) e);
            } else if (e instanceof DoubleVector<?>) {
                re.addAll(List.of(((DoubleVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Double' or 'DoubleVector'.");
            }
        });

        return new Vector3d(re.get(0), re.get(1), re.get(2));
    }

    public static Vector3i vec3i(Object... values) {
        if (values.length == 0) return null;
        List<Integer> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Integer) {
                re.add((int) e);
            } else if (e instanceof IntVector<?>) {
                re.addAll(List.of(((IntVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Integer' or 'IntVector'.");
            }
        });

        return new Vector3i(re.get(0), re.get(1), re.get(2));
    }

    public static Vector3l vec3l(Object... values) {
        if (values.length == 0) return null;
        List<Long> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Long) {
                re.add((long) e);
            } else if (e instanceof LongVector<?>) {
                re.addAll(List.of(((LongVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Long' or 'LongVector'.");
            }
        });

        return new Vector3l(re.get(0), re.get(1), re.get(2));
    }

    public static Vector4f vec4f(Object... values) {
        if (values.length == 0) return null;
        List<Float> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Float) {
                re.add((float) e);
            } else if (e instanceof FloatVector<?>) {
                re.addAll(List.of(((FloatVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Float' or 'FloatVector'.");
            }
        });

        return new Vector4f(re.get(0), re.get(1), re.get(2), re.get(3));
    }

    public static Vector4d vec4d(Object... values) {
        if (values.length == 0) return null;
        List<Double> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Double) {
                re.add((double) e);
            } else if (e instanceof DoubleVector<?>) {
                re.addAll(List.of(((DoubleVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Double' or 'DoubleVector'.");
            }
        });

        return new Vector4d(re.get(0), re.get(1), re.get(2), re.get(3));
    }

    public static Vector4i vec4i(Object... values) {
        if (values.length == 0) return null;
        List<Integer> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Integer) {
                re.add((int) e);
            } else if (e instanceof IntVector<?>) {
                re.addAll(List.of(((IntVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Integer' or 'IntVector'.");
            }
        });

        return new Vector4i(re.get(0), re.get(1), re.get(2), re.get(3));
    }

    public static Vector4l vec4l(Object... values) {
        if (values.length == 0) return null;
        List<Long> re = new ArrayList<>();

        Arrays.stream(values).forEach(e -> {
            if (e instanceof Long) {
                re.add((long) e);
            } else if (e instanceof LongVector<?>) {
                re.addAll(List.of(((LongVector<?>) e).toArray()));
            } else {
                throw new UnsupportedOperationException("Unsupported other than type 'Long' or 'LongVector'.");
            }
        });

        return new Vector4l(re.get(0), re.get(1), re.get(2), re.get(3));
    }

    public static boolean equalsDimensional(Vector<?, ?> v1, Vector<?, ?> v2) {
        return v1.dimension() == v2.dimension();
    }
}
