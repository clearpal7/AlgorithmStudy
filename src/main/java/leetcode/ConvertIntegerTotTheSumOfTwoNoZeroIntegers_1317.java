package leetcode;

public class ConvertIntegerTotTheSumOfTwoNoZeroIntegers_1317 {

    public static void main(String[] args) {
        int n = 11;
        int[] result = getNoZeroIntegers(n);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] getNoZeroIntegers(int n) {
        int firstInt = 0;
        int secondInt = 0;
        for(int i = 1; i < n; i++) {
            int j = n - i;
            if(String.valueOf(i).contains("0") || String.valueOf(j).contains("0")) {
                continue;
            } else {
                firstInt = i;
                secondInt = j;
            }

        }
        return new int[]{firstInt, secondInt};
    }


}
