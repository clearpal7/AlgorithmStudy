package educative.subsets;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for(int num : nums) {
            int size = permutations.size();

            for(int i = 0; i < size; i++) {
                List<Integer> oldPermu = permutations.poll();
                for(int j = 0; j <= oldPermu.size(); j++) {
                    List<Integer> newPermu = new ArrayList<>(oldPermu);
                    newPermu.add(j, num);
                    if(newPermu.size() == nums.length)
                        result.add(newPermu);
                    else
                        permutations.offer(newPermu);
                }
            }

        }

        return result;
    }

    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generatePermutations(int[] nums, int index, ArrayList<Integer> currentPermutations, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(currentPermutations);
        } else {
         for(int i = 0; i <= currentPermutations.size(); i++) {
             List<Integer> newPermutations = new ArrayList<Integer>(currentPermutations);
             newPermutations.add(i, nums[index]);
             generatePermutations(nums, index + 1, currentPermutations, result);
         }
        }

    }
}
