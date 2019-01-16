package leetcode;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class DeleteColumnsToMakeSorted_III_960 {

    public static void main(String[] args) {

        String[] A = {"babca","bbazb"};
        System.out.print(minDeletionSize(A));
    }

    public static int minDeletionSize(String[] A) {
        int letterSize = A[0].length();
        int res = letterSize - 1;
        int[] dp = new int[letterSize];
        Arrays.fill(dp, 1);
        int stringIndex;

        for(int fixedLetterLoc = 0; fixedLetterLoc < letterSize; fixedLetterLoc++) {
            for(int fluidLetterLoc= 0; fluidLetterLoc < fixedLetterLoc; fluidLetterLoc++) {
                for(stringIndex = 0; stringIndex < A.length ; ++stringIndex) {
                    if(A[stringIndex].charAt(fixedLetterLoc) < A[stringIndex].charAt(fluidLetterLoc)) {
                        break;
                    }
                }

                if(stringIndex == A.length && dp[fixedLetterLoc] < dp[fluidLetterLoc] + 1) {
                    dp[fixedLetterLoc] = dp[fluidLetterLoc] + 1;
                }

            }

            res = Math.min(res, letterSize - dp[fixedLetterLoc]);
        }

        List<String> words = new ArrayList<>();
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        Collections.sort(words, comparingInt(String::length));

        words.sort(comparingInt(String::length));

        return res;
    }


}
