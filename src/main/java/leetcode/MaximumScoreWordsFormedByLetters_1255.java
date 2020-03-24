package leetcode;

public class MaximumScoreWordsFormedByLetters_1255 {

    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        System.out.println(maxScoreWords(words, letters, score));
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[score.length];
        for(char ch : letters) {
            count[ch - 'a']++;
        }
        int res = dfs(words, score, count, 0);
        return res;
    }

    private static int dfs(String[] words, int[] score, int[] count, int index) {
        int max = 0;
        for(int i = index; i < words.length; i++) {
            int cnt = 0;
            boolean isValid = true;
            for(char ch : words[i].toCharArray()) {
                count[ch - 'a']--;
                cnt += score[ch - 'a'];
                if(count[ch - 'a'] < 0){
                    isValid = false;
                }
            }
            if(isValid) {
                cnt += dfs(words, score, count, i + 1);
                max = Math.max(max, cnt);
            }
            for(char ch : words[i].toCharArray()) {
                count[ch - 'a']++;
                cnt = 0;
            }
        }
        return max;
    }
}
