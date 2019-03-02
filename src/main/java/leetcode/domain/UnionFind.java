package leetcode.domain;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    Map<Character, Character> node = new HashMap<>();

    public UnionFind() {
        for(int i = 0; i < 26; i++) {
            node.put((char)('a' + i), (char)('a' + i));
        }
    }

    public Character findRoot(char c) {
        char source = c;
        while(node.get(source) != source) {
            source = node.get(source);
        }

        return source;
    }

    public void add(char nodeA, char nodeB) {
        char rootA = findRoot(nodeA);
        char rootB = findRoot(nodeB);
        node.put(rootB, rootA);
        node.put(nodeA, rootA);
        node.put(nodeB, rootA);
    }


}
