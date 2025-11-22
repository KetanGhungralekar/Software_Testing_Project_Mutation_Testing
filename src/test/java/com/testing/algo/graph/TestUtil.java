package com.testing.algo.graph;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class TestUtil {

    @SuppressWarnings("unchecked")
    public static void setAdjListToNull(Graph g, int vertex) {
        try {
            Field f = Graph.class.getDeclaredField("adjVertices");
            f.setAccessible(true);

            Map<Integer, List<Integer>> map = (Map<Integer, List<Integer>>) f.get(g);
            map.put(vertex, null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
