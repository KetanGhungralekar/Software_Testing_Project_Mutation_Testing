package com.testing.algo.math;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixOperationsTest {

    MatrixOperations mo = new MatrixOperations();

    @Test
    public void testAddBasic() {
        int[][] A = {{1,2},{3,4}};
        int[][] B = {{5,6},{7,8}};
        int[][] C = mo.add(A,B);
        assertArrayEquals(new int[][]{{6,8},{10,12}}, C);
    }

    @Test
    public void testAddNegative() {
        int[][] A = {{-1,-2},{3,4}};
        int[][] B = {{1,2},{-3,-4}};
        int[][] C = mo.add(A,B);
        assertArrayEquals(new int[][]{{0,0},{0,0}}, C);
    }

    @Test
    public void testMultiplyBasic() {
        int[][] A = {{1,2},{3,4}};
        int[][] B = {{2,0},{1,2}};
        int[][] C = mo.multiply(A,B);
        assertArrayEquals(new int[][]{{4,4},{10,8}}, C);
    }

    @Test
    public void testMultiplyDimensionMismatch() {
        int[][] A = {{1,2,3}};
        int[][] B = {{1,2}};
        assertThrows(IllegalArgumentException.class, () -> mo.multiply(A,B));
    }

    @Test
    public void testMultiplySingle() {
        int[][] A = {{5}};
        int[][] B = {{7}};
        int[][] C = mo.multiply(A,B);
        assertArrayEquals(new int[][]{{35}}, C);
    }

    @Test
    public void testTransposeBasic() {
        int[][] A = {{1,2,3},{4,5,6}};
        int[][] C = mo.transpose(A);
        assertArrayEquals(new int[][]{{1,4},{2,5},{3,6}}, C);
    }

    @Test
    public void testTransposeSquare() {
        int[][] A = {{9,8},{7,6}};
        int[][] C = mo.transpose(A);
        assertArrayEquals(new int[][]{{9,7},{8,6}}, C);
    }
}
