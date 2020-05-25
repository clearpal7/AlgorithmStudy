package leetcode.contest166;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenAThreshold_1283 {

    public static void main(String[] args) {
        int[] nums = {19};
        int threshold = 5;
        System.out.print(smallestDivisor(nums, threshold));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while(left < right) {
            int mid = (left + right) >>>1;
            int sum = 0;
            for(int i : nums)
                sum += (i + mid - 1) / mid;
            if(sum > threshold)
                left = mid + 1;
            else
                right = mid;

        }
        return left;
    }
}
