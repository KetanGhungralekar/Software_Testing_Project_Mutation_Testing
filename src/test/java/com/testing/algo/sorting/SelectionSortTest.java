package com.testing.algo.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    SelectionSort ss = new SelectionSort();

    @Test
    public void testSort_Basic() {
        int[] arr = {5, 3, 1, 4, 2};
        ss.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSort_AlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        ss.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSort_ReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        ss.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSort_SingleElement() {
        int[] arr = {10};
        ss.sort(arr);
        assertArrayEquals(new int[]{10}, arr);
    }

    @Test
    public void testSort_Null() {
        ss.sort(null);
    }

    @Test
    public void testSort_Duplicates() {
        int[] arr = {3, 1, 3, 2, 1};
        ss.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }

    @Test
    public void testSort_AllEqual() {
        int[] arr = {7, 7, 7};
        ss.sort(arr);
        assertArrayEquals(new int[]{7, 7, 7}, arr);
    }

    @Test
    public void testSortDescending_Basic() {
        int[] arr = {1, 3, 5, 2, 4};
        ss.sortDescending(arr);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    public void testSortDescending_AlreadySorted() {
        int[] arr = {5, 4, 3, 2, 1};
        ss.sortDescending(arr);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    public void testSortDescending_ReverseSorted() {
        int[] arr = {1, 2, 3, 4, 5};
        ss.sortDescending(arr);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    public void testSortDescending_SingleElement() {
        int[] arr = {9};
        ss.sortDescending(arr);
        assertArrayEquals(new int[]{9}, arr);
    }

    @Test
    public void testSortDescending_Null() {
        ss.sortDescending(null);
    }

    @Test
    public void testSortDescending_Duplicates() {
        int[] arr = {3, 1, 3, 2, 2};
        ss.sortDescending(arr);
        assertArrayEquals(new int[]{3, 3, 2, 2, 1}, arr);
    }

    @Test
    public void testSortDescending_AllEqual() {
        int[] arr = {5, 5, 5};
        ss.sortDescending(arr);
        assertArrayEquals(new int[]{5, 5, 5}, arr);
    }
}
