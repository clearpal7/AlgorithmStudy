package leetcode.contest138;

import java.util.Arrays;

public class HeightChecker_1051 {

    public static void main(String[] args) {
        int[] height = {1,1,4,2,1,3};
        System.out.println(heightChecker(height));
    }

    public static int heightChecker(int[] heights) {
        int[] orderedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(orderedHeights);

        int count = 0;

        for(int i = 0; i < heights.length; i++) {
            if(orderedHeights[i] != heights[i]) {
                ++count;
            }
        }
        return count;
    }
}
