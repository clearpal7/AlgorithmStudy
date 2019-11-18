package leetcode.contest156;

import java.util.HashMap;
import java.util.Map;

public class LongestArthimeticSequence_1027 {

    public static void main(String[] args) {
        int[] A = {9, 4 ,7, 2, 10};
        System.out.print(longestArithSeqLength(A));
    }

    public static int longestArithSeqLength(int[] A) {
        Map<Integer, Integer> dp[] = new HashMap[A.length];
        int res = 2;
        for(int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for(int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}
