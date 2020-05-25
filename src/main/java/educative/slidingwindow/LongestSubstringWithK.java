package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithK {


    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + findLength("araaci", 1));
    }

    public static int findLength(String str, int k) {
        if(str == null || str.length() == 0)
            return 0;

        int max = 0;
        int windowStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            while(freqMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if(freqMap.get(leftChar) <=0)
                    freqMap.remove(leftChar);
                 windowStart++;
            }

            max = Math.max(windowEnd - windowStart + 1, max);

        }
        return max;
    }
}
