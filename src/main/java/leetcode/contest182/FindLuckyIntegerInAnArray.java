package leetcode.contest182;

import java.util.*;

public class FindLuckyIntegerInAnArray {

    public static void main(String[] args) {

        int[] arr = {1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }

    public static int findLucky(int[] arr) {
        int max = -1;
        Map<Integer, Integer> valueCount = new HashMap<>();
        Arrays.stream(arr).forEach((number) -> {
            valueCount.put(number, valueCount.getOrDefault(number, 0) + 1);
        });

        for(Map.Entry entry : valueCount.entrySet()) {
            if(entry.getKey() == entry.getValue()) {
                Integer value = (Integer) entry.getValue();
                max = Math.max(value, max);
            }
        }
        return max;
    }
}
