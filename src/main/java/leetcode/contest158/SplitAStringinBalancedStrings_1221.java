package leetcode.contest158;

public class SplitAStringinBalancedStrings_1221 {

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.print(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int balanced = 0;
        int count = 0;
        for(Character c : s.toCharArray()) {
            if(c == 'R') {
                ++balanced;
            } else if(c == 'L') {
                --balanced;
            }

            if(balanced == 0) {
                ++count;
            }
        }
        return count;
    }
}
