package educative.slidingwindow;

import java.util.*;

public class NoRepeatSubString {

    public static int findLength(String str) {

        int max = 0;
        int windowStart = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if(indexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, indexMap.get(rightChar) + 1);
            }
            indexMap.put(rightChar, windowEnd);
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + findLength("abbbb"));
        System.out.println("Length of the longest substring: " + findLength("abccde"));
    }
}
