package educative.slidingwindow;

public class MaximumSumSubarrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int sum = 0;
        int windowStart = 0;
        int max = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];
            if(windowEnd >= k-1) {
                max = Math.max(max, sum);
                sum -= arr[windowStart];
                ++windowStart;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
