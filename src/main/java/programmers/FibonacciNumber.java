package programmers;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.print(solution(5));
    }

    public static int solution(int n) {
        int divide = 1234567;

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for(int i = 2; i <= n ; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % divide;
        }


        return fib[n];
    }

   /* public int fibonacci(int num) {
        if(num == 0)return 0;
        else if(num == 1) return 1;



    }*/
}
