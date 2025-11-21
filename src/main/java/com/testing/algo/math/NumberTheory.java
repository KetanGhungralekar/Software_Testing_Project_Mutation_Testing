package com.testing.algo.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Number Theory algorithms.
 */
public class NumberTheory {

    /**
     * Checks if a number is prime.
     *
     * @param n The number to check.
     * @return true if prime, false otherwise.
     */
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) of two numbers.
     *
     * @param a First number.
     * @param b Second number.
     * @return The GCD.
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Calculates the Least Common Multiple (LCM) of two numbers.
     *
     * @param a First number.
     * @param b Second number.
     * @return The LCM.
     */
    public int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd(a, b);
    }

    /**
     * Generates prime numbers up to a limit using Sieve of Eratosthenes.
     *
     * @param limit The upper limit.
     * @return A list of prime numbers.
     */
    public List<Integer> sieveOfEratosthenes(int limit) {
        boolean[] prime = new boolean[limit + 1];
        for (int i = 0; i <= limit; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= limit; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    prime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    /**
     * Calculates the factorial of a number.
     * 
     * @param n The number.
     * @return The factorial.
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
