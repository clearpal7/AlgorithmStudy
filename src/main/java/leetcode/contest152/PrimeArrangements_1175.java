package leetcode.contest152;


import java.math.BigInteger;

public class PrimeArrangements_1175 {


    static int MOD = 1000000007;

    public static void main(String[] args) {

        int n = 100;
        int answer = numPrimeArrangements(n);
        System.out.println(answer);

    }

    public static int numPrimeArrangements(int n) {
        boolean[] isPrime = getPrimeBooleans(n + 1);
        int cnt = 0;

        for(int i = 0; i < isPrime.length; i++) {
            if(isPrime[i] == true)
                cnt++;
        }

        BigInteger x = factorial(cnt);
        BigInteger y = factorial(n - cnt);
        return x.multiply(y).mod(BigInteger.valueOf(MOD)).intValue();

    }

    public static BigInteger factorial(int count) {
        BigInteger fac = BigInteger.ONE;
        for(int i = 2; i <= count; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }

        return fac;
    }


    public static boolean[] getPrimeBooleans(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i < n; i++) {
            if(isPrime[i] == true)
            for(int j = i * i; j < n; j+=i) {
                    isPrime[j] = false;
            }
        }

        return isPrime;
    }
}
