package com.testing.algo.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    QuickSort qs = new QuickSort();

    @Test
    public void testSort_Basic() {
        int[] arr = {5, 3, 1, 4, 2};
        qs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_AlreadySorted() {
        int[] arr = {1,2,3,4,5};
        qs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_ReverseSorted() {
        int[] arr = {5,4,3,2,1};
        qs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_WithDuplicates() {
        int[] arr = {3,1,2,3,1};
        qs.sort(arr);
        assertArrayEquals(new int[]{1,1,2,3,3}, arr);
    }

    @Test
    public void testSort_AllSame() {
        int[] arr = {7,7,7,7};
        qs.sort(arr);
        assertArrayEquals(new int[]{7,7,7,7}, arr);
    }

    @Test
    public void testSort_PivotIsMinimum() {
        int[] arr = {1,5,4,3,2};
        qs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_PivotIsMaximum() {
        int[] arr = {5,4,3,2,1};
        qs.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSort_SingleElement() {
        int[] arr = {9};
        qs.sort(arr);
        assertArrayEquals(new int[]{9}, arr);
    }

    @Test
    public void testSort_Null() {
        qs.sort(null);
    }
}
