package datastructure.trie;



public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            currentNode = currentNode.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }
        currentNode.setEndOfWord(true);
        currentNode.setContent(word);
    }

    public boolean find(String word) {
        TrieNode currentNode = root;
        for(int i = 0; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if(currentNode.getChildren().containsKey(ch)) {
                currentNode = currentNode.getChildren().get(ch);
            } else {
                return false;
            }
        }
        return true;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()) {
            if(!current.isEndOfWord()) {
                return false;
            }
        }

        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if(node == null) {
            return false;
        }
        boolean shouldRemove = delete(node, word, index + 1) && !current.isEndOfWord();
        if(shouldRemove) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}
