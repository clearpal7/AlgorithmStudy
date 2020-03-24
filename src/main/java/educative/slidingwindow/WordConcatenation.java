package educative.slidingwindow;

import java.util.*;

public class WordConcatenation {

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        Arrays.stream(words).forEach(word -> freqMap.put(word, freqMap.getOrDefault(word, 0) + 1));
        int wordLength = words[0].length();
        int wordsCount = words.length;

        List<Integer> resultIndices = new ArrayList<>();

        for(int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordSeen = new HashMap<>();
            for(int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;

                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);

                if(!freqMap.containsKey(word))
                    break;

                wordSeen.put(word, wordSeen.getOrDefault(word, 0) + 1);

                if(wordSeen.get(word) > freqMap.get(word))
                    break;

                if(j+1 == wordsCount)
                    resultIndices.add(i);
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}
