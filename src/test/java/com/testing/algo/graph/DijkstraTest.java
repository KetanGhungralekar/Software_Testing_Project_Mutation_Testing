package com.testing.algo.graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class DijkstraTest {

    @Test
    public void testNodeCompareTo() {
        Dijkstra.Node a = new Dijkstra.Node(1, 5);
        Dijkstra.Node b = new Dijkstra.Node(2, 1);
        assertTrue(a.compareTo(b) > 0);
    }

    @Test
    public void testDijkstra_VisitedCheckMutation() {
        Dijkstra.WeightedGraph g = new Dijkstra.WeightedGraph();
        g.addEdge(1,2,1);
        g.addEdge(1,3,10);
        g.addEdge(2,3,1);

        Dijkstra d = new Dijkstra();
        Map<Integer, Integer> dist = d.calculateShortestPath(g, 1);

        assertEquals(0, dist.get(1));
        assertEquals(1, dist.get(2));
        assertEquals(2, dist.get(3));  // ensures visited condition isn't bypassed
    }

    @Test
    public void testDijkstra_NullAdjacencySafe() {
        Dijkstra.WeightedGraph g = new Dijkstra.WeightedGraph();
        g.addVertex(1);

        Dijkstra d = new Dijkstra();
        Map<Integer, Integer> dist = d.calculateShortestPath(g, 1);

        assertEquals(0, dist.get(1));
    }

    @Test
    public void testDijkstra_ComparisonBoundaryMutant() {
        Dijkstra.WeightedGraph g = new Dijkstra.WeightedGraph();
        g.addEdge(1,2,5);
        g.addEdge(1,3,1);

        Dijkstra d = new Dijkstra();
        Map<Integer, Integer> dist = d.calculateShortestPath(g, 1);

        assertEquals(1, dist.get(3));
        assertEquals(5, dist.get(2));
    }
}
