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
        Graph g = new Graph(false); 
        g.addEdge(29, 28);
        g.addEdge(28, 31);
        g.addEdge(31, 5);
        
        g.addEdge(46, 10);
        g.addEdge(46, 33);
        g.addEdge(33, 49);

        BFS bfs = new BFS();

        assertFalse(bfs.hasPath(g, 29, 46));
    }
}
