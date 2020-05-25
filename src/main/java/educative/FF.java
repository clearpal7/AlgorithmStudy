package educative;

public class FF {

    public static void main(String[] args) {
        int[]arr = {2, 1, 5, 2, 3,2};
        int S=7;
        System.out.print(findMinSubArray(S,  arr));
    }

    public static int findMinSubArray(int S, int[] arr) {
        int windowStart = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if(arr[windowEnd] >= S)
                return 1;

            sum += arr[windowEnd];
            ++count;

            if(sum >= S) {
                min = Math.min(min, count);
                sum -= arr[windowStart];
                count = 0;
                sum = 0;
                ++windowStart;
            }
        }
        return min;
    }
}
