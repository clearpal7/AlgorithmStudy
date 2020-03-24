package leetcode.contest168;

import java.util.*;


public class MaximumNumberOfOccurrencesOfASubstring_1297 {

    public static void main(String[] args) {
        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};
        System.out.print(jobScheduling(startTime, endTime, profit));
    }

    /*public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;

        for(int windowStart = 0; windowStart < s.length(); windowStart++) {
            Map<Character, Integer> chMap = new HashMap<>();
            int dist = 0;

            for(int j = 0; j < maxSize; j++) {
                if(windowStart + j >= s.length()) break;
                chMap.put(s.charAt(windowStart + j), chMap.getOrDefault(s.charAt(windowStart + j), 0) + 1);
                if(chMap.get(s.charAt(windowStart + j)) == 1) ++dist;
                if(dist > maxLetters) break;
                if(j + 1 >= minSize && j + 1 <= maxSize) {
                    map.put(s.substring(windowStart, windowStart + j + 1), map.getOrDefault(s.substring(windowStart, windowStart + j + 1), 0) + 1);
                }
            }
        }

        for(String key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max;
    }
*/

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // sort by endTime
        int[][] items = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            items[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(items, (a1, a2)->a1[1] - a2[1]);
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        // init value to avoid IndexOutBoundExp
        dpEndTime.add(0);
        dpProfit.add(0);
        for (int[] item : items) {
            int s = item[0], e = item[1], p = item[2];
            // find previous endTime index
            int prevIdx = Collections.binarySearch(dpEndTime, s + 1);
            if (prevIdx < 0) {
                prevIdx = -prevIdx - 1;
            }
            prevIdx--;
            int currProfit = dpProfit.get(prevIdx) + p, maxProfit = dpProfit.get(dpProfit.size() - 1);
            if (currProfit > maxProfit) {
                dpProfit.add(currProfit);
                dpEndTime.add(e);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }

}
