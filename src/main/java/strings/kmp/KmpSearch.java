package strings.kmp;


public class KmpSearch {

   public static void main(String[] args) {
       String haystack = "aaaaa";
       String needle = "bba";

       System.out.println(strStr(haystack, needle));
   }

    public static int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0)
            return 0;
        else if (haystack.length() == 0 && needle.length() != 0) {
            return -1;
        } else if(haystack.length() != 0 && needle.length() ==0) {
            return 0;
        }
        int N = haystack.length();
        int M = needle.length();
        int[] pi = getPartitalMatch(needle);

        int begin = 0;
        int matched = 0;

        char[] hayStackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();

        while (begin <= N - M) {
            if(matched < M && hayStackChar[begin + matched] == needleChar[matched]) {
                ++matched;
                if(matched == M)
                    return begin;
            } else {
                if(matched == 0) {
                    ++begin;
                } else {
                    begin+= matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }
        return -1;
    }

    public static int[] getPartitalMatch(String needle) {
        int begin = 1;
        int matched = 0;
        int M = needle.length();
        int[] pi = new int[M];
        char[] needleChar = needle.toCharArray();

        while (begin + matched < M) {
            if(needleChar[begin + matched] == needleChar[matched]) {
                ++matched;
                pi[begin + matched - 1] = matched;
            } else {
                if(matched == 0) {
                    ++begin;
                } else {
                   begin+= matched - pi[matched -1];
                   matched = pi[matched - 1];
                }
            }
        }
        return pi;
    }

}
