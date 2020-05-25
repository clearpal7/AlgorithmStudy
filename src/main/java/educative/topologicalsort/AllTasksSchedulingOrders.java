package educative.topologicalsort;

import java.util.*;

public class AllTasksSchedulingOrders {

    private static List<List<Integer>> result = new ArrayList<>();

    public static void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();

        if(tasks == 0)
            new ArrayList<>();

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for(int p[] : prerequisites) {
            int parent = p[0];
            int child = p[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = inDegree.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if(entry.getValue() == 0)
                sources.offer(entry.getKey());
        }

        printAllTopologicalSorts(graph, inDegree, sources, sortedOrder);

        System.out.println();

    }

    private static void printAllTopologicalSorts(Map<Integer, List<Integer>> graph,
                                                 Map<Integer, Integer> inDegree, Queue<Integer> sources, List<Integer> sortedOrder) {

        if(!sources.isEmpty()) {

            for(Integer source : sources) {
                sortedOrder.add(source);
                Queue<Integer> cloneQueue = clone(sources);

                cloneQueue.remove(source);
                List<Integer> children = graph.get(source);
                for(Integer child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if(inDegree.get(child) == 0)
                        cloneQueue.add(child);
                }

                printAllTopologicalSorts(graph, inDegree, cloneQueue, sortedOrder);
                sortedOrder.remove(source);
                for(Integer child : children) {
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }

        if(sortedOrder.size() == inDegree.size())
            System.out.println(sortedOrder);

    }

    private static Queue<Integer> clone(Queue<Integer> sources) {
        Queue<Integer> cloneQueue = new LinkedList<>();
        //sources.stream().forEach(entry -> cloneQueue.offer(entry));
        for(Integer source : sources) {
            cloneQueue.offer(source);
        }
        return cloneQueue;
    }


    public static void main(String[] args) {
       /* AllTasksSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        AllTasksSchedulingOrders.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();*/

        AllTasksSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        for(List<Integer> resultComponenet : result) {
            System.out.println(resultComponenet);
        }
        System.out.println();
    }
}
