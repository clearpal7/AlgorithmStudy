package hackerrank;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DijkstraShortestReach2 {

    public static void main(String[] args) {
        int n = 4;
        int[][] edge = {
                {1,2,24},
                {1,4,20},
                {3,1,3},
                {4,3,12}
        };
        int start = 1;
        int[] answer = shortestReach(n, edge, start);

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    static int[] shortestReach(int n, int[][] edges, int s) {
        int start = s;
        int nodesCount = n;

        boolean visited[] = new boolean[nodesCount + 1];
        visited[0] = true;
        visited[start] = true;

        int[] distance = new int[nodesCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Element(start, distance[start]));

        Map<Integer, Map<Integer, Integer>> nodesMap = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            nodesMap.put(i, new HashMap<>());
        }

        for(int line = 0 ; line < edges.length; line++) {
            int from = edges[line][0];
            int to = edges[line][1];
            int weight = edges[line][2];

            nodesMap.computeIfAbsent(from, k -> new HashMap<>()).put(to, weight);
            nodesMap.computeIfAbsent(to, k -> new HashMap<>()).put(from, weight);
        }

        while(!priorityQueue.isEmpty()) {
            Element element = priorityQueue.poll();
            int source = element.index;
            if(visited[source] == true)
                continue;
            visited[source] = true;

            Map<Integer, Integer> toNodes = nodesMap.get(source);
            for(Integer dest : toNodes.keySet()) {
                if((distance[dest] > distance[source] + toNodes.get(dest)) && visited[dest] == false) {
                    distance[dest] = distance[source] + toNodes.get(dest);
                    priorityQueue.add(new Element(dest, distance[dest]));
                }

            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i < distance.length; i++) {
            if(distance[i] == 0)
                continue;
            if(distance[i] == Integer.MAX_VALUE) {
                answer.add(-1);
            } else {
                answer.add(distance[i]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

}
class Element implements Comparable<Element> {
    int index;
    int distance;

    public Element(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Element o) {
        return this.distance < o.distance ? -1 : 1;
    }

}