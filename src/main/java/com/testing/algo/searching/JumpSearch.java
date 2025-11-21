package com.testing.algo.searching;

/**
 * Implementation of Jump Search algorithm.
 * Like Binary Search, Jump Search is a searching algorithm for sorted arrays.
 * The basic idea is to check fewer elements (than linear search) by jumping
 * ahead by fixed steps
 * or skipping some elements in place of searching all elements.
 */
public class JumpSearch {

    /**
     * Searches for a key in a sorted array using Jump Search.
     *
     * @param arr The sorted array to search in.
     * @param x   The key to search for.
     * @return The index of the key if found, otherwise -1.
     */
    public int search(int[] arr, int x) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int n = arr.length;

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));

        // Finding the block where element is present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < x) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block beginning with prev
        while (arr[prev] < x) {
            prev++;

            // If we reached next block or end of array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }

        // If element is found
        if (arr[prev] == x)
            return prev;

        return -1;
    }
}
