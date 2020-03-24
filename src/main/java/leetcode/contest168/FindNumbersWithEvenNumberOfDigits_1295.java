package leetcode.contest168;


public class FindNumbersWithEvenNumberOfDigits_1295 {

    public static void main(String[] args) {
        int[] arr = {555,901,482,1771};
        System.out.print(findNumbers(arr));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            int digit = getDigit(num);
            if(digit % 2 == 0)
                count++;
        }
        return count;
    }

    private static int getDigit(int num) {
        int digitNum = 1;
        while((num/=10) != 0) {
            digitNum++;
        }
        digitNum++;
        return digitNum;
    }
}
