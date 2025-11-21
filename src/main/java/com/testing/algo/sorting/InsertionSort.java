package com.testing.algo.sorting;

/**
 * Implementation of the Insertion Sort algorithm.
 * Insertion sort is a simple sorting algorithm that works similar to the way
 * you sort playing cards in your hands.
 * The array is virtually split into a sorted and an unsorted part.
 * Values from the unsorted part are picked and placed at the correct position
 * in the sorted part.
 */
public class InsertionSort {

    /**
     * Sorts an array of integers using Insertion Sort.
     *
     * @param arr The array to be sorted.
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are greater than key,
             * to one position ahead of their current position
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Sorts an array of integers in descending order using Insertion Sort.
     *
     * @param arr The array to be sorted.
     */
    public void sortDescending(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
