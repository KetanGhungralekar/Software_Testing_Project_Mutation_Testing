package com.testing.algo.graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

class GraphTests {

    @Test
    void testGraph() {
        Graph g = new Graph(false);
        g.addEdge(0, 1);
        g.addEdge(1, 2);

        assertEquals(3, g.getVertexCount());
        assertEquals(2, g.getEdgeCount());

        g.removeEdge(0, 1);
        assertEquals(1, g.getEdgeCount());

        g.removeVertex(2);
        assertEquals(2, g.getVertexCount());
    }

    @Test
    void testBFS() {
        Graph g = new Graph(true);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        BFS bfs = new BFS();
        List<Integer> traversal = bfs.traverse(g, 2);
        // Expected: 2, 0, 3, 1 (order of neighbors depends on implementation, but
        // assuming insertion order)
        assertTrue(traversal.contains(2));
        assertTrue(traversal.contains(0));
        assertTrue(traversal.contains(3));
        assertTrue(traversal.contains(1));

        assertTrue(bfs.hasPath(g, 2, 1));
        assertFalse(bfs.hasPath(g, 3, 0)); // 3 only goes to 3
    }

    @Test
    void testDFS() {
        Graph g = new Graph(true);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        DFS dfs = new DFS();
        List<Integer> traversal = dfs.traverseIterative(g, 2);
        assertTrue(traversal.contains(2));
        assertTrue(traversal.contains(0));
        assertTrue(traversal.contains(3));
        assertTrue(traversal.contains(1));

        List<Integer> traversalRec = dfs.traverseRecursive(g, 2);
        assertTrue(traversalRec.contains(2));
    }

    @Test
    void testDijkstra() {
        Dijkstra dijkstra = new Dijkstra();
        Dijkstra.WeightedGraph g = new Dijkstra.WeightedGraph();
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(7, 8, 7);
        g.addEdge(7, 6, 1);

        Map<Integer, Integer> distances = dijkstra.calculateShortestPath(g, 0);
        assertEquals(0, distances.get(0));
        assertEquals(4, distances.get(1));
        assertEquals(12, distances.get(2)); // 0->1->2 (4+8=12)
        assertEquals(8, distances.get(7));
        assertEquals(9, distances.get(6)); // 0->7->6 (8+1=9)
    }
}
