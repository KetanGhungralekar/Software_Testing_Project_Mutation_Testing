package com.testing.algo.graph;

import java.util.*;

/**
 * Implementation of Depth First Search (DFS) algorithm.
 * DFS is an algorithm for traversing or searching tree or graph data
 * structures.
 * The algorithm starts at the root node (selecting some arbitrary node as the
 * root node in the case of a graph)
 * and explores as far as possible along each branch before backtracking.
 */
public class DFS {

    /**
     * Performs DFS traversal starting from a given source vertex (Iterative).
     *
     * @param graph The graph to traverse.
     * @param start The starting vertex.
     * @return A list of vertices in the order they were visited.
     */
    public List<Integer> traverseIterative(Graph graph, int start) {
        List<Integer> visitedOrder = new ArrayList<>();
        if (graph == null || !graph.getAllVertices().contains(start)) {
            return visitedOrder;
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited.contains(v)) {
                visited.add(v);
                visitedOrder.add(v);

                List<Integer> neighbors = graph.getAdjVertices(v);
                if (neighbors != null) {
                    // Push neighbors in reverse order to visit them in natural order (optional but
                    // common)
                    for (int i = neighbors.size() - 1; i >= 0; i--) {
                        int neighbor = neighbors.get(i);
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }

        return visitedOrder;
    }

    /**
     * Performs DFS traversal starting from a given source vertex (Recursive).
     *
     * @param graph The graph to traverse.
     * @param start The starting vertex.
     * @return A list of vertices in the order they were visited.
     */
    public List<Integer> traverseRecursive(Graph graph, int start) {
        List<Integer> visitedOrder = new ArrayList<>();
        if (graph == null || !graph.getAllVertices().contains(start)) {
            return visitedOrder;
        }
        Set<Integer> visited = new HashSet<>();
        dfsRecursiveHelper(graph, start, visited, visitedOrder);
        return visitedOrder;
    }

    private void dfsRecursiveHelper(Graph graph, int v, Set<Integer> visited, List<Integer> visitedOrder) {
        visited.add(v);
        visitedOrder.add(v);

        List<Integer> neighbors = graph.getAdjVertices(v);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    dfsRecursiveHelper(graph, neighbor, visited, visitedOrder);
                }
            }
        }
    }
}
