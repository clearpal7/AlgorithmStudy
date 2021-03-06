package educative.subsets;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfDuplicate {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex =0;
        int endIndex = 0;

        for(int i = 0; i < nums.length; i++) {

            if(i > 0 && nums[i] == nums[i-1])
                startIndex = endIndex + 1;
            endIndex = subsets.size() - 1;
            for(int j = startIndex; j <= endIndex; j++) {
                List<Integer> partSubsets = new ArrayList<>(subsets.get(j));
                partSubsets.add(nums[i]);
                subsets.add(partSubsets);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
