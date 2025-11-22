package com.testing.algo.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    BubbleSort bs = new BubbleSort();

    @Test
    public void testSort_BasicCase() {
        int[] arr = {5, 3, 1, 4, 2};
        bs.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSort_AlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        bs.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSort_ReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        bs.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSort_SingleElement() {
        int[] arr = {10};
        bs.sort(arr);
        assertArrayEquals(new int[]{10}, arr);
    }

    @Test
    public void testSort_NullArray() {
        bs.sort(null);
    }

    @Test
    public void testSort_WithDuplicates() {
        int[] arr = {3, 1, 2, 3, 1};
        bs.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }

    @Test
    public void testSort_AllEqual() {
        int[] arr = {4, 4, 4, 4};
        bs.sort(arr);
        assertArrayEquals(new int[]{4, 4, 4, 4}, arr);
    }

    @Test
    public void testSortDescending_BasicCase() {
        int[] arr = {1, 3, 5, 2, 4};
        bs.sortDescending(arr);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    public void testSortDescending_AlreadySorted() {
        int[] arr = {5, 4, 3, 2, 1};
        bs.sortDescending(arr);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    public void testSortDescending_ReverseSorted() {
        int[] arr = {1, 2, 3, 4, 5};
        bs.sortDescending(arr);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    public void testSortDescending_NullArray() {
        bs.sortDescending(null);
    }

    @Test
    public void testSortDescending_SingleElement() {
        int[] arr = {99};
        bs.sortDescending(arr);
        assertArrayEquals(new int[]{99}, arr);
    }

    @Test
    public void testSortDescending_WithDuplicates() {
        int[] arr = {3, 1, 3, 2, 2};
        bs.sortDescending(arr);
        assertArrayEquals(new int[]{3, 3, 2, 2, 1}, arr);
    }

    @Test
    public void testSortDescending_AllEqual() {
        int[] arr = {7, 7, 7};
        bs.sortDescending(arr);
        assertArrayEquals(new int[]{7, 7, 7}, arr);
    }
}
