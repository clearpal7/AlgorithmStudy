package educative.slidingwindow;

import java.util.HashSet;

public class NoRepeatSubstring {

    public static void main(String[] args) {
        String str = "abccde";
        System.out.print(findLength(str));
    }

    public static int findLength(String str) {
        int max = 0;
        int windowStart = 0;
        HashSet<Character> set = new HashSet<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if(set.contains(rightChar)) {
                max = Math.max(max, windowEnd - windowStart);
                set.remove(windowStart);
                ++windowStart;
            } else {
                set.add(rightChar);
            }

        }

        return max;
    }
}
