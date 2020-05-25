package educative.topologicalsort;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if(vertices <= 0)
            return sortedOrder;

        Map<Integer, Integer> inComing = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        //init
        for(int i = 0; i < vertices; i++) {
            inComing.put(i, 0);
            graph.put(i,  new ArrayList<>());
        }

        for(int edge[] : edges) {
            int from = edge[0];
            int end = edge[1];
            graph.get(from).add(end);
            inComing.put(end, inComing.get(end) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inComing.entrySet()) {
            if(entry.getValue() == 0)
                sources.offer(entry.getKey());
        }

        while(!sources.isEmpty()) {
            Integer vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for(int child : children) {
                inComing.put(child, inComing.get(child) - 1);
                if(inComing.get(child) == 0)
                    sources.add(child);

            }
        }


        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
