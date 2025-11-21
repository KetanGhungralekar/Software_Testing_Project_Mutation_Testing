package com.testing.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of a Graph using Adjacency List.
 * This graph supports both directed and undirected edges.
 */
public class Graph {

    private Map<Integer, List<Integer>> adjVertices;
    private boolean directed;

    /**
     * Constructor for Graph.
     *
     * @param directed true if the graph is directed, false otherwise.
     */
    public Graph(boolean directed) {
        this.directed = directed;
        this.adjVertices = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param v The vertex to add.
     */
    public void addVertex(int v) {
        adjVertices.putIfAbsent(v, new ArrayList<>());
    }

    /**
     * Adds an edge between two vertices.
     *
     * @param source      The source vertex.
     * @param destination The destination vertex.
     */
    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjVertices.get(source).add(destination);
        if (!directed) {
            adjVertices.get(destination).add(source);
        }
    }

    /**
     * Removes a vertex from the graph.
     *
     * @param v The vertex to remove.
     */
    public void removeVertex(int v) {
        if (!adjVertices.containsKey(v)) {
            return;
        }
        adjVertices.values().forEach(e -> e.remove(Integer.valueOf(v)));
        adjVertices.remove(v);
    }

    /**
     * Removes an edge between two vertices.
     *
     * @param source      The source vertex.
     * @param destination The destination vertex.
     */
    public void removeEdge(int source, int destination) {
        List<Integer> eV1 = adjVertices.get(source);
        List<Integer> eV2 = adjVertices.get(destination);
        if (eV1 != null)
            eV1.remove(Integer.valueOf(destination));
        if (!directed && eV2 != null)
            eV2.remove(Integer.valueOf(source));
    }

    /**
     * Returns the adjacency list of a vertex.
     *
     * @param v The vertex.
     * @return The list of adjacent vertices.
     */
    public List<Integer> getAdjVertices(int v) {
        return adjVertices.get(v);
    }

    /**
     * Returns all vertices in the graph.
     *
     * @return A set of vertices.
     */
    public List<Integer> getAllVertices() {
        return new ArrayList<>(adjVertices.keySet());
    }

    /**
     * Returns the number of vertices in the graph.
     * 
     * @return the number of vertices.
     */
    public int getVertexCount() {
        return adjVertices.size();
    }

    /**
     * Returns the number of edges in the graph.
     * 
     * @return the number of edges.
     */
    public int getEdgeCount() {
        int count = 0;
        for (List<Integer> edges : adjVertices.values()) {
            count += edges.size();
        }
        if (!directed) {
            count /= 2;
        }
        return count;
    }
}
