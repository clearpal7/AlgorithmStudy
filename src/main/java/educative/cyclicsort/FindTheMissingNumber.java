package educative.cyclicsort;

public class FindTheMissingNumber {

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }

    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        for(int index = 0; index < nums.length; index++) {
            if(index != nums[index])
                return index;
        }

        return nums.length;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
