package com.testing.algo.sorting;

import java.util.Arrays;

/**
 * Context class for Sorting Algorithms using the Strategy Pattern.
 * This allows switching between different sorting strategies at runtime.
 */
public class SortingContext {

    private SortingStrategy strategy;

    /**
     * Enum defining available sorting strategies.
     */
    public enum SortingStrategy {
        BUBBLE_SORT,
        SELECTION_SORT,
        INSERTION_SORT,
        MERGE_SORT,
        QUICK_SORT,
        HEAP_SORT
    }

    /**
     * Sets the sorting strategy.
     *
     * @param strategy The strategy to use.
     */
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sorts the array using the currently selected strategy.
     *
     * @param arr The array to sort.
     * @return The sorted array (copy).
     */
    public int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] copy = Arrays.copyOf(arr, arr.length);

        if (strategy == null) {
            throw new IllegalStateException("Sorting strategy not set");
        }

        switch (strategy) {
            case BUBBLE_SORT:
                new BubbleSort().sort(copy);
                break;
            case SELECTION_SORT:
                new SelectionSort().sort(copy);
                break;
            case INSERTION_SORT:
                new InsertionSort().sort(copy);
                break;
            case MERGE_SORT:
                new MergeSort().sort(copy);
                break;
            case QUICK_SORT:
                new QuickSort().sort(copy);
                break;
            case HEAP_SORT:
                new HeapSort().sort(copy);
                break;
            default:
                throw new IllegalArgumentException("Unknown strategy: " + strategy);
        }
        return copy;
    }
}
