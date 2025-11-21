package com.testing.algo.math;

/**
 * Implementation of Matrix Operations.
 */
public class MatrixOperations {

    /**
     * Adds two matrices.
     *
     * @param A First matrix.
     * @param B Second matrix.
     * @return The sum matrix.
     */
    public int[][] add(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] C = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    /**
     * Multiplies two matrices.
     *
     * @param A First matrix.
     * @param B Second matrix.
     * @return The product matrix.
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix dimensions mismatch for multiplication");
        }

        int[][] C = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    /**
     * Transposes a matrix.
     *
     * @param A The matrix to transpose.
     * @return The transposed matrix.
     */
    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] C = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[j][i] = A[i][j];
            }
        }
        return C;
    }
}
