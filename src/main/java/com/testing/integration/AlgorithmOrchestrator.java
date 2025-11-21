package com.testing.integration;

import com.testing.algo.graph.BFS;
import com.testing.algo.graph.DFS;
import com.testing.algo.graph.Graph;
import com.testing.algo.string.StringManipulator;
import com.testing.algo.string.PatternMatching;

import java.util.List;

/**
 * Orchestrates complex scenarios involving Graph and String algorithms.
 */
public class AlgorithmOrchestrator {

    private final BFS bfs;
    private final DFS dfs;
    private final StringManipulator stringManipulator;
    private final PatternMatching patternMatching;

    public AlgorithmOrchestrator() {
        this.bfs = new BFS();
        this.dfs = new DFS();
        this.stringManipulator = new StringManipulator();
        this.patternMatching = new PatternMatching();
    }

    /**
     * Analyzes a social network graph to find if two users are connected and if
     * their names are anagrams.
     * 
     * @param socialGraph The graph representing user connections.
     * @param userAId     ID of user A.
     * @param userAName   Name of user A.
     * @param userBId     ID of user B.
     * @param userBName   Name of user B.
     * @return true if connected AND names are anagrams.
     */
    public boolean areConnectedAnagrams(Graph socialGraph, int userAId, String userAName, int userBId,
            String userBName) {
        boolean areAnagrams = stringManipulator.isAnagram(userAName, userBName);
        if (!areAnagrams) {
            return false;
        }

        return bfs.hasPath(socialGraph, userAId, userBId);
    }

    /**
     * Traverses a graph and searches for a pattern in the string representation of
     * visited nodes.
     * (A bit contrived, but good for integration testing).
     * 
     * @param graph     The graph.
     * @param startNode The start node.
     * @param pattern   The pattern to search for in the path string.
     * @return true if pattern is found in the DFS traversal path string.
     */
    public boolean searchPatternInGraphPath(Graph graph, int startNode, String pattern) {
        List<Integer> path = dfs.traverseIterative(graph, startNode);
        StringBuilder pathStr = new StringBuilder();
        for (Integer node : path) {
            pathStr.append(node);
        }

        return patternMatching.searchKMP(pathStr.toString(), pattern) != -1;
    }
}
