package com.testing.algo.graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class GraphTest {

    private Graph makeGraph(int... nodes) {
        Graph g = new Graph(false);
        for (int n : nodes) g.addVertex(n);
        return g;
    }

    @Test
    public void testRemoveVertex_NotPresent() {
        Graph g = makeGraph(1,2,3);
        g.removeVertex(99);
        assertEquals(3, g.getVertexCount());
    }

    @Test
    public void testRemoveVertex_RemovesAllEdges() {
        Graph g = makeGraph(1,2,3);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.removeVertex(2);

        assertFalse(g.getAdjVertices(1).contains(2));
        assertFalse(g.getAdjVertices(3).contains(2));
    }

    @Test
    public void testRemoveEdge_HandlesNullLists() {
        Graph g = makeGraph(1,2);
        g.removeEdge(1,2);
        assertEquals(0, g.getEdgeCount());
    }

    @Test
    public void testRemoveEdge_UndirectedRemovesBothWays() {
        Graph g = new Graph(false);
        g.addEdge(1,2);
        g.removeEdge(1,2);

        assertFalse(g.getAdjVertices(1).contains(2));
        assertFalse(g.getAdjVertices(2).contains(1));
    }

    @Test
    public void testEdgeCount_UndirectedCorrectDivision() {
        Graph g = new Graph(false);
        g.addEdge(1,2);
        g.addEdge(2,3);

        assertEquals(2, g.getEdgeCount());
    }

    @Test
    public void testRemoveEdge_ConditionalPathsSurvived() {
        Graph g = new Graph(false);
        g.addVertex(1);
        g.addVertex(2);

        g.removeEdge(1,2);

        assertEquals(0, g.getEdgeCount());
    }
}
