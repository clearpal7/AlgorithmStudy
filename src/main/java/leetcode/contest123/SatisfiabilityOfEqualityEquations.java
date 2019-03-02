package leetcode.contest123;

import leetcode.domain.UnionFind;


public class SatisfiabilityOfEqualityEquations {

    public static void main(String[] args) {
        String[] equations = new String[3];
        equations[0] = "a==b";
        equations[1] = "b!=c";
        equations[2] = "c==a";
        System.out.print(equationsPossible(equations));
    }

    public static boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();

        for (int i = 0; i < equations.length; i++) {
            char first = equations[i].charAt(0);
            char second = equations[i].charAt(3);
            if (equations[i].charAt(1) == '=') {
                unionFind.add(first, second);
            }
        }
        for(int i = 0; i < equations.length; i++) {
            if(equations[i].charAt(1) == '!') {
                char first = equations[i].charAt(0);
                char second = equations[i].charAt(3);
                if(equations[i].charAt(1) == '!') {
                    char f = unionFind.findRoot(first);
                    char s = unionFind.findRoot(second);
                    if(f == s) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
