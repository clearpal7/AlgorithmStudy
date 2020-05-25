package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationsString {

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + findPermutation("aaacb", "abc"));
    }

    public static boolean findPermutation(String str, String pattern) {

        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        str.chars().mapToObj(i -> (char)i).forEach(ch -> freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1));

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            char rightChar = str.charAt(windowEnd);
            if(freqMap.containsKey(rightChar)) {
                freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) - 1);
                if(freqMap.get(rightChar) == 0)
                    ++matched;
            }

            if(matched == pattern.length()) {
                return true;
            }

            if(windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if(freqMap.containsKey(leftChar)) {
                    if(freqMap.get(leftChar) == 0)
                        --matched;
                    freqMap.put(leftChar, freqMap.getOrDefault(leftChar, 0) + 1);
                }
            }

        }
        return false;
    }
}
