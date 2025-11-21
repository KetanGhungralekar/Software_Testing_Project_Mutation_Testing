package com.testing.algo.graph;

import java.util.*;

/**
 * Implementation of Dijkstra's Algorithm.
 * Dijkstra's algorithm is an algorithm for finding the shortest paths between
 * nodes in a graph.
 * Note: This implementation assumes a weighted graph where weights are stored
 * separately or handled differently.
 * For simplicity in this project context, we will adapt the Graph class to
 * handle weights or use a separate structure.
 * Here, we'll create a WeightedGraph helper class inside or assume a simple
 * adjacency matrix/list with weights.
 * 
 * Actually, to keep it simple and compatible with our Graph class, we will
 * assume unweighted for now OR
 * we will create a specific WeightedGraph class for Dijkstra. Let's create a
 * WeightedGraph class here.
 */
public class Dijkstra {

    public static class WeightedGraph {
        private final Map<Integer, List<Node>> adjVertices = new HashMap<>();

        public void addVertex(int v) {
            adjVertices.putIfAbsent(v, new ArrayList<>());
        }

        public void addEdge(int source, int destination, int weight) {
            addVertex(source);
            addVertex(destination);
            adjVertices.get(source).add(new Node(destination, weight));
            // Assuming undirected for this example, or directed? Let's assume directed for
            // Dijkstra usually.
            // If undirected: adjVertices.get(destination).add(new Node(source, weight));
        }

        public List<Node> getAdjVertices(int v) {
            return adjVertices.get(v);
        }

        public Set<Integer> getAllVertices() {
            return adjVertices.keySet();
        }
    }

    public static class Node implements Comparable<Node> {
        int id;
        int weight;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    /**
     * Calculates the shortest path from source to all other nodes.
     *
     * @param graph  The weighted graph.
     * @param source The source vertex.
     * @return A map of vertex to shortest distance.
     */
    public Map<Integer, Integer> calculateShortestPath(WeightedGraph graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize distances
        for (int v : graph.getAllVertices()) {
            distances.put(v, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.id;

            if (visited.contains(u)) {
                continue;
            }
            visited.add(u);

            List<Node> neighbors = graph.getAdjVertices(u);
            if (neighbors != null) {
                for (Node neighbor : neighbors) {
                    int v = neighbor.id;
                    int weight = neighbor.weight;

                    if (!visited.contains(v)) {
                        int newDist = distances.get(u) + weight;
                        if (newDist < distances.get(v)) {
                            distances.put(v, newDist);
                            pq.add(new Node(v, newDist));
                        }
                    }
                }
            }
        }
        return distances;
    }
}
