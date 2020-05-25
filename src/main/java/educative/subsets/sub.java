package educative.subsets;

import java.util.ArrayList;
import java.util.List;

public class sub {

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        findSubsets(nums).stream().forEach(list -> {
            list.stream().forEach(i -> System.out.print(i + ","));
            System.out.println();
        });
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for(int num : nums) {
            int n = subsets.size();
            for(int i = 0; i < n; i++) {
                List<Integer> partialSubsets = new ArrayList<>(subsets.get(i));
                partialSubsets.add(num);
                subsets.add(partialSubsets);
            }
        }
        return subsets;
    }
}
