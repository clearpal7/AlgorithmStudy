package leetcode;

public class ReplaceTheSubstringForBalancedString_1234 {

    public static void main(String[] args) {
        String s = "QQQQ";
        System.out.println(balancedString(s));
    }


    public static int balancedString(String s) {
        int[] count = new int[128];
        int n = s.length();
        int res = n;
        int k = n / 4;
        int fixedPointAtFirstTime = 0;

        for(int i = 0; i < s.length(); i++) {
            ++count[s.charAt(i)];
        }

        for(int j = 0; j < n; j++) {
            --count[s.charAt(j)];
            while(fixedPointAtFirstTime < n && count['Q'] <=k && count['W'] <=k && count['E'] <=k && count['R'] <=k) {
                res = Math.min(res, j - fixedPointAtFirstTime + 1);
                ++count[s.charAt(fixedPointAtFirstTime++)];
            }
        }
        return res;
    }
}
