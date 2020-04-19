package educative.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        System.out.println(generatePermutations(nums));
    }

    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation,
                                                      List<List<Integer>> result) {

        if(index == nums.length || currentPermutation.size() == nums.length) {
            result.add(currentPermutation);
        } else {

            for (int i = 0; i <= currentPermutation.size(); i++) {
                List<Integer> newPermutations = new ArrayList<>(currentPermutation);
                newPermutations.add(i, nums[index]);
                generatePermutationsRecursive(nums, index + 1, newPermutations, result);
            }
        }

    }

}
