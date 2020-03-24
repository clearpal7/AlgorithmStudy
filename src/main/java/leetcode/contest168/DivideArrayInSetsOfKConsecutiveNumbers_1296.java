package leetcode.contest168;

import java.util.*;
import java.util.stream.Collectors;

public class DivideArrayInSetsOfKConsecutiveNumbers_1296 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 3;
        System.out.print(isPossibleDivide(nums, k));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        if((nums.length % k) != 0)
            return false;

        int count = k;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        List<Integer> sortedArray = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(sortedArray);

        for(int i : nums) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }


        for(int i = 0; i <= sortedArray.size() - k; i++) {
            int num = sortedArray.get(i);
            while(count != 0 && treeMap.containsKey(num)) {
                --count;
               treeMap.put(num, treeMap.get(num) - 1);
               if(treeMap.get(num) == 0)
                   treeMap.remove(num);
               ++num;
            }
            count = k;
        }

        return treeMap.size() !=0 ? false : true;

    }
}
