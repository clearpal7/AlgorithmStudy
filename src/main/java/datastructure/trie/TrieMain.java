package datastructure.trie;


public class TrieMain {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");

        System.out.println(trie.find("Programing"));
    }
}
