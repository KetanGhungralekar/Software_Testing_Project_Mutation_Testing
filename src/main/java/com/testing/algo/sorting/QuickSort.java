package com.testing.algo.sorting;

/**
 * Implementation of the Quick Sort algorithm.
 * QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and
 * partitions
 * the given array around the picked pivot.
 */
public class QuickSort {

    /**
     * Sorts an array of integers using Quick Sort.
     *
     * @param arr The array to be sorted.
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
