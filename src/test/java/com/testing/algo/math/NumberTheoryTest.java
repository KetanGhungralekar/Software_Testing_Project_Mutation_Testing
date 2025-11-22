package com.testing.algo.math;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class NumberTheoryTest {

    NumberTheory nt = new NumberTheory();

    @Test
    public void testIsPrimeSmall() {
        assertFalse(nt.isPrime(0));
        assertFalse(nt.isPrime(1));
        assertTrue(nt.isPrime(2));
        assertTrue(nt.isPrime(3));
    }

    @Test
    public void testIsPrimeCompositeSmall() {
        assertFalse(nt.isPrime(4));
        assertFalse(nt.isPrime(6));
        assertFalse(nt.isPrime(9));
    }

    @Test
    public void testIsPrimeLargePrime() {
        assertTrue(nt.isPrime(29));
    }

    @Test
    public void testIsPrimeLargeComposite() {
        assertFalse(nt.isPrime(49));
    }

    @Test
    public void testIsPrime6kCases() {
        assertFalse(nt.isPrime(25));
        assertFalse(nt.isPrime(35));
        assertTrue(nt.isPrime(31));
    }

    @Test
    public void testGCD() {
        assertEquals(6, nt.gcd(54,24));
        assertEquals(10, nt.gcd(10,0));
        assertEquals(1, nt.gcd(17,4));
    }

    @Test
    public void testLCM() {
        assertEquals(0, nt.lcm(0,5));
        assertEquals(0, nt.lcm(5,0));
        assertEquals(60, nt.lcm(12,15));
    }

    @Test
    public void testSieveBasic() {
        List<Integer> primes = nt.sieveOfEratosthenes(10);
        assertEquals(List.of(2,3,5,7), primes);
    }

    @Test
    public void testSieveBoundary() {
        List<Integer> primes = nt.sieveOfEratosthenes(2);
        assertEquals(List.of(2), primes);
    }

    @Test
    public void testFactorial() {
        assertEquals(1, nt.factorial(0));
        assertEquals(1, nt.factorial(1));
        assertEquals(120, nt.factorial(5));
    }

    @Test
    public void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> nt.factorial(-1));
    }
}
