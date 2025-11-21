package com.testing.algo.sorting;

/**
 * Implementation of the Selection Sort algorithm.
 * The selection sort algorithm sorts an array by repeatedly finding the minimum
 * element
 * (considering ascending order) from unsorted part and putting it at the
 * beginning.
 */
public class SelectionSort {

    /**
     * Sorts an array of integers using Selection Sort.
     *
     * @param arr The array to be sorted.
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Sorts an array of integers in descending order using Selection Sort.
     *
     * @param arr The array to be sorted.
     */
    public void sortDescending(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
