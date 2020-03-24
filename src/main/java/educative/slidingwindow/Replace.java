package educative.slidingwindow;

public class Replace {

    public static int findLength(int[] arr, int k) {

        int maxOnesCount = 0;
        int windowStart = 0;
        int max = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if(arr[windowEnd] == 1)
                ++maxOnesCount;

            if(windowEnd - windowStart - maxOnesCount + 1 > k) {
                if(arr[windowStart] == 1)
                    --maxOnesCount;
                ++windowStart;
            }
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Replace.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(Replace.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
