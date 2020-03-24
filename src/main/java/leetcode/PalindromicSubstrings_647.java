package leetcode;

public class PalindromicSubstrings_647 {

    int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++) {
            palindrome(s, i, i);
            palindrome(s, i, i+1);
        }
        return count;
    }

    private void palindrome(String s, int i, int j) {
        while(i>=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            ++count;
            --i;
            ++j;
        }
    }
}
