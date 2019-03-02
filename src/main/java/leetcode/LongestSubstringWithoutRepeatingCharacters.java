package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s.equals(" "))
            return 1;
        if(s.equals(""))
            return 0;

       int max = 0;
       Map<Character, Integer> map = new HashMap<>();
       int lastIndex = 0;

       for(int i = 0; i < s.length(); i++) {
           if(map.containsKey(s.charAt(i))) {
               lastIndex = Math.max(lastIndex, map.get(s.charAt(i)) + 1);
           }
           map.put(s.charAt(i), i);
           max = Math.max(max, i - lastIndex + 1);
       }
       return max;
    }
}
