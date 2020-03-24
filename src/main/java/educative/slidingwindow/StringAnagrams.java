package educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int matched = 0;
        for(Character character : pattern.toCharArray())
            map.put(character, map.getOrDefault(character, 0) + 1);

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0)
                    ++matched;
            }
            if(matched == map.size())
                resultIndices.add(windowStart);
            if(windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) == 0)
                        --matched;

                    map.put(leftChar, map.get(leftChar) + 1);
                }

            }
        }
        return resultIndices;
    }

}
