package educative.cyclicsort;

import java.util.*;

public class FindAllDuplicateNumbers {

    public static void main(String[] args) {
        List<Integer> duplicates = findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();

        int i = 0;
        while(i < nums.length) {
            int index = nums[i] - 1;
            if(i != index) {
                if(nums[i] == nums[index]) {
                    duplicateNumbers.add(nums[i]);
                    ++i;
                } else {
                    swap(nums, i, index);
                }
            } else {
                ++i;
            }
        }
        return duplicateNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
