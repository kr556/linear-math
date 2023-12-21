package org.linear.main.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix4fTest {

    @Test
    void testReduction() {

    }

    @Test
    void testCopy() {
        Matrix4f m = new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );

        assertEquals(m.add(1), m.copy());
    }

    @Test
    void testCopy1() {
    }

    @Test
    void testAbs() {
    }

    @Test
    void testAbs1() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void testAdd1() {
    }

    @Test
    void testAdd2() {
    }

    @Test
    void testAdd3() {
    }

    @Test
    void testSub() {
    }

    @Test
    void testSub1() {
    }

    @Test
    void testSub2() {
    }

    @Test
    void testSub3() {
    }

    @Test
    void testMul() {
    }

    @Test
    void testMul1() {
    }

    @Test
    void testMul2() {
    }

    @Test
    void testMul3() {
    }

    @Test
    void testDiv() {
    }

    @Test
    void testDiv1() {
    }

    @Test
    void testDiv2() {
    }

    @Test
    void testDiv3() {
    }

    @Test
    void testGet() {
    }

    @Test
    void testTranspose() {
    }

    @Test
    void testTranspose1() {
    }

    @Test
    void testRowsSize() {
    }

    @Test
    void testColumnsSize() {
    }

    @Test
    void testGetRow() {
    }

    @Test
    void testGetColumn() {
    }

    @Test
    void testSet() {
    }

    @Test
    void testSet1() {
    }

    @Test
    void testGet1() {
    }

    @Test
    void invert() {
    }

    @Test
    void testInvert() {
    }
}