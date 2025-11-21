package com.testing.integration;

import com.testing.algo.graph.Graph;
import com.testing.algo.sorting.SortingContext;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
