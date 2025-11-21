package com.testing.algo.math;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class MathTests {

    @Test
    void testNumberTheory() {
        NumberTheory nt = new NumberTheory();

        assertTrue(nt.isPrime(7));
        assertFalse(nt.isPrime(10));

        assertEquals(6, nt.gcd(12, 18));
        assertEquals(36, nt.lcm(12, 18));

        List<Integer> primes = nt.sieveOfEratosthenes(10);
        assertTrue(primes.contains(2));
        assertTrue(primes.contains(3));
        assertTrue(primes.contains(5));
        assertTrue(primes.contains(7));
        assertFalse(primes.contains(9));

        assertEquals(120, nt.factorial(5));
    }

    @Test
    void testMatrixOperations() {
        MatrixOperations mo = new MatrixOperations();
        int[][] A = { { 1, 2 }, { 3, 4 } };
        int[][] B = { { 5, 6 }, { 7, 8 } };

        int[][] sum = mo.add(A, B);
        assertEquals(6, sum[0][0]);
        assertEquals(8, sum[0][1]);

        int[][] product = mo.multiply(A, B);
        // 1*5 + 2*7 = 19
        assertEquals(19, product[0][0]);

        int[][] transpose = mo.transpose(A);
        assertEquals(3, transpose[0][1]);
    }
}
