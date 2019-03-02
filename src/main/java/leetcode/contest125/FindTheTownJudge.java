package leetcode.contest125;

import java.util.*;

public class FindTheTownJudge {

    public static void main(String[] args) {
        int[][] A = {
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        };
        System.out.print(findJudge(4, A));
    }

    public static int findJudge(int N, int[][] trust) {

        Map<Integer, HashSet<Integer>> believe = new HashMap<>();
        for(int i = 1; i <=N; i++) {
            believe.put(i, new HashSet<>());
        }

        for(int i = 0; i < trust.length; i++) {
            believe.computeIfAbsent(trust[i][0], k -> new HashSet<>()).add(trust[i][1]);
        }

        for(int key : believe.keySet()) {
            HashSet<Integer> temp = believe.get(key);
            if(temp.size() == 0 && allcheck(believe, key)) {
                return key;
            }
        }

        return -1;
    }

    private static boolean allcheck(Map<Integer, HashSet<Integer>> believe, int key) {
        for(int k : believe.keySet()) {
            if(k != key && !believe.get(k).contains(key)) {
                return false;
            }
        }
        return true;
    }
}
