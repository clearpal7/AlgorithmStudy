package leetcode.contest140;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram_5083 {

    public static void main(String[] args) {
        String text = "we will we will rock you";
        String first = "we";
        String second = "will";
        String[] result = findOcurrences(text, first, second);
        for(String word : result) {
            System.out.println(word);
        }

    }

    public static String[] findOcurrences(String text, String first, String second) {
        String[] sentence = text.split(" ");
        List<String> result = new ArrayList<>();

        for(int i = 0; i < sentence.length - 2; i++) {
            if(sentence[i].equals(first) && sentence[i + 1].equals(second)) {
                result.add(sentence[i  + 2]);
            }
        }
        return result.toArray((new String[result.size()]));
    }
}
