package leetcode.contest119;

public class SubarraySumsDivisibleByK_974 {

    public static void main(String[] args) {
        int[]A = {4,5,0,-2,-3,1};
        int K = 5;

        System.out.println(subarraysDivByK(A, K));
    }

    public static int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < A.length ; i++) {
            sum = A[i];
            if(sum % K == 0)
                count++;
            for(int j = i + 1; j < A.length; j++) {
                sum+= A[j];
                if(sum % K ==0) {
                    count++;
                }
            }
            sum = 0;
        }
        return count;
    }
}
