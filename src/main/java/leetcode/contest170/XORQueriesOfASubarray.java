package leetcode.contest170;

public class XORQueriesOfASubarray {

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = {{0,1}, {1,2}, {0,3}, {3,3}};
        int[] answer = xorQueries(arr, queries);

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] ^ arr[i-1];
        }
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0) answer[i] = arr[end];
            else answer[i] = arr[end] ^ arr[start - 1];
        }
        return answer;
    }
}
