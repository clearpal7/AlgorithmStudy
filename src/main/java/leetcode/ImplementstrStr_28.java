package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ImplementstrStr_28 {

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";

        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {

        if("".equals(haystack) || "".equals(needle)) {
            return 0;
        }

        int N = haystack.length();
        int M = needle.length();

        Map<Integer, Integer> pi = getPi(needle);

        int begin = 0;
        int matched = 0;

        while (begin <= N - M) {

            if(matched < M && haystack.charAt(begin + matched) == needle.charAt(matched)) {
                ++matched;
                if(matched == M)
                    return begin;
            } else {
                if(matched == 0) {
                    ++begin;
                } else {
                    begin += matched - pi.get(matched - 1);
                    matched = pi.get(matched - 1);
                }
            }
        }
        return -1;
    }

    private static Map<Integer, Integer> getPi(String needle) {
        int begin = 1;
        int matched = 0;
        Map<Integer, Integer> pi = new HashMap<>();
        int N = needle.length();

        for(int i = 0; i < needle.length(); i++) {
            pi.put(i, 0);
        }

        while(begin + matched < N) {

            if(needle.charAt(begin + matched) == needle.charAt(matched)) {
                ++matched;
                pi.put(begin + matched - 1, matched);
            } else {
                if(matched == 0) {
                    ++begin;
                } else {
                    begin += matched - pi.get(matched - 1);
                    matched = pi.get(matched - 1);
                }
            }
        }
        return pi;
    }
}
