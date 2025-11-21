package com.testing.algo.searching;

/**
 * Implementation of Binary Search algorithm.
 * Binary Search is a fast search algorithm with run-time complexity of O(log
 * n).
 * This search algorithm works on the principle of divide and conquer.
 * For this algorithm to work properly, the data collection should be in the
 * sorted form.
 */
public class BinarySearch {

    /**
     * Searches for a key in a sorted array using Binary Search (Iterative).
     *
     * @param arr The sorted array to search in.
     * @param x   The key to search for.
     * @return The index of the key if found, otherwise -1.
     */
    public int search(int[] arr, int x) {
        if (arr == null) {
            return -1;
        }

        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

            // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was not present
        return -1;
    }

    /**
     * Searches for a key in a sorted array using Binary Search (Recursive).
     *
     * @param arr The sorted array to search in.
     * @param x   The key to search for.
     * @return The index of the key if found, otherwise -1.
     */
    public int searchRecursive(int[] arr, int x) {
        if (arr == null) {
            return -1;
        }
        return binarySearchRecursive(arr, 0, arr.length - 1, x);
    }

    private int binarySearchRecursive(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearchRecursive(arr, l, mid - 1, x);

            // Else the element can only be present in right subarray
            return binarySearchRecursive(arr, mid + 1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }
}
