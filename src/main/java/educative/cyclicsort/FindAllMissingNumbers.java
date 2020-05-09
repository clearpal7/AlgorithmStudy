package educative.cyclicsort;

import java.util.*;

public class FindAllMissingNumbers {

    public static void main(String[] args) {
        List<Integer> missing = findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int index = 0;
        while(index < nums.length) {
            int value = nums[index] - 1;
            if(nums[value] != nums[index]) {
                swap(nums, value, index);
            } else {
                index++;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
