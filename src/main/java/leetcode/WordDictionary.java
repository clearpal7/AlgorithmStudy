package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode tempRoot = root;

        for(char ch : word.toCharArray()) {
            if(tempRoot.children.get(ch) == null)
                tempRoot.children.put(ch, new TrieNode());
            tempRoot = tempRoot.children.get(ch);
        }
        tempRoot.isWord = true;
    }

    public boolean search(String word) {
        return match(word, 0, root);
    }

    private boolean match(String word, int index, TrieNode node) {
        if(index >= word.length())
            return node.isWord;

        char ch = word.charAt(index);
        if(ch == '.') {
            for(Character key : node.children.keySet()) {
                if(node.children.get(key) != null && match(word, index + 1, node.children.get(key))) {
                    return true;
                }
            }
        } else {
            return node.children.get(ch) != null && match(word, index + 1, node.children.get(ch));
        }
        return false;
    }

}


