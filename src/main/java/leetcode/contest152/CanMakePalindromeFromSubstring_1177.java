package leetcode.contest152;

import java.util.*;

public class CanMakePalindromeFromSubstring_1177 {

    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {
                {3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}
        };
        List<Boolean> answer = canMakePaliQueries(s, queries);
        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList();

        for (int[] query : queries) {
            res.add(canMakePal(s, query[0], query[1], query[2]));
        }

        return res;
    }

    private static boolean canMakePal(String s, int start, int end, int max) {
        if (max >= 13) return true;
        Set<Character> set = new HashSet();
        for (int i = start; i <= end; i++) {
            boolean isAlready = set.add(s.charAt(i));
            if (!isAlready) set.remove(s.charAt(i));
        }
        return max >= set.size()/2;
    }
}
