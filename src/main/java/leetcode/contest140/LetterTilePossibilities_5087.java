package leetcode.contest140;



public class LetterTilePossibilities_5087 {

    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for(char tile : tiles.toCharArray()) {
            count[tile - 'A']++;
        }
        return dfs(count);
    }

    private static int dfs(int[] count) {
        int sum = 0;
        for(int i = 0; i < 26 ;i ++) {
            if(count[i] == 0) continue;
            sum++;
            count[i]--;
            sum += dfs(count);
            count[i]++;
        }
        return sum;
    }
}
