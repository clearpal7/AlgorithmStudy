package leetcode.contest133;

public class MaximumSumOfTwoNonOverlappingSubarrays {

    public static void main(String[] args) {
        int[] A = {0,6,5,2,2,5,1,9,4};
        int L = 1;
        int M = 2;
        System.out.println(maxSumTwoNoOverlap(A, L, M));
    }

    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int max = 0;
        for(int lStart = 0; lStart < A.length ;lStart++) {
            int lEnd = lStart + L;
            for(int mStart = 0; mStart < A.length; mStart++) {
                int mEnd = mStart + M;
                if(!(lEnd >= mStart || mEnd >= lStart))  {
                    max = Math.max(max, sum(lStart, lEnd, mStart, mEnd, A));
                }
            }
        }
        return max;
    }

    private static int sum(int lStart, int lEnd, int mStart, int mEnd, int[] A) {
        int sum = 0;
        for(int i = lStart; i < lEnd; i++) {
            sum += A[i];
        }

        for(int i = mStart; i < mEnd; i++) {
            sum += A[i];
        }
        return sum;
    }
}
