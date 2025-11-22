package com.testing.algo.graph;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DFSTest {

    private Graph makeGraph(int... nodes) {
        Graph g = new Graph(false);
        for (int n : nodes) g.addVertex(n);
        return g;
    }

    @Test
    public void testIterativeDFS_NullGraph() {
        DFS dfs = new DFS();
        assertTrue(dfs.traverseIterative(null, 1).isEmpty());
    }

    @Test
    public void testIterativeDFS_StartMissing() {
        Graph g = makeGraph(1, 2);
        DFS dfs = new DFS();
        assertTrue(dfs.traverseIterative(g, 99).isEmpty());
    }

    @Test
    public void testIterativeDFS_NullAdjacencyList() {
        Graph g = makeGraph(1);

        TestUtil.setAdjListToNull(g, 1);

        DFS dfs = new DFS();
        assertEquals(List.of(1), dfs.traverseIterative(g, 1));
    }

    @Test
    public void testRecursiveDFS_NullGraph() {
        DFS dfs = new DFS();
        assertTrue(dfs.traverseRecursive(null, 1).isEmpty());
    }

    @Test
    public void testRecursiveDFS_StartMissing() {
        Graph g = makeGraph(1, 2);
        DFS dfs = new DFS();
        assertTrue(dfs.traverseRecursive(g, 99).isEmpty());
    }

    @Test
    public void testRecursiveDFS_NullAdjacencyList() {
        Graph g = makeGraph(1, 2);
        g.addEdge(1, 2);

        TestUtil.setAdjListToNull(g, 1);

        DFS dfs = new DFS();
        assertEquals(List.of(1), dfs.traverseRecursive(g, 1));
    }

    @Test
    public void testRecursiveDFS_DeepTraversal() {
        Graph g = makeGraph(1,2,3);
        g.addEdge(1,2);
        g.addEdge(2,3);

        DFS dfs = new DFS();
        assertEquals(List.of(1,2,3), dfs.traverseRecursive(g, 1));
    }
}
