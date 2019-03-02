package datastructure;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    Map<Character, TrieNode> children = new HashMap<>();
    boolean lastWord;

    public Map<Character, TrieNode> getChildren() {
        return this.children;
    }

    public boolean isLastWord() {
        return this.lastWord;
    }

    public void setLastWord(boolean lastWord) {
        this.lastWord = lastWord;
    }
}
