package com.testing.algo.graph;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BFSTest {

    private Graph g(boolean directed) {
        return new Graph(directed);
    }

    @Test
    public void testTraverse_ValidGraph() {
        Graph g = g(false);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        BFS bfs = new BFS();
        assertEquals(List.of(1, 2, 3), bfs.traverse(g, 1));
    }

    @Test
    public void testTraverse_WithNeighbors() {
        Graph g = g(false);
        g.addEdge(1, 2);
        BFS bfs = new BFS();
        assertTrue(bfs.traverse(g, 1).contains(2));
    }

    @Test
    public void testTraverse_MultipleNeighborsVisited() {
        Graph g = g(false);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        BFS bfs = new BFS();
        List<Integer> out = bfs.traverse(g, 1);
        assertEquals(4, out.size());
        assertTrue(out.contains(4));
    }

    @Test
    public void testTraverse_NullGraph() {
        BFS bfs = new BFS();
        assertTrue(bfs.traverse(null, 1).isEmpty());
    }

    @Test
    public void testTraverse_StartMissing() {
        Graph g = g(false);
        g.addVertex(1);
        BFS bfs = new BFS();
        assertTrue(bfs.traverse(g, 99).isEmpty());
    }

    @Test
    public void testTraverse_NullAdjacencyList() {
        Graph g = new Graph(true);
        g.addVertex(1);

        List<Integer> result = new BFS().traverse(g, 1);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0));
    }

    @Test
    public void testHasPath_ValidGraph() {
        Graph g = g(false);
        g.addEdge(1, 2);
        BFS bfs = new BFS();
        assertTrue(bfs.hasPath(g, 1, 2));
    }

    @Test
    public void testHasPath_WithValidDestination() {
        Graph g = g(false);
        g.addEdge(1, 2);
        BFS bfs = new BFS();
        assertTrue(bfs.hasPath(g, 1, 2));
    }

    @Test
    public void testHasPath_SourceEqualsDestination() {
        Graph g = g(false);
        g.addVertex(1);
        BFS bfs = new BFS();
        assertTrue(bfs.hasPath(g, 1, 1));
    }

    @Test
    public void testHasPath_NullGraph() {
        BFS bfs = new BFS();
        assertFalse(bfs.hasPath(null, 1, 2));
    }

    @Test
    public void testHasPath_InvalidSource() {
        Graph g = g(false);
        g.addVertex(1);
        BFS bfs = new BFS();
        assertFalse(bfs.hasPath(g, 99, 1));
    }

    @Test
    public void testHasPath_InvalidDestination() {
        Graph g = g(false);
        g.addVertex(1);
        BFS bfs = new BFS();
        assertFalse(bfs.hasPath(g, 1, 99));
    }

    @Test
    public void testHasPath_NullAdjacencyList() {
        Graph g = g(false);
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(1, 2);
        g.getAdjVertices(1).clear();
        BFS bfs = new BFS();
        assertFalse(bfs.hasPath(g, 1, 2));
    }

    @Test
    public void testHasPath_DoesNotRevisitNodes() {
        Graph g = g(false);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        BFS bfs = new BFS();
        assertTrue(bfs.hasPath(g, 1, 2));
    }

    @Test
    public void testHasPath_FailsWithoutVisitedMarking() {
        Graph g = new Graph(false); // undirected graph

        int[][] edges = {
                { 31, 5 }, { 10, 46 }, { 19, 31 }, { 5, 1 }, { 31, 28 }, { 28, 29 }, { 8, 26 }, { 13, 23 }, { 16, 34 },
                { 30, 1 },
                { 16, 18 }, { 33, 46 }, { 27, 35 }, { 2, 25 }, { 49, 33 }, { 44, 19 }, { 22, 26 }, { 30, 13 },
                { 27, 12 },
                { 8, 16 }, { 42, 13 }, { 18, 3 }, { 21, 20 }, { 2, 17 }, { 5, 48 }, { 41, 37 }, { 39, 37 }, { 2, 11 },
                { 20, 26 },
                { 19, 43 }, { 45, 7 }, { 0, 21 }, { 44, 23 }, { 2, 39 }, { 27, 36 }, { 41, 48 }, { 17, 42 }, { 40, 32 },
                { 2, 28 },
                { 35, 38 }, { 3, 9 }, { 41, 30 }, { 5, 11 }, { 24, 22 }, { 39, 5 }, { 40, 31 }, { 18, 35 }, { 23, 39 },
                { 20, 24 },
                { 45, 12 }
        };

        for (int[] e : edges)
            g.addEdge(e[0], e[1]);

        BFS bfs = new BFS();

        // In correct BFS, 0 and 49 are NOT connected
        assertFalse(bfs.hasPath(g, 29, 46));
    }

}
