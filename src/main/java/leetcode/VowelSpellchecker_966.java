package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/vowel-spellchecker/discuss/211189/JavaC%2B%2BPython-Two-HashMap
public class VowelSpellchecker_966 {

    public static void main(String[] args) {
        String[] wordlist = {"ae","aa"};
        String[] queries = {"UU"};

        String[] answers = spellchecker(wordlist, queries);
        for(String a : answers) {
            System.out.println(a);
        }
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>();
        for(String temp : wordlist) {
            words.add(temp);
        }
        HashMap<String, String> captilize = new HashMap<>();
        HashMap<String, String> devowels = new HashMap<>();

        for(String word : wordlist) {
            String lower = word.toLowerCase();
            String noVowels = lower.replaceAll("[aeiou]", "#");
            captilize.putIfAbsent(lower, word);
            devowels.putIfAbsent(noVowels, word);
        }

        for(int i = 0; i < queries.length; i++) {
            if(words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase();
            String noVowels = lower.replaceAll("[aeiou]", "#");

            if(captilize.containsKey(lower)) {
                queries[i] = captilize.get(lower);
            }
            else if(devowels.containsKey(noVowels)) {
                queries[i] = devowels.get(noVowels);
            } else {
                queries[i] = "";
            }
        }

        return queries;
    }
}
