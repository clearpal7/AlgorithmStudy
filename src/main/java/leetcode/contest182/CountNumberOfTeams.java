package leetcode.contest182;

public class CountNumberOfTeams {

    public static void main(String[] args) {
        int[] ratings = {1, 2, 3, 4};
        System.out.println(numTeams(ratings));
    }

    public static int numTeams(int[] rating) {
        int count = 0;

        for(int i = 0; i < rating.length - 2; i++) {
            count += calculateCount(i + 1, rating.length - 1, rating[i], rating);
        }
        return count;
    }

    private static int calculateCount(int left, int right, int prevValue, int[] rating) {
        int count = 0;

        for(int i = left; i < right; i++) {
            for(int j = right; j > i; j--) {
                if(rating[i] > prevValue && rating[i] < rating[j]) {
                    count++;
                }  else if(rating[i] < prevValue && rating[i] > rating[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
