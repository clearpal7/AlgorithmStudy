package programmers;

public class programmer1 {

    public static void main(String[] args) {
        System.out.print(solution(33));
    }

    public static int solution(int n) {

        boolean[] isPrime = getNumber(1000);

        int count = 0;

        for(int i = 2; i <=n ;i++) {
            for(int j = i+1; j <=n; j++) {
                for(int k = j+1; k<=n; k++) {
                    if(isPrime[i] && isPrime[j] && isPrime[k]) {
                        if(i + j + k == n) {
                            ++count;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static boolean[] getNumber(int N) {
        boolean[] isPrime = new boolean[N + 1];
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i <= N; i++) {
            if(isPrime[i] == true) {
                for(int j = i*i; j<=N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
