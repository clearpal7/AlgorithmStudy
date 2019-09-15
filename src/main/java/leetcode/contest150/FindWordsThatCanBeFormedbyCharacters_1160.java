package leetcode.contest150;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedbyCharacters_1160 {

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {

        Map<Character, Integer> charMap = new HashMap<>();
        for(Character character : chars.toCharArray()) {
            if(!charMap.containsKey(character)) {
                charMap.put(character, 1);
            } else {
                charMap.put(character, charMap.get(character) + 1);
            }
        }
        int sum = 0;
        for(String word : words) {
            int count = word.length();
            Map<Character, Integer> copyMap = new HashMap<>();
            copyMap.putAll(charMap);

            for(Character character : word.toCharArray()) {
                if(copyMap.containsKey(character) && copyMap.get(character) > 0) {
                    copyMap.put(character, copyMap.get(character) - 1);
                    --count;
                }
            }
            if(count == 0)
                sum += word.length();
        }
        return sum;
    }
}
