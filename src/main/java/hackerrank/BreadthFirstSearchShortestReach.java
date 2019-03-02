package hackerrank;

import java.util.*;

public class BreadthFirstSearchShortestReach {

    static int[] bfs(int n, int m, int[][] edges, int s) {

        int distanceUnit = 6;
        int start = s;
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[start] = 0;

        int adj[][] = new int[n+1][n+1];
        for(int i = 0; i < adj.length; i++) {
            Arrays.fill(adj[i], -1);
        }

        for(int row = 0; row < edges.length; row++) {
            int from  = edges[row][0];
            int to = edges[row][1];
            adj[from][to] = 6;
            adj[to][from] = 6;
        }
        boolean[] visited = new boolean[n+1];
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            Integer from = queue.poll();

            for(int to = 1; to <=n; to++) {
                if(visited[to] == false && (adj[from][to] != -1)) {
                    distance[to] = distance[from] + distanceUnit;
                    queue.add(to);
                    visited[to] = true;
                }
            }
        }
        List<Integer> answer = new ArrayList<>();

        for(int i = 1; i < distance.length; i++) {
            if(distance[i] == 0) {
                distance[i] = -1;
            }
            if(i != start) {
                answer.add(distance[i]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }


}
