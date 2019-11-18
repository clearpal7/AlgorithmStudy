package leetcode.contest147;

public class NthTribonacciNumber {

    public static void main(String[] args) {
        System.out.print(tribonacci(25));
    }

    public static int tribonacci(int n) {
        int[] t = new int[38];
        initMethod(t);
        return t[n];
    }

    private static void initMethod(int[] t) {
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;
        for(int i = 3; i < t.length; i++) {
            t[i] = t[i - 1] + t[i - 2] + t[i - 3];
        }
    }

}
