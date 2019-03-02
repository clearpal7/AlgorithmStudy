/*
package hackerrank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class contacts {

    static int[] contacts(String[][] queries) {
        int rowSize = queries.length;
        List<Integer> result = new ArrayList<>();

        Trie trie = new Trie();

        for(int row = 0; row < rowSize; row++) {
            for(int col = 0; col < queries[0].length; col++) {
                if(queries[row][col].equalsIgnoreCase("add")) {
                    addWord(queries[row][col], trie);
                } else if(queries[row][col].equalsIgnoreCase("find")){
                    result.add(findWord(queries[row][col]));
                }
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    public static void addWord(String w, Trie trie) {
        Map<Character, Trie> firstWords = trie.getChildren();

        char[] words = w.toCharArray();
        if(!firstWords.containsKey(words[0])) {
            firstWords.put(words[0], trie);
        }

        Trie fWord = firstWords.get(0);

        for(int i = 1; i < w.length(); i++) {
            Trie child = firstWords.get()
        }
    }

    public static int findWord(String word) {

    }

}
*/
