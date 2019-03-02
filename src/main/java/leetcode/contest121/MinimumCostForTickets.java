package leetcode.contest121;

import java.util.Arrays;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(mincostTickets(days, costs));
    }


    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < days.length; i++) {
            dp[days[i]] = 1;
        }

        for(int i = 1; i < 366; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + costs[0];

            }
            if(i >= 7) {
                dp[i] = Math.min(dp[i - 7] + costs[1], dp[i]);
            }
            if (i >= 30) {
                dp[i] = Math.min(dp[i - 30] + costs[2], dp[i]);
            }
        }
        return dp[365];
    }
}
