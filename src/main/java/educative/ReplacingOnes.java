package educative;

public class ReplacingOnes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k=2;
        System.out.print(findLength(arr, k));
    }

    public static int findLength(int[] arr, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            int rightNum = arr[windowEnd];
            if(rightNum == 0)
                ++zeroCount;

            while(zeroCount > k) {
                int leftNum = arr[windowStart];
                if(leftNum == 0)
                    --zeroCount;
                ++windowStart;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
