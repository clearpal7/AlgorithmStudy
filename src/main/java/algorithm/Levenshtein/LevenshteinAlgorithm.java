package algorithm.Levenshtein;

public class LevenshteinAlgorithm {

    public static void main(String[] args) {
        String word1 = "NCSOFT";
        String word2 = "MICROSOFT";

        System.out.println(levenstein(word1, word2));
    }

    public static int levenstein(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();

        int [][]dp = new int[word2Length + 1][word1Length + 1];
        for(int i = 1; i <= word1Length; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= word2Length; i++) {
            dp[i][0] = i;
        }

        for(int i = 1; i <= word2Length; i++) {
            for(int j = 1; j <= word1Length; j++) {
                if(word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1]+1), dp[i-1][j-1] + 1);
                }
            }
        }

        return dp[word2Length][word1Length];
    }
}
