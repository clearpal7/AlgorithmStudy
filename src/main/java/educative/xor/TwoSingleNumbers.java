package educative.xor;

public class TwoSingleNumbers {

    public static int[] findSingleNumbers(int[] nums) {
        int n1n2 = 0;
        for(int num : nums) {
            n1n2 = n1n2 ^ num;
        }

        int rightMostBit = 1;
        while((rightMostBit & n1n2) == 0)
            rightMostBit = rightMostBit << 1;

        int num1 = 0;
        int num2 = 0;
        for(int num : nums) {
            if((num & rightMostBit) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }

        return new int[] { num1, num2 };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}
