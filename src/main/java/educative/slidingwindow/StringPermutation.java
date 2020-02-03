package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public static void main(String[] args) {
        String str = "oidbcaf";
        String pattern = "abc";
        System.out.print(findPermutation(str, pattern));
    }

    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : pattern.toCharArray()) {
            map.putIfAbsent(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character ch = str.charAt(windowEnd);

            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    ++count;
                }

            }
            if(count == map.size())
                return true;
            if(windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) == 0)
                        --count;

                }
            }
        }
        return false;
    }
}
