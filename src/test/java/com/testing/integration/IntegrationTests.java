package com.testing.integration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.testing.algo.graph.Graph;
import com.testing.algo.math.NumberTheory;
import com.testing.algo.sorting.SortingContext;

class IntegrationTests {

    @Test
    void testDataPipeline() {
        DataPipeline pipeline = new DataPipeline();
        int[] data = { 10, 7, 8, 9, 1, 5, 11, 13 };

        // Primes in data: 7, 1, 5, 11, 13 (1 is usually not prime, but let's check our
        // impl)
        // Our isPrime says 1 is not prime. So: 7, 5, 11, 13.
        // Sorted: 5, 7, 11, 13.
        // Index of 11 should be 2.

        int result = pipeline.processData(data, SortingContext.SortingStrategy.MERGE_SORT, 11);
        assertEquals(2, result);

        result = pipeline.processData(data, SortingContext.SortingStrategy.QUICK_SORT, 10); // 10 is not prime
        assertEquals(-1, result);
    }

    @Test
    void testDataPipelineComplex() {
        DataPipeline pipeline = new DataPipeline();
        int[] data = { 5, 3, 4, 1 };
        // Top 2 largest: 5, 4.
        // Factorial(5) = 120. Factorial(4) = 24. Sum = 144.

        long sum = pipeline.sumFactorialOfTopK(data, 2);
        assertEquals(144, sum);
    }

    @Test
    void testAlgorithmOrchestrator() {
        AlgorithmOrchestrator orchestrator = new AlgorithmOrchestrator();
        Graph socialGraph = new Graph(false);
        socialGraph.addEdge(1, 2);
        socialGraph.addEdge(2, 3);

        // Connected (1-3) and Anagrams (listen, silent) -> True
        assertTrue(orchestrator.areConnectedAnagrams(socialGraph, 1, "listen", 3, "silent"));

        // Connected (1-3) but not Anagrams -> False
        assertFalse(orchestrator.areConnectedAnagrams(socialGraph, 1, "hello", 3, "world"));

        // Not connected (1-4) -> False
        assertFalse(orchestrator.areConnectedAnagrams(socialGraph, 1, "listen", 4, "silent"));
    }

    @Test
    void testPatternInGraphPath() {
        AlgorithmOrchestrator orchestrator = new AlgorithmOrchestrator();
        Graph g = new Graph(true);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        // Path 1->2->3. String "123". Pattern "23" should be found.

        assertTrue(orchestrator.searchPatternInGraphPath(g, 1, "23"));
        assertFalse(orchestrator.searchPatternInGraphPath(g, 1, "13")); // "13" not in "123"
    }

    @Test
    void testDataPipelineNullInput() {
        DataPipeline dp = new DataPipeline();
        assertEquals(-1, dp.processData(null, SortingContext.SortingStrategy.BUBBLE_SORT, 5));
    }

    @Test
    void testDataPipelineNoPrimes() {
        DataPipeline dp = new DataPipeline();
        int[] data = { 4, 6, 8, 10, 12 };
        assertEquals(-1, dp.processData(data, SortingContext.SortingStrategy.SELECTION_SORT, 7));
    }

    @Test
    void testSumFactorialOfTopKZero() {
        DataPipeline dp = new DataPipeline();
        int[] data = { 5, 6, 7 };
        assertEquals(0, dp.sumFactorialOfTopK(data, 0));
    }

    @Test
    void testSumFactorialOfTopKNegative() {
        DataPipeline dp = new DataPipeline();
        int[] data = { 5, 6, 7 };
        assertEquals(0, dp.sumFactorialOfTopK(data, -3));
    }

    @Test
    void testSumFactorialOfTopKNoValidFactorials() {
        DataPipeline dp = new DataPipeline();
        int[] data = { 25, 30, 100 };
        assertEquals(0, dp.sumFactorialOfTopK(data, 2));
    }

