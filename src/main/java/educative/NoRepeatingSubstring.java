package educative;

import java.util.HashMap;

public class NoRepeatingSubstring {

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }

    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxRepeatCount = 0;
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatCount = Math.max(maxRepeatCount, freqMap.get(rightChar));

            if(windowEnd - windowStart + 1 - maxRepeatCount > k) {
                char leftChar = str.charAt(windowStart);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                ++windowStart;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
