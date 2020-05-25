package leetcode.contest137;

import java.util.*;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        Map<String, Integer> dp = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            dp.put(words[i], 1);
        }
        int max = 0;
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if(dp.containsKey(prev)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(prev) + 1));
                }
            }
            max = Math.max(dp.get(word), max);
        }
        return max;

    }


}
