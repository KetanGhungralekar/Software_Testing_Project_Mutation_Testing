package com.testing.algo.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class SortingContextTest {

    SortingContext ctx = new SortingContext();

    private int[] arr() {
        return new int[]{5, 3, 1, 4, 2};
    }

    @Test
    public void testSort_NullArray() {
        ctx.setStrategy(SortingContext.SortingStrategy.BUBBLE_SORT);
        assertNull(ctx.sort(null));
    }

    @Test
    public void testSort_NoStrategySet_Throws() {
        assertThrows(IllegalStateException.class, () -> ctx.sort(arr()));
    }

    @Test
    public void testSort_BubbleSort() {
        ctx.setStrategy(SortingContext.SortingStrategy.BUBBLE_SORT);
        assertArrayEquals(new int[]{1,2,3,4,5}, ctx.sort(arr()));
    }

    @Test
    public void testSort_SelectionSort() {
        ctx.setStrategy(SortingContext.SortingStrategy.SELECTION_SORT);
        assertArrayEquals(new int[]{1,2,3,4,5}, ctx.sort(arr()));
    }

    @Test
    public void testSort_InsertionSort() {
        ctx.setStrategy(SortingContext.SortingStrategy.INSERTION_SORT);
        assertArrayEquals(new int[]{1,2,3,4,5}, ctx.sort(arr()));
    }

    @Test
    public void testSort_MergeSort() {
        ctx.setStrategy(SortingContext.SortingStrategy.MERGE_SORT);
        assertArrayEquals(new int[]{1,2,3,4,5}, ctx.sort(arr()));
    }

    @Test
    public void testSort_QuickSort() {
        ctx.setStrategy(SortingContext.SortingStrategy.QUICK_SORT);
        assertArrayEquals(new int[]{1,2,3,4,5}, ctx.sort(arr()));
    }

    @Test
    public void testSort_HeapSort() {
        ctx.setStrategy(SortingContext.SortingStrategy.HEAP_SORT);
        assertArrayEquals(new int[]{1,2,3,4,5}, ctx.sort(arr()));
    }
}
