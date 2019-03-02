package leetcode.contest124;

public class MinimumNumberOfKConsecutiveBitFlips {

    public static void main(String[] args) {
        int[] A = {0,0,0,1,0,1,1,0};
        int K = 3;
        System.out.print(minKBitFlips(A, K));
    }

    public static int minKBitFlips(int[] A, int K) {
        int n = A.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < A.length; ++i) {
            if (i >= K)
                flipped ^= isFlipped[i - K];
            if (flipped == A[i]) {
                if (i + K > A.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }

}
