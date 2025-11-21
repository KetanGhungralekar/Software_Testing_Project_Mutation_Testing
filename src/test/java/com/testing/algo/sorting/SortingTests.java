package com.testing.algo.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class SortingTests {

    @Test
    void testBubbleSort() {
        BubbleSort sorter = new BubbleSort();
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        sorter.sort(arr);
        assertArrayEquals(new int[] { 11, 12, 22, 25, 34, 64, 90 }, arr);

        int[] empty = {};
        sorter.sort(empty);
        assertArrayEquals(new int[] {}, empty);

        int[] single = { 1 };
        sorter.sort(single);
        assertArrayEquals(new int[] { 1 }, single);
    }

    @Test
    void testSelectionSort() {
        SelectionSort sorter = new SelectionSort();
        int[] arr = { 64, 25, 12, 22, 11 };
        sorter.sort(arr);
        assertArrayEquals(new int[] { 11, 12, 22, 25, 64 }, arr);
    }

    @Test
    void testInsertionSort() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = { 12, 11, 13, 5, 6 };
        sorter.sort(arr);
        assertArrayEquals(new int[] { 5, 6, 11, 12, 13 }, arr);
    }

    @Test
    void testMergeSort() {
        MergeSort sorter = new MergeSort();
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        sorter.sort(arr);
        assertArrayEquals(new int[] { 5, 6, 7, 11, 12, 13 }, arr);
    }

    @Test
    void testQuickSort() {
        QuickSort sorter = new QuickSort();
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        sorter.sort(arr);
        assertArrayEquals(new int[] { 1, 5, 7, 8, 9, 10 }, arr);
    }

    @Test
    void testHeapSort() {
        HeapSort sorter = new HeapSort();
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        sorter.sort(arr);
        assertArrayEquals(new int[] { 5, 6, 7, 11, 12, 13 }, arr);
    }

    @Test
    void testSortingContext() {
        SortingContext context = new SortingContext();
        int[] arr = { 5, 2, 9, 1, 5, 6 };

        context.setStrategy(SortingContext.SortingStrategy.BUBBLE_SORT);
        int[] sorted = context.sort(arr);
        assertArrayEquals(new int[] { 1, 2, 5, 5, 6, 9 }, sorted);

        context.setStrategy(SortingContext.SortingStrategy.QUICK_SORT);
        sorted = context.sort(arr);
        assertArrayEquals(new int[] { 1, 2, 5, 5, 6, 9 }, sorted);
    }
}
