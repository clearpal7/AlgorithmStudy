package leetcode.contest170;

public class XORQuriesOfASubArray2 {

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        int[] ans = xorQueries(arr, queries);

        for(int a : ans)
            System.out.println(a);
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorSum = new int[queries.length];

        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] ^ arr[i];
        }
        int index = 0;

        for(int[] q : queries) {
            int s = q[0];
            int e = q[1];
            if(s == 0) {
                xorSum[index++] = arr[e];
            } else {
                xorSum[index++] = arr[s-1] ^ arr[e];
            }

        }
        return xorSum;
    }
}
