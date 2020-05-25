package educative.TwoPointers;

public class PairTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        int sum = 0;
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            sum = arr[start] + arr[end];
            if(sum == targetSum) {
                return new int[]{start, end};
            }

            if(sum < targetSum) {
                ++start;
            } else {
                --end;
            }

        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
