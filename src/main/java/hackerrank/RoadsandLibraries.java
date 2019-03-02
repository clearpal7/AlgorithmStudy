package hackerrank;

import java.util.Arrays;
import java.util.Stack;

public class RoadsandLibraries {

    public static void main(String[] args) {
        int N = 3;
        int M = 3;
        int c_lib = 2;
        int c_road = 1;
        int[][] cities = new int[N][N];
        cities[0][0] = 1;
        cities[0][1] = 2;
        cities[1][0] = 3;
        cities[1][1] = 1;
        cities[2][0] = 2;
        cities[2][1] = 3;
        System.out.println(roadsAndLibraries(N, c_lib, c_road, cities));
    }

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if(c_road > c_lib)
            return c_lib * n;


        boolean[] visited = new boolean[n+1];
        int[][] connected = new int[n+1][n+1];
        for(int i = 0; i < connected.length; i++) {
            Arrays.fill(connected[i], -1);
        }
        for(int i = 1; i < connected.length; i++) {
            connected[i][i] = 1;
        }

        for(int i = 0; i < cities.length; i++) {
            int from = cities[i][0];
            int to = cities[i][1];
            connected[from][to] = 1;
            connected[to][from] = 1;
        }

        long cost = 0;
        Stack<Integer> city = new Stack<>();

        for(int loc = 1; loc <= n; loc++) {
            if(visited[loc] == false) {
                city.add(loc);
                cost += c_lib;
                int count = 0;
                while (!city.isEmpty()) {
                    Integer currentLoc = city.pop();
                    if (!visited[currentLoc]) {
                        visited[currentLoc] = true;
                    }
                    for (int next = 1; next < connected[currentLoc].length; next++) {
                        if (connected[currentLoc][next] != -1 && !visited[next]) {
                            city.add(next);
                            visited[next] = true;
                            ++count;
                        }
                    }
                }
                cost+= c_road * count;
            }
        }
        return cost;
    }
}
