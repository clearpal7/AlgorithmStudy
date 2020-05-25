package datastructure.trie;

import java.util.HashMap;

public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private String content;
    private boolean isEndOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
    }

    public HashMap<Character, TrieNode> getChildren() {
        if(this.children == null) {
            this.children = new HashMap<>();
        }
        return this.children;
    }

    public boolean isEndOfWord() {
        return this.isEndOfWord;
    }

    public void setEndOfWord(boolean end) {
        this.isEndOfWord = end;
    }

    public void setContent(String word) {
        this.content = word;
    }

}
