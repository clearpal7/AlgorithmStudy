package leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoSum_1 {

    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int target = 10;
        int[] result = twoSum(nums, target);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Set<Integer> answer  = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 1; j <nums.length; j++) {
                if(i != j) {
                    if(nums[i] + nums[j] == target) {
                        answer.add(i);
                        answer.add(j);
                        break;
                    }
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
