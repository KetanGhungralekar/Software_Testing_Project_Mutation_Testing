package com.testing.algo.graph;

import java.util.*;

/**
 * Implementation of Breadth First Search (BFS) algorithm.
 * BFS is a traversing algorithm where you should start traversing from a
 * selected node (source or starting node)
 * and traverse the graph layerwise thus exploring the neighbour nodes (nodes
 * which are directly connected to source node).
 */
public class BFS {

    /**
     * Performs BFS traversal starting from a given source vertex.
     *
     * @param graph The graph to traverse.
     * @param start The starting vertex.
     * @return A list of vertices in the order they were visited.
     */
    public List<Integer> traverse(Graph graph, int start) {
        List<Integer> visitedOrder = new ArrayList<>();
        if (graph == null || !graph.getAllVertices().contains(start)) {
            return visitedOrder;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            visitedOrder.add(v);

            List<Integer> neighbors = graph.getAdjVertices(v);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return visitedOrder;
    }

    /**
     * Checks if a path exists between source and destination using BFS.
     * 
     * @param graph       The graph.
     * @param source      The source vertex.
     * @param destination The destination vertex.
     * @return true if a path exists, false otherwise.
     */
    public boolean hasPath(Graph graph, int source, int destination) {
        if (graph == null || !graph.getAllVertices().contains(source)
                || !graph.getAllVertices().contains(destination)) {
            return false;
        }

        if (source == destination) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == destination) {
                return true;
            }

            List<Integer> neighbors = graph.getAdjVertices(v);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return false;
    }
}
