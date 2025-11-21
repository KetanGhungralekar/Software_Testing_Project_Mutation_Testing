package com.testing.algo.sorting;

/**
 * Implementation of the Bubble Sort algorithm.
 * Bubble Sort is a simple sorting algorithm that repeatedly steps through the
 * list,
 * compares adjacent elements and swaps them if they are in the wrong order.
 * The pass through the list is repeated until the list is sorted.
 */
public class BubbleSort {

    /**
     * Sorts an array of integers using Bubble Sort.
     *
     * @param arr The array to be sorted.
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts an array of integers in descending order using Bubble Sort.
     *
     * @param arr The array to be sorted.
     */
    public void sortDescending(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
