package leetcode.contest124;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSquarefulArrays {

    public static void main(String[] args) {
        int[] A = {1,17,8};
        System.out.println(numSquarefulPerms(A));
    }

    static Map<Integer, Integer> count;
    static Map<Integer, List<Integer>> graph;

    public static int numSquarefulPerms(int[] A) {

        count = new HashMap<>();
        graph = new HashMap<>();
        int N = A.length;

        for(int x : A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for(int x : A) {
            graph.put(x, new ArrayList<>());
        }

        for(int x : count.keySet()) {
            for(int y : count.keySet()) {
                int r = (int)(Math.sqrt(x + y));
                if(r * r == x + y) {
                    graph.get(x).add(y);
                }
            }
        }

        int answer = 0;

        for(int x : count.keySet()) {
            answer += dfs(x, N - 1);
        }
        return answer;
    }

    private static int dfs(int start, int N) {
        count.put(start, count.get(start) - 1);
        int ans = 1;
        if(N != 0) {
            ans = 0;
            for (int x : graph.get(start)) {
                if (count.get(x) != 0) {
                    ans += dfs(x, N - 1);
                }
            }
        }
        count.put(start, count.get(start) + 1);
        return ans;
    }
}
