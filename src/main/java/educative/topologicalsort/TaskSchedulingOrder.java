package educative.topologicalsort;


import java.util.*;

public class TaskSchedulingOrder {

    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if(tasks == 0)
            return new ArrayList<>();

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0)
                sources.offer(entry.getKey());
        }

        while(!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);

            graph.get(vertex).stream().forEach(child -> {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0)
                    sources.offer(child);
            });
        }

        if(sortedOrder.size() != tasks)
            return new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println(result);
    }
}
