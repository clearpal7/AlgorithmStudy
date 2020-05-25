package review_leetcode;

import java.util.*;

public class MaximumProfit_1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] items = new int[profit.length][3];
        for(int i = 0; i < profit.length; i++) {
            items[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(items, (a1, a2) -> a1[1] - a2[1]);

        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();

        dpEndTime.add(0);
        dpProfit.add(0);

        for(int[] item : items) {
            int s = item[0];
            int e = item[1];
            int p = item[2];

            int prevIndex = Collections.binarySearch(dpEndTime, s + 1);

            if(prevIndex < 0) {
                prevIndex = -prevIndex - 1;
            }

            prevIndex--;
            int currProfit = dpProfit.get(prevIndex) + p;
            int maxProfit = dpProfit.get(dpProfit.size() - 1);
            if(currProfit > maxProfit) {
                dpProfit.add(currProfit);
                dpEndTime.add(e);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }
}
