package leetcode.contest151;

public class DietPlanPerformance_1176 {

    public static void main(String[] args) {
        int[] calories = {6,5,0,0};
        int k = 2;
        int lower = 1;
        int upper = 5;

        System.out.print(dietPlanPerformance(calories, k, lower, upper));
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int point = 0;
        int n = calories.length;

        for(int start = 0; start <= n - k; start++) {
            int sum = 0;
            for(int j = 0; j < k ; j++) {
                sum += calories[start + j];
            }
            if(sum < lower)
                point --;
            else if(sum > upper)
                point++;
        }
        return point;
    }
}
