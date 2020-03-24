package codility;

public class Task1 {

    public static void main(String[] args) {
        int N = 3;
        int[] answer = solution(N);
        for(int i = 0; i < answer.length; i++)
            System.out.println(answer[i]);

    }

    //0을 체크할 만한 좋은 방법 생각해보기
    public static int[] solution(int N) {
        int halfValue = N >>>1;
        int leftValue = N - halfValue;
        int rightValue = N - leftValue;

        if(!isZeroInDecimal(leftValue) && !isZeroInDecimal(rightValue))
            return new int[]{leftValue, rightValue};

        while(leftValue > 0 && rightValue < N) {
            if(!isZeroInDecimal(leftValue) && !isZeroInDecimal(rightValue))
                return new int[]{leftValue, rightValue};

            --leftValue;
            ++rightValue;
        }
        return new int[]{-1, -1};
    }

    private static boolean isZeroInDecimal(int n) {
        while(n !=0) {
            if(n%10 == 0) return true;
            n = n / 10;
        }

        return false;
    }
}
