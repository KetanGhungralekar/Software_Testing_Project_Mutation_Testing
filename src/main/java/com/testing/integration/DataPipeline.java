package com.testing.integration;

import com.testing.algo.sorting.SortingContext;
import com.testing.algo.searching.BinarySearch;
import com.testing.algo.math.NumberTheory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A data pipeline that processes data through various algorithms.
 * This serves as a component for integration testing.
 */
public class DataPipeline {

    private final SortingContext sortingContext;
    private final BinarySearch binarySearch;
    private final NumberTheory numberTheory;

    public DataPipeline() {
        this.sortingContext = new SortingContext();
        this.binarySearch = new BinarySearch();
        this.numberTheory = new NumberTheory();
    }

    /**
     * Processes an array of integers:
     * 1. Sorts the array using the specified strategy.
     * 2. Filters out non-prime numbers.
     * 3. Searches for a specific target in the filtered (and potentially re-sorted)
     * list.
     * 
     * @param data     The input data.
     * @param strategy The sorting strategy.
     * @param target   The target to search for.
     * @return The index of the target in the processed list, or -1.
     */
    public int processData(int[] data, SortingContext.SortingStrategy strategy, int target) {
        if (data == null) {
            return -1;
        }

        // Step 1: Sort
        sortingContext.setStrategy(strategy);
        int[] sortedData = sortingContext.sort(data);

        // Step 2: Filter Primes (Integration of Math and Sorting)
        // Note: Filtering breaks the sorted order if we just remove elements and keep
        // relative order?
        // Actually, if we remove elements from a sorted array, the remaining elements
        // are still sorted.
        List<Integer> primes = Arrays.stream(sortedData)
                .filter(numberTheory::isPrime)
                .boxed()
                .collect(Collectors.toList());

        int[] primeArray = primes.stream().mapToInt(i -> i).toArray();

        // Step 3: Search
        return binarySearch.search(primeArray, target);
    }

    /**
     * A complex operation that uses sorting and math.
     * Calculates the sum of the factorial of the top K largest elements.
     */
    public long sumFactorialOfTopK(int[] data, int k) {
        if (data == null || k <= 0) {
            return 0;
        }

        // Sort descending (using bubble sort descending or just sort and take from end)
        // Let's use our sorting context, which sorts ascending.
        sortingContext.setStrategy(SortingContext.SortingStrategy.QUICK_SORT);
        int[] sorted = sortingContext.sort(data);

        int n = sorted.length;
        long sum = 0;
        int count = 0;

        for (int i = n - 1; i >= 0 && count < k; i--) {
            int val = sorted[i];
            if (val >= 0 && val <= 20) { // Factorial grows fast, limit to 20
                sum += numberTheory.factorial(val);
                count++;
            }
        }
        return sum;
    }
}
