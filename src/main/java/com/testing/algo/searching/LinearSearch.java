package com.testing.algo.searching;

/**
 * Implementation of Linear Search algorithm.
 * Linear search is a very simple search algorithm. In this type of search,
 * a sequential search is made over all items one by one.
 * Every item is checked and if a match is found then that particular item is
 * returned,
 * otherwise the search continues till the end of the data collection.
 */
public class LinearSearch {

    /**
     * Searches for a key in an array using Linear Search.
     *
     * @param arr The array to search in.
     * @param x   The key to search for.
     * @return The index of the key if found, otherwise -1.
     */
    public int search(int[] arr, int x) {
        if (arr == null) {
            return -1;
        }

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches for a key in an array using Linear Search starting from the end.
     *
     * @param arr The array to search in.
     * @param x   The key to search for.
     * @return The index of the key if found, otherwise -1.
     */
    public int searchFromEnd(int[] arr, int x) {
        if (arr == null) {
            return -1;
        }

        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
