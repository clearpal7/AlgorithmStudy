package leetcode.contest159;

public class ReplaceTheSubstringForBalancedString_1234 {

    public static void main(String[] args) {
        String s = "WQWRQQQW";
        System.out.print(balancedString(s));
    }

    public static int balancedString(String s) {
        int n = s.length() / 4;
        int Q = 0;
        int W = 0;
        int E = 0;
        int R = 0;
        int ans = 0;

        for(char ch : s.toCharArray()) {
            if(ch == 'Q') {
                ++Q;
            } else if (ch == 'W') {
                ++W;
            } else if (ch == 'E') {
                ++E;
            } else if (ch == 'R') {
                ++R;
            }
        }
        ans += (Math.abs(Q-n) + Math.abs(W-n) + Math.abs(E-n) + Math.abs(R-n)) / 2;
        return ans;
    }
}
