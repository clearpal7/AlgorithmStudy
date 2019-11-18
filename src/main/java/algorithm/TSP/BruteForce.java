package algorithm.TSP;

import java.util.ArrayList;
import java.util.List;

public class BruteForce {

    static int N = 10;

    static int [][]dist;

    public static void main(String[] args) {

        boolean[] visited = new boolean[N];
        dist = new int[N][N];

        List<Integer> path = new ArrayList<>();
        visited[0] = true;
        path.add(0);
        System.out.print(shortestPath(path, visited, 0));
    }

    public static int shortestPath(List<Integer> path, boolean[] visited, int currentLength) {
        int len = path.size();
        if(path.size() == N) {
            return currentLength + dist[path.get(0)][path.get(len - 1)];
        }

        int ret = Integer.MAX_VALUE;

        for(int next = 0; next < N; next++) {
            if(visited[next] == true) continue;

            int here = path.size() - 1;

            path.add(next);
            visited[next] = true;
            int temp = shortestPath(path, visited, currentLength + dist[here][next]);

            ret = Math.min(ret, temp);
            visited[next] = false;
            path.remove(next);
        }
        return ret;

    }
}
