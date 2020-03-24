package educative.slidingwindow;

import java.util.*;

public class ReplaceSubstring {

    public static int findLength(String str, int k) {
        int maxLength = 0;
        int windowStart = 0;
        int maxRepeatCount = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatCount = Math.max(maxRepeatCount, freqMap.get(rightChar));

            if(windowEnd - windowStart - maxRepeatCount + 1 > k) {
                char leftChar = str.charAt(windowStart);
                ++windowStart;
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(ReplaceSubstring.findLength("aabccbb", 2));
        System.out.println(ReplaceSubstring.findLength("abbcb", 1));
        System.out.println(ReplaceSubstring.findLength("abccde", 1));
    }
}
