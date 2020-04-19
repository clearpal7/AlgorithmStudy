package leetcodechallenge.firstweek;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        List<Integer> subSum = new ArrayList<>();
        int previousSum = 0;
        for(int num : nums) {
            previousSum = Math.max(num, num + previousSum);
            subSum.add(previousSum);
        }
        AtomicInteger at = new AtomicInteger(0);
        Map<Integer, Integer> indexAndValue = subSum
                                    .stream()
                                    .collect(Collectors.toMap((integer) -> at.getAndIncrement(), (integer) -> integer));

        return subSum.stream().max(Comparator.comparing(Integer::intValue)).get();
    }
}
