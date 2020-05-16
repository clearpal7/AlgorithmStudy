package educative.cyclicsort;

public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        System.out.println(findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }

    public static int findNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int realIndex = nums[i] - 1;
            if(i != realIndex) {
                if(nums[i] == nums[realIndex]) {
                    return nums[realIndex];
                } else {
                    swap(nums, i, realIndex);
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
