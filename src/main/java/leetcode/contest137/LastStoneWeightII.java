package leetcode.contest137;

public class LastStoneWeightII {

    public static void main(String[] args) {
        int[] a = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(a));
    }

    public static int lastStoneWeight(int[] A) {
        int[] dp = new int[1501];
        dp[0] = 1;
        int sumA = 0, res = 100;
        for (int a : A) {
            sumA += a;
            for (int i = 1500; i >= a; --i)
                dp[i] |= dp[i - a];
        }
        for (int i = 0; i < 1500; ++i)
            res = Math.min(res, Math.abs(sumA - dp[i] * i * 2));
        return res;
    }


}
