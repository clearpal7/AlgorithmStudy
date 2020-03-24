package leetcode.contest120;

import java.util.*;

public class SquaresOfASortedArray {

    public static void main(String[] args) {

        int[] arr = {-3, -1, 0, 1, 2};
        Arrays.stream(makeSquares(arr)).forEach(System.out::println);
        //System.out.println(makeSquares(arr));
    }

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        int highestIdx = arr.length - 1;

        while(start <= end) {
            int left = arr[start] * arr[start];
            int right = arr[end] * arr[end];

            if(left < right) {
                squares[highestIdx--] = right;
                --end;
            } else {
                squares[highestIdx--] = left;
                ++start;
            }
        }
        return squares;
    }
}
