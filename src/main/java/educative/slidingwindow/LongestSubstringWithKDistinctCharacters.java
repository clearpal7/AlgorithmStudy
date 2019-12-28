package educative.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        String str ="araaci";
        int K=1;
        System.out.print(findLength(str, K));
    }

    public static int findLength(String str, int k) {
        int windowStart = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.size() > k) {
                char leftChar = str.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                windowStart++;
            }
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        return max;
    }
}