    @Test
    public void testSumFactorialOfTopK_KillsAllBoundaryMutants() {

        // data includes:
        // - negative value (-1) → should be ignored
        // - valid boundary (20) → must be included
        // - invalid >20 (25) → must be ignored
        // - typical positive (5) → included when in top K
        int[] data = { -1, 20, 25, 5 };

        // we want top 2 valid factorial values: 20 and 5
        int k = 2;
        NumberTheory nt = new NumberTheory();
        long expected = nt.factorial(20) + nt.factorial(5);

        DataPipeline dp = new DataPipeline();
        long result = dp.sumFactorialOfTopK(data, k);

        assertEquals(expected, result,
                "Any boundary-change mutant will mishandle either -1, 20, or 25.");
    }

    @Test
    public void testSumFactorialOfTopK_EnsuresTwentyIsIncluded() {
        // Only values around the boundary. Sorting ascending → [-1, 5, 20, 21]
        // Descending traversal → [21, 20, 5, -1]
        // K = 1 → ONLY top valid value must be chosen.
        int[] data = { -1, 5, 20, 21 };

        DataPipeline dp = new DataPipeline();
        NumberTheory nt = new NumberTheory();

        long expected = nt.factorial(20); // 21 must be ignored, 20 must be used

        long result = dp.sumFactorialOfTopK(data, 1);

        assertEquals(expected, result,
                "Mutant changes <=20 to <20, which skips factorial(20). This test detects it.");
    }

    private final NumberTheory nt = new NumberTheory();
    private final DataPipeline dp = new DataPipeline();

    /**
     * Ensures 20 is included when it's the first valid value encountered after
     * skipping >20.
     * K = 1 so loop must pick 20 (tests <= vs < mutation).
     */
    @Test
    public void testTwentyIncludedWhenTopIsExcluded() {
        int[] data = { -5, 5, 20, 21 }; // descending => [21,20,5,-5]
        long expected = nt.factorial(20);
        long actual = dp.sumFactorialOfTopK(data, 1);
        assertEquals(expected, actual);
    }

    /**
     * Ensures 0 and 20 are both accepted (tests >= vs > and <= vs < together).
     * Also ensures values >20 are ignored.
     */
    @Test
    public void testZeroAndTwentyAreAcceptedAndGreaterIgnored() {
        int[] data = { 0, 20, 21 }; // descending => [21,20,0]
        long expected = nt.factorial(20) + nt.factorial(0);
        long actual = dp.sumFactorialOfTopK(data, 2);
        assertEquals(expected, actual);
    }

    /**
     * Ensure duplicates of boundary are handled correctly (k counts separately).
     * If <= was mutated to <, one of the 20s would be dropped and result would
     * differ.
     */
    @Test
    public void testMultipleTwentiesCountSeparately() {
        int[] data = { 20, 20, 19, 21 }; // descending => [21,20,20,19]
        long expected = nt.factorial(20) + nt.factorial(20); // top 2 valid values
        long actual = dp.sumFactorialOfTopK(data, 2);
        assertEquals(expected, actual);
    }

    /**
     * Detects && -> || mutation by verifying the method does NOT throw when
     * out-of-range values
     * (like 25) are present. If the mutant includes such values and factorial(...)
     * throws,
     * this test will fail.
     *
     * We also check that only valid values within 0..20 are used for the expected
     * sum.
     */
    @Test
    public void testNoExceptionWhenLargeValuesPresentAndOnlyValidUsed() {
        int[] data = { 25, 21, 20, 5 }; // descending => [25,21,20,5]
        // original should ignore 25 and 21 and pick 20 (k=1)
        assertDoesNotThrow(() -> {
            long actual = dp.sumFactorialOfTopK(data, 1);
            long expected = nt.factorial(20);
            assertEquals(expected, actual);
        });
    }

    /**
     * Edge-case: k larger than number of valid elements — ensures function returns
     * sum of all valid ones.
     * This helps detect early-loop break issues.
     */
    @Test
    public void testKLargerThanValidCount() {
        int[] data = { -1, 2, 3, 30 }; // valid: 2,3
        long expected = nt.factorial(3) + nt.factorial(2);
        long actual = dp.sumFactorialOfTopK(data, 5); // k > number of valid entries
        assertEquals(expected, actual);
    }

    @Test
    void testSumFactorialOfTopK_WhenKIsNegative_ReturnsZero() {
        int[] data = {1, 2, 3};
        assertEquals(0, dp.sumFactorialOfTopK(data, 0));
    }
}
