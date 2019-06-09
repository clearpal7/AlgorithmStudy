package leetcode.contest132;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequence {

    public static void main(String[] args) {
        int[] A = {3,6,9,12};
        System.out.println(longestArithSeqLength(A));
    }

    public static int longestArithSeqLength(int[] A) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>(); // <difference, <Index of Element for this difference, count of sequence>>
        int res = 2;
        for(int i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
                int diff = A[j] - A[i];
                Map<Integer, Integer> map = dp.computeIfAbsent(diff, d -> new HashMap<>());
                map.put(j, map.getOrDefault(i, 1) + 1);
                res = Math.max(res, map.get(j));
            }
        }
        return res;
    }
}
