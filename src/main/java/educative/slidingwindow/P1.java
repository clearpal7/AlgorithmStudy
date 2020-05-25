package educative.slidingwindow;


import java.util.*;


public class P1 {

    public static void main(String[] args) {
        String str ="ppqp"; String pattern="pq";
        System.out.print(findPermutation(str, pattern));
    }

    public static List<Integer> findPermutation(String str, String pattern) {
        int windowStart = 0;
        List<Integer> index = new ArrayList<>();
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

            if(matched == map.size()) {
                index.add(windowStart);
                matched = 0;
            }

            if(windowEnd > pattern.length()) {
                ++windowStart;
                map.put(str.charAt(windowStart), map.get(str.charAt(windowStart)) + 1);
            }
        }
        return index;
    }
}
