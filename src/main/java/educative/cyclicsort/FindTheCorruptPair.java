package educative.cyclicsort;

public class FindTheCorruptPair {

    public static void main(String[] args) {
        int[] nums = findNumbers(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }

    public static int[] findNumbers(int[] nums) {
        int duple = findDupleNumber(nums);
        int missing = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - i != 1)
                missing = i + 1;
        }

        return new int[] { duple, missing };
    }

    private static int findDupleNumber(int[] nums) {
        int i = 0;
        int duple = -1;

        while(i < nums.length) {
            int j = nums[i] - 1;
            if(i != j) {
                if(nums[i] == nums[j]) {
                    duple = nums[i];
                    ++i;
                } else {
                    swap(nums, i, j);
                }
            } else {
                ++i;
            }
        }
        return duple;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
