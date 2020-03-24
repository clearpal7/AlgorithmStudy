package educative.topologicalsort;

import java.util.*;

public class TasksScheduling {

    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        if(tasks == 0)
            return false;

        List<Integer> sortedOrder = new ArrayList<>();


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
            if(entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }

        while(!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for(int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0)
                    sources.offer(child);
            }
        }

        return sortedOrder.size() == tasks;
    }

    public static void main(String[] args) {

        boolean result = isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
