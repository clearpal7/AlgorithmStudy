package leetcode.contest136;


import java.util.stream.IntStream;


public class PartitionArrayforMaximumSum {

    public static void main(String[] args) {
        int[]A = {1,4,1,5,7,3,6,1,9,9,3};
        int K = 4;
        System.out.println(maxSumAfterPartitioning(A, K));
    }

    public static int maxSumAfterPartitioning(int[] A, int K) {
        int quotient = A.length / K;
        int residual = A.length % K;

        if(residual == 0) {
            return getMax(A, K);
        } else {
            return getMaxWhenResidualisNotZero(A, residual, K);
        }
    }

    private static int getMaxWhenResidualisNotZero(int[] A, int residual, int K) {
        boolean[] flag = new boolean[A.length];
        int max = 0;

        for(int start = 0; start < A.length; start++) {
            int middle = getTemp(start, residual, A, flag);
            int middle2 = getMaxWithFlag(A, flag, K);
            max = Math.max(max, middle + middle2);
            reset(flag, start, residual);
        }
        return max;
    }

    private static void reset(boolean[] flag, int start, int residual) {
        for(int i = start; residual > 0 && i < flag.length; i++) {
            flag[i] = false;
            --residual;
        }
    }

    private static int getMaxWithFlag(int[] A, boolean[] flag, int K) {
        int count = K;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            if(flag[i] != true) {
                --count;
                if(count > 0) {
                    max = Math.max(max, A[i]);
                } else {
                    max = Math.max(max, A[i]);
                    sum += max * K;
                    count = K;
                    max = Integer.MIN_VALUE;
                }
            }
        }
        return sum;
    }

    private static int getTemp(int startIndex, int residual, int[] A, boolean[] flag) {
        int sum = 0;
        for(int i = startIndex; residual > 0 && i < A.length; i++) {
            sum += A[i];
            flag[i] = true;
            --residual;
        }
        return sum;
    }

    private static int getMax(int[] A, int K) {
        int count = K;
        int max = A[0];

        for(int i = 0; i < A.length; i++) {
            --count;
            if(count > 0) {
                max = Math.max(max, A[i]);
            } else {
                max = Math.max(max, A[i]);
                A[i] = max;
                if(i - 1 >= 0) {
                    A[i - 1] = max;
                }
                if(i - 2 >= 0) {
                    A[i - 2] = max;
                }
                count = K;
            }
        }

        return IntStream.of(A).sum();
    }
}
