package eleven_company;

import java.util.*;
import java.util.stream.Collectors;

public class Concataness {

    static int max = 0;

    public static void main(String[] args) {
        String[] A = {"eva", "jqw", "tyn", "jan"};
        System.out.println(solution(A));
    }

    public static int solution(String[] A) {
        List<String> nonDuplicate = new ArrayList<>();
        for(String word : A) {
            Set<Character> set = word.chars().mapToObj(m -> (char)m).collect(Collectors.toSet());
            if(set.size() == word.length())
                nonDuplicate.add(word);
        }
        for(int i = 0; i < nonDuplicate.size(); i++) {
            getLongestLength(nonDuplicate, i + 1, nonDuplicate.get(i));
        }
        return max;
    }

    private static int getLongestLength(List<String> nonDuplicate, int index, String currentWords) {
        if(index >= nonDuplicate.size())
            return currentWords.length();

        for(int i = index; i < nonDuplicate.size(); i++) {
            boolean isContain = false;
            Set<Character> ithWord = nonDuplicate.get(i).chars().mapToObj(m -> (char)m).collect(Collectors.toSet());
            for(Character c : currentWords.toCharArray()) {
                if(ithWord.contains(c))
                    isContain = true;
            }
            if(!isContain) {
                if(max < currentWords.length() + nonDuplicate.get(i).length()) {
                    currentWords = currentWords + nonDuplicate.get(i);
                    max = Math.max(max, getLongestLength(nonDuplicate, ++index, currentWords));
                }

            }

        }
        return currentWords.length();
    }
}
