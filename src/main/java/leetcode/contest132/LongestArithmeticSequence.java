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
        int max = 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i];
                int b = A[j];
                Map<Integer, Integer> diff = dp.computeIfAbsent(b - a, c -> new HashMap<>());
                int currMax = Math.max(diff.getOrDefault(j, 0), diff.getOrDefault(i, 0) + 1);
                diff.put(j, currMax);
                max = Math.max(max, currMax + 1);
            }
        }
        return max;
    }
}
