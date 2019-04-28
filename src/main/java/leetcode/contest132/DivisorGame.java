package leetcode.contest132;

public class DivisorGame {

    public static void main(String[] args) {

        System.out.println(divisorGame(3));
    }

    public static boolean divisorGame(int N) {
        boolean isAliceWin = false;

        while(N != 1) {
            N = N - 1;
            isAliceWin = true;
        }
        return isAliceWin;
    }
}
