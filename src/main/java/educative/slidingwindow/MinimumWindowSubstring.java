package educative.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String str ="aabdec";
        String pattern="abc";
        System.out.print(findSubstring(str, pattern));
    }

    public static String findSubstring(String str, String pattern) {
        int windowStart = 0;
        String answer = "";
        int matched = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(Character character : pattern.toCharArray())
            map.put(character, map.getOrDefault(character, 0) + 1);

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0) {
                    ++matched;
                }
            }

            if(matched == map.size()) {
                if(answer.equals("") || windowEnd - windowStart + 1 < answer.length()) {
                    answer = str.substring(windowStart, windowEnd + 1);
                }
            }
            if(windowEnd - windowStart > pattern.length()) {
                char leftChar = str.charAt(windowStart++);
                if(map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if(map.get(leftChar) == 0)
                        --matched;
                }
            }

        }

        return answer;
    }
}
