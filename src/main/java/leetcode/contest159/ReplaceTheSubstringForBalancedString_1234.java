package leetcode.contest159;

public class ReplaceTheSubstringForBalancedString_1234 {

    public int balancedString(String s) {
        int ans = 0;
        int count = s.length() / 4;
        int Q = 0;
        int W = 0;
        int E = 0;
        int R = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'Q') {
                ++Q;
            } else if(ch == 'W') {
                ++W;
            } else if(ch == 'E') {
                ++E;
            } else if (ch == 'R') {
                ++R;
            }
        }


    }

}
