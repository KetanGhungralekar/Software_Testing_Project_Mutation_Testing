package com.testing.algo.searching;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class JumpSearchTest {

    JumpSearch js = new JumpSearch();

    @Test
    public void testNullAndEmpty() {
        assertEquals(-1, js.search(null, 5));
        assertEquals(-1, js.search(new int[] {}, 5));
    }

    @Test
    public void testFoundBeginning() {
        assertEquals(0, js.search(new int[] { 1, 2, 3, 4, 5 }, 1));
    }

    @Test
public void testJumpSearch_KillsReturnZeroMutant() {
    JumpSearch js = new JumpSearch();

    // Step = sqrt(4) = 2, and linear scan will land EXACTLY on prev = 2
    int[] arr = {1, 2, 5, 6};

    // This forces execution of line 44
    int x = 4;

    int result = js.search(arr, x);

    // Real implementation must return -1
    assertEquals(-1, result);
}


    @Test
    public void testFoundMiddle() {
        assertEquals(2, js.search(new int[] { 1, 2, 3, 4, 5 }, 3));
    }

    @Test
    public void testFoundEnd() {
        assertEquals(4, js.search(new int[] { 1, 2, 3, 4, 5 }, 5));
    }

    @Test
    public void testNotFound() {
        assertEquals(-1, js.search(new int[] { 1, 2, 3, 4, 5 }, 99));
    }

    @Test
    public void testBlockJumpEdge() {
        assertEquals(3, js.search(new int[] { 1, 2, 3, 7, 9, 14 }, 7));
    }

    @Test
    public void testLinearSearchPhase() {
        assertEquals(1, js.search(new int[] { 1, 4, 7, 9, 12 }, 4));
    }

    @Test
    public void testEqualityBranchHits() {
        int[] arr = { 3 };
        assertEquals(0, js.search(arr, 3));
    }

    @Test
    public void testFinalReturnPath() {
        int[] arr = { 2, 4, 6, 8, 10 };
        assertEquals(-1, js.search(arr, 999));
    }

    @Test
    public void testSmallArrayExactStepHit() {
        int[] arr = { 1, 5 };
        assertEquals(1, js.search(arr, 5));
    }

    @Test
    void testJumpSearchEmptyArray() {
        assertEquals(-1, js.search(new int[] {}, 5));
    }

    @Test
    void testJumpSearchBlockBoundaryMiss() {
        int[] arr = { 1, 3, 5, 7, 9, 11 };
        assertEquals(-1, js.search(arr, 4));
    }

    @Test
    void testJumpSearchNotFoundInFinalReturn() {
        int[] arr = { 2, 4, 6, 8, 10 };
        assertEquals(-1, js.search(arr, 1));
    }

    @Test
    void testJumpSearchHitsBlockBoundaryReturn() {
        JumpSearch js = new JumpSearch();
        int[] arr = { 1, 2, 50, 60, 80 };
        assertEquals(-1, js.search(arr, 90));
    }
}
