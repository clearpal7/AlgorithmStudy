package leetcode.contest159;

public class ReplaceTheSubstringForBalancedString_1234 {

    public static void main(String[] args) {
        String s = "WQWRQQQW";
        System.out.print(balancedString(s));
    }

    public static int balancedString(String s) {
        int[] count = new int[128];
        int n = s.length();
        int res = n;
        for(int i  = 0; i < n; i++) {
            ++count[s.charAt(i)];
        }
        int i = 0 ;
        for(int j = 0; j < n; j++) {
            --count[s.charAt(j)];

        }
        return 0;
    }
}
